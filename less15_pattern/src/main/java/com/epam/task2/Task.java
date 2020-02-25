package com.epam.task2;

public class Task {
    private static int counter = 0;
    private int id;
    private String name;
    private String requirement;

    public Task(String name, String requirement) {
        counter++;
        this.id = counter;
        this.name = name;
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}
