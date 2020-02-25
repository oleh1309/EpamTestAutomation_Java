package com.epam.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.Random;

public class Droids extends SuperDroid implements Serializable {

    private int power;
    private String name;
    private transient String id;

    public Droids(int power, String name) {
        super(10);
        this.power = power;
        this.name = name;
        generateId();
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateId(){
        this.id = (new Random().nextInt(21)/3)*100 + RandomStringUtils.randomAlphabetic(3);
    }

    @Override
    public String toString() {
        return "Droids{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
