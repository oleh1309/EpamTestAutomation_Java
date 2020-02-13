package com.epam.view;

import com.epam.controller.Controller;
import com.epam.controller.ControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class View {
    private static final Logger logger = LogManager.getLogger(com.epam.view.View.class);
    private Controller controller;
    private List<String> textList;
    private Map<String, String> menu;
    private Map<String, Printable> menubar;
    private static Scanner input = new Scanner(System.in);
    private Locale locale;
    private ResourceBundle menuLanguage;


    public View() {
        controller = new ControllerImpl();
        this.textList = new LinkedList<>();
        menu = new LinkedHashMap<>();
        getLocal();

        menubar = new LinkedHashMap<>();
        menubar.put("1", this::concatStrings); //task 2
        menubar.put("2", this::setLanguage); //task 3
        menubar.put("3", this::multiplyRegex); //task 4
        menubar.put("4", this::splitString);//task 5
        menubar.put("5", this::replaceWord);//task 5
    }

    private void getLocal() {
        logger.info("Please choose language!\n" + "UK(1), EN(2), PL(3)");
        int res = input.nextInt();
        if (res >= 1 && res <= 3) {
            switch (res) {
                case 1:
                    locale = new Locale("ua", "UA");
                    break;
                case 2:
                    locale = new Locale("en", "US");
                    break;
                case 3:
                    locale = new Locale("uk", "UK");
                    break;
            }
        } else {
            logger.info("Please input number of language which included in optional menu!");
            getLocal();
        }
        menuLanguage = ResourceBundle.getBundle("MenuBundle", locale);
        menu.put("1", menuLanguage.getString("name1") + menuLanguage.getString("description1"));
        menu.put("2", menuLanguage.getString("name2") + menuLanguage.getString("description2"));
        menu.put("3", menuLanguage.getString("name3") + menuLanguage.getString("description3"));
        menu.put("4", menuLanguage.getString("name4") + menuLanguage.getString("description4"));
        menu.put("5", menuLanguage.getString("name5") + menuLanguage.getString("description5"));
        menu.put("Q", menuLanguage.getString("name_exit"));
    }

    private void concatStrings() {
        logger.info("Please input words:");
        Object[] args = null;
        Scanner inp = new Scanner(System.in);
        String res = "";
        int i = 0;
        do {
            Object[] temp = new Object[i+1];
            if(args.length == 0){
                res = inp.nextLine();
                temp[i] = res;
                args = temp;
                i++;
            }else{
                for (int j = 0; j < args.length; j++){
                    temp[j] = args[j];
                }
                res = inp.nextLine();
                temp[i] = res;
                args = temp;
                i++;
            }

        } while (res.compareToIgnoreCase("") != 0);
        controller.getUtils(args);
    }

    private void setLanguage() {
        getLocal();
    }

    private void multiplyRegex() {
        controller.multiplyRegex("Qwewewe dfdsfsdf 22/11/1933");
    }

    private void splitString() {
        controller.splitString("Qwewthe dfdsfyouf 22/11/1933");
    }

    private void replaceWord() {
        controller.replaceWord("Qwewthe dfdsfyouf");
    }

    private void printMenu() {
        menu.forEach((a, b) -> System.out.println(a + " - " + b));
    }

    public void show() {
        String keyMenu;
        do {
            printMenu();
            logger.info("Please, select menu point.");
            keyMenu = new Scanner(System.in).nextLine().toUpperCase();
            try {
                menubar.get(keyMenu).print();
            } catch (Exception e) {
                logger.error(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}
