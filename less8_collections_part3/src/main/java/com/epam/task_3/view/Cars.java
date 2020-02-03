package com.epam.task_3.view;

public enum Cars {

    FERRARI("FERRARI"),LAMBORGINI("LAMBORGINI"),AUDI("AUDI");

    private String value;
    Cars(String car) {
    }
    @Override
    public String toString() {
        return value;
    }
}
