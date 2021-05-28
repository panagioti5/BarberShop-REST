package com.shop.rest.entities;


import org.springframework.stereotype.Component;

@Component
public class ShopWorkers {
    private String name;
    private String surname;
    private String workerProfilePictureLink;
    private String workerDesc;
    private long shopId;

    public ShopWorkers(){}

    //Temporary before db creation for testing purposes
    public ShopWorkers(String name, String surname, long shopId)
    {
        this.setName(name);
        this.setSurname(surname);
        this.setShopId(shopId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWorkerProfilePictureLink() {
        return workerProfilePictureLink;
    }

    public void setWorkerProfilePictureLink(String workerProfilePictureLink) {
        this.workerProfilePictureLink = workerProfilePictureLink;
    }

    public String getWorkerDesc() {
        return workerDesc;
    }

    public void setWorkerDesc(String workerDesc) {
        this.workerDesc = workerDesc;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
}
