package com.epam.task3.decorate.iml;

import com.epam.task3.decorate.FlowersDecorator;

public class Delivery extends FlowersDecorator {
    private final double ADDITIONAL_PRICE = 30;
    private final String TO_NAME = " + Delivery";

    public Delivery(boolean goldDiscount) {
        if(!goldDiscount) {
            setAdditionalPrice(ADDITIONAL_PRICE);
            setToName(TO_NAME + "(" +  ADDITIONAL_PRICE + ")");
        }else{
            setToName(TO_NAME + "(" +  0.0 + ")");
        }
    }
}
