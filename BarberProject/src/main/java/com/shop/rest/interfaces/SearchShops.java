package com.shop.rest.interfaces;

import java.util.List;

public interface SearchShops
{
    public List<? extends Object> searchAllShopsByCity(String city);
}
