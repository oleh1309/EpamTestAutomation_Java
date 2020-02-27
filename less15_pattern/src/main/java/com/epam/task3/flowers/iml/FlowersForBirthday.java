package com.epam.task3.flowers.iml;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.LinkedList;
import java.util.List;

public class FlowersForBirthday implements Flowers {
    final private double PRICE = 165;
    final private String NAME_FLOWERS = "Birthday gift";
    private List<String> flowers;
    private TypeOfFlowers type;

    public FlowersForBirthday() {
        this.flowers = new LinkedList<>();
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        flowers.add(FlowerType.TULIP.toString());
        this.type = TypeOfFlowers.BIRTHDAY;
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
        return "FlowersForBirthday{" +
                "PRICE=" + PRICE +
                ", NAME_FLOWERS='" + NAME_FLOWERS + '\'' +
                ", flowers=" + flowers +
                ", type=" + type +
                '}';
    }
}
