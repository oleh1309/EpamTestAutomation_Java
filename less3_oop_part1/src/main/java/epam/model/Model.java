package epam.model;
/**
 * Model creating for class BusinessLogic.
 */
import java.util.Map;

public interface Model {
  /**
   * getList() list.
   */
  Map<String,ElectricalApplianse> getList();
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
  String getString();
}
