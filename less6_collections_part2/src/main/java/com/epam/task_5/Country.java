package com.epam.task_5;

import java.util.Comparator;

public class Country implements Comparator<Country> {
    private String name;
    private String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getCapital() {
        return capital;
    }

    //    public int compareTo(Country o) {
//       // int result = this.name.compareTo(o.name);
//        int result = this.capital.compareTo(o.capital);
//        return result;
//    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    @Override
    public int compare(Country o1, Country o2) {
            return o1.name.compareTo(o2.name);
    }
}
