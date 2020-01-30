package com.epam.game.model;

import java.util.Random;

public class Monstr {
    private int power;

    public Monstr() {
        this.power = setPower();
    }

    private int setPower() {
        Random random = new Random();
        this.power = random.nextInt((100 - 5) + 1) + 5;
        return this.power;
    }

    public int getPower() {
        return power;
    }
}
