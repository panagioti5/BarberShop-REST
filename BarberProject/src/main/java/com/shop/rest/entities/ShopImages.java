package com.shop.rest.entities;


import org.springframework.stereotype.Component;

@Component
public class ShopImages {

    private String imageLink;
    private String imageDescription;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}
