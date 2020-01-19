package epam.model;
/**
 * BusinessLogic create and calculate info on the view page.
 */
import java.util.Map;

public class BusinessLogic implements Model{
  /**
   * class listOfItems model.
   */
  private ListOfItems listOfItems;
  /**
   * Constructor BusinessLogic.
   */
  public BusinessLogic() {
    listOfItems = new ListOfItems();
  }
  /**
   * getList Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> getList() {
    return listOfItems.getList();
  }
  /**
   * sortByValueName Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> sortByValueName() {
    return listOfItems.sortByValueName();
  }
  /**
   * sortByValuePower Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> sortByValuePower() {
    return listOfItems.sortByValuePower();
  }
  /**
   * getElementFromMap Override method which return from
   * interface model.
   */
  @Override
  public Map<String, ElectricalApplianse> getElementFromMap(String name) {
     return listOfItems.getElementFromMap(name);
  }
  /**
   * switchOn Override method which return from
   * interface model.
   */
  @Override
  public void switchOn(String name, boolean switchOnFromUser) {
    listOfItems.switchOn(name,switchOnFromUser);
  }
  /**
   * getTotalPower Override method which return from
   * interface model.
   */
  @Override
  public int getTotalPower() {
    return listOfItems.getTotalPower();
  }
  /**
   * getStat Override method which return from
   * interface model.
   */
  @Override
  public String getString() {
    return listOfItems.getString();
  }
}
