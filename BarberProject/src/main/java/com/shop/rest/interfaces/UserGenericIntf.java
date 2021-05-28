package com.shop.rest.interfaces;

import com.shop.rest.constants.UserOperationCodes;
import com.shop.rest.entities.PushNotificationUsers;
import com.shop.rest.entities.UpdatePassword;
import com.shop.rest.entities.User;
import com.shop.rest.entities.UserDetails;

import java.util.List;

public interface UserGenericIntf {

    public UserOperationCodes getUserExistence(UserDetails userDetails);

    public UserOperationCodes registerUser(UserDetails user);

    public UserOperationCodes confirmAccount(String email);

    public UserOperationCodes resendVerification(String email);

    public UserDetails userDetails(UserDetails user);

    public UserOperationCodes forgotPassword(UserDetails user);

    public UserOperationCodes updateToken(UpdatePassword updatePassword);

    public List<User> getAllUsers();

    public UserOperationCodes userDetailsUpdate(UserDetails user);

    public void savePushToken(PushNotificationUsers pushNotificationUsers);
}
