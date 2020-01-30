/**
 * Copyright notice filename: View.java.
 */
package epam.view;
/**
 * <h1>MyView</h1>
 * Class is building by Map
 */

import epam.controller.Controller;
import epam.controller.ControllerImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {
  /**
   * Controller where we start using option of mvc.
   */
  Controller controller;
  /**
   * menuBar main option of view page.
   */
  private Map<String, String> menuBar;
  /**
   * menuBarsub main sub option of view page.
   */
  private Map<String, String> menuBarsub;
  /**
   * methodsMenuBar main methods of view page.
   */
  private Map<String, Printable> methodsMenuBar;
  /**
   * input value.
   */
  private static Scanner input = new Scanner(System.in);
  /**
   * <h1>Constructor</h1>.
   * Constructor generate menu in the console.
   */
  public MyView() {
    controller = new ControllerImpl();
    //Menu
    menuBar = new LinkedHashMap<>();
    menuBar.put("1", "1  -  Print List of all electrical applianse");
    menuBar.put("2", "2  -  Find info about electrical applianse");
    menuBar.put("3", "3  -  Calculate all swiched on electrical applianse");
    menuBar.put("Q", "Q  -  Exit");
    //Sub menu
    menuBarsub = new LinkedHashMap<>();
    menuBarsub.put("1", "1  -  Sort list electrical applianse by name");
    menuBarsub.put("2", "2  -  Sort list electrical applianse by power");
    menuBarsub.put("Q", "Q  -  Exit");
    //methods of menu
    methodsMenuBar = new LinkedHashMap<>();
    methodsMenuBar.put("1", this::pressButton1);
    methodsMenuBar.put("1.1", this::pressButton1Sub1);
    methodsMenuBar.put("1.2", this::pressButton1Sub2);
    methodsMenuBar.put("2", this::pressButton2);
    methodsMenuBar.put("3", this::pressButton3);
  }
  /**
   * PressButton1- print list of items.
   */
  private void pressButton1() {

    String keyMenu;
    do {
      System.out.println("\nKind of list:");
      for (String str : menuBarsub.values()) {
        System.out.println(str);
      }
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();
      try {
        methodsMenuBar.get("1." + keyMenu).print();
      } catch (Exception e) {
      }
    } while (!keyMenu.equals("Q"));
  }
  /**
   * pressButton1Sub1- print list of items sort by NAME.
   */
  private void pressButton1Sub1() {
    System.out.println("List of electrical applianse sort by NAME");
    System.out.println(controller.sortByValueName());
  }
  /**
   * pressButton1Sub2- print list of items sort by POWER.
   */
  private void pressButton1Sub2() {
    System.out.println("List of electrical applianse sort by POWER");
    System.out.println(controller.sortByValuePower());
  }
  /**
   * pressButton2- find items and switch on/off.
   */
  private void pressButton2() {
    System.out.println("Please input name:");
    String name = input.nextLine();
    System.out.println(controller.getElementFromMap(name));
    System.out.println("Do you want to switch on?(true/false):");
    boolean switchOn = input.nextBoolean();
    controller.switchOn(name, switchOn);
  }
  /**
   * pressButton2- find items and switch on/off.
   */
  private void pressButton3() {
    System.out.print("Total power of all swiched on electrical applianse :");
    System.out.println(controller.getTotalPower());
  }
  //---------------------------------------------------
  /**
   * outputMenu- output menu on view.
   */
  private void outputMenu() {
    System.out.println("\nMENU:");
    for (String str : menuBar.values()) {
      System.out.println(str);
    }
  }
  /**
   * show - show output menu on view.
   */
  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();
      try {
        methodsMenuBar.get(keyMenu).print();
      } catch (Exception e) {
      }
    } while (!keyMenu.equals("Q"));
  }
}
