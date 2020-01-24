package epam.model;

/**
 * Model creating for class BusinessLogic.
 */

public interface Model {

    void showList();
    void addPlayers(String name);
    int getList();
    void animate_roll() throws InterruptedException;
    int roll();
    void play(boolean isGameStarted);

}
