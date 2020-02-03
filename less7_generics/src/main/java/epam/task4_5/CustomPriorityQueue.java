package epam.task4_5;

import java.util.*;

public class CustomPriorityQueue<E extends Object & Comparable<E>> extends AbstractQueue<E>{
    private E [] arr;

    public CustomPriorityQueue() {
        arr = (E[]) new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public boolean add(E e){
        return offer(e);
    }

    @Override
    public int size() {
        return this.arr.length;
    }

    @Override
    public boolean offer(E e) {
        Object[] temp = null;
        if (e == null) {
            throw new NullPointerException();
        }else if (arr.length == 0) {
            arr = (E[]) new Object[1];
            arr[0] = e;
        } else {
            temp =  (E[]) new Object[arr.length + 1];
            temp[0] = (E) e;
            for (int i = 1; i < temp.length; i++) {
                temp[i] = arr[i-1];
            }
            Arrays.sort(temp);
            arr = (E[]) temp;
            //size++;
        }
        return true;
    }

    @Override
    public E poll() {
        if(arr.length!=0) {
            E object = arr[0];
            E[] temp = (E[]) new Object[arr.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = arr[i + 1];
            }
            arr = temp;
        }else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public E peek() {
        return this.arr.length == 0 ? null : (E) arr[0];
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    public String print() {
        String res = "Priority{[ ";
        for (int i = 0; i < arr.length; i++) {
                res = res + arr[i] + " ,";
        }
        res = res + "]}";
        return res;
    }

    @Override
    public String toString() {
        return print();
    }

}
