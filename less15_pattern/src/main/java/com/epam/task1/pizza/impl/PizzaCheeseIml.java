package com.epam.task1.pizza.impl;

import com.epam.task1.Location;
import com.epam.task1.pizza.componants.Components;
import com.epam.task1.pizza.Pizza;
import com.epam.task1.pizza.componants.TypeComponents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PizzaCheeseIml implements Pizza {
    private static final Logger logger = LogManager.getLogger(PizzaCheeseIml.class);
    private Components components;
    private String logo;

    public PizzaCheeseIml() {
        this.components = new Components();
    }

    public void prepare(Location location) {
        if (location == Location.LVIV) {
            components.setSauce(TypeComponents.MARINARA);
            components.setToppings(TypeComponents.CHICKEN);
        } else if (location == Location.KYIV) {
            components.setSauce(TypeComponents.PESTO);
            components.setToppings(TypeComponents.DOUBLE_CHEESE);
        } else if (location == Location.DNIPRO) {
            components.setSauce(TypeComponents.PLUM_TOMATO);
            components.setToppings(TypeComponents.PINEAPPLE);
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
        }
        logger.info("Preparing Cheese pizza ....");
    }

    public void bake(Location location) {
        if (location == Location.LVIV) {
            components.setDough(TypeComponents.CRUST);
        } else if (location == Location.KYIV) {
            components.setDough(TypeComponents.THICK);
        } else if (location == Location.DNIPRO) {
            components.setDough(TypeComponents.THIN);
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
        }
        logger.info("Baking Cheese pizza ....");
    }

    public void box(Location location) {
        if (location == Location.LVIV) {
            logo = "Pizzeria HELLO Lviv";
        } else if (location == Location.KYIV) {
            logo = "Pizzeria HELLO Kyiv";
        } else if (location == Location.DNIPRO) {
            logo = "Pizzeria HELLO Dnipro";
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
            logo = "default";
        }
        logger.info("Box: " + logo + "\nBoxing Cheese pizza ....");
    }

    public void cut() {
        logger.info("Cutting Cheese pizza ....");
    }

    @Override
    public String toString() {
        return "PizzaCheese{" +
                "components=" + components +
                ", logo='" + logo + '\'' +
                '}';
    }
}
