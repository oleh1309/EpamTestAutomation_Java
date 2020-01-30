package com.epam.task_6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        //Testing custom deque
        Deque stringDeque1 = new CustomDeque();
        for (int i = 0; i < 11; i++) {
            stringDeque1.add("qwwqwqw" + i);
            logger.info(stringDeque1);
        }
        stringDeque1.addFirst("weee");
        logger.info(stringDeque1);
        logger.info(stringDeque1.size());
        logger.info(stringDeque1.getFirst());
        logger.info(stringDeque1.getLast());
        stringDeque1.removeFirst();
        logger.info(stringDeque1);
        logger.info(stringDeque1.size());
        for (int i = 0; i < 12; i++) {
            stringDeque1.removeLast();
            logger.info(stringDeque1);
        }

        //Testing util Deque
        java.util.Deque<String> strings = new ArrayDeque<>();

        for (int i = 0; i < 13; i++) {
            strings.add("qwwqwqw" + i);
            logger.info(strings);

        }
        strings.addFirst("weee");
        logger.info(strings);
        logger.info(strings.size());
        logger.info(strings.getFirst());
        logger.info(strings.getLast());
        strings.remove("qwwqwqw1");
        strings.removeLast();
        logger.info(strings);

    }

}
