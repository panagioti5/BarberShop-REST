package com.shop.rest.utils;

import com.shop.rest.constants.Constants;
import com.shop.rest.constants.TempAddress;
import com.shop.rest.constants.TempWorkers;
import com.shop.rest.entities.Address;
import com.shop.rest.entities.ShopWorkers;

import java.util.List;
import java.util.stream.Collectors;

public class UtilsImpl {

    public static String getShopStatusMessage(long shopId, long currentDateTimeInMills) {

        if (shopId == 1) {
            return Constants.SHOP_CLOSES_SOON;
        }

        if (shopId == 3) {
            return Constants.SHOP_CLOSES_SOON;
        }
        if (shopId == 10) {
            return Constants.SHOP_OPEN;
        }
        if (shopId == 6) {
            return Constants.SHOP_CLOSED;
        }
        return Constants.SHOP_CLOSES_SOON;
    }

    public static List<ShopWorkers> getWorkersByShopID(long shopID) {
        return TempWorkers.getAllShopWorkers().stream().filter(w -> shopID == w.getShopId()).collect(Collectors.toList());
    }

    public static Address getShopAddressByShopID(long shopID) {
        return TempAddress.getAllAddressList().stream().filter(a -> shopID == a.getShopId()).findAny().orElse(null);
    }

    public static boolean isNotNullOrEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
