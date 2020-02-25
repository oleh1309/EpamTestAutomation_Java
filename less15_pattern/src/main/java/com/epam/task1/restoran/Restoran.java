package com.epam.task1.restoran;

import com.epam.task1.Location;
import com.epam.task1.Type;
import com.epam.task1.pizza.Pizza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Restoran {
    private static Logger logger = LogManager.getLogger(Restoran.class);

    protected abstract Pizza createPizza(Type type);

    public Pizza order(Location location, Type type) {
        Pizza pizza = createPizza(type);
        pizza.prepare(location);
        pizza.bake(location);
        pizza.cut();
        pizza.box(location);
        return pizza;
    }
}
