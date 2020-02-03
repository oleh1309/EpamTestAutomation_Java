package com.epam.task_4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class View{
    private static final Logger logger = LogManager.getLogger(com.epam.task_2.Application.class);
    private List<String> textList;
    private Map<String,String> menu;
    private Map<String,Printable> menubar;
    private static Scanner input = new Scanner(System.in);

    public View() {
        this.textList = new LinkedList<>();
        logger.info("Please enter words!");
        getText();
        menu = new LinkedHashMap<>();
        menu.put("1","Calculate unique words");
        menu.put("2","Sort unique words");
        menu.put("3","Count unique words");
        menu.put("4","Count symbol");
        menu.put("Q","Exit");

        menubar = new LinkedHashMap<>();
        menubar.put("1", this::calculateUnique);
        menubar.put("2", this::sortUnique);
        menubar.put("3", this::countUnique);
        menubar.put("4",this::countNumSymbol);
    }

    private List<String> getText(){
        String input;
        do{
            input = new Scanner(System.in).nextLine();
            textList.add(input);
        }while (input.length()!=0);
        return textList;
    }

    private void calculateUnique(){
        List<String> list = textList.stream().distinct().collect(Collectors.toList());
        logger.info(list);
    }

    private void sortUnique(){
        List<String> list = textList.stream().distinct().sorted().collect(Collectors.toList());
        logger.info(list);
    }

    private void countUnique(){
        Map<String,Long> list = textList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        logger.info(list);
    }

    private void countNumSymbol(){
        Map<Character,Long> list = wordToList().stream().filter(Character::isLowerCase)
                .collect(Collectors.groupingBy(symbol -> symbol, Collectors.counting()));
        logger.info(list);
    }

    private List<Character> wordToList () {
        StringBuilder text = new StringBuilder();
        textList.forEach((a)-> text.append(a));
        char[] brokenStr = text.toString().toCharArray();
        List<Character> result = new LinkedList<>();
        for (char ch : brokenStr) {
            result.add(ch);
        }
        return result;
    }

    private void printMenu(){
        menu.forEach((a,b)->logger.info(a + " - " + b));
    }

    public void show(){
        String keyMenu;
        do {
            logger.info(textList);
            printMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                menubar.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }

}
