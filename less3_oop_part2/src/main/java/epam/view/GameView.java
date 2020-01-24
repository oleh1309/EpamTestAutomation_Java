package epam.view;

import java.util.Scanner;

public class GameView extends View{


    private boolean isGameStarted;

    public GameView(){

        System.out.println("Throwing a dice");
        try {
            controller.animate_roll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //print(controller.roll());
        isGameStarted = true;
        controller.play(isGameStarted);

    }



    private void toDo(String value) {
        System.out.println("Next move for " + value);
        System.out.println("Do you want to roll the dice?");
        if (new Scanner(System.in).next() == "y") {
            //    controller.roll();
        } else {
            System.out.println("Blabla");
        }
    }

}
