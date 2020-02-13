package com.epam.model;

import com.epam.annotation.DroidValidPower;

public class Droid extends Bot{

    @DroidValidPower(priority = DroidValidPower.Priority.LOW, value = 10, createdBy = "Oleh")
    private int power;

    public Droid(String name, int power) {
        super(name);
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + this.getName() + '\'' +
                ", power=" + power +
                '}';
    }
}
