package com.shop.rest.interfaces;


import com.shop.rest.constants.OperationCodes;

import java.util.List;

public interface GenericIntf {

    public List<? extends Object> getAll();

    public Object get(long id, long currentDateTimeInMills);

    public OperationCodes update(Object obj);

    public OperationCodes delete(Object obj);


}
