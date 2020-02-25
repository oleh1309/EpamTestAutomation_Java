package com.epam.task1;

import com.epam.task1.pizza.Pizza;
import com.epam.task1.restoran.Restoran;
import com.epam.task1.restoran.iml.PizzeriaRestoran;

public class Client {
    public static void main(String[] args) {
        Restoran restoran = new PizzeriaRestoran();
        Pizza pizza = restoran.order(Location.DNIPRO, Type.CHEESE);
        System.out.println(pizza);

        Pizza pizza1 = restoran.order(Location.LVIV, Type.CLAM);
        System.out.println(pizza1);

        Pizza pizza2 = restoran.order(Location.KYIV, Type.PEPPERONI);
        System.out.println(pizza2);
    }
}
