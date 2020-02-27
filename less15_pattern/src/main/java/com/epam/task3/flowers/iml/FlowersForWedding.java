package com.epam.task3.flowers.iml;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.LinkedList;
import java.util.List;

public class FlowersForWedding implements Flowers {
    final private double PRICE = 110;
    final private String NAME_FLOWERS = "Rebellious bride";
    private List<String> flowers;
    private TypeOfFlowers type;

    public FlowersForWedding() {
        this.flowers = new LinkedList<>();
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        flowers.add(FlowerType.ROSE.toString());
        this.type = TypeOfFlowers.WEDDING;
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
        return PRICE;
    }

    @Override
    public String getName() {
        return NAME_FLOWERS;
    }

    @Override
    public String toString() {
        return "FlowersForWedding{" +
                "PRICE=" + PRICE +
                ", NAME_FLOWERS='" + NAME_FLOWERS + '\'' +
                ", flowers=" + flowers +
                ", type=" + type +
                '}';
    }
}
