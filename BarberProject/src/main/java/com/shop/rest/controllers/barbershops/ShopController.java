package com.shop.rest.controllers.barbershops;


import com.shop.rest.constants.OperationCodes;
import com.shop.rest.entities.Shop;
import com.shop.rest.interfaces.SearchShops;
import com.shop.rest.interfaces.ShopIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    ShopIntf shopService;

    @Autowired
    SearchShops searchShopsService;

    @GetMapping("/getAllShops")
    @SuppressWarnings("unchecked")
    public List<Shop> getAllShops() {
        return (List<Shop>) shopService.getAll();
    }

    @GetMapping("/getAllShopsByAreaAndDateTime/{city}/{currentDateTimeInMills}/{indexId}")
    @SuppressWarnings("unchecked")
    public List<Shop> getAllShops(@PathVariable String city, @PathVariable long currentDateTimeInMills, @PathVariable int indexId) {
        System.out.println("Helloooooooooooooooo");
        return (List<Shop>) shopService.getAllShopsByAreaAndDateTime(city, currentDateTimeInMills, indexId);
    }

    @GetMapping("/getPopularShops")
    @SuppressWarnings("unchecked")
    public List<Shop> getPopularShops() {
        return (List<Shop>) shopService.getPopularShops();
    }

    @GetMapping("/getAllShops/{city}")
    @SuppressWarnings("unchecked")
    public List<Shop> getAllShopsForCity(@PathVariable String city) {
        return (List<Shop>) shopService.getAllShopsForArea(city);
    }

    @GetMapping("/delete/{shopID}")
    public OperationCodes deleteShop(@PathVariable long shopID) {
        return shopService.delete(shopID);
    }

    @GetMapping("/getShop/{shopID}/{currentDateTimeInMills}")
    public Shop getShop(@PathVariable long shopID, @PathVariable long currentDateTimeInMills) {
        return (Shop) shopService.get(shopID, currentDateTimeInMills);
    }

    @GetMapping("/update/{shopID}")
    public OperationCodes updateShop(@PathVariable long shopID) {
        return shopService.update(shopID);
    }

    @GetMapping("/getSuggestedShops")
    @SuppressWarnings("unchecked")
    public List<Shop> getSuggestedShops() {
        return (List<Shop>) shopService.getAllSuggestedShops();
    }

    @GetMapping("/getSuggestedShops/{city}")
    @SuppressWarnings("unchecked")

    public List<Shop> getSuggestedShopsByCity(@PathVariable String city) {
        return (List<Shop>) shopService.getSuggestedShopsByCity(city);
    }

    @GetMapping("searchAllShopsByCity/{city}")
    public List<Shop> searchAllShopsByCity(@PathVariable String city) {
        return (List<Shop>) searchShopsService.searchAllShopsByCity(city);
    }

}
