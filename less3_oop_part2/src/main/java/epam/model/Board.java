package epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Board {
    private static final Logger logger = LogManager.getLogger(Board.class);
    private Map<Player, Integer> playerPositions;
    private Map<Integer, Object> mapa;

    public Board() {
        mapa = new HashMap<>();
        mapa.put(1,"Start!!!");
        mapa.put(2, new Building("Hotel 1 str.1", 50, 10));
        mapa.put(3,new Building("Hotel 2 str.1",55, 11));
        mapa.put(4,"Take card with task!");
        mapa.put(5,new Building("Hotel 3 str.1",48, 9));
        mapa.put(6,new Building("Hotel 1 str.2", 60, 12));
        mapa.put(7,new Building("Railway station", 100, 20));
        mapa.put(8,new Building("Hotel 2 str.2", 52, 10));
        mapa.put(9,new Building("Hotel 3 str.2",56,11));

        mapa.put(10,new Building("Prison!!!"));
        mapa.put(11,"Hotel 1 str.3");
        mapa.put(12,"Hotel 2 str.3");
        mapa.put(13,"Hotel 3 str.3");
        mapa.put(14,"Take card with bad task!");
        mapa.put(15,"Hotel 1 str.4");
        mapa.put(16,"Electricity station");
        mapa.put(17,"Hotel 2 str.4");
        mapa.put(18,"Hotel 3 str.4");


        mapa.put(19,new Building("Parking!!!"));
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
        logger.info("Map init");
        playerPositions = new HashMap<>();

    }

    public void addPlayers(List<Player> player) {
        Objects.requireNonNull(player);
        if (playerPositions.containsKey(player)) {
            throw new IllegalStateException("Player has already joined the game.");
        } else {
            for (Player p: player) {
                logger.info("Player " + p.toString() + " put on the position 0");
                playerPositions.put(p, 0);
            }

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

    public void getBoardPosition(int position){
        logger.info(mapa.get(position).toString());
    }

    public Building getBuilding(int position){
        return (Building) mapa.get(position);
    }

    public boolean isBuilding(int position){
        return mapa.get(position) instanceof Building;
    }

}
