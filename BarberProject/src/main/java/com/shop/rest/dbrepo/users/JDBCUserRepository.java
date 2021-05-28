package com.shop.rest.dbrepo.users;


import com.shop.rest.entities.PushNotificationUsers;
import com.shop.rest.entities.User;
import com.shop.rest.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JDBCUserRepository implements UserDBRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(UserDetails user) {
        jdbcTemplate.update(
                "insert into USERS (userEmail, userToken,name,phoneNumber,isUserAccountActivated,acceptsNotifications, acceptsPushNotifications, policyAgreed) values(?,?,?,?,?,?,?,?)",
                user.getUserEmail(), user.getUserToken(), user.getName(), user.getPhoneNumber(), false, user.isAcceptsNotifications(), user.isAcceptsPushNotifications(), true);
    }

    @Override
    public Optional<User> findByEmailAndToken(String email, byte[] token) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from users where userEmail = ? and userToken = ?",
                    new Object[]{email, token},
                    (rs, rowNum) ->
                            Optional.of(new User(
                                    rs.getString("userEmail"),
                                    rs.getBytes("userToken"),
                                    rs.getString("name"),
                                    rs.getLong("phoneNumber"),
                                    rs.getBoolean("isUserAccountActivated"),
                                    rs.getBoolean("acceptsNotifications"),
                                    rs.getBoolean("acceptsPushNotifications"),
                                    rs.getBoolean("policyAgreed"))));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from users where userEmail = ?",
                    new Object[]{email},
                    (rs, rowNum) ->
                            Optional.of(new User(
                                    rs.getString("userEmail"),
                                    rs.getBytes("userToken"),
                                    rs.getString("name"),
                                    rs.getLong("phoneNumber"),
                                    rs.getBoolean("isUserAccountActivated"),
                                    rs.getBoolean("acceptsNotifications"),
                                    rs.getBoolean("acceptsPushNotifications"),
                                    rs.getBoolean("policyAgreed"))));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setAccountActivated(String email) {
        jdbcTemplate.update(
                "update users set isUserAccountActivated = ? where userEmail = ?",
                true, email);
    }

    @Override
    public void forgotPasswordInsertEntry(UserDetails user, String updatedKey) {
        jdbcTemplate.update(
                "insert into USERS_FP (userEmail, updatedKey, isExpired) values(?,?,?)",
                user.getUserEmail(), updatedKey, false);
    }

    @Override
    public void forgotPasswordUpdateEntry(UserDetails user, String updatedKey) {
        jdbcTemplate.update(
                "update USERS_FP set updatedKey = ? , isExpired = ? where userEmail = ?",
                updatedKey, false, user.getUserEmail());
    }

    @Override
    public int forgotPasswordSelectEntry(UserDetails user) {
        return jdbcTemplate.queryForObject(
                "select count(*) from users_FP where userEmail = ?", Integer.class,
                user.getUserEmail());
    }

    @Override
    public int selectUserFPByEmailAndCode(String code, String email) {
        return jdbcTemplate.queryForObject(
                "select count(*) from users_FP where userEmail = ? and updatedKey = ? and isExpired = ?", Integer.class,
                email, code, false);
    }

    @Override
    public void updateUserPassword(String email, byte[] newToken) {
        jdbcTemplate.update(
                "update USERS set userToken = ? where userEmail = ?",
                newToken, email);
    }

    @Override
    public void expireFPEntry(String email) {
        jdbcTemplate.update(
                "update USERS_FP set isExpired = ? where userEmail = ?",
                true, email);
    }

    @Override
    public List<User> getAllRegisteredUsers() {
        try {
            return jdbcTemplate.query(
                    "select * from users",
                    (rs, rowNum) ->
                            new User(
                                    rs.getString("userEmail"),
                                    rs.getBytes("userToken"),
                                    rs.getString("name"),
                                    rs.getLong("phoneNumber"),
                                    rs.getBoolean("isUserAccountActivated"),
                                    rs.getBoolean("acceptsNotifications"),
                                    rs.getBoolean("acceptsPushNotifications"),
                                    rs.getBoolean("policyAgreed")
                            )
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUserDetails(UserDetails user) {
        jdbcTemplate.update(
                "update USERS set userToken = ?, name = ?, phoneNumber = ?, acceptsNotifications = ?, acceptsPushNotifications = ? where userEmail = ?",
                user.getUserToken(), user.getName(), user.getPhoneNumber(), user.isAcceptsNotifications(),user.isAcceptsPushNotifications(), user.getUserEmail());
    }

    @Override
    public void saveUnknownToken(PushNotificationUsers pushNotificationUsers) {
        try {
            jdbcTemplate.update(
                    "insert into TBNOTIFICATIONS (pushNotificationID, userEmail,acceptsPushNotifications, isUserSignedIn) values(?,?,?,?)",
                    pushNotificationUsers.getPushNotificationID(), null, pushNotificationUsers.getAcceptsPushNotifications(), null);
        } catch (Exception e) {

        }

    }

    @Override
    public int findTokenExistence(String pushNotificationID) {
        return jdbcTemplate.queryForObject(
                "select count(*) from TBNOTIFICATIONS where pushNotificationID = ?", Integer.class,
                pushNotificationID);
    }

    @Override
    public void updateTokenWithUserMail(PushNotificationUsers pushNotificationUsers) {
        jdbcTemplate.update(
                "update TBNOTIFICATIONS set userEmail = ? , acceptsPushNotifications = ?, isUserSignedIn = ? where pushNotificationID = ?",
                pushNotificationUsers.getUserEmail(), pushNotificationUsers.getAcceptsPushNotifications(), pushNotificationUsers.isSignedIn(), pushNotificationUsers.getPushNotificationID());
    }

    @Override
    public void insertTokenWithUserMail(PushNotificationUsers pushNotificationUsers) {
        try {
            jdbcTemplate.update(
                    "insert into TBNOTIFICATIONS (pushNotificationID, userEmail,acceptsPushNotifications, isUserSignedIn) values(?,?,?,?)",
                    pushNotificationUsers.getPushNotificationID(), pushNotificationUsers.getUserEmail(), pushNotificationUsers.getAcceptsPushNotifications(), pushNotificationUsers.isSignedIn());
        } catch (Exception e) {

        }
    }
}