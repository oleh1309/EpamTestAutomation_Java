package epam.Controller;


import epam.Model.BusinessLogic;
import epam.Model.Model;


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
    model.getList();
  }

  @Override
  public void addPlayers(int key, String name) {
    model.addPlayers(key, name);
  }

  @Override
  public int getListSize() {
    return model.getListSize();
  }

  @Override
  public void animate_roll() throws InterruptedException {
    model.animate_roll();
  }

  @Override
  public int roll() {
    return model.roll();
  }
}
