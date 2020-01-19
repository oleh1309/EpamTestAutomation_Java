package epam.View;
/**
 * interface Printable print all methods
 */
@FunctionalInterface
public interface Printable {
  /** Methods print*/
  <T> void print(T t);
}
