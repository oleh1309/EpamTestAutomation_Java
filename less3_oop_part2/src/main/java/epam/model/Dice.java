package epam.model;

import java.util.Random;

public class Dice {

    private String lastLine = "";
    private byte anim;
    private final Random randomGenerator;

    public Dice() {
        randomGenerator = new Random();
    }

    public int roll() {
        return  randomGenerator.nextInt(6) + 1;
    }

    public void roll_animation(){
        switch (anim){
            case 1: print("[     ]");
            break;
            case 2: print("[ .   ]");
            break;
            case 3: print("[ ..  ]");
            break;

            default:
                anim = 0;
                print("[ ... ]");
        }
        anim++;
    }

    private void print(String line){
        if(lastLine.length() > line.length()){
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++){
                temp += " ";
            }
            if (temp.length() > 1){
                System.out.print("\r" + temp);
            }
        }
        System.out.print("\r" + line);
        lastLine = line;

    }

}
