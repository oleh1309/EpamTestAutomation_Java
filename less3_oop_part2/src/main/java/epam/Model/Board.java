package epam.Model;

import epam.Model.ListPlayer;
import epam.Model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {

    private Map<Player, Integer> playerPositions;
    private Map<Integer, String> mapa;
    private ListPlayer listPlayer;

    public Board() {
        mapa.put(1,"Start!!!");
        mapa.put(2,"Hotel 1 str.1");
        mapa.put(3,"Hotel 2 str.1");
        mapa.put(4,"Take card with task!");
        mapa.put(5,"Hotel 3 str.1");
        mapa.put(6,"Hotel 1 str.2");
        mapa.put(7,"Railway station");
        mapa.put(8,"Hotel 2 str.2");
        mapa.put(9,"Hotel 3 str.2");

        mapa.put(10,"Prison!!!");
        mapa.put(11,"Hotel 1 str.3");
        mapa.put(12,"Hotel 2 str.3");
        mapa.put(13,"Hotel 3 str.3");
        mapa.put(14,"Take card with bad task!");
        mapa.put(15,"Hotel 1 str.4");
        mapa.put(16,"Electricity station");
        mapa.put(17,"Hotel 2 str.4");
        mapa.put(18,"Hotel 3 str.4");


        mapa.put(19,"Parking!!!");
        mapa.put(20,"Hotel 1 str.5");
        mapa.put(21,"Hotel 2 str.5");
        mapa.put(22,"Hotel 3 str.5");
        mapa.put(23,"Take card with  task!");
        mapa.put(24,"Hotel 1 str.6");
        mapa.put(25,"Airport");
        mapa.put(26,"Hotel 2 str.6");
        mapa.put(27,"Hotel 3 str.6");

        mapa.put(28,"Go to the prison!!!");
        mapa.put(29,"Hotel 1 str.7");
        mapa.put(30,"Hotel 2 str.7");
        mapa.put(31,"Hotel 3 str.7");
        mapa.put(32,"Take card with bad task!");
        mapa.put(33,"Hotel 1 str.8");
        mapa.put(34,"Water station");
        mapa.put(35,"Hotel 2 str.8");
        mapa.put(36,"Hotel 3 str.8");

        playerPositions = new HashMap<>();

    }

    public void addPlayers(Player player) {
        Objects.requireNonNull(player);
        if (playerPositions.containsKey(player)) {
            throw new IllegalStateException("Player has already joined the game.");
        } else {
            playerPositions.put(player, 0);
        }
    }

    public int getPosition(Player player) {
        Integer position = playerPositions.get(player);
        if (position == null) {
            throw new IllegalArgumentException("Player does not play in the game.");
        } else {
            return position; //auto-unboxing to int would throw a NullPointerException if position == null
        }
    }

    public void setPosition(Player player, int newPosition) {
        playerPositions.put(player, playerPositions.get(player)+ newPosition);
    }

}
