package epam.Model;
/**
 * Model creating for class BusinessLogic.
 */

public interface Model {

    void getList();
    void addPlayers(int key, String name);
    int getListSize();
    void animate_roll() throws InterruptedException;
    int roll();

}
