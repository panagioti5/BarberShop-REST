package com.shop.rest.services.shops.search;

import com.shop.rest.constants.Cities;
import com.shop.rest.constants.Temp;
import com.shop.rest.entities.Address;
import com.shop.rest.entities.Shop;
import com.shop.rest.entities.ShopDetails;
import com.shop.rest.entities.ShopWorkers;
import com.shop.rest.exceptionhandlers.barbershop.AddressNotFoundException;
import com.shop.rest.exceptionhandlers.barbershop.WorkersNotFoundException;
import com.shop.rest.interfaces.SearchShops;
import com.shop.rest.utils.UtilsImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchShopsService implements SearchShops
{

    @Override
    public List<Shop> searchAllShopsByCity(String city)
    {
        List<Shop> allShopsByCity = Temp.getShopsList(Cities.Limassol.name());
        allShopsByCity.stream().forEach(shop -> populateShopDetails(shop));
        return allShopsByCity;
    }

    private void populateShopDetails(Shop shop)
    {
        ShopDetails shopDetails = shop.getShopDetails();
        List<ShopWorkers> workersInShop = UtilsImpl.getWorkersByShopID(shop.getShopId());
        shopDetails.setShopWorkers(workersInShop);
        Address address = UtilsImpl.getShopAddressByShopID(shop.getShopId());
        shopDetails.setShopAddress(address);
        shopDetails.setShopName("Barber Name " + shop.getShopId());
        shop.setShopDetails(shopDetails);
    }

}
