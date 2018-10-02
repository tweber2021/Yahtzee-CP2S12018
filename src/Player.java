import java.util.Scanner;

public class Player {

    private String name;
    private int score;
    private boolean isPlaying;
    private int finalScore;

    public Player(String name) {
        this.name = name;
    }

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public Player(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public boolean getIsPlaying() {
        return this.isPlaying;
    }
    public int getFinalScore() {
        return this.finalScore;
    }


    //Turns could be handled by one takeTurn() method to encapsulate all of the player's options. After this method has
    //run completely, the player's turn will automatically be terminated, voiding the need for a method to end the turn.




    //possibly do research over weekend and figure out how to set-up the code to be able to get the name of the players
    //for use in the System.out.println(); that will print out a line saying which player's turn it is.

    //below line is for testing


   // String findPlayerName


//  public int takeTurn(int i) {
    public void takeTurn(int i) {

      /* String def; //if you try to name a variable default it causes errors

        String name(def) {
            this()
        } */
   //     String Name = Test;
        //Scanner playerName = new Scanner(System.in);

        Scanner reRoll = new Scanner(System.in);
       // Scanner tester = new Scanner(System.in);

//    public int numberOfPlayers() {
//        System.out.println("Welcome to Yahtzee! Please enter the number of players that will be playing the game.");
//
//    }
        //trying to use private int Die for testing the code but that doesn't seem possible unless the Die class exists on this computer.
        int Die;

     //make sure to uncomment when done testing


     /*   public String getName() {
            return Name;
        } */

       // String findPlayerName;
     //   Player(String findPlayerName) {

       // }

//        Player() {this("test");}
//
//        //test code to get player name
//        public String getFindPlayerName() {
//            return findPlayerName;
//        }
//
//        //test code to set PlayerName
//        public void setFindPlayerName(String findPlayerName) {
//            findPlayerName = playerName.nextLine();
//        }


       /* public void takeTurn() - allows player to take their turn - passing turns to other players are automatically handled by Main.
        public String getName() - returns Player name.
        public boolean getIsPlaying() - returns whether a player is playing or not.
        public int getFinalScore() - returns a player's final score after the game ends. */

       //adding these in because according to Trello, the main class depends on these three variables being in the Player class (I think...)






        //array to hold 5 dice is needed

        //temporarily comment out the 5 dice for testing code first
        Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die();

        i=0;
       // String yes;

        //test code
       // String t = "test";

       /* //more test
        System.out.println("Enter player name");
        String Name = tester.nextLine(); */



            System.out.println("It is now player " + getName() + "'s turn.");

        //test code
       // System.out.println("It is now player " + Name + "'s turn.");

            // code to roll dice and print the values, need to contact person doing that piece of code to make sure I
            // get the name of the method that rolls the dice or stores the results of the roll, or both.

        while(i<=2) {

            //get result from all five dice rolled and print them out to the player

            //commenting out the system out println to test code
            System.out.println("You Rolled: " + die1.getFaceValue() + " " + die2.getFaceValue() + " " + die3.getFaceValue() + " " + die4.getFaceValue() + " " + die5.getFaceValue());

            //code for testing
          //  System.out.println(i);

            System.out.println(" ");

            boolean answeredCorrectly = false;
            do {
                System.out.println("Would you like to roll again?");
                String reRollDice = reRoll.nextLine();

                if (reRollDice.equalsIgnoreCase("yes")) {
                    i = i + 1;
                    answeredCorrectly = true;
                }
                else if (reRollDice.equalsIgnoreCase("no")) {
                    i = 3;
                    answeredCorrectly=true;
                } else {
                    answeredCorrectly = false;
                }
            } while(!answeredCorrectly);

        }

        //code for testing
        //System.out.println(i);


        //temporary return statement
  //      return getTotalScore;
        }





       // String i = Integer.toString(i);
    }


//below commented line is how to convert from int to string
    //String s = Integer.toString(y)