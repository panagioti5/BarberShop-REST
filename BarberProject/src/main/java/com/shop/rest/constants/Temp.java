package com.shop.rest.constants;


import com.shop.rest.entities.*;
import com.shop.rest.utils.UtilsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Temp {

    public static List<Shop> getShopsList(String city) {
        //This method will return object only of below type.Nothing more. We need efficient API on loading of all Shops. "Heavy" API will take place once user clicks on any shop.
        List<Shop> shopList = new ArrayList<>();
//        shopList.add(new Shop(0, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName0", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(1, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName1", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName2", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName3", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(4, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName4", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(5, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName5", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(6, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName6", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(7, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName7", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(8, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName8", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(9, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName9", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(10, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName10", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(11, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName11", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(12, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName12", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(13, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName13", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(14, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName14", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(15, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName15", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(16, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName16", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(17, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName17", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(18, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName18", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(19, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName19", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(20, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName20", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(21, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName21", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(22, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName22", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(23, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName23", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(24, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName24", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(25, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName25", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(26, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName26", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(27, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName27", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(28, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName28", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(29, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName29", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(30, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName30", 10, 14, Cities.Nicosia.name())));
//        shopList.add(new Shop(31, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName31", 10, 14, Cities.Nicosia.name())));
//
//
//        shopList.add(new Shop(0, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName0", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(1, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName1", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName2", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName3", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(4, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName4", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(5, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName5", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(6, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName6", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(7, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName7", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(8, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName8", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(9, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName9", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(10, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName10", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(11, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName11", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(12, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName12", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(13, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName13", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(14, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName14", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(15, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName15", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(16, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName16", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(17, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName17", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(18, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName18", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(19, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName19", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(20, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName20", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(21, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName21", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(22, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName22", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(23, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName23", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(24, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName24", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(25, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName25", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(26, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName26", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(27, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName27", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(28, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName28", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(29, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName29", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(30, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName30", 10, 14, Cities.Limassol.name())));
//        shopList.add(new Shop(31, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName31", 10, 14, Cities.Limassol.name())));
//
//
//        shopList.add(new Shop(0, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName0", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(1, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName1", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName2", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName3", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(4, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName4", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(5, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName5", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(6, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName6", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(7, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName7", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(8, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName8", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(9, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName9", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(10, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName10", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(11, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName11", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(12, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName12", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(13, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName13", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(14, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName14", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(15, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName15", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(16, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName16", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(17, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName17", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(18, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName18", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(19, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName19", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(20, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName20", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(21, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName21", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(22, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName22", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(23, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName23", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(24, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName24", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(25, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName25", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(26, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName26", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(27, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName27", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(28, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName28", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(29, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName29", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(30, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName30", 10, 14, Cities.Larnaca.name())));
//        shopList.add(new Shop(31, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", new ShopDetails("ShopName31", 10, 14, Cities.Larnaca.name())));


        shopList.add(new Shop(0, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/barber-shop-logo.jpg", true, new ShopDetails("Parperko o Pa", Cities.Limassol.name(), new Address(34.676630, 33.012140))));
        shopList.add(new Shop(1, "https://images.squarespace-cdn.com/content/v1/5a5906400abd0406785519dd/1547305849352-CYT6FWXR75U7ZUBL5NAK/ke17ZwdGBToddI8pDm48kKAwwdAfKsTlKsCcElEApLR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UegTYNQkRo-Jk4EWsyBNhwKrKLo5CceA1-Tdpfgyxoog5ck0MD3_q0rY3jFJjjoLbQ/IB+alex.jpg?format=2500w", "https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/barber-shop-logo.jpg", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(34.676630, 33.012140))));
        shopList.add(new Shop(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(4, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(5, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(6, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(7, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(8, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(9, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(10, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(11, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(12, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(13, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(14, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(15, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(16, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(17, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(18, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(19, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(20, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(21, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(22, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(23, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", true, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(24, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(25, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(26, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(27, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(28, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(29, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(30, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));
        shopList.add(new Shop(31, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg", "https://cdn.logojoy.com/wp-content/uploads/2018/05/30161114/3_big6-768x591.png", false, new ShopDetails("ShopName10", Cities.Limassol.name(), new Address(13, 14))));

        return shopList.stream().filter(b -> city.equals(b.getShopDetails().getCity()))
                .collect(Collectors.toList());

    }


    public static Shop getSpecificShop(long id, Long currentDateTimeInMills) {

        Shop shop = new Shop();
        populateShopInfo(shop, currentDateTimeInMills);
        populateShopDetails(shop);
        populateShopImages(shop);
        populateAddressDetails(shop);
        populateSocialMediaDetails(shop);
        populateShopWorkers(shop);
        populateOpeningHours(shop);
        return shop;
    }


    private static void populateShopWorkers(Shop shop) {
        List<ShopWorkers> workers = new ArrayList<>();
        ShopWorkers worker1 = new ShopWorkers();
        worker1.setName("Will");
        worker1.setSurname("Smith");
        worker1.setWorkerProfilePictureLink("https://www.biography.com/.image/t_share/MTE4MDAzNDEwNzQzMTY2NDc4/will-smith-9542165-1-402.jpg");
        worker1.setWorkerDesc("Best Hair Cut");
        workers.add(worker1);

        ShopWorkers worker2 = new ShopWorkers();
        worker2.setName("Dwayne");
        worker2.setSurname("Johnson");
        worker2.setWorkerProfilePictureLink("https://ca-times.brightspotcdn.com/dims4/default/491b0cb/2147483647/strip/true/crop/5184x3456+0+0/resize/840x560!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F9e%2Faf%2F0d8ec73b408ba1fde362ef73570d%2F459362-et-0717-johnson-mwy-0066.JPG");
        worker2.setWorkerDesc("Employee of the year");
        workers.add(worker2);

        ShopWorkers worker3 = new ShopWorkers();
        worker3.setName("Roger");
        worker3.setSurname("Federer");
        worker3.setWorkerProfilePictureLink("https://images.beinsports.com/HeVCp5hiOsuighWXoqKvVRbpNyc=/full-fit-in/1000x0/roger-federer-cropped_1fwi3jtofry8z1cs9907pp8dfp.jpg");
        worker3.setWorkerDesc("Bast Shaving");
        workers.add(worker3);

        ShopWorkers worker4 = new ShopWorkers();
        worker4.setName("Barack");
        worker4.setSurname("Obama");
        worker4.setWorkerProfilePictureLink("https://www.clickondetroit.com/resizer/xicf4XaR_AcOLqwW2_EbbJDpbhE=/1280x720/smart/filters:format(jpeg):strip_exif(true):strip_icc(true):no_upscale(true):quality(65)/cloudfront-us-east-1.images.arcpublishing.com/gmg/PZKLWSUHYNB7LCY6NW2SP5QITM.jpg");
        worker4.setWorkerDesc("Awarded");
        workers.add(worker4);

        ShopWorkers worker5 = new ShopWorkers();
        worker5.setName("Bill");
        worker5.setSurname("Gates");
        worker5.setWorkerProfilePictureLink("https://www.kathimerini.com.cy/assets/modules/wnp/articles/202003/355888/images/b_bill.jpg");
        worker5.setWorkerDesc("Hair Coloring");
        workers.add(worker5);

        ShopWorkers worker6 = new ShopWorkers();
        worker6.setName("John");
        worker6.setSurname("Kennedy");
        worker6.setWorkerProfilePictureLink("https://www.history.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTU3ODc4Njc0MzgxMTU0MDE1/gettyimages-523204139-2.jpg");
        worker6.setWorkerDesc("Hair Care");
        workers.add(worker6);

        ShopWorkers worker7 = new ShopWorkers();
        worker7.setName("John");
        worker7.setSurname("Cena");
        worker7.setWorkerProfilePictureLink("https://upload.wikimedia.org/wikipedia/commons/6/60/John_Cena_July_2018.jpg");
        worker7.setWorkerDesc("Hair Styling");
        workers.add(worker7);

        ShopWorkers worker8 = new ShopWorkers();
        worker8.setName("Donald");
        worker8.setSurname("Trump");
        worker8.setWorkerProfilePictureLink("https://pmcdeadline2.files.wordpress.com/2019/10/shutterstock_editorial_10434333bm.jpg");
        worker8.setWorkerDesc("Extension Manager");
        workers.add(worker8);

        ShopWorkers worker9 = new ShopWorkers();
        worker9.setName("Usain");
        worker9.setSurname("Bolt");
        worker9.setWorkerProfilePictureLink("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fshaenamontanari%2Ffiles%2F2016%2F08%2FUsain_Bolt_Anniversary_Games_London_2013-1200x1466.jpg");
        worker9.setWorkerDesc("Beard Trimmer");
        workers.add(worker9);

        ShopWorkers worker10 = new ShopWorkers();
        worker10.setName("Cristiano");
        worker10.setSurname("Ronaldo");
        worker10.setWorkerProfilePictureLink("https://en.as.com/en/imagenes/2018/06/15/football/1529052763_864488_1529069355_noticia_normal.jpg");
        worker10.setWorkerDesc("Cut n' color");
        workers.add(worker10);

        shop.getShopDetails().setShopWorkers(workers);
    }

    private static void populateShopDetails(Shop shop) {
        ShopDetails shopDetails = new ShopDetails();
        shopDetails.setCity(Cities.Limassol.name());
        shopDetails.setPhoneNum(22933085);
        shopDetails.setPhoneNumAlt(99084676);
        shopDetails.setShopName("Barber Shop Name Here");
        shopDetails.setProviderServices("Hair Cut;Shaving;Washing;Cleaning;Caring");
        shop.setShopDetails(shopDetails);

    }

    private static void populateOpeningHours(Shop shop) {
        OpeningHours[] openingHours = new OpeningHours[7];
        openingHours[0] = new OpeningHours();
        openingHours[0].setDayOfWeek(DaysOfWeek.MONDAY);
        openingHours[0].setOpen(true);
        Integer[] openFromUntil0 = new Integer[4];
        openFromUntil0[0] = 900;
        openFromUntil0[1] = 1230;
        openFromUntil0[2] = 1430;
        openFromUntil0[3] = 1800;
        openingHours[0].setOpenFromUntil(openFromUntil0);


        openingHours[1] = new OpeningHours();
        openingHours[1].setDayOfWeek(DaysOfWeek.TUESDAY);
        openingHours[1].setOpen(true);
        Integer[] openFromUntil1 = new Integer[4];
        openFromUntil1[0] = 900;
        openFromUntil1[1] = 1230;
        openFromUntil1[2] = 1430;
        openFromUntil1[3] = 1800;
        openingHours[1].setOpenFromUntil(openFromUntil1);


        openingHours[2] = new OpeningHours();
        openingHours[2].setDayOfWeek(DaysOfWeek.WEDNESDAY);
        openingHours[2].setOpen(true);
        Integer[] openFromUntil2 = new Integer[4];
        openFromUntil2[0] = 800;
        openFromUntil2[1] = 1330;
        openFromUntil2[2] = 1430;
        openFromUntil2[3] = 1900;
        openingHours[2].setOpenFromUntil(openFromUntil2);

        openingHours[3] = new OpeningHours();
        openingHours[3].setDayOfWeek(DaysOfWeek.THURSDAY);
        openingHours[3].setOpen(true);
        Integer[] openFromUntil3 = new Integer[4];
        openFromUntil3[0] = 800;
        openFromUntil3[1] = 1330;
        openFromUntil3[2] = 1430;
        openFromUntil3[3] = 1900;
        openingHours[3].setOpenFromUntil(openFromUntil3);

        openingHours[4] = new OpeningHours();
        openingHours[4].setDayOfWeek(DaysOfWeek.FRIDAY);
        openingHours[4].setOpen(true);
        Integer[] openFromUntil4 = new Integer[4];
        openFromUntil4[0] = 700;
        openFromUntil4[1] = 1530;
        openFromUntil4[2] = 1630;
        openFromUntil4[3] = 2100;
        openingHours[4].setOpenFromUntil(openFromUntil4);

        openingHours[5] = new OpeningHours();
        openingHours[5].setDayOfWeek(DaysOfWeek.SATURDAY);
        openingHours[5].setOpen(false);

        openingHours[6] = new OpeningHours();
        openingHours[6].setDayOfWeek(DaysOfWeek.SUNDAY);
        openingHours[6].setOpen(true);
        Integer[] openFromUntil6 = new Integer[4];
        openFromUntil6[0] = 1200;
        openFromUntil6[1] = 2300;
        openingHours[6].setOpenFromUntil(openFromUntil6);

        shop.getShopDetails().setOpeningHours(openingHours);
    }

    private static void populateShopInfo(Shop shop, Long currentDateTime) {
        shop.setShopId(1);
        shop.setImageLink("https://images.squarespace-cdn.com/content/v1/5a5906400abd0406785519dd/1547305849352-CYT6FWXR75U7ZUBL5NAK/ke17ZwdGBToddI8pDm48kKAwwdAfKsTlKsCcElEApLR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UegTYNQkRo-Jk4EWsyBNhwKrKLo5CceA1-Tdpfgyxoog5ck0MD3_q0rY3jFJjjoLbQ/IB+alex.jpg?format=2500w");
        shop.setStatusMessage(UtilsImpl.getShopStatusMessage(shop.getShopId(), currentDateTime));
        shop.setLogoLink("https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/barber-shop-logo.jpg");
        shop.setRecentlyAdded(false);
    }

    private static void populateAddressDetails(Shop shop) {
        Address address = new Address();
        address.setShopLatitude(34.676630);
        address.setShopLongitude(33.012140);
        address.setBuildingNum("41");
        address.setPostalCode(3060);
        address.setStreetName("Diogenous");
        address.setArea("Katw Polemidia");
        shop.getShopDetails().setShopAddress(address);
    }

    private static void populateSocialMediaDetails(Shop shop) {
        SocialMediaInfo socialMediaInfo = new SocialMediaInfo();
        socialMediaInfo.setFacebookLink("https://www.facebook.com");
        socialMediaInfo.setWebSiteLink("https://www.google.com");
        socialMediaInfo.setInstagramLink("https://www.instagram.com");
        shop.getShopDetails().setSocialMediaInfo(socialMediaInfo);
    }

    private static void populateShopImages(Shop shop) {
        ShopImages[] shopGallery = new ShopImages[3];
        ShopImages image1 = new ShopImages();
        image1.setImageDescription("Our Shop");
        image1.setImageLink("https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/54257856789233.5a127c75dd739.jpg");
        ShopImages image2 = new ShopImages();
        image2.setImageDescription("Best Barber Styles");
        image2.setImageLink("https://images.creativemarket.com/0.1.0/ps/2732861/910/607/m1/fpnw/wm0/barber-logo-01-preview-01-.jpg?1495533817&s=0c44310a0f49b3f560ecf91242112401");
        ShopImages image3 = new ShopImages();
        image3.setImageDescription("Shop Logo :)");
        image3.setImageLink("https://image.freepik.com/free-vector/retro-barber-shop-logo_23-2148420012.jpg");

        shopGallery[0] = image1;
        shopGallery[1] = image2;
        shopGallery[2] = image3;

        shop.getShopDetails().setGalleryLinks(shopGallery);
    }

    public static List<User> getAllUsers() {
        return null;
    }

//    public static void registerUser(User user) {
//        allUsers.add(user);
//    }

}
