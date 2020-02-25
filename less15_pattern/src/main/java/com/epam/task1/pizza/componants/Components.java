package com.epam.task1.pizza.componants;

public class Components {

    private String dough;
    private String sauce;
    private String toppings;

    public Components() {
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Components{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings='" + toppings + '\'' +
                '}';
    }
}
