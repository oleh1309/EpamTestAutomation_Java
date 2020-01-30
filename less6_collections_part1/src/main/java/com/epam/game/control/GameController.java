package com.epam.game.control;

import com.epam.game.model.Doors;
import com.epam.game.model.Hero;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController implements Controller {
    private static final Logger logger = LogManager.getLogger(GameController.class);
    private Hero hero;
    private final Doors doors;
    int health;

    public GameController() {
        hero = new Hero();
        doors = new Doors();
        health = hero.getPower();
    }

    public void play() {
        checkArr(doors.getHole());
        for (int i = 0; i < doors.getHole().length; i++) {
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                logger.error(e);
            }
            logger.info("Opening the door: " + (i + 1));
            if (doors.getHole()[i][0] == 1) {
                int artifact = doors.getHole()[i][1];
                logger.info("Hero take artifact with power = " + artifact);
                hero.addPower(artifact);
                logger.info(hero);
            } else if (doors.getHole()[i][0] == 0) {
                logger.info("Hero meet a monster with power = " + doors.getHole()[i][1]);
                int res = calculatePower(hero.getPower(), doors.getHole()[i][1]);
                if (res == -1) {
                    logger.info("Game over!!!");
                    logger.info("");
                    hero.setPower(0);
                    break;
                } else {
                    logger.info("Hero win in this battle");
                    hero.setPower(res);
                    logger.info(hero);
                }
            }
        }
        if (hero.getPower() > 0) {
            logger.info("Hero win!!!");
        }
    }

    public void recursive() {
        recursiveCalculation(0);
    }

    public void bestWay(){
       bestWayToWin();
    }

    private int calculatePower(int hero, int monster) {
        int power = 0;
        if (checkPower(hero, monster)) {
            if (hero > monster) {
                power = hero - monster;
            } else {
                power = monster - hero;
            }
        } else {
            power = -1;
        }
        return power;
    }

    private boolean checkPower(int hero, int monster) {
        if (hero >= monster) {
            return true;
        }
        return false;
    }

    private void checkArr(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            logger.info("Door number " + i + " (" + t[i][0] + " " + t[i][1] + ")");
        }
    }

    private void recursiveCalculation(int count) {
        if (count >= doors.getHole().length) {
            logger.info("Hero can open " + count + " doors!");
        } else {
            if (doors.getHole()[count][0] == 1) {
                hero.addPower(doors.getHole()[count][1]);
                recursiveCalculation(++count);
            } else if (doors.getHole()[count][0] == 0) {
                hero.setPower(calculatePower(hero.getPower(), doors.getHole()[count][1]));
                if (hero.getPower() > 0) {
                    recursiveCalculation(++count);
                } else {
                    logger.info("Hero can open " + (count + 1) + " doors!");
                }
            }

        }
    }

    private void bestWayToWin(){
        int[][] possibleWay = new int[10][2];
        int[] que = new int[10];
        int count = 1;
        int index = 0;
        for(int i = 0; i < doors.getHole().length; i++){
            if(doors.getHole()[i][0] == 1){
                possibleWay[index][0] = 1;
                possibleWay[index][1] = doors.getHole()[i][1];
                que[index] = i;
                index++;
            }else if (doors.getHole()[i][0] == 0){
                possibleWay[possibleWay.length - count][0] = 0;
                possibleWay[possibleWay.length - count][1] = doors.getHole()[i][1];
                que[possibleWay.length - count] = i;
                count++;

            }
        }

        for (int i = 0; i < possibleWay.length; i++) {
            logger.info("Door number " + que[i] + " (" + possibleWay[i][0] + " " + possibleWay[i][1] + ")");
        }
    }
}
