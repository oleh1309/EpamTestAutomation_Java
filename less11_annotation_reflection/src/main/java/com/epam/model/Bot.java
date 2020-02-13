package com.epam.model;

import java.util.Random;

public class Bot {
    private String name;

    public Bot(String name) {
        this.name = name;
    }

    public Bot(String name, boolean isDescriptionInclude) {
        this.name = name;
        if (isDescriptionInclude) {
            printDescription();
        } else {
            System.out.print("No description");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printDescription() {
        System.out.println("This bot is the main core of the next version of droids.");
    }

    public void generate(String name) {
        System.out.println(name + getName() + " with id:" + new Random().nextInt(10));
    }

    public void generate(String name, int... args) {
        int res = 0;
        for (int a : args) {
            res += a;
        }
        System.out.println(name + " with id:" + new Random().nextInt(res));
    }

    public int getPower() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                '}';
    }
}
