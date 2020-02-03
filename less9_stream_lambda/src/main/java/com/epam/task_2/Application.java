package com.epam.task_2;

import com.epam.task_2.command.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    private static File file1;
    private static Printable printable;
    private static Controller controller;
    private static Map<Integer, String> listOfFunction;
    public static void main(String[] args) {
        file1 = new File("File1");
        controller = new Controller();

        listOfFunction = new HashMap<>();
        listOfFunction.put(1, " Command as lambda function");
        listOfFunction.put(2, " Command as method reference");
        listOfFunction.put(3, " Command as anonymous class");
        listOfFunction.put(4, " Command as object of class");
        listOfFunction.put(5, " Exit");
        logger.info(listOfFunction);

        listOfFunction.entrySet().stream().forEach((a) -> chooseFunction(new Scanner(System.in).nextInt()));

    }

    private static void chooseFunction(int num) {
        if (num < 1 || num > 5) {
            logger.error("Choose number from 1 to 4!!!");
            chooseFunction(new Scanner(System.in).nextInt());
        } else {
            switch (num) {
                case 1:
                    logger.info("lambda function");
                    controller.setPrintable(((a) -> {
                        return "sdadsads";
                    }), "sdsd");
                    break;
                case 2:
                    logger.info("method reference");
                    controller.setPrintable(file1::closeFile, "Closing ....");
                    break;
                case 3:
                    logger.info("anonymous class");
                    printable = new Printable() {
                        @Override
                        public String print(String v) {
                            return file1.writeFile(v);
                        }
                    };
                    logger.info(printable.print("Writing...."));
                    break;
                case 4:
                    logger.info("object of class");
                    printable = new FileOpen(file1);
                    controller.setPrintable(printable, "Opening ....");
                    break;
                case 5:
                    logger.info("Exit");
                    System.exit(0);
                    break;
            }
        }
    }

}
