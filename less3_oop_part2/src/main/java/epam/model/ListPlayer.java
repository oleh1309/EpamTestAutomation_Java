package epam.model;

import java.util.LinkedList;
import java.util.List;

public class ListPlayer {

    private List<Player> list;

    public ListPlayer() {
        list = new LinkedList();
    }

    public void addPlayer(String name) {
        this.list.add(new Player(name));
    }

    public void showPlayers() {
        list.forEach((value) -> System.out.println(value));
    }

    public List<Player> getList(){
        return list;
    }

    public Player getPlayer(Building building){
        int i = 0;
        for (Player p : list) {
            if(p.chekBuildinginList(building)){
                i = list.indexOf(p);
            }
        }
        return list.get(i);
    }

    public boolean checkList(Building building){
        boolean i = false;
        for (Player p : list) {
            if(p.chekBuildinginList(building)){
                i = true;
                break;
            }
        }
        return i;


    }


}
