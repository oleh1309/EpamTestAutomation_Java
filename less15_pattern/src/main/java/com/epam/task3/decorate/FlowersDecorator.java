package com.epam.task3.decorate;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.List;
import java.util.Optional;

public class FlowersDecorator implements Flowers {

    private Optional<Flowers> flowers;
    private double additionalPrice;
    private String toName = "";
    private String additionalComponent;

    public void setFlowers(Flowers outflowers) {
        flowers = Optional.ofNullable(outflowers);
        if (additionalComponent != null) {
            flowers.orElseThrow(IllegalArgumentException::new).getFlowersList().add(additionalComponent);
        }
    }

    protected void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public void setAdditionalComponent(String additionalComponent) {
        this.additionalComponent = additionalComponent;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    @Override
    public List<String> getFlowersList() {
        return flowers.orElseThrow(IllegalArgumentException::new).getFlowersList();
    }

    @Override
    public TypeOfFlowers getType() {
        return flowers.orElseThrow(IllegalArgumentException::new).getType();
    }

    @Override
    public String getName() {
        return flowers.orElseThrow(IllegalArgumentException::new).getName() + toName;
    }

    @Override
    public double getPrice() {
        return flowers.orElseThrow(IllegalArgumentException::new).getPrice() + additionalPrice;
    }
}
