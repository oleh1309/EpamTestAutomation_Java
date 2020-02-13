package com.epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        PrintInt lambda1 = (a,b,c)->(a+b+c);
        logger.info("Result = " + lambda1.print(2,4,6));

        PrintInt lambda2 = (a,b,c)->  Math.max(a,Math.max(b,c));
        logger.info("Result = " + lambda2.print(2,4,6));
    }
}
