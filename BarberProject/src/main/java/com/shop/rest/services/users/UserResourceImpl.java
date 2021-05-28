package com.shop.rest.services.users;

import com.shop.rest.constants.UserOperationCodes;
import com.shop.rest.dbrepo.users.UserDBRepository;
import com.shop.rest.emails.EmailSender;
import com.shop.rest.entities.PushNotificationUsers;
import com.shop.rest.entities.UpdatePassword;
import com.shop.rest.entities.User;
import com.shop.rest.entities.UserDetails;
import com.shop.rest.exceptionhandlers.users.UserAlreadyExistsException;
import com.shop.rest.exceptionhandlers.users.UserNotFoundException;
import com.shop.rest.exceptionhandlers.users.UserVerificationPendingException;
import com.shop.rest.interfaces.UserGenericIntf;
import com.shop.rest.utils.EncryptorDecryptor;
import com.shop.rest.utils.UtilsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Component
public class UserResourceImpl implements UserGenericIntf, CommandLineRunner {

    Logger log = LoggerFactory.getLogger(UserResourceImpl.class);

    @Autowired
    private UserDBRepository userDBRepository;

    @Override
    public UserOperationCodes getUserExistence(UserDetails userDetails) {

        if (null != userDetails && UtilsImpl.isNotNullOrEmpty(userDetails.getUserEmail()) && null != userDetails.getUserToken()) {

            Optional<User> userFiltered = userDBRepository.findByEmailAndToken(userDetails.getUserEmail(), userDetails.getUserToken());

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found");
            }

            boolean isUserAccountActivated = userFiltered.map(User::isUserAccountActivated).get();

            if (!isUserAccountActivated) {
                throw new UserVerificationPendingException("User account pending verification. Check your email");
            }

            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("ER1");
    }

    @Override
    public UserOperationCodes registerUser(UserDetails user) {

        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())
                && null != user.getUserToken()
                && UtilsImpl.isNotNullOrEmpty(user.getName())
                && user.getPhoneNumber() != -1) {

            Optional<User> userFiltered = userDBRepository.findByEmail(user.getUserEmail());

            if (null != userFiltered && userFiltered.isPresent()) {
                throw new UserAlreadyExistsException("User already exists");
            }

            UserDetails newUser = new UserDetails(user.getUserEmail(), user.getUserToken(),
                    user.getName(), user.getPhoneNumber(), user.isAcceptsNotifications(), user.isAcceptsPushNotifications(), null);

            userDBRepository.save(newUser);

            EmailSender emailSender = new EmailSender();
            try {
                emailSender.send(true, newUser.getUserEmail(), "");
            } catch (Exception e) {
                return UserOperationCodes.success;
            }
            return UserOperationCodes.success;
        }
        throw new UserAlreadyExistsException("ER2");
    }

    @Override
    public UserOperationCodes confirmAccount(String email) {
        final String secretKey = "Barber127Barber120";
        String decodedMail = EncryptorDecryptor.decrypt(email, secretKey);

        if (UtilsImpl.isNotNullOrEmpty(decodedMail)) {

            Optional<User> userFiltered = userDBRepository.findByEmail(decodedMail);

            if (null == userFiltered || !userFiltered.isPresent()) {
                return null;
            }
            boolean isUserAccountActivated = userFiltered.get().isUserAccountActivated();

            if (isUserAccountActivated) {
                return UserOperationCodes.alreadyActivated;
            }
            userDBRepository.setAccountActivated(decodedMail);
            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("");
    }

    @Override
    public UserOperationCodes resendVerification(String email) {

        Optional<User> userFiltered = userDBRepository.findByEmail(email);

        if (null == userFiltered || !userFiltered.isPresent()) {
            throw new UserNotFoundException("User Not found");
        }

        EmailSender emailSender = new EmailSender();
        try {
            emailSender.send(true, email, "");
        } catch (Exception e) {
            return UserOperationCodes.success;
        }
        return UserOperationCodes.success;
    }

    @Override
    public UserDetails userDetails(UserDetails user) {

        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail()) && null != user.getUserToken()) {

            Optional<User> userFiltered = userDBRepository.findByEmailAndToken(user.getUserEmail(), user.getUserToken());

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


    @Override
    public UserOperationCodes forgotPassword(UserDetails user) {
        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())) {

            Optional<User> userFiltered = userDBRepository.findByEmail(user.getUserEmail());

            if (null == userFiltered || !userFiltered.isPresent()) {
                return UserOperationCodes.success;
            }

            String key = generateRandomKey();
            if (userDBRepository.forgotPasswordSelectEntry(user) == 1) {
                userDBRepository.forgotPasswordUpdateEntry(user, key);
            } else {
                userDBRepository.forgotPasswordInsertEntry(user, key);
            }

            EmailSender sendForgotPasswordEmail = new EmailSender();
            try {
                sendForgotPasswordEmail.send(false, user.getUserEmail(), key);
            } catch (Exception e) {
                return UserOperationCodes.success;
            }
        }
        return UserOperationCodes.success;
    }

    @Override
    public UserOperationCodes updateToken(UpdatePassword updatePassword) {
        if (UtilsImpl.isNotNullOrEmpty(updatePassword.getEmail())
                && UtilsImpl.isNotNullOrEmpty(updatePassword.getCode())
                && null != updatePassword.getNewToken()) {

            Optional<User> userFiltered = userDBRepository.findByEmail(updatePassword.getEmail());

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found");
            }
            if (userDBRepository.selectUserFPByEmailAndCode(updatePassword.getCode(), updatePassword.getEmail()) == 1) {
                userDBRepository.updateUserPassword(updatePassword.getEmail(), updatePassword.getNewToken());
                userDBRepository.expireFPEntry(updatePassword.getEmail());
                return UserOperationCodes.success;
            } else {
                //forgotPasswordStepNotDone
                throw new UserNotFoundException("Invalid Reach Point");
            }
        }
        throw new UserNotFoundException("");
    }

    private String generateRandomKey() {
        Random r = new Random(System.currentTimeMillis());
        return String.valueOf(10000 + r.nextInt(20000));
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public List<User> getAllUsers() {
        return userDBRepository.getAllRegisteredUsers();
    }

    @Override
    public UserOperationCodes userDetailsUpdate(UserDetails user) {
        if (UtilsImpl.isNotNullOrEmpty(user.getUserEmail())
                && null != user.getUserToken()
                && UtilsImpl.isNotNullOrEmpty(user.getName())
                && user.getPhoneNumber() != -1) {

            Optional<User> userFiltered = userDBRepository.findByEmailAndToken(user.getUserEmail(), user.getUserOldToken());

            if (null == userFiltered || !userFiltered.isPresent()) {
                throw new UserNotFoundException("User Not found");
            }
            userDBRepository.updateUserDetails(user);
            return UserOperationCodes.success;
        }
        throw new UserNotFoundException("");
    }

    @Override
    public void savePushToken(PushNotificationUsers pushNotificationUsers) {
        if (UtilsImpl.isNotNullOrEmpty(pushNotificationUsers.getPushNotificationID()) && !UtilsImpl.isNotNullOrEmpty(pushNotificationUsers.getUserEmail())) {
            userDBRepository.saveUnknownToken(pushNotificationUsers);
            return;
        }
        if (UtilsImpl.isNotNullOrEmpty(pushNotificationUsers.getPushNotificationID()) && UtilsImpl.isNotNullOrEmpty(pushNotificationUsers.getUserEmail())) {

            int registeredTokens = userDBRepository.findTokenExistence(pushNotificationUsers.getPushNotificationID());

            if (registeredTokens == 1) {
                userDBRepository.updateTokenWithUserMail(pushNotificationUsers);
            } else if (registeredTokens == 0) {
                userDBRepository.insertTokenWithUserMail(pushNotificationUsers);
            }
            return;
        }
    }
}
