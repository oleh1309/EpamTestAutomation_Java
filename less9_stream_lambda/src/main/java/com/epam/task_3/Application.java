package com.epam.task_3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Application {
    private static final Logger logger = LogManager.getLogger(com.epam.task_2.Application.class);
    private static List<Integer> list;

    public static void main(String[] args) {
        addList();
        int input = 0;
        do{
            input = new Scanner(System.in).nextInt();
            if(input<1||input>5){
                logger.error("Please use number from 1 to 5!!!");
            }else {
                calculateList(input);
            }
        }while (input!=5);
    }

    private static void addList(){
        Stream<Integer> stream = Stream.generate(() -> (new Random()).nextInt(100));
        list = stream.limit(10).collect(toList());
        logger.info(list);
    }

    private static void calculateList(int num){
        int res;
        double res1;
        switch (num){
            case 1:
                logger.info("Get max value");
                res = list.stream().max(Integer::compare).get();
                logger.info(res);
                break;
            case 2:
                logger.info("Get min value");
                res = list.stream().min(Integer::compare).get();
                logger.info(res);
                break;
            case 3:
                logger.info("Get average value");
                res1 = list.stream().mapToInt(Integer::byteValue).average().getAsDouble();
                logger.info(res1);
                break;
            case 4:
                logger.info("Get sum of all list value");
                res = list.stream()
                        .reduce(0, (a, b) -> a + b);
                logger.info(res);
                break;
            case 5:
                logger.info("Get sum of all list value which are bigger then average");
                int res2 = (int) list.stream().mapToInt(Integer::byteValue).average().getAsDouble();
                res = list.stream().filter((s)-> s>res2).mapToInt(Integer::byteValue).sum();
                logger.info(res);
                break;
        }
    }
}
