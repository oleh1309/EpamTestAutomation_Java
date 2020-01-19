package epam; /**<h1>Package</h1>
 * @author Martsyniuk Oleh
 * @version 1.0
 */

import epam.view.MyView;

/** <h1>MVC project</h1>
 * This app Determine the hierarchy of
 * electrical appliances. Plug some into
 * the socket. Calculate power consumption.
 * Sort appliances in an apartment based on power.
 * Find an appliance in the apartment that fits a
 * given range of parameters.
 *
 * @author Martsyniuk Oleh
 * @version 1.0
 * @since 11.11.19
 */
public class Application {
  /** <h1>Main</h1>.
   * @param args Unused.
   */
  public static void main(final String[] args) {
    /** Method Main it`s Start point of the program.
     * In this method we call two objects , which can
     * calculate numbers.
     * First one is CalculateNum.
     * Second is FibonacciNum.
     *
     * @param args Unused.
     */
    new MyView().show();
  }
}
