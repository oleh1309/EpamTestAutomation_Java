package com.epam.task1.pizza.impl;

import com.epam.task1.Location;
import com.epam.task1.pizza.Pizza;
import com.epam.task1.pizza.componants.Components;
import com.epam.task1.pizza.componants.TypeComponents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PizzaVeggieIml implements Pizza {
    private static final Logger logger = LogManager.getLogger(PizzaVeggieIml.class);

    private Components components;
    private String logo;

    public PizzaVeggieIml() {
        this.components = new Components();
    }

    public void prepare(Location location) {
        if (location == Location.LVIV) {
            components.setSauce(TypeComponents.PESTO);
            components.setToppings(TypeComponents.MUSHROOMS);
        } else if (location == Location.KYIV) {
            components.setSauce(TypeComponents.PESTO);
            components.setToppings(TypeComponents.DOUBLE_CHEESE);
        } else if (location == Location.DNIPRO) {
            components.setSauce(TypeComponents.PESTO);
            components.setToppings(TypeComponents.ONION);
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
        }
        logger.info("Preparing Veggie pizza ....");
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
        logger.info("Baking Veggie pizza ....");
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
        logger.info("Boxing Veggie pizza ....");
    }

    public void cut() {
        logger.info("Cutting Veggie pizza ....");
    }

    @Override
    public String toString() {
        return "PizzaVeggie{" +
                "components=" + components +
                ", logo='" + logo + '\'' +
                '}';
    }
}
