package epam.Model;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * BusinessLogic create and calculate info on the view page.
 */

public class BusinessLogic implements Model {

    private ListPlayer listPlayer;
    private Dice dice;

    public BusinessLogic() {
        listPlayer = new ListPlayer();
        dice = new Dice();
    }

    @Override
    public void showList() {
        listPlayer.showPlayers();
    }

    @Override
    public void addPlayers(int key, String name) {
        listPlayer.addPlayer(key, name);
    }

    @Override
    public int getList() {

        return listPlayer.getList().size();
    }

    @Override
    public void animate_roll() throws InterruptedException {
        for (int i = 0; i < 14; i++) {
            dice.roll_animation();
            Thread.sleep(350);
        }
        System.out.println(" ");
    }

    @Override
    public int roll() {
        return dice.roll();
    }

    @Override
    public void play(boolean isGameStarted) {

         do{
                toDo();
             }while (isGameStarted);
    }

    private void toDo() {
      Iterator<Map.Entry<Integer, Player>> iter = listPlayer.getList().entrySet().iterator();
      while (iter.hasNext()) {
        System.out.println("Next move for " + iter.next().getValue());
        System.out.println("Do you want to roll the dice?");
        if (new Scanner(System.in).next() == "y") {
          dice.roll();
        } else {
          System.out.println("Blabla");
        }
      }
    }

}
