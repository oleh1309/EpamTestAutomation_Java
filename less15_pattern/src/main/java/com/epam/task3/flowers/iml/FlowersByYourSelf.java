package com.epam.task3.flowers.iml;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;
import com.epam.task3.flowers.Flowers;

import java.util.List;

public class FlowersByYourSelf implements Flowers {
    private double PRICE = 0;
    final private String NAME_FLOWERS = "Your gift";
    private List<String> flowers;
    private TypeOfFlowers type;

    public FlowersByYourSelf(List<String> yourFlowers, TypeOfFlowers typeOfFlowers) {
        this.flowers = yourFlowers;
        this.type = typeOfFlowers;
        this.PRICE = calculatePrice();
    }

    @Override
    public List<String> getFlowersList() {
        return flowers;
    }

    @Override
    public TypeOfFlowers getType() {
        return type;
    }

    private double calculatePrice(){
        for(String flowerType: flowers){
            if(flowerType.equals(FlowerType.CARNATIONS.toString())){
                PRICE += 15;
            }
            if(flowerType.equals(FlowerType.CHRYSANTHEMUM.toString())){
                PRICE += 10;
            }
            if(flowerType.equals(FlowerType.GREENS.toString())){
                PRICE += 5;
            }
            if(flowerType.equals(FlowerType.ROSE.toString())){
                PRICE += 25;
            }
            if(flowerType.equals(FlowerType.TULIP.toString())){
                PRICE += 28;
            }
            if(flowerType.equals(FlowerType.ORCHIDS.toString())){
                PRICE += 35;
            }
        }
        return PRICE;
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
        return "FlowersByYourSelf{" +
                "PRICE=" + PRICE +
                ", NAME_FLOWERS='" + NAME_FLOWERS + '\'' +
                ", flowers=" + flowers +
                ", type=" + type +
                '}';
    }
}
