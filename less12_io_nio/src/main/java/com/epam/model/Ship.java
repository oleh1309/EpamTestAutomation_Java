package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship{

    private List<Droids> droidsList;
    private int countOfDroids;

    public Ship() {
        countOfDroids = 10;
        this.droidsList = new ArrayList<>();
        generateArmy();
    }
    public Ship(int size) {
        countOfDroids = size;
        this.droidsList = new ArrayList<>();
        generateArmy();
    }

    private void generateArmy(){
        long counter = 0;
        do {
            droidsList.add(new Droids(new Random().nextInt(20), "Name" + counter));
            counter++;
        } while (counter != countOfDroids);
    }
    public void generateArmy(int countOfDroidsX){
        long counter = 0;
        do {
            droidsList.add(new Droids(new Random().nextInt(20), "Name" + counter));
            counter++;
        } while (counter != countOfDroidsX);
    }

    public List<Droids> getDroidsList() {
        return droidsList;
    }

    public int getCountOfDroids() {
        return countOfDroids;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "droidsList=" + droidsList +
                '}';
    }
}
