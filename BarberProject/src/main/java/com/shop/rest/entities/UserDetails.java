package com.shop.rest.entities;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {

    private String userEmail;
    private byte[] userToken;
    private String name;
    private long phoneNumber;
    private boolean acceptsNotifications;
    private boolean acceptsPushNotifications;
    private byte[] userOldToken;


    public UserDetails() {
    }

    public UserDetails(String userEmail, byte[] userToken, String name, long phoneNumber, boolean acceptsNotifications, boolean acceptsPushNotifications, byte[] userOldToken) {
        setUserEmail(userEmail);
        setUserToken(userToken);
        setName(name);
        setPhoneNumber(phoneNumber);
        setAcceptsNotifications(acceptsNotifications);
        setAcceptsPushNotifications(acceptsPushNotifications);
        setUserOldToken(userOldToken);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public byte[] getUserToken() {
        return userToken;
    }

    public void setUserToken(byte[] userToken) {
        this.userToken = userToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAcceptsNotifications() {
        return acceptsNotifications;
    }

    public void setAcceptsNotifications(boolean acceptsNotifications) {
        this.acceptsNotifications = acceptsNotifications;
    }

    public boolean isAcceptsPushNotifications() {
        return acceptsPushNotifications;
    }

    public void setAcceptsPushNotifications(boolean acceptsPushNotifications) {
        this.acceptsPushNotifications = acceptsPushNotifications;
    }

    public byte[] getUserOldToken() {
        return userOldToken;
    }

    public void setUserOldToken(byte[] userOldToken) {
        this.userOldToken = userOldToken;
    }
}
