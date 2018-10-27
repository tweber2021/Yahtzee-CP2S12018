import java.util.Scanner;
import java.util.Arrays;

public class Player {

    //initializes variables
    private String name;
    private int score;
    private Die[] dice;
    private Rules rules;
 //   private boolean diceHeld;
 //   private int finalScore;
Scanner chose = new Scanner(System.in);

    //initializes constructors, getters, setters, and the array that holds the dice.
    public Player(String name) {
        this.name = name;
        dice = new Die[5];
        for(int i = 0; i<dice.length;i++){
            dice[i] = new Die();
            rules = new Rules(this);
            //need to have each Player Object hold it's own score so that when all 13 rounds are over for each player,
            // a winner can be calculated and declared.
        }

        /*for(Die die: dice){
            die.
        }*/
    }

    public Die[] getDice() {
        return dice;
    }


 //   public Player(int finalScore) {this.finalScore = finalScore;}

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

 /*   public boolean getDiceHeld() {
        return diceHeld;
    } */

 /*   public void setDiceHeld(boolean diceHeld) {
        this.diceHeld = diceHeld;
    } */

//getFinalScore is no longer needed
   // public int getFinalScore() {return this.finalScore;}

    //method takeTurn that will contain all of the aspects of a player's turn.
//  public int takeTurn(int i) {
    public void takeTurn() {

        Scanner reRoll = new Scanner(System.in); //scanner used to ask the player if they want to re-roll the dice
        // after an initial or previous roll on their current turn.

        //code TODO in next build of player class
        //ask the player after rolling which dice they would like to set aside by having them type a number 1 through 5
        // where each number corresponds to a dice, and then asks them if they want to set aside another dice to allow
        // them to set aside more than just one dice, but set it up so they can't set aside they same dice more than
        // once to avoid potential errors? Then set up a for loop so that when the player next rolls, it only re-rolls
        // the dice that they didn't set aside. (We could make variables called dice(dice #) re-roll which would be
        // boolean variables initially initialized as false, then change them to true if the player wants to re-roll
        // that certain dice, but set any of them that are true back to false after the roll.)


boolean [] heldDie = new boolean[5];

heldDie[0] = false;
heldDie[1] = false;
heldDie[2] = false;
heldDie[3] = false;
heldDie[4] = false;

   /* private boolean[] getHeldDie(boolean [] pHeldDie) {
        return pHeldDie;
            } */





        //array to hold 5 dice is needed

       // int[] Die = new int[5];

        /*Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die();*/



        int rollNumber=0; //initializes a variable i that keeps track of the number of the times the dice were rolled.
       // if (rollNumber<2) { //should not ask player if they want to roll again after last roll.
        //System.out.println("i initial:"+i);

        String playersTurnPhrase = "It is now " + getName() + "'s turn.";
            System.out.println(playersTurnPhrase); //returns the name of the player who's
        // turn it is
        for(int i = 0; i<playersTurnPhrase.length();i++) {
            System.out.print("_");
        }
        System.out.println("");


        while(rollNumber<=2) { //while the variable i is less than or equal to 2 (i=0 is the first/initial roll.),
            // return the dice value for all five dice that the player rolled.

           // System.out.println("i inside of while:"+rollNumber);


             for(int d=0; d<dice.length;d++) {
                 if(!heldDie[d]) {
                    dice[d].rollDie();
                 }
                 else {
                    continue;
                 }
             }


           /* for(int i=0; i<dice.length;i++) {

                if(input==i){
                    continue;
                }
                die.rollDie();
            } */


            System.out.println("You Rolled: ");
            printDice(dice);
            System.out.println();

    boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
    // if they would like to re-roll, but it will keep them here unless they answer yes or no.
//            if (rollNumber==2) {
//                answeredCorrectly = true;
//            }
//if (rollNumber<2) {
//    answeredCorrectly = false;
//}
//else {
//    answeredCorrectly = true;
//}
            //need to figure out how to solve the two bugs that cause confusion within the user interface during a turn.
    if(rollNumber<2){do {
        System.out.println("Would you like to roll again?\n");
        String reRollDice = reRoll.nextLine();

        if (reRollDice.equalsIgnoreCase("yes")) {

            Arrays.fill(heldDie, false);

            //System.out.println("i inside of do before i increments by one:"+rollNumber);
//         if (rollNumber<2) {
             rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
             // then it is now the third roll.
//         }
//         else {
//             //answeredCorrectly = true;
//         }
            //System.out.println("i inside of do after i increments by one:"+rollNumber);

            // int h = 0;
            System.out.println("How many dice would you like to set aside? (This is amount of dice, not the " +
                    "dice themselves.");
            int desiredHeldDie = reRoll.nextInt();

            if (desiredHeldDie>5) {
                throw new IllegalArgumentException(
                        "For the safety of our game of Yahtzee, trying to enter a \nvalue >5 here is dangerous and " +
                                "would crash the game if you managed to get past this message when entering a value >5. \n\nTL " +
                                "DR: Don't enter a number >5.");
            }

            for (int h = 1; h < (desiredHeldDie + 1); h++) {
                System.out.println("Which dice would you like to set aside? (This is the actual dice, not the " +
                        "amount of dice you want to set aside.");
                int hold2 = reRoll.nextInt();

                if (hold2>5) {
                    throw new IllegalArgumentException(
                            "For the safety of our game of Yahtzee, trying to enter a \nvalue >5 here is dangerous " +
                                    "and would crash the game if you managed to get past this message when entering " +
                                    "a value >5. \n\nTL DR:Don't enter a number >5.");
                }

                heldDie[hold2 - 1] = true;
            }


//                    System.out.println("Please enter the number for the dice you want to set aside for the next roll " +
//                            "(You can enter more than one number). (Example: 0 is the first dice and 2 is the third " +
//                            "dice.) ");
//                    String holdDice = reRoll.nextLine();
//                    //figure out how to check for numbers entered but also at the same time work regardless of the
//                    // order the numbers are entered in (Example: entering "0 2" should work the same as entering "2 0"
//                    // without creating separate code for each clause.
//
//                    if (holdDice.equals("0")) {
//                        heldDie[0]=true;
//                    }
//                    if (holdDice.equals("1")) {
//                        heldDie[1]=true;
//                    }
//                    if (holdDice.equals("2")) {
//                        heldDie[2]=true;
//                    }
//                    if (holdDice.equals("3")) {
//                        heldDie[3]=true;
//                    }
//                    if (holdDice.equals("4")) {
//                        heldDie[4]=true;
//                    }
//
//                    //test idea
//                    if (holdDice.equals(heldDie[i])) {
//                        heldDie[i]=true;
//                    }
////                    public boolean dieHeld(reRoll.nextLine()); {
////                        for();
////                    }
//
////                    public boolean dieIsHeld(int ... a) {
////                        for(reRollDice ("0"));
////                    }

            answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

        } else if (reRollDice.equalsIgnoreCase("no")) {
            rollNumber = 3; //sets the roll count to 3,
            answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

        }
//        else if (reRollDice.equalsIgnoreCase("no")&&rollNumber=2) {
//            rollNumber = 3; //sets the roll count to 3,
//            answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
//
//        }


        else {
            System.out.println("This is a yes/no question. Please respond with \"yes\" or \"no\".");
            answeredCorrectly = false;
        }

    } while (!answeredCorrectly)/*||if(rollNumber<2)*/;}
    else{rollNumber++;}
}
System.out.println("placeholder text for when choosing what category to score roll under.");
        System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes.");
        //below line is supposed to call the instance of the Rules class that the current player has, and then
        //calculate the score of the roll before starting the next player's turn.
//rules.checkCategory();
           // System.out.println("i at end of loop:"+rollNumber);

        }
//need to call up the Rules class to calculate the score for the round
       // return getScore();

    private void printDice(Die[] dice){ // Prints graphical representation of dice in a row
        String[] printRows = new String[5]; // We need rows because we want the dice to be all in a row.
        Arrays.fill(printRows,""); // Init. array
        for(int i=0;i<5;i++) {
            if(dice[i].getFaceValue()<1||dice[i].getFaceValue()>6){printRows[2]+="[!]";} // No graphical representation of the faceValue found

            // These are some pretty ugly dice; the output window just can't display the fancy unicode dice.
            // But hey, at least I got them all to display in a row.
            switch (dice[i].getFaceValue()) {
                case 1:
                    printRows[0]+="-------";
                    printRows[1]+="|     |";
                    printRows[2]+="|  o  |";
                    printRows[3]+="|     |";
                    printRows[4]+="-------";
                    break;
                case 2:
                    printRows[0]+="-------";
                    printRows[1]+="|    o|";
                    printRows[2]+="|     |";
                    printRows[3]+="|o    |";
                    printRows[4]+="-------";
                    break;
                case 3:
                    printRows[0]+="-------";
                    printRows[1]+="|    o|";
                    printRows[2]+="|  o  |";
                    printRows[3]+="|o    |";
                    printRows[4]+="-------";
                    break;
                case 4:
                    printRows[0]+="-------";
                    printRows[1]+="|o   o|";
                    printRows[2]+="|     |";
                    printRows[3]+="|o   o|";
                    printRows[4]+="-------";
                    break;
                case 5:
                    printRows[0]+="-------";
                    printRows[1]+="|o   o|";
                    printRows[2]+="|  o  |";
                    printRows[3]+="|o   o|";
                    printRows[4]+="-------";
                    break;
                case 6:
                    printRows[0]+="-------";
                    printRows[1]+="|o   o|";
                    printRows[2]+="|o   o|";
                    printRows[3]+="|o   o|";
                    printRows[4]+="-------";
                    break;
            }
            printRows[0]+=" ";
            printRows[1]+=" ";
            printRows[2]+=" "; // S p a c i n g  between the dice
            printRows[3]+=" ";
            printRows[4]+=" ";
        }
        for(int i=0;i<5;i++){
            System.out.println(printRows[i]);
        }
    }
}