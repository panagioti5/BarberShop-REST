package com.shop.rest.controllers.users;

import com.shop.rest.constants.UserOperationCodes;
import com.shop.rest.emails.EmailSenderAWS;
import com.shop.rest.entities.UpdatePassword;
import com.shop.rest.entities.UserDetails;
import com.shop.rest.exceptionhandlers.users.UserAlreadyExistsException;
import com.shop.rest.exceptionhandlers.users.UserNotFoundException;
import com.shop.rest.exceptionhandlers.users.UserVerificationPendingException;
import com.shop.rest.utils.EncryptorDecryptor;
import com.shop.rest.utils.UtilsImpl;

import java.util.*;

public class UsersTemp {

    private static List<UserDetails> userList = new ArrayList<>();
    private static List<String> activatedAccounts = new ArrayList<>();
    private static Map<String, String> forgotPwd = new HashMap<>();

    public UserOperationCodes registerUser(UserDetails user) {

        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())
//                && null != user.getUserToken()
                && UtilsImpl.isNotNullOrEmpty(user.getName())
                && user.getPhoneNumber() != -1) {

            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(user.getUserEmail())).findFirst();

            if (null != userFiltered && userFiltered.isPresent()) {
                throw new UserAlreadyExistsException("User already exists");
            }

            UserDetails newUser = new UserDetails(user.getUserEmail(), user.getUserToken(),
                    user.getName(), user.getPhoneNumber(), user.isAcceptsNotifications(), user.isAcceptsPushNotifications(), null);

            userList.add(newUser);

            EmailSenderAWS emailSender = new EmailSenderAWS();
            try {
                emailSender.send(true, newUser.getUserEmail(), "");
            } catch (Exception e) {
                return UserOperationCodes.success;
            }
            return UserOperationCodes.success;
        }
        throw new UserAlreadyExistsException("ER2");
    }

    public UserOperationCodes resendVerification(String email) {

        Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(email)).findFirst();
        System.out.println(userList);
        if (null == userFiltered || !userFiltered.isPresent()) {
            throw new UserNotFoundException("User Not found");
        }

        EmailSenderAWS emailSender = new EmailSenderAWS();
        try {
            emailSender.send(true, email, "");
        } catch (Exception e) {
            return UserOperationCodes.success;
        }
        return UserOperationCodes.success;
    }

    public UserOperationCodes confirmAccount(String email) {
        final String secretKey = "Barber127Barber120";
        String decodedMail = EncryptorDecryptor.decrypt(email, secretKey);
        System.out.println(decodedMail);
        if (UtilsImpl.isNotNullOrEmpty(decodedMail)) {

            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(decodedMail)).findFirst();

            if (null == userFiltered || !userFiltered.isPresent()) {
                return null;
            }
            if (activatedAccounts.contains(decodedMail)) {
                return UserOperationCodes.alreadyActivated;
            }
            activatedAccounts.add(decodedMail);
            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("");
    }

    public UserOperationCodes getUserExistence(UserDetails userDetails) {
        if (UtilsImpl.isNotNullOrEmpty(userDetails.getUserEmail())) {
//            Optional<User> userFiltered = userDBRepository.findByEmailAndToken(userDetails.getUserEmail(), userDetails.getUserToken());
            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(userDetails.getUserEmail())).findFirst();
            System.out.println(userFiltered + " 111");
            System.out.println(userList + "22");
            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found.");
            }

            boolean isUserAccountActivated = activatedAccounts.contains(userDetails.getUserEmail());

            if (!isUserAccountActivated) {
                throw new UserVerificationPendingException("User account pending verification. Check your email");
            }

            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("ER1");
    }

    public UserDetails userDetails(UserDetails user) {

        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())) {

            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(user.getUserEmail())).findFirst();

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found");
            }

            UserDetails userDetails = new UserDetails();
            userDetails.setName(userFiltered.get().getName());
            userDetails.setPhoneNumber(userFiltered.get().getPhoneNumber());
            userDetails.setUserEmail(userFiltered.get().getUserEmail());
            userDetails.setUserToken(userFiltered.get().getUserToken());
            userDetails.setAcceptsNotifications(userFiltered.get().isAcceptsNotifications());
            userDetails.setAcceptsPushNotifications(userFiltered.get().isAcceptsPushNotifications());

            return userDetails;
        }
        throw new UserNotFoundException("");
    }

    public UserOperationCodes forgotPassword(UserDetails user) {
        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())) {

            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(user.getUserEmail())).findFirst();

            if (null == userFiltered || !userFiltered.isPresent()) {
                return UserOperationCodes.success;
            }

            String key = generateRandomKey();
            if (UtilsImpl.isNotNullOrEmpty(forgotPwd.get(user.getUserEmail()))) {
                forgotPwd.put(user.getUserEmail(), key);
            } else {
                forgotPwd.put(user.getUserEmail(), key);
            }

            EmailSenderAWS sendForgotPasswordEmail = new EmailSenderAWS();
            try {
                sendForgotPasswordEmail.send(false, user.getUserEmail(), key);
            } catch (Exception e) {
                return UserOperationCodes.success;
            }
        }
        return UserOperationCodes.success;
    }

    private String generateRandomKey() {
        Random r = new Random(System.currentTimeMillis());
        return String.valueOf(10000 + r.nextInt(20000));
    }

    public UserOperationCodes updateToken(UpdatePassword updatePassword) {
        if (UtilsImpl.isNotNullOrEmpty(updatePassword.getEmail())
                && UtilsImpl.isNotNullOrEmpty(updatePassword.getCode())) {

            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(updatePassword.getEmail())).findFirst();

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found");
            }
            if (UtilsImpl.isNotNullOrEmpty(forgotPwd.get(updatePassword.getEmail())) && forgotPwd.get(updatePassword.getEmail()).equals(updatePassword.getCode())) {
//                userDBRepository.updateUserPassword(updatePassword.getEmail(), updatePassword.getNewToken());
                forgotPwd.remove(updatePassword.getEmail());
                return UserOperationCodes.success;
            } else {
                //forgotPasswordStepNotDone
                throw new UserNotFoundException("Invalid Reach Point");
            }
        }
        throw new UserNotFoundException("");
    }

    public void clearAll(String eraseMethod) {
        userList.clear();
        activatedAccounts.clear();
        forgotPwd.clear();
    }



    public UserOperationCodes updateUser(UserDetails userDetails) {
        if (UtilsImpl.isNotNullOrEmpty(userDetails.getUserEmail())) {
            Optional<UserDetails> userFiltered = userList.stream().filter(x -> x.getUserEmail().equals(userDetails.getUserEmail())).findFirst();

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found.");
            }
            userFiltered.get().setName(userDetails.getName());
            userFiltered.get().setUserToken(userDetails.getUserToken());
            userFiltered.get().setPhoneNumber(userDetails.getPhoneNumber());

            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("ER1");
    }
}
