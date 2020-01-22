package epam.Controller;

import java.util.Map;

/**
 * Controller creating for class ControllerImpl.
 */


public interface Controller {

    void showPlayers();
    void addPlayers(int key, String name);
    int getList();
    void animate_roll() throws InterruptedException;
    int roll();

    void play(boolean isGameStarted);

}
