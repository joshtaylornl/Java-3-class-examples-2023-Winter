package ca.nl.cna.java3.a1help;

import java.util.Scanner;

/**
 * Simple console Menu Application to use in CP2280
 *
 * @author Josh
 */
public class ApplicationMenuExample {

    public static void main(String[] args) {
        System.out.println("Doing something fun on a Console!");

        //TODO use this as a guide for the menu in Book Application

        Scanner input = new Scanner(System.in);
        char c; //Char to drive menu choice

        do{
            printMenu();
            //Grab the user input
            c = Character.toUpperCase(input.next().charAt(0));

            System.out.printf("\nEcho: %c", c);

            if(c=='A'){
                System.out.printf("\nIn Option %c", c);
                //TODO do something
            } else  if(c=='B'){
                System.out.printf("\nIn Option %c", c);
                //TODO do something
            } else if (c=='C'){
                System.out.printf("\nIn Option %c", c);
                //TODO do something
            }

        }while(c!='Q');

        System.out.println("\nGOODBYE!");
    }

    public static void printMenu(){
        System.out.println("\n\nMake a choice");
        System.out.println("(A) Option A");
        System.out.println("(B) Option B");
        System.out.println("(C) Option C");
        System.out.println("(Q) Quit");
    }

}
