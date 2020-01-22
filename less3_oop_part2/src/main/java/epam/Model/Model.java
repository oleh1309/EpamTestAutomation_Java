package epam.Model;

import java.util.Map;

/**
 * Model creating for class BusinessLogic.
 */

public interface Model {

    void showList();
    void addPlayers(int key, String name);
    int getList();
    void animate_roll() throws InterruptedException;
    int roll();
    void play(boolean isGameStarted);

}
