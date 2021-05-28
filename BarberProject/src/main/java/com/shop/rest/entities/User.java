package com.shop.rest.entities;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String userEmail;
    private byte[] userToken;
    private String name;
    private long phoneNumber;
    private boolean isUserAccountActivated;
    private boolean acceptsNotifications;
    private boolean acceptsPushNotifications;
    private boolean policyAgreed;


    public User() {
    }

    public User(String userEmail, byte[] userToken, String name, long phoneNumber, boolean isUserAccountActivated, boolean acceptsNotifications, boolean acceptsPushNotifications, boolean policyAgreed) {
        setUserEmail(userEmail);
        setUserToken(userToken);
        setName(name);
        setPhoneNumber(phoneNumber);
        setUserAccountActivated(isUserAccountActivated);
        setAcceptsNotifications(acceptsNotifications);
        setAcceptsPushNotifications(acceptsPushNotifications);
        setPolicyAgreed(policyAgreed);
    }

    public boolean getPolicyAgreed() {
        return policyAgreed;
    }

    public void setPolicyAgreed(boolean policyAgreed) {
        this.policyAgreed = policyAgreed;
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

    public boolean isUserAccountActivated() {
        return isUserAccountActivated;
    }

    public void setUserAccountActivated(boolean userAccountActivated) {
        isUserAccountActivated = userAccountActivated;
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
}
