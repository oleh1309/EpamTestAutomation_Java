package epam.model;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private int money;
    private String name;
    private List<Building> listOfItems;

    public Player(String name) {
        this.name = name;
        this.money = 300;
        this.listOfItems = new LinkedList();
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Attempted robbery.");
        }
        this.money += money;
    }

    public void pay(Player p, int sum){
       this.money -= sum;
       p.addMoney(sum);
    }

    public void buyItem(Building building){
        listOfItems.add(building);
        this.money -= building.getPurchase_price();
    }

    public boolean chekBuildinginList(Building building){
        boolean isInList = false;
        for (Building b : listOfItems) {
            if(building == b){
               return true;
            }else{
                return false;
            }
        }
        return isInList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
