package epam.controller;

/**
 * Controller creating for class ControllerImpl.
 */


public interface Controller {

    void showPlayers();
    void addPlayers(String name);
    int getList();
    void animate_roll() throws InterruptedException;
    int roll();

    void play(boolean isGameStarted);

}
