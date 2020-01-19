package epam.model;
/**
 * ElectricalApplianse class.
 */

public class ElectricalApplianse implements Comparable{
  /**name field.*/
  private  String name;
  /**switchOn field.*/
  private boolean switchOn;
  /**power field.*/
  private int power;
/**
 * Constructor ElectricalApplianse
 * @param name name.
 * @param power power.
 * @param switchOn switchOn.
 */
  public ElectricalApplianse(String name, boolean switchOn,
      int power) {
    this.name = name;
    this.switchOn = switchOn;
    this.power = power;
  }
  /**getName.*/
  public String getName() {
    return name;
  }
  /**setName.*/
  public void setName(String name) {
    this.name = name;
  }
  /**isSwitchOn.*/
  public boolean isSwitchOn() {
    return switchOn;
  }
  /**setSwitchOn.
   * @param switchOn switchOn.
   */
  public void setSwitchOn(boolean switchOn) {
    this.switchOn = switchOn;
  }
  /**getPower.*/
  public int getPower() {
    return power;
  }
  /**setPower
   * @param power power
   */
  public void setPower(int power) {
    this.power = power;
  }
  /**toString*/
  @Override
  public String toString() {
    return "[" +
        "name='" + name + '\'' +
        ", switchOn=" + switchOn +
        ", power=" + power +
        ']'+"\n";
  }
  /**compareTo.
   * @param o object.
   */
  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
