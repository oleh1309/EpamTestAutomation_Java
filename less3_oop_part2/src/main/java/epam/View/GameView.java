package epam.View;

import epam.Controller.Controller;
import epam.Controller.ControllerImpl;

public class GameView implements Printable{

    private Controller controller;

    public GameView(){
        controller = new ControllerImpl();

        try {
            controller.animate_roll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(controller.roll());
    }

    @Override
    public <T> void print(T t) {
        System.out.println(t);
    }

}
