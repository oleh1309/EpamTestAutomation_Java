package com.epam.task_2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        CustomBinaryTree<Integer, String> list = new CustomBinaryTree<>();
        list.put(1, "AAA");
        list.put(2, "BBB");
        list.put(3, "CCC");
        list.put(4, "DDD");

        logger.info(list.print());
        logger.info(list.get(2));
        logger.info(list.remove(2));
        logger.info(list.print());
        logger.info(list.remove(3));
        logger.info(list.print());
        logger.info(list.remove(4));
        logger.info(list.print());
        logger.info(list.size());
    }
}
