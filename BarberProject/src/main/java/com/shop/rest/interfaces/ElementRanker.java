package com.shop.rest.interfaces;

import com.shop.rest.constants.OperationCodes;

import java.util.List;

public interface ElementRanker {

    public OperationCodes rank(List<? extends Object> elements, int indexID) throws Exception;


}
