package com.epam.game.model;

import java.util.Random;

public class Doors {
    private int[][] hole;

    public Doors() {
        this.hole = new int[10][2];
        setHole();
    }

    private void setHole() {
        for(int i = 0; i<hole.length; i++){
            int num = getRandomBoolean()?1:0;
            if(num==0){
                this.hole[i][0] = num;
                this.hole[i][1] = new Monstr().getPower();
            }else if (num == 1){
                Random r1 = new Random();
                int artifact = r1.nextInt((80 - 10) + 1) + 10;
                this.hole[i][0] = num;
                this.hole[i][1] = artifact;
            }

        }
    }

    private boolean getRandomBoolean() {
        return Math.random()<0.5;
    }

    public int[][] getHole() {
        return hole;
    }

    @Override
    public String toString() {
        return "Doors{" +
                "hole=" + (hole.length) +
                '}';
    }
}
