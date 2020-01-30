package com.epam.game.model;

public class Hero {
    private String name;
    private int power;

    public Hero() {
        this.name = "Vasia";
        this.power = 25;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void addPower(int power) {
        this.power += power;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
