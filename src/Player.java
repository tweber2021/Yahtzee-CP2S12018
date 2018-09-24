import java.util.Scanner;

public class Player {

    //Turns could be handled by one takeTurn() method to encapsulate all of the player's options. After this method has
    //run completely, the player's turn will automatically be terminated, voiding the need for a method to end the turn.

    //Scanner PlayerNumber = new Scanner(System.in);
    Scanner reRoll = new Scanner(System.in);
//    public int numberOfPlayers() {
//        System.out.println("Welcome to Yahtzee! Please enter the number of players that will be playing the game.");
//
//    }

    private String findPlayerName;
    private String reRollDice;
    //possibly do research over weekend and figure out how to set-up the code to be able to get the name of the players
    //for use in the System.out.println(); that will print out a line saying which player's turn it is.


   // String findPlayerName


    public int takeTurn(int i) {
        i=0;
       // String yes;
            System.out.println("It is now player " + findPlayerName + "'s turn.");
            // code to roll dice and print the values, need to contact person doing that piece of code to make sure I
            // get the name of the method that rolls the dice or stores the results of the roll, or both.
        while(i<=2) {
            //get result from all five dice rolled and print them out to the player
            System.out.println("placeholder text");

            System.out.println(" ");

            System.out.println("Would you like to roll again?");
            String reRollDice = reRoll.nextLine();
            if (reRoll.nextLine() == "yes") {
                i = i + 1;
            }
            if (reRoll.nextLine() == "no") {
                i = 3;
            }

        }
        //temporary return statement
        return i;
        }





       // String i = Integer.toString(i);
    }


//below commented line is how to convert from int to string
    //String s = Integer.toString(y)