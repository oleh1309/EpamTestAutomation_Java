package com.epam.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
  private static final Logger logger = LogManager.getLogger(Sprint.class);
  public static void main(String[] args) {
    List<Task> mainList  = new LinkedList<>();
    mainList.add(new Task("Task 1", "Check requirements and give feedback!"));
    mainList.add(new Task("Task 2", "Split project into tasks!"));
    mainList.add(new Task("Task 3", "Estimate all tasks!"));
    mainList.add(new Task("Task 4", "Split all tasks into sub-tasks!"));
    Sprint sprint = new Sprint(mainList);
    menu(sprint);

  }

  public static void menu(Sprint sprint){
    Scanner input = new Scanner(System.in);
    String keyMenu;
    do {
      logger.info("\033[0;30m");
      logger.info("   1 - Add Sprint" + "   2 - set inProgress   ");
      logger.info("   3 - review      " + "   4 - testing    ");
      logger.info("   5 - Done       " + "   6 - blocked     ");
      logger.info("   L - Get Sprint List" + "   Q - exit");
      logger.info("   Please, select menu point.");
      logger.info("\033[0m");
      keyMenu = input.nextLine().toUpperCase();
      try {
        switch (keyMenu) {
          case "1":
            sprint.addSprintBacklog();
            break;
          case "2":
            sprint.inProgress();
            break;
          case "3":
            sprint.review();
            break;
          case "4":
            sprint.inTest();
            break;
          case "5":
            sprint.done();
            break;
          case "6":
            sprint.blocked();
            break;
          case "L":
            sprint.getList();
            break;
        }
      } catch (Exception e) {
        logger.error(e);
      }
    } while (!keyMenu.equals("Q"));
  }
}
