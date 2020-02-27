package com.epam.task3.decorate.iml;

import com.epam.task3.decorate.FlowersDecorator;

public class OilclothWrappingForFlowers extends FlowersDecorator {

    private final double ADDITIONAL_PRICE = 30;
    private final String TO_NAME = " + Oilcloth";

    public OilclothWrappingForFlowers() {
        setAdditionalPrice(ADDITIONAL_PRICE);
        setToName(TO_NAME + "(" +  ADDITIONAL_PRICE + ")");
        setAdditionalComponent("Oilcloth Paper");
    }
}
