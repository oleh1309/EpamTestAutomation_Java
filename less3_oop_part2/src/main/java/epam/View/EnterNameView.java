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

public class EnterNameView {
  /**
   * Controller where we start using option of mvc.
   */
  private Controller controller;
  private static Scanner input = new Scanner(System.in);
  private Map<Integer,Player> listOfPlayer;
  private GameView gameView;

  public EnterNameView() {
    controller = new ControllerImpl();
    listOfPlayer = new LinkedHashMap<>();
    addPlayer();
    controller.showPlayers();
    gameView = new GameView();
  }

  private void addPlayer(){
    int i = 1;
    do{
      System.out.println("Enter name " + i + " :");
      controller.addPlayers(i,input.next());
      i++;
    }while (controller.getListSize()!=4);
  }

}
