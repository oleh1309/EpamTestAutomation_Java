package com.epam.task_5;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Application {
    private static final Logger logger = LogManager.getLogger(com.epam.task_4.Application.class);
    private static Comparator<Country> comparator = Comparator.comparing(Country::getCapital); //using Comparator
    public static void main(String[] args) {
        Country country1 = new Country("Ukraine", "Kiev");
        Country country2 = new Country("Poland", "Warsaw");
        Country country3 = new Country("Belarus", "Minsk");
        Country country4 = new Country("Germany", "Berlin");
        Country country5 = new Country("Turkey", "Istanbul");
        Country country6 = new Country("Israel", "Tel-Aviv");
        logger.info("-------array before sort--------");
        Country[] countries = new Country[6];
        countries[0] = country1;
        countries[1] = country2;
        countries[2] = country3;
        countries[3] = country4;
        countries[4] = country5;
        countries[5] = country6;
        for (int i = 0; i < countries.length; i++){
            logger.info(countries[i]);
        }
        //Arrays.sort(countries); //using Comparable
        Arrays.sort(countries,comparator);//using Comparator
        logger.info("-------array after sort--------");
        for (int i = 0; i < countries.length; i++){
            logger.info(countries[i]);
        }

        List<Country> list = new ArrayList<>();
        list.add(country1);
        list.add(country2);
        list.add(country3);
        list.add(country4);
        list.add(country5);
        list.add(country6);

        logger.info("-------list before sort--------");
        for (Country u : list) {
            logger.info(u);
        }

        logger.info("-------list after sort-----");

        //Collections.sort(list); //using Comparable

        Collections.sort(list,comparator);//using Comparator
        for (Country u : list) {
            logger.info(u);
        }
        logger.info("-------binary search-----");
        int index = Collections.binarySearch(list, country5, comparator);
        System.out.println(index);
    }
}
