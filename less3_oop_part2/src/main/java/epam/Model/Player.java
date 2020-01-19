package epam.Model;

import java.util.List;

public class Player {

    private int money;
    private String name;
    private List listOfItems;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        money = 0;
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

    public void buyItem(int key, String value){


    }

    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
