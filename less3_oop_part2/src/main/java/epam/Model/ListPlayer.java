package epam.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListPlayer {

    private Map<Integer, Player> list;


    public ListPlayer() {
        list = new LinkedHashMap<>(4);
    }

    public void addPlayer(int key, String name) {
        list.put(key, new Player(name));
    }

    public void showPlayers() {
        list.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public int listSize(){
        return list.size();
    }


}
