package com.epam.task1.restoran.iml;

import com.epam.task1.Type;
import com.epam.task1.pizza.Pizza;
import com.epam.task1.pizza.impl.PizzaCheeseIml;
import com.epam.task1.pizza.impl.PizzaClamIml;
import com.epam.task1.pizza.impl.PizzaPepperoniIml;
import com.epam.task1.pizza.impl.PizzaVeggieIml;
import com.epam.task1.restoran.Restoran;

public class PizzeriaRestoran extends Restoran {

    protected Pizza createPizza(Type type) {
        Pizza pizza = null;
        if (type == Type.CHEESE) {
            pizza = new PizzaCheeseIml();
        } else if (type == Type.CLAM) {
            pizza = new PizzaClamIml();
        } else if (type == Type.PEPPERONI) {
            pizza = new PizzaPepperoniIml();
        } else if (type == Type.VEGGIE) {
            pizza = new PizzaVeggieIml();
        }
        return pizza;
    }

}
