package epam.task4_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ship<T> {

    private List<T> list;

    public Ship() {
        this.list = new ArrayList<>();
    }

    public List<T> getDroid() {
        return list;
    }

    public void setDroid(T t) {
        this.list.add(t);
    }

    public void setAll(Collection <?extends T> collection){
        for (T t: collection) {
            list.add(t);
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "list=" + list +
                '}';
    }
}
