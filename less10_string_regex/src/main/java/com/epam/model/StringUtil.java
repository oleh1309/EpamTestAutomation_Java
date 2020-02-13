package com.epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtil {
    private static final Logger logger = LogManager.getLogger(StringUtil.class);
    private Object[] args;

    public StringUtil(Object... args) {
        this.args = args;
        logger.info(calculate());
    }
    
    private String calculate(){
        String result = "";
        for (int i = 0; i < args.length; i++) {
            result = result.concat(args[i].toString());
        }
        return result;
    }
}
