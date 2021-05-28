package com.shop.rest.services;

import com.shop.rest.constants.OperationCodes;

import java.util.List;

public abstract class Service {

    protected abstract void validateInput() throws Exception;

    public abstract void execute() throws Exception;

    public abstract OperationCodes getOutput();

    public abstract void setInput(List<? extends Object> elementList);

    public abstract void setElementType(String elementsType);

    public abstract void setIndexID(int indexID);
}
