package com.shop.rest.services.ranker;

import com.shop.rest.constants.OperationCodes;
import com.shop.rest.entities.Shop;
import com.shop.rest.interfaces.ElementRanker;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopElementRankerImpl implements ElementRanker {

    @Override
    @SuppressWarnings("unchecked")
    public OperationCodes rank(List<?> elements, int indexID) throws Exception {
        AtomicInteger coutner = new AtomicInteger(0);
        try (InputStream input = getClass()
                .getClassLoader().getResourceAsStream(decideWhichAreaFileToPick(((List<Shop>) elements).get(0).getShopDetails().getCity().toLowerCase()))) {

            Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key, value) -> decideRank(key, value, elements));
            int lastRankedShop = prop.size();
            ((List<Shop>) elements).stream().filter(e -> -1 == e.getRankID()).forEach(s ->
            {
                s.setRankID(lastRankedShop + coutner.get());
                coutner.getAndIncrement();
            });
            ((List<Shop>) elements).sort((o1, o2) -> ((Integer) o1.getRankID()).compareTo(((Integer) o2.getRankID())));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return OperationCodes.success;
    }

    private String decideWhichAreaFileToPick(String city) {
        return city + "rank.properties";
    }

    @SuppressWarnings("unchecked")
    private void decideRank(Object key, Object value, List<?> elements) {
        ((List<Shop>) elements).stream().filter(x -> x.getShopId() == Integer.parseInt((String) value)).forEach(x -> x.setRankID(Integer.parseInt((String) key)));
    }
}