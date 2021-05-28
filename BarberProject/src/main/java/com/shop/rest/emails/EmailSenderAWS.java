package com.shop.rest.emails;

import com.shop.rest.constants.EmailConstants;
import com.shop.rest.utils.EncryptorDecryptor;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Properties;

public class EmailSenderAWS {

    public void send(boolean isRegistration, String email, String updatedKey) throws Exception {
        try (InputStream input = getClass()
                .getClassLoader().getResourceAsStream("email.properties")) {

            Properties emailProperties = new Properties();
            emailProperties.load(input);

//            Properties propsLocal = new Properties();
//            propsLocal.put("mail.smtp.auth", "true");
//            propsLocal.put("mail.smtp.starttls.enable", "true");
//            propsLocal.put("mail.smtp.host", "smtp.gmail.com");
//            propsLocal.put("mail.smtp.port", "587");

            String SMTP_USERNAME = "AKIAU2PIMQK7ANMAFBOC";
            String SMTP_PASSWORD = "BGAqCyfXmcwbvLQRiakJZ4F5oHuxpip/pQzN/PHbyNCa";
            String HOST = "email-smtp.us-east-2.amazonaws.com";
            final int PORT = 587;

            Properties props = System.getProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", PORT);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

//            Session sessionLocal = Session.getInstance(propsLocal, new Authenticator() {

//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(emailProperties.get("email").toString(), emailProperties.get("pwd").toString());
//                }
//            });
//            Message msgLocal = new MimeMessage(sessionLocal);
//            msgLocal.setFrom(new InternetAddress(emailProperties.get("from").toString(), false));

//            msgLocal.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            String subject = null;
            if (isRegistration) {
//                msgLocal.setSubject(emailProperties.get("subjectRegistration").toString());
                subject = emailProperties.get("subjectRegistration").toString();
            } else {
//                msgLocal.setSubject(emailProperties.get("subjectForgotPassword").toString());
                subject = emailProperties.get("subjectForgotPassword").toString();
            }

//            msgLocal.setContent("CONTENT", "text/html");
//            msgLocal.setSentDate(new Date());

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

//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//
//            msgLocal.setContent(multipart);
//            Transport.send(msgLocal);


            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailProperties.get("email").toString()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject(subject);
            msg.setContent(messageBodyPart.getContent(), "text/html");
            Transport transport = session.getTransport();

            // Send the message.
            try {
                transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
                transport.sendMessage(msg, msg.getAllRecipients());
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                transport.close();
            }
        }
    }

    private String encryptMail(String email) {
        final String secretKey = "Barber127Barber120";
        return EncryptorDecryptor.encrypt(email, secretKey);
    }
}
