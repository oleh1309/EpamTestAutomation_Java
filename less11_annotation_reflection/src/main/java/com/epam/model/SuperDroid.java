package com.epam.model;

import com.epam.annotation.DroidValidPower;

public class SuperDroid extends Bot {

    @DroidValidPower(priority = DroidValidPower.Priority.MEDIUM, value = 20, createdBy = "Vova")
    private int power;

    public SuperDroid(String name, int power) {
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
        return "SuperDroid{" +
                "name='" + this.getName() + '\'' +
                ", power=" + power +
                '}';
    }
}
