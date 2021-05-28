package com.shop.rest.services.shops;

import com.shop.rest.constants.Cities;
import com.shop.rest.constants.OperationCodes;
import com.shop.rest.constants.Temp;
import com.shop.rest.entities.Address;
import com.shop.rest.entities.Shop;
import com.shop.rest.entities.ShopDetails;
import com.shop.rest.exceptionhandlers.barbershop.BarberShopNotFoundException;
import com.shop.rest.helpers.AllShopsHelper;
import com.shop.rest.interfaces.ShopIntf;
import com.shop.rest.utils.UtilsImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopResourceImpl implements ShopIntf {


    @Override
    public List<Shop> getAll() {
        return null;
    }


    @Override
    public List<Shop> getAllShopsByAreaAndDateTime(String city, long currentDateTimeInMills, int indexId) {
        //This API, will give us the result of 1st app screen. We need to keep it smooth and fast.
        List<Shop> shopsInArea = Temp.getShopsList(city);

        if (shopsInArea.isEmpty()) {
            throw new BarberShopNotFoundException("Could not find shops in " + city);
        } else {
            AllShopsHelper helper = new AllShopsHelper();
            helper.setShops(shopsInArea);
            helper.setIndexID(indexId);
            helper.setCurrentDateTime(currentDateTimeInMills);
            helper.execute();
            return helper.getOutput();
        }
    }


    @Override
    public List<Shop> getAllShopsForArea(String city) {
        return null;
    }

    @Override
    public Shop get(long id, long currentDateTimeInMills) {
        if (null == Temp.getSpecificShop(id, currentDateTimeInMills)) {
            throw new BarberShopNotFoundException("Could not find shops");
        }
        return Temp.getSpecificShop(id, currentDateTimeInMills);
    }

    @Override
    public OperationCodes update(Object obj) {
        return OperationCodes.success;
    }

    @Override
    public OperationCodes delete(Object obj) {
        return OperationCodes.uncaught;
    }

    @Override
    public List<Object> getAllSuggestedShops() {
        throw new BarberShopNotFoundException("No suggested shops found");
    }

    @Override
    public List<Object> getSuggestedShopsByCity(String city) {
        throw new BarberShopNotFoundException("No suggested shops found in " + city);
    }

    @Override
    public List<? extends Object> getPopularShops() {
        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop(0, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/barber-shop-logo.jpg", false, new ShopDetails("Parperko o Pampos", Cities.Limassol.name(), new Address(34.676630, 33.012140))));
        shopList.add(new Shop(1, "https://images.squarespace-cdn.com/content/v1/5a5906400abd0406785519dd/1547305849352-CYT6FWXR75U7ZUBL5NAK/ke17ZwdGBToddI8pDm48kKAwwdAfKsTlKsCcElEApLR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UegTYNQkRo-Jk4EWsyBNhwKrKLo5CceA1-Tdpfgyxoog5ck0MD3_q0rY3jFJjjoLbQ/IB+alex.jpg?format=2500w", "https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/barber-shop-logo.jpg", true, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(34.676630, 33.012140))));
        shopList.add(new Shop(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(4, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(5, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(6, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(13, 14))));
        shopList.add(new Shop(7, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Ammochostos.name(), new Address(13, 14))));
        shopList.add(new Shop(8, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(13, 14))));
        shopList.add(new Shop(9, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(10, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(11, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(12, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(13, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(14, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Ammochostos.name(), new Address(13, 14))));
        shopList.add(new Shop(15, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(16, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(13, 14))));
        shopList.add(new Shop(17, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Ammochostos.name(), new Address(13, 14))));
        shopList.add(new Shop(18, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(19, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(20, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(21, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(22, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(23, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Ammochostos.name(), new Address(13, 14))));
        shopList.add(new Shop(24, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(25, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(26, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(27, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(28, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Nicosia.name(), new Address(13, 14))));
        shopList.add(new Shop(29, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(13, 14))));
        shopList.add(new Shop(30, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Larnaca.name(), new Address(13, 14))));
        shopList.add(new Shop(31, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Paphos.name(), new Address(13, 14))));
        populateStatusesOnShopsInArea(shopList, 0);
        return shopList;
    }
    private void populateStatusesOnShopsInArea(List<Shop> shopsInArea, long currentDateTimeInMills) {
        shopsInArea.forEach(x -> x.setStatusMessage(UtilsImpl.getShopStatusMessage(x.getShopId(), currentDateTimeInMills)));
    }
}
