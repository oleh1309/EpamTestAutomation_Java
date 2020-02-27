package com.epam.task3.flowers.iml;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.LinkedList;
import java.util.List;

public class FlowersForLovers implements Flowers {
    final private double PRICE = 200;
    final private String NAME_FLOWERS = "Flowers for good Lovers";
    private List<String> flowers;
    private TypeOfFlowers type;

    public FlowersForLovers() {
        this.flowers = new LinkedList<>();
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.GREENS.toString());
        flowers.add(FlowerType.GREENS.toString());
        this.type = TypeOfFlowers.SAINT_VALENTINES_DAY;
    }

    @Override
    public List<String> getFlowersList() {
        return flowers;
    }

    @Override
    public TypeOfFlowers getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return  PRICE;
    }

    @Override
    public String getName() {
        return NAME_FLOWERS;
    }

    @Override
    public String toString() {
        return "FlowersForLovers{" +
                "PRICE=" + PRICE +
                ", NAME_FLOWERS='" + NAME_FLOWERS + '\'' +
                ", flowers=" + flowers +
                ", type=" + type +
                '}';
    }
}
