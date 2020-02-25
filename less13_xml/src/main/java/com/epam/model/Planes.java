package com.epam.model;

import java.util.Objects;

public class Planes {

    private String model;
    private String origin;
    private Chars chars;
    private Parameters parameters;
    private int price;

    public Planes(String model, String origin, Chars chars, Parameters parameters, int price) {
        this.model = model;
        this.origin = origin;
        this.chars = chars;
        this.parameters = parameters;
        this.price = price;
    }
    public Planes(){}

    public void setModel(String model) {
        this.model = model;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Planes{" +
                "model='" + model + '\'' +
                ", origin='" + origin + '\'' +
                ", chars=" + chars +
                ", parameters=" + parameters +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planes)) return false;
        Planes planes = (Planes) o;
        return price == planes.price &&
                Objects.equals(model, planes.model) &&
                Objects.equals(origin, planes.origin) &&
                Objects.equals(chars, planes.chars) &&
                Objects.equals(parameters, planes.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, origin, chars, parameters, price);
    }
}
