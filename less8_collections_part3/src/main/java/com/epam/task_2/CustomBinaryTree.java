package com.epam.task_2;

import java.util.*;

public class CustomBinaryTree<K, V> {

    private Set<K> keyList;
    private V[] vList;

    public CustomBinaryTree() {
        this.keyList = new TreeSet<>();
        this.vList = (V[]) new Object[0];
    }

    public V put(K key, V value) {

        if (key == null) {
            throw new NullPointerException();
        } else {
            keyList.add(key);
            //vList.add(getPosition(key),value);
            addToArr(getPosition(key),value);

        }

        return value;
    }

    public V get(K key) {
        int value = getPosition(key);
        return vList[value];
    }

    public V remove(K key) {
        V variable = get(key);
        if (getPosition(key) < 0) {
            throw new NullPointerException();
        } else {
            //vList.remove(getPosition(key));
            removeFromArr(getPosition(key));
            keyList.remove(key);
            return variable;
        }
    }

    public int size(){
        return keyList.size();
    }
    
    public String print(){
        String s = "Tree[";
        for (K key: keyList) {

            if(getPosition(key) == keyList.size()-1){
                s = s + " (" + key + ", " + get(key) + ")";
            }else{
                s = s + " (" + key + ", " + get(key) + "),";
            }
        }
        s = s + "]";
        return s;
    }

    private int getPosition(K key) {
        int pos = 0;
        if (pos > keyList.size()) {
            pos--;
        }
        for (K k : keyList) {
                if (k.equals(key)) {
                    //pos--;
                    break;
                }
                    pos++;
        }
        return pos;
    }

    private void addToArr(int index, V value) {
        if (index < 0) {
            throw new NullPointerException();
        } else if (vList.length == 0) {
            vList = (V[]) new Object[1];
            vList[index] = value;
        } else {
            Object[] temp = (V[]) new Object[vList.length + 1];
            for (int i = 0; i < temp.length-1; i++) {
                temp[i] = vList[i];
            }
            temp[index] = value;
            vList = (V[]) temp;
        }
    }
    
    private void removeFromArr(int index){
        Object[] temp = null;
        if (index < 0) {
            throw new NullPointerException();
        }else {
            temp = (V[]) new Object[vList.length - 1];
            int pos = 0;
            for (int i = 0; i < vList.length-1; i++) {
                if(i == index) {
                    pos++;
                    temp[i] = vList[pos];
                }else{
                    temp[i] = vList[pos];
                }
                pos++;
            }
            vList = (V[]) temp;
            
        }
        
        
    }

}
