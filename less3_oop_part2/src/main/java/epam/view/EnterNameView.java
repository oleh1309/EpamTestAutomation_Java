/**
 * Copyright notice filename: View.java.
 */
package epam.view;
/**
 * <h1>MyView</h1>
 * Class is building by Map
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class EnterNameView extends View{
  /**
   * Controller where we start using option of mvc.
   */
  private static final Logger logger = LogManager.getLogger(EnterNameView.class);
  //private static Scanner input = new Scanner(System.in);
  private boolean isGameStarted;

  public EnterNameView() {

    addPlayer();
    controller.showPlayers();

    System.out.println("Throwing a dice");
    try {
      controller.animate_roll();
    } catch (InterruptedException e) {
      logger.error(e);
    }
    logger.info(controller.roll());
    isGameStarted = true;
    controller.play(isGameStarted);

  }

  private void addPlayer(){
    int i = 1;
    do{
      System.out.println("Enter name " + i + " :");
      controller.addPlayers(new Scanner(System.in).next());
      i++;
    }while (controller.getList()!=4);
  }


}
