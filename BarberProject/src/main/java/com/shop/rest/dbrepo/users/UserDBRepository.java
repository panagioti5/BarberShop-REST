package com.shop.rest.dbrepo.users;

import com.shop.rest.entities.PushNotificationUsers;
import com.shop.rest.entities.User;
import com.shop.rest.entities.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDBRepository {
    public void save(UserDetails user);

    public Optional<User> findByEmailAndToken(String email, byte[] token);

    public Optional<User> findByEmail(String email);

    public void setAccountActivated(String email);

    public void forgotPasswordInsertEntry(UserDetails user, String updatedKey);

    public void forgotPasswordUpdateEntry(UserDetails user, String updatedKey);

    public int forgotPasswordSelectEntry(UserDetails user);

    public int selectUserFPByEmailAndCode(String code, String email);

    public void updateUserPassword(String email, byte[] newToken);

    public void expireFPEntry(String email);

    public List<User> getAllRegisteredUsers();

    public void updateUserDetails(UserDetails user);

    public void saveUnknownToken(PushNotificationUsers pushNotificationUsers);

    public int findTokenExistence(String pushNotificationID);

    public void updateTokenWithUserMail(PushNotificationUsers pushNotificationUsers);

    public void insertTokenWithUserMail(PushNotificationUsers pushNotificationUsers);
}
