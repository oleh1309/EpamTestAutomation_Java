package epam.task_2;

import epam.task_2.plant_properties.Color;
import epam.task_2.plant_properties.Type;
import epam.task_2.plant_properties.exception.ColorException;
import epam.task_2.plant_properties.exception.TypeException;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws ColorException, TypeException {
        List list = new ArrayList();
        list.add(new Plants(Color.COLOR_RED,45, Type.TYPE_SEEDS));
        list.add(new Plants(Color.COLOR_GREEN,25, Type.TYPE_CONIFERS));


        for (Object p : list) {
            System.out.println(p);
        }
    }
}
