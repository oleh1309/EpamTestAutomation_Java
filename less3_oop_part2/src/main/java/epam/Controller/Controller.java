package epam.Controller;
/**
 * Controller creating for class ControllerImpl.
 */


public interface Controller {

    void showPlayers();
    void addPlayers(int key, String name);
    int getListSize();
    void animate_roll() throws InterruptedException;
    int roll();

}
