package epam.controller;


import epam.model.BusinessLogic;
import epam.model.Model;


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
  public void addPlayers(String name) {
    model.addPlayers(name);
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
