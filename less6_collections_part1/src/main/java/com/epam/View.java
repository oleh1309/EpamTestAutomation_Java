package com.epam;

import com.epam.game.control.Controller;
import com.epam.game.control.GameController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class View {
    private static final Logger logger = LogManager.getLogger(View.class);
    private Map<String, String> menuBar;
    private Map<String, String> menuSubBar;
    private Map<String, Printable> methodsMenuBar;
    private static Scanner input = new Scanner(System.in);
    private Controller controller;

    private int[] numbs1;
    private int[] numbs2;
    private int[] numbs3;

    public View() {
        controller = new GameController();
        menuBar = new LinkedHashMap<>();
        menuBar.put("1", "1  -  check Task 1");
        menuBar.put("2", "2  -  check Task 2");
        menuBar.put("3", "3  -  Calculate all swiched on electrical applianse");
        menuBar.put("4", "4  -  Calculate all swiched on electrical applianse");
        menuBar.put("Q", "Q  -  Exit");
        //sub menu
        menuSubBar = new LinkedHashMap<>();
        menuSubBar.put("1", "1  -  Play game");
        menuSubBar.put("2", "2  -  Check recursive");
        menuSubBar.put("3", "3  -  Check the best way to win");
        menuSubBar.put("Q", "Q  -  Exit");
        //methods of menu
        methodsMenuBar = new LinkedHashMap<>();
        methodsMenuBar.put("1", this::pressButton1);
        methodsMenuBar.put("1.1", this::pressButton1_1);
        methodsMenuBar.put("1.2", this::pressButton1_2);
        methodsMenuBar.put("1.3", this::pressButton1_3);
        methodsMenuBar.put("2", this::pressButton2);
        methodsMenuBar.put("3", this::pressButton3);
        methodsMenuBar.put("4", this::pressButton4);
    }

    private void pressButton1() {
        logger.info("Дано два масиви. Сформувати третій масив, що " +
                "складається з тих елементів, які: а) присутні в обох масивах; " +
                "б) присутні тільки в одному з масивів.");

        this.numbs1 = new int[]{1, 1, 1, 4, 5};
        numbs2 = new int[]{6, 6, 8, 9, 10};
        numbs3 = new int[]{};
        numbs3 = copy(numbs1);
        printArray(numbs3);
        this.numbs3 = copy(numbs1, numbs2);
        printArray(numbs3);
    }

    private void pressButton2() {
        logger.info("Видалити в масиві всі числа, які " +
                "повторюються більше двох разів.");
        this.numbs2 = new int[]{6, 6, 8, 6, 7, 7, 10, 11};
        printArray(numbs2);
        int[] numb6 = remveCopyItems(numbs2);
        printArray(numb6);
    }

    private void pressButton3() {
        if (numbs3 == null) {
            logger.info("Please, check task 1!!!");
        } else {
            logger.info("Знайти в масиві всі серії однакових елементів, " +
                    "які йдуть підряд, і видалити з них всі елементи крім одного.");
            printArray(numbs3);
            int[] num4 = checkArr(numbs3);
            printArray(num4);
        }
    }

    private void pressButton4(){
        String keyMenu;
        do {
            System.out.println("\nKind of list:");
            for (String str : menuSubBar.values()) {
                System.out.println(str);
            }
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenuBar.get("1." + keyMenu).print();
            } catch (Exception e) {
                logger.error(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    private void pressButton1_1(){
       logger.info("Game starting...");
       controller.play();
    }

    private void pressButton1_2(){
        logger.info("Game starting by recursive...");
        controller.recursive();
    }

    private void pressButton1_3(){
        logger.info("Check the best way to win the game...");
        controller.bestWay();
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menuBar.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenuBar.get(keyMenu).print();
            } catch (Exception e) {
                logger.error(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            logger.info(arr[i]);
        }
        logger.info("Length of array is: " + arr.length);
    }

    private int[] checkArr(int[] arr) {
        int index = 0;
        int[] sameValueArr = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            int checkValue = arr[i];
            if (checkValue != arr[i + 1]) {
                sameValueArr[index++] = checkValue;
            } else {
                logger.info("we find the same value: " + checkValue);
            }
        }
        sameValueArr[index++] = arr[arr.length - 1];
        return sameValueArr;
    }

    private int[] copy(int[] copyArr) {
        int[] mainArr = new int[copyArr.length];
        System.arraycopy(copyArr, 0, mainArr, 0, copyArr.length);
        return mainArr;
    }

    private int[] copy(int[] copyArrFirst, int[] copyArrSec) {
        int[] mainArr = new int[copyArrFirst.length + copyArrSec.length];
        System.arraycopy(copyArrFirst, 0, mainArr, 0, copyArrFirst.length);
        System.arraycopy(copyArrSec, 0, mainArr, copyArrFirst.length, copyArrSec.length);
        return mainArr;
    }

    private int[] remveCopyItems(int[] arr) {
        class Local {
            boolean isDuplicate(int[] array, int numb) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == numb) {
                        return false;
                    }
                }
                return true;
            }
        }
        int[] firstArrVsDup = new int[arr.length];
        int counter = 0;
        for (int i = 0; i < firstArrVsDup.length; i++) {
            firstArrVsDup[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (new Local().isDuplicate(firstArrVsDup, arr[i]))
                firstArrVsDup[counter++] = arr[i];
        }


        int[] originalItems = new int[counter];
        System.arraycopy(firstArrVsDup, 0, originalItems, 0, originalItems.length);
        return originalItems;

    }
}
