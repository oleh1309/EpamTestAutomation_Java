package epam.controller;
/**
 * Controller creating for class ControllerImpl.
 */


import epam.model.ElectricalApplianse;

import java.util.Map;

public interface Controller {
  /**
   * getList() list.
   */
  Map<String, ElectricalApplianse> getList();
  /**
   * sortByValueName()  sorted list by name.
   */
  Map<String, ElectricalApplianse> sortByValueName();
  /**
   * sortByValuePower()  sorted list by power.
   */
  Map<String, ElectricalApplianse> sortByValuePower();
  /**
   * getElementFromMap()  item of map.
   * @param name name of element.
   */
  Map<String, ElectricalApplianse> getElementFromMap(String name);
  /**
   * switchOn()  switchOn item.
   * @param name name of element.
   * @param switchOnFromUser switcher.
   */
  void switchOn(String name, boolean switchOnFromUser);
  /**
   * getTotalPower()  get Total Power for items.
   */
  int getTotalPower();
  /**
   * getStat()  get string for items.
   */
  public String getStat();
}
