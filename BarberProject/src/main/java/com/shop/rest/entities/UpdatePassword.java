package com.shop.rest.entities;

public class UpdatePassword {
    private String code;
    private String email;
    private byte[] newToken;

    public UpdatePassword() {
    }

    public UpdatePassword(String code, String email, byte[] newToken) {
        this.code = code;
        this.email = email;
        this.newToken = newToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getNewToken() {
        return newToken;
    }

    public void setNewToken(byte[] newToken) {
        this.newToken = newToken;
    }
}
