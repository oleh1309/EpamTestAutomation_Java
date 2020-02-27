package com.epam.task3.flowers;

import com.epam.task3.FlowerType;
import com.epam.task3.TypeOfFlowers;

import java.util.List;

public interface Flowers {

    List<String> getFlowersList();

    TypeOfFlowers getType();

    double getPrice();

    String getName();
}
