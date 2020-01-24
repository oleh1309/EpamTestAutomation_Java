package epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * BusinessLogic create and calculate info on the view page.
 */

public class BusinessLogic implements Model {
    private static final Logger logger = LogManager.getLogger(BusinessLogic.class);
    private ListPlayer listPlayer;
    private Dice dice;
    private Board board;

    public BusinessLogic() {
        listPlayer = new ListPlayer();
        dice = new Dice();
        board = new Board();
    }

    @Override
    public void showList() {
        listPlayer.showPlayers();
    }

    @Override
    public void addPlayers(String name) {
        listPlayer.addPlayer(name);
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
        board.addPlayers(listPlayer.getList());
        do {
            toDo();
        } while (isGameStarted);
    }

    private void toDo() {
        for (Player p : listPlayer.getList()) {
            logger.info("Next move for " + p.toString());
            logger.info("Do you want to roll the dice?");

            if (new Scanner(System.in).nextLine().equals("y")) {
                int res = dice.roll();
                logger.info(res);
                board.setPosition(p, res);
                int newPosition = board.getPosition(p);
                logger.info("new position: " + newPosition);
                logger.info("Your stay at: ");
                board.getBoardPosition(newPosition);
                if (board.isBuilding(newPosition)) {
                    //building
                    if (listPlayer.checkList(board.getBuilding(newPosition))) { //check if this building has owner
                        if (p.chekBuildinginList(board.getBuilding(newPosition))) { //check if we are owner of the building
                            logger.info("We are in our Hotel! We don`t need to pay for it!");
                        } else { // someone is owner of this building
                            logger.info("this is the plase of " + listPlayer.getPlayer(board.getBuilding(newPosition)).toString());
                            logger.info("We need to pay " + board.getBuilding(res).getPurchase_price());
                            p.pay(listPlayer.getPlayer(board.getBuilding(newPosition)), board.getBuilding(newPosition).getPurchase_price());
                        }
                    } else { //this building has no owner and we can buy it
                        logger.info("This building has no owner.");
                        logger.info("Do you buy it?");
                        if (new Scanner(System.in).nextLine().equals("y")) {
                            p.buyItem(board.getBuilding(newPosition));
                        } else {
                            continue;
                        }
                    }

                }


            } else {
                System.out.println("Blabla");
            }
        }
    }

}
