package flowershop;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Keyboard class provides methods to read input from the console.
 */
public class Keyboard {

    /**
     * Reads a string from the console.
     *
     * @param message the message to be displayed to the user
     * @return the string entered by the user
     */
    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextLine();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert caracters.");
            }
        } while(!correct);
        return input;
    }


    /**
     * Reads an integer from the console.
     *
     * @param message the message to be displayed to the user
     * @return the integer entered by the user
     */
    public static int getInt(String message){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextInt();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert integers.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }

    /**
     * Reads a double from the console.
     *
     * @param message the message to be displayed to the user
     * @return the double entered by the user
     */
    public static double getDouble(String message){
        Scanner sc = new Scanner(System.in);
        double input = 0;
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextDouble();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input. Insert double.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }

}
