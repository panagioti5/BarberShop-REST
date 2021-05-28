package com.shop.rest.helpers;

import com.shop.rest.constants.Constants;
import com.shop.rest.entities.Shop;
import com.shop.rest.services.Service;
import com.shop.rest.services.ranker.Ranker;
import com.shop.rest.utils.UtilsImpl;

import java.util.List;
import java.util.stream.Collectors;

public class AllShopsHelper extends APIHelper {
    private List<Shop> shopsInArea;
    private int indexId;
    private long currentDateTimeInMills;

    @Override
    public void execute() {
        rankShopsInArea(indexId, shopsInArea);
        shopsInArea = limitListSizeBasedOnIndex(indexId, shopsInArea);
        populateStatusesOnShopsInArea(shopsInArea, currentDateTimeInMills);
    }

    public void setShops(List<Shop> shopsInArea) {
        this.shopsInArea = shopsInArea;
    }

    public void setIndexID(int indexId) {
        this.indexId = indexId;
    }

    public void setCurrentDateTime(long currentDateTimeInMills) {
        this.currentDateTimeInMills = currentDateTimeInMills;
    }

    private List<Shop> limitListSizeBasedOnIndex(int indexId, List<Shop> shopsInArea) {
        if (indexId == 0) {
            shopsInArea = shopsInArea.stream().limit(Constants.INDEX_RADIO_DECIDER + 1).collect(Collectors.toList());
        } else {
            if (shopsInArea.size() >= indexId + Constants.INDEX_RADIO_DECIDER + 1) {
                shopsInArea = shopsInArea.subList(indexId + 1, indexId + Constants.INDEX_RADIO_DECIDER + 1);
            } else {
                shopsInArea = shopsInArea.subList(indexId + 1, shopsInArea.size());
            }
        }
        return shopsInArea;
    }

    private void populateStatusesOnShopsInArea(List<Shop> shopsInArea, long currentDateTimeInMills) {
        shopsInArea.forEach(x -> x.setStatusMessage(UtilsImpl.getShopStatusMessage(x.getShopId(), currentDateTimeInMills)));
    }

    private void rankShopsInArea(int indexId, List<Shop> shopsInArea) {
        shopsInArea.stream().forEach(x -> x.setRankID(-1));
        Service ranker = new Ranker();
        ranker.setInput(shopsInArea);
        ranker.setIndexID(indexId);
        ranker.setElementType(Constants.BARBER_SHOP_TYPE_NAME);
        try {
            ranker.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Shop> getOutput() {
        return shopsInArea;
    }
}
