package com.epam.task3.decorate.iml;

import com.epam.task3.decorate.FlowersDecorator;

public class PaperWrappingForFlowers extends FlowersDecorator {
    private final double ADDITIONAL_PRICE = 30;
    private final String TO_NAME = " + Paper";

    public PaperWrappingForFlowers() {
        setAdditionalPrice(ADDITIONAL_PRICE);
        setToName(TO_NAME + "(" +  ADDITIONAL_PRICE + ")");
        setAdditionalComponent("Wrapping Paper");
    }
}
