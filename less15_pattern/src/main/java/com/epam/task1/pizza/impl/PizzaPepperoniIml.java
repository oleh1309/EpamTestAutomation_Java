package com.epam.task1.pizza.impl;

import com.epam.task1.Location;
import com.epam.task1.pizza.Pizza;
import com.epam.task1.pizza.componants.Components;
import com.epam.task1.pizza.componants.TypeComponents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PizzaPepperoniIml implements Pizza {
    private static final Logger logger = LogManager.getLogger(PizzaPepperoniIml.class);
    private Components components;
    private String logo;

    public PizzaPepperoniIml() {
        this.components = new Components();
    }

    public void prepare(Location location) {
        if (location == Location.LVIV) {
            components.setSauce(TypeComponents.MARINARA);
            components.setToppings(TypeComponents.RED_PEPPER);
        } else if (location == Location.KYIV) {
            components.setSauce(TypeComponents.PESTO);
            components.setToppings(TypeComponents.DOUBLE_CHEESE);
        } else if (location == Location.DNIPRO) {
            components.setSauce(TypeComponents.MARINARA);
            components.setToppings(TypeComponents.CHICKEN);
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
        }
        logger.info("Preparing Pepperoni pizza ....");
    }

    public void bake(Location location) {
        if (location == Location.LVIV) {
            components.setDough(TypeComponents.THIN);
        } else if (location == Location.KYIV) {
            components.setDough(TypeComponents.THIN);
        } else if (location == Location.DNIPRO) {
            components.setDough(TypeComponents.THICK);
        } else {
            logger.error("We don`t have pizzeria in some location which you want, but it will be soon...");
        }
        logger.info("Baking Pepperoni pizza ....");
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
        logger.info("Boxing Pepperoni pizza ....");
    }

    public void cut() {
        logger.info("Cutting Pepperoni pizza ....");
    }

    @Override
    public String toString() {
        return "PizzaPepperoni{" +
                "components=" + components +
                ", logo='" + logo + '\'' +
                '}';
    }
}
