package com.shop.rest.emails;

import com.shop.rest.constants.EmailConstants;
import com.shop.rest.utils.EncryptorDecryptor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.InputStream;
import javax.mail.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    public void send(boolean isRegistration, String email, String updatedKey) throws Exception {
        try (InputStream input = getClass()
                .getClassLoader().getResourceAsStream("email.properties")) {

            Properties emailProperties = new Properties();
            emailProperties.load(input);

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailProperties.get("email").toString(), emailProperties.get("pwd").toString());
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailProperties.get("from").toString(), false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            if (isRegistration) {
                msg.setSubject(emailProperties.get("subjectRegistration").toString());
            } else {
                msg.setSubject(emailProperties.get("subjectForgotPassword").toString());
            }

            msg.setContent("CONTENT", "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            if (isRegistration) {
                String encryptText = encryptMail(email);
                messageBodyPart.setContent(EmailConstants.REGISTRATION_MAIL0
                        + EmailConstants.REGISTRATION_MAIL1 + encryptText
                        + EmailConstants.REGISTRATION_MAIL2
                        + EmailConstants.REGISTRATION_MAIL4
                        + EmailConstants.REGISTRATION_MAIL5
                        + EmailConstants.REGISTRATION_MAIL6, "text/html");
            } else {
                messageBodyPart.setContent(EmailConstants.FORGOT_PASSWORD_TEMPLATE
                        + EmailConstants.FORGOT_PASSWORD_TEMPLATE1
                        + EmailConstants.FORGOT_PASSWORD_BODY_1 + updatedKey
                        + EmailConstants.FORGOT_PASSWORD_BODY_2
                        + EmailConstants.FORGOT_PASSWORD_BODY_3_DID_NOT_REQUEST
                        + EmailConstants.TECHNICAL_SUPPORT, "text/html");
            }

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);
            Transport.send(msg);
        }
    }

    private String encryptMail(String email) {
        final String secretKey = "Barber127Barber120";
        return EncryptorDecryptor.encrypt(email, secretKey) ;
    }
}
