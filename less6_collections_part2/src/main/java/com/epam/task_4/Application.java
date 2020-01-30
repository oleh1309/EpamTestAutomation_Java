package com.epam.task_4;

import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Container container = new Container();
        logger.info(container);
        for (int i = 0; i < 11; i++) {
            container.setCont(i, i+"iuiu");
            logger.info(container);
        }
        stopwatch.stop();

        logger.info("time: " + stopwatch);

        stopwatch.reset().start();
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < 11; i++) {
            stringList.add(i+"iuiu");
            logger.info(stringList);
        }
        stopwatch.stop();
        logger.info("time: " + stopwatch);
    }
}
