/**
 * Copyright notice filename: View.java.
 */
package epam.View;
/**
 * <h1>MyView</h1>
 * Class is building by Map
 */

import epam.Controller.ControllerImpl;
import epam.Model.Player;
import epam.Controller.Controller;

import java.util.*;

public class EnterNameView extends View implements Printable{
  /**
   * Controller where we start using option of mvc.
   */

  private static Scanner input = new Scanner(System.in);
  private GameView gameView;
  private boolean isGameStarted;

  public EnterNameView() {

    addPlayer();
    controller.showPlayers();

    System.out.println("Throwing a dice");
    try {
      controller.animate_roll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    print(controller.roll());
    isGameStarted = true;
    controller.play(isGameStarted);
    new GameView();
  }

  private void addPlayer(){
    int i = 1;
    do{
      System.out.println("Enter name " + i + " :");
      controller.addPlayers(i,input.next());
      i++;
    }while (controller.getList()!=4);
  }
  @Override
  public <T> void print(T t) {
    System.out.println(t);
  }

}
