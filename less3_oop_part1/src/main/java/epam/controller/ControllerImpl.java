package epam.controller;

import epam.model.BusinessLogic;
import epam.model.ElectricalApplianse;
import epam.model.Model;

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
  /**
   * getList Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> getList() {
    return model.getList();
  }
  /**
   * sortByValueName Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> sortByValueName() {
    return model.sortByValueName();
  }
  /**
   * sortByValuePower Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> sortByValuePower() {
    return model.sortByValuePower();
  }
  /**
   * getElementFromMap Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> getElementFromMap(String name) {
    return model.getElementFromMap(name);
  }
  /**
   * switchOn Override method which return from
   * interface model.
   */
  @Override
  public void switchOn(String name, boolean switchOnFromUser) {
    model.switchOn(name,switchOnFromUser);
  }
  /**
   * getTotalPower Override method which return from
   * interface model.
   */
  @Override
  public int getTotalPower() {
    return model.getTotalPower();
  }
  /**
   * getStat Override method which return from
   * interface model.
   */
  @Override
  public String getStat() {
    return model.getString();
  }
}
