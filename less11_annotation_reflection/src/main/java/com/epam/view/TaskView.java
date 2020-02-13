package com.epam.view;

import com.epam.annotation.DroidValidPower;
import com.epam.model.Bot;
import com.epam.model.Droid;
import com.epam.model.SuperDroid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TaskView {
    private static final Logger logger = LogManager.getLogger(TaskView.class);
    private Map<String, String> menu;
    private Map<String, Print> menubar;

    public TaskView() {
        menu = new LinkedHashMap<>();
        menu.put("1", "Task 2 -3. Create your own annotation. Create class with a few fields, some of\n" +
                "which annotate with this annotation. Through reflection print those\n" +
                "fields in the class that were annotate by this annotation.\n" +
                "Print annotation value into console.");
        menu.put("2", "Task 4. Invoke method (three method with different parameters and return\n" +
                "types)");
        menu.put("3", "Task 5. Set value into field not knowing its type.");
        menu.put("4", "Task 6. Invoke myMethod(String a, int ... args) and myMethod(String … args).");
        menu.put("5", "Task 7. Create your own class that received object of unknown type and show all " +
                "information about that Class.");
        menu.put("Q", "Exit");

        menubar = new LinkedHashMap<>();
        menubar.put("1", this::getOwnAnnotation);
        menubar.put("2", this::getInvokeMethods);
        menubar.put("3", this::setUnknownTYpe);
        menubar.put("4", this::overloadMethods);
        menubar.put("5", this::setUnknownTypeInClass);
    }


    private void getOwnAnnotation() {
        getReflection(new Droid("Poroshenko", 1));
        logger.info("\n");
        getReflection(new SuperDroid("Zelenskij", 12));
        logger.info("\n");
        getReflection(new SuperDroid("Putin", 20));
        logger.info("\n");
    }

    private void getInvokeMethods() {
        invokeMethods(new Bot("Oleh"));
    }

    private void setUnknownTYpe() {
        setFields(new Bot("Vasiliy"));
    }

    private void overloadMethods() {
        getOverloadMethods(new Bot("Oless"));
    }

    private void setUnknownTypeInClass() {
        getConstructor();
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

    private void getReflection(Bot bot) {
        logger.info("Before \n" + bot);
        try {
            String class_name = bot.getClass().toString().replaceFirst("class ", "");
            Field privateField = Class.forName(class_name).getDeclaredField("power");
            privateField.setAccessible(true);
            if (privateField.isAnnotationPresent(DroidValidPower.class)) {
                DroidValidPower valueOfPower = privateField.getAnnotation(DroidValidPower.class);
                int priority = valueOfPower.value();
                if ((int) privateField.get(bot) < priority) {
                    logger.error("Choosing value of power is not equal: " + bot.getPower());
                    privateField.set(bot, priority);
                    logger.info("After \n" + bot);
                } else {
                    logger.info("Power in allowed range");
                    logger.info("Without changes \n" + bot);
                }
            }
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchFieldException ex) {
            logger.error(ex);
        }
    }

    private void invokeMethods(Bot bot) {
        Class<? extends Bot> classes = bot.getClass();
        Method[] methods = classes.getDeclaredMethods();
        for (int i = 0; i < methods.length - 1; i++) {
            logger.info("Calling method: " + methods[i].toString());
            try {
                methods[i].setAccessible(true);

                if (methods[i].getParameterCount() > 0 && !methods[i].getName().equals("generate")) {
                    methods[i].invoke(bot, "Vovs");
                    logger.info(bot + "\n");
                } else if(!methods[i].getName().equals("generate")){
                    methods[i].invoke(bot);
                }else{
                    logger.info("this method are not invoke for same reasons!!!");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                logger.error(e);
            }
        }
    }

    private void setFields(Bot bot) {
        logger.info("Before \n" + bot + "\n");
        Class<? extends Bot> classes = bot.getClass();
        Field[] fields = classes.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                String s = fields[i].getType().toString();
                if (fields[i].getType().toString().equals(String.class.toString())) {
                    fields[i].set(bot, "Petro");
                    logger.info("After \n" + bot + "\n");
                }
            } catch (IllegalAccessException e) {
                logger.error(e);
            }
        }
    }

    private void getOverloadMethods(Bot bot) {
        logger.info("Before \n" + bot + "\n");
        Class<? extends Bot> classes = bot.getClass();
        Method[] methods = classes.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.setAccessible(true);
                if (method.getName().equals("generate") && method.getParameterCount() == 1) {
                    method.invoke(bot, "vasia");
                } else if (method.getName().equals("generate") && method.getParameterCount() > 1) {
                    method.invoke(bot, "vasia", new int[]{1, 2, 3});
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void getConstructor() {
        Class<? extends Bot> userClass = Bot.class;
        Bot one_args = null;
        Bot two_args = null;
        try {
            one_args = userClass.getDeclaredConstructor(String.class).newInstance("Oleh");
            logger.info(one_args + "\n");
            two_args = userClass.getDeclaredConstructor(String.class, boolean.class).newInstance("Vasia", true);
            logger.info(two_args + "\n");

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            logger.error(e);
        }


    }

}
