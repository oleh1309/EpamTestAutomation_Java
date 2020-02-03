package com.epam.task_2.command;

import com.epam.task_1.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private Printable printable;

    public void setPrintable(Printable printable,String value){
        this.printable = printable;
        executer(value);
    }
    private void executer(String value){
        logger.info(printable.print(value));
    }

}
