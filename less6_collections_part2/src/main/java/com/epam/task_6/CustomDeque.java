package com.epam.task_6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomDeque implements Deque {
    private static final Logger logger = LogManager.getLogger(CustomDeque.class);
    private Object[] lines;
    private int size;
    private int first = 0;
    private int last = 0;

    public CustomDeque() {
        size = MIN_SIZE;
        this.lines = new Object[size];
    }

    public CustomDeque(int num) {
        size = num;
        this.lines = new Object[size];
    }

    private void calcDoubleSize() {
        Object[] temp = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = lines[i];
        }
        lines = temp;
        size = lines.length;
        first = 0;
    }

    private void copyArr(Object firstEl) {
        Object[] temp = new Object[size];
        assert first != 0;
        temp[first] = firstEl;
        int id = 1;
        for (int i = 0; i < size - 1; i++) {
            temp[id] = lines[i];
            id++;
        }
        lines = temp;
        size = lines.length;
        last++;

    }

    @Override
    public void add(Object e) {
        addLast(e);
    }

    @Override
    public void addFirst(Object o) {
        if (o == null)
            logger.error("Null pointer!!!");
        if (last + 1 >= size * 0.75) {
            calcDoubleSize();
            copyArr(o);
        } else {
            copyArr(o);
        }
    }

    @Override
    public void addLast(Object o) {
        if (o == null)
            logger.error("Null pointer!!!");
        if (last >= size * 0.75) {
            calcDoubleSize();
            lines[last] = o;
        } else {
            lines[last] = o;
        }
        last++;
    }

    @Override
    public Object getFirst() {
        Object result = lines[first];
        if (result == null)
            logger.error("No Such Element!!!");
        return result;
    }

    @Override
    public Object getLast() {
        Object result = lines[last - 1];
        if (result == null)
            logger.error("No Such Element!!!");
        return result;
    }

    @Override
    public void removeFirst() {
        if(last == 0) {
            logger.error("No Such Element!!!");
        }else{
            Object[] temp = new Object[size - 1];
            int id = 1;
            for (int i = 0; i < size - 1; i++) {
                temp[i] = lines[id];
                id++;
            }
            lines = temp;
            size--;
            last--;
        }
    }

    @Override
    public void removeLast() {

        if (last == 0) {
            logger.error("No Such Element!!!");
        } else {
            lines[last-1] = null;
            last--;
            if (last <= lines.length * 0.5) {
                System.arraycopy(lines,0,lines,0,size/2);
            }
        }

    }

    @Override
    public void remove() {
        removeFirst();
    }

    @Override
    public int size() {
        return last;
    }

    public String print() {
        String res = "CustomDeque{ lines=[ ";
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != null && i != last - 1) {
                res = res + lines[i] + " ,";
            } else if (lines[i] != null && i == last - 1) {
                res = res + lines[i];
            }

        }
        res = res + "]}";
        return res;
    }

    @Override
    public String toString() {
        return print();
    }
}
