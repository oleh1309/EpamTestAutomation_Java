package epam.model;
/**
 * class ListOfItems
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfItems {
  /**
   * Map electricalApplianses
   */
  private Map<String, ElectricalApplianse> electricalApplianses;
  /**
   * Constructor ListOfItems.
   */
  public ListOfItems() {
    electricalApplianses = new LinkedHashMap<>();
    getList();
  }
  /**
   * getList method return list.
   */
  public Map<String, ElectricalApplianse> getList() {
    electricalApplianses.put("1", new ElectricalApplianse("Radio",
            false, 70));
    electricalApplianses.put("2", new ElectricalApplianse("Mobile",
            false, 80));
    electricalApplianses.put("3", new ElectricalApplianse("TV",
            false, 90));
    electricalApplianses.put("4", new ElectricalApplianse("Conditioner",
            false, 110));
    electricalApplianses.put("5", new ElectricalApplianse("Microvawe",
            false, 150));
    return electricalApplianses;
  }
  /**
   * sortByValueName method which return from
   * interface model.
   */
  public Map<String, ElectricalApplianse> sortByValueName() {
    return electricalApplianses.entrySet()
        .stream()
        .sorted((e1, e2) -> e1.getValue().getName().compareTo(e2.getValue().getName()))
        .collect(
            Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));
  }
  /**
   * sortByValuePower  method which return sorted list.
   */
  public Map<String, ElectricalApplianse> sortByValuePower() {
    return electricalApplianses.entrySet()
        .stream()
        .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
        .collect(
            Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));
  }
  /**
   * getElementFromMap  method which return element.
   */
  public Map<String, ElectricalApplianse> getElementFromMap(String name) {
    return electricalApplianses.entrySet()
        .stream()
        .filter(k -> k.getValue().getName().equals(name))
        .collect(
            Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));

  }
  /**
   * switchOn  method which switch on/off.
   */
  public void switchOn(String name, boolean switchOnFromUser) {
    for (Map.Entry<String, ElectricalApplianse> map :
        electricalApplianses.entrySet()) {
      if (map.getValue().getName().equals(name)) {
          map.setValue(map.getValue()).setSwitchOn(switchOnFromUser);
      }
    }
  }
  /**
   * getTotalPower  method which return total power.
   */
  public int getTotalPower() {
    int sum=0;
    for (Map.Entry<String, ElectricalApplianse> map : electricalApplianses.entrySet()) {
      if (map.getValue().isSwitchOn()) {
        sum = sum + map.getValue().getPower();
      }
    }
    return sum;
  }
  /**
   * getStat  method which return from
   * interface model.
   */
  public String getString() {
    return electricalApplianses.values().toString() + "\n";
  }
}
