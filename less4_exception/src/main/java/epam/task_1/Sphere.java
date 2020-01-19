package epam.task_1;

import java.util.Scanner;

public class Sphere {
    private int A;
    private int B;
    private int square;

    public Sphere() {
        square = squareRectangle();
    }

    public Sphere(int a, int b) {
        A = a;
        B = b;
        square = squareRectangle();
    }

    public int squareRectangle (){
        System.out.println("Please enter first value: ");
        A = check_input();

        System.out.println("Please enter second value: ");
        B = check_input();

        System.out.println("Result: ");
        return A*B;
    }

    private int check_input(){
        int inputValue;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                inputValue = scanner.nextInt();
                if(inputValue < 0){
                    throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
                }
            } catch (java.util.InputMismatchException e) { // if the user enters something that is not an integer
                System.out.println("Please only enter integers");
                inputValue = Integer.MIN_VALUE;
                scanner.next(); // consume the non-int so we don't get caught in an endless loop
            }
        }while (inputValue < -1);

        return inputValue;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "A=" + A +
                ", B=" + B +
                ", square=" + square +
                '}';
    }
}
