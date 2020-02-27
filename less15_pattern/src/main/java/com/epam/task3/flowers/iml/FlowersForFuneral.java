package com.epam.task3.flowers.iml;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.LinkedList;
import java.util.List;

public class FlowersForFuneral implements Flowers {
    final private double PRICE = 95;
    final private String NAME_FLOWERS = "Simple Carnations";
    private List<String> flowers;
    private TypeOfFlowers type;

    public FlowersForFuneral() {
        this.flowers = new LinkedList<>();
        flowers.add(FlowerType.CARNATIONS.toString());
        flowers.add(FlowerType.CARNATIONS.toString());
        flowers.add(FlowerType.CARNATIONS.toString());
        flowers.add(FlowerType.CARNATIONS.toString());
        flowers.add(FlowerType.CARNATIONS.toString());
        flowers.add(FlowerType.CARNATIONS.toString());
        this.type = TypeOfFlowers.FUNERAL;
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
        return "FlowersForFuneral{" +
                "PRICE=" + PRICE +
                ", NAME_FLOWERS='" + NAME_FLOWERS + '\'' +
                ", flowers=" + flowers +
                ", type=" + type +
                '}';
    }
}
