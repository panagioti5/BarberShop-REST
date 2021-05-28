package com.shop.rest.services.ranker;

import com.shop.rest.constants.OperationCodes;
import com.shop.rest.factory.Factory;
import com.shop.rest.interfaces.ElementRanker;
import com.shop.rest.services.Service;

import java.util.List;

public class Ranker extends Service {

    private ElementRanker elementRanker;
    private List<?> input;
    private String elementType;
    private int indexID;

    public int getIndexID() {
        return indexID;
    }

    @Override
    public void setIndexID(int indexID) {
        this.indexID = indexID;
    }

    public List<?> getInput() {
        return input;
    }

    @Override
    protected void validateInput() throws Exception {
        if (null == elementRanker) {
            throw new RuntimeException("No implementation of elementRanker found.");
        }
    }

    @Override
    public void execute() throws Exception {
        elementRanker = new Factory().getElementRankerObjectType(getElementType());
        validateInput();
        elementRanker.rank(getInput(), getIndexID());
    }

    @Override
    public OperationCodes getOutput() {
        return null;
    }

    @Override
    public void setInput(List<?> elementList) {
        input = elementList;
    }

    @Override
    public void setElementType(String elementsType) {
        this.elementType = elementsType;
    }

    public String getElementType() {
        return elementType;
    }
}
