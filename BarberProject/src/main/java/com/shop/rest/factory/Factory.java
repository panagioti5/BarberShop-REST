package com.shop.rest.factory;

import com.shop.rest.constants.Constants;
import com.shop.rest.interfaces.ElementRanker;
import com.shop.rest.services.ranker.ShopElementRankerImpl;

public class Factory {


    public ElementRanker getElementRankerObjectType(String elementType) {

        if (elementType.equals(Constants.BARBER_SHOP_TYPE_NAME)) {

            return new ShopElementRankerImpl();
        }
        return null;
    }

}
