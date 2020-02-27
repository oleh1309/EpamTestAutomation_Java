package com.epam.task3.decorate.iml;

import com.epam.task3.decorate.FlowersDecorator;

public class PromotionalOffer extends FlowersDecorator {
    private final String TO_NAME = " + Promotional Offer";

    public PromotionalOffer(double discount) {
        setAdditionalPrice(-discount);
        setToName(TO_NAME + "(-" +  discount + ")");
    }
}
