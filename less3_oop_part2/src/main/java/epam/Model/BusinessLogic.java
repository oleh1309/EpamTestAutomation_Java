package epam.Model;

/**
 * BusinessLogic create and calculate info on the view page.
 */

public class BusinessLogic implements Model{

  private ListPlayer listPlayer;
  private Dice dice;

  public BusinessLogic() {
    listPlayer = new ListPlayer();
    dice = new Dice();
  }

  @Override
  public void getList() {
    listPlayer.showPlayers();
  }

  @Override
  public void addPlayers(int key, String name) {
    listPlayer.addPlayer(key, name);
  }

  @Override
  public int getListSize() {
    return listPlayer.listSize();
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


}
