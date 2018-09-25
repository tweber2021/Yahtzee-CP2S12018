import java.util.Scanner;

public class Player {



    //Turns could be handled by one takeTurn() method to encapsulate all of the player's options. After this method has
    //run completely, the player's turn will automatically be terminated, voiding the need for a method to end the turn.




    //possibly do research over weekend and figure out how to set-up the code to be able to get the name of the players
    //for use in the System.out.println(); that will print out a line saying which player's turn it is.

    //below line is for testing


   // String findPlayerName


    public int takeTurn(int i) {

        Scanner playerName = new Scanner(System.in);
        Scanner reRoll = new Scanner(System.in);
//    public int numberOfPlayers() {
//        System.out.println("Welcome to Yahtzee! Please enter the number of players that will be playing the game.");
//
//    }
        //trying to use private int Die for testing the code but that doesn't seem possible unless the Die class exists on this computer.
        int Die;
        String findPlayerName;
        Player(String findPlayerName) {

        }

        Player() {this("test");}

        //test code to get player name
        public String getFindPlayerName() {
            return findPlayerName;
        }

        //test code to set PlayerName
        public void setFindPlayerName(String findPlayerName) {
            findPlayerName = playerName.nextLine();
        }


        //array to hold 5 dice is needed

        /*temporarily comment out the 5 dice for testing code first
        Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die(); */

        i=0;
       // String yes;
            System.out.println("It is now player " + findPlayerName + "'s turn.");
            // code to roll dice and print the values, need to contact person doing that piece of code to make sure I
            // get the name of the method that rolls the dice or stores the results of the roll, or both.
        while(i<=2) {
            //get result from all five dice rolled and print them out to the player

            //commenting out the system out println to test code
          //  System.out.println("You Rolled: " + die1.getFaceValue() + " " + die2.getFaceValue() + " " + die3.getFaceValue() + " " + die4.getFaceValue() + " " + die5.getFaceValue());

            //code for testing
            System.out.println(i);

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