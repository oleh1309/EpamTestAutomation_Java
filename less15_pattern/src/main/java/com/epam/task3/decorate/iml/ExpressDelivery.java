package com.epam.task3.decorate.iml;

import com.epam.task3.decorate.FlowersDecorator;

public class ExpressDelivery extends FlowersDecorator {

    private final double ADDITIONAL_PRICE = 60;
    private final String TO_NAME = " + DeliveryExpress";


    public ExpressDelivery(boolean goldDiscount) {
        if(!goldDiscount) {
            setAdditionalPrice(ADDITIONAL_PRICE);
            setToName(TO_NAME + "(" +  ADDITIONAL_PRICE + ")");
        }else{
            setToName(TO_NAME + "(" +  0.0 + ")");
        }
    }

}
