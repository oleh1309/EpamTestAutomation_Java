package epam.Controller;


import epam.Model.BusinessLogic;
import epam.Model.Model;

import java.util.Map;


/**
 * ControllerImpl update info on the view page.
 */

public class ControllerImpl implements Controller {
  /**
   * interface model.
   */
  private Model model;
  /**
   * Constructor ControllerImpl.
   */
  public ControllerImpl() {
    model = new BusinessLogic();
  }

  @Override
  public void showPlayers() {
    model.showList();
  }

  @Override
  public void addPlayers(int key, String name) {
    model.addPlayers(key, name);
  }

  @Override
  public int getList() {
     return model.getList();
  }

  @Override
  public void animate_roll() throws InterruptedException {
    model.animate_roll();
  }

  @Override
  public int roll() {
    return model.roll();
  }

  @Override
  public void play(boolean isGameStarted) {
    model.play(isGameStarted);
  }


}
