package com.epam.task_4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Container {
    private static final Logger logger = LogManager.getLogger(Container.class);
    private String [] cont;

    public Container() {
        this.cont = new String[10];
    }

    public String[] getCont() {
        return cont.clone();
    }

    public void setCont(int index, String value) {
        try {
            this.cont[index] = value;
        }catch (ArrayIndexOutOfBoundsException e){
            logger.error(e);
            this.cont = copy();
            this.cont[index] = value;
        }
    }

    private String[] copy() {
        String[] mainArr = new String[cont.length + 1];
        System.arraycopy(cont, 0, mainArr, 0, cont.length);
        return mainArr;
    }

    @Override
    public String toString() {
        return "com.epam.task_4.Container{" +
                "cont=" + Arrays.toString(cont) +
                '}';
    }
}
