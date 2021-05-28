package com.shop.rest.interfaces;

import java.util.List;

public interface ShopIntf extends GenericIntf {

    public List<? extends Object> getAllShopsByAreaAndDateTime(String city, long currentDateTimeInMills, int indexId);

    public List<? extends Object> getAllShopsForArea(String area);

    public List<? extends Object> getAllSuggestedShops();

    public List<? extends Object> getSuggestedShopsByCity(String area);

    public List<? extends Object> getPopularShops();
}
