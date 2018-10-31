import java.util.Scanner;
import java.util.Arrays;

public class Player {

    //initializes variables
    private String name;
    private int score;
    private boolean isPlaying = true;
    private Die[] dice;
    private Rules rules;
    //   private boolean diceHeld;
    //   private int finalScore;

    //initializes constructors, getters, setters, and the array that holds the dice.
    public Player(String name) {
        this.name = name;
        dice = new Die[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();

            //isPlaying is no longer needed with an update to the Yahtzee Class.
            //need to have each Player Object hold it's own score so that when all 13 rounds are over for each player,
            // a winner can be calculated and declared.
        }
        rules = new Rules(this);

        /*for(Die die: dice){
            die.
        }*/
    }

    public Die[] getDice() {
        return dice;
    }

    //  public void setDice(Die[] dice) {this.dice = dice;}

    public Player(boolean isPlaying) {
        this.isPlaying = isPlaying;
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

    public boolean getIsPlaying() {
        return this.isPlaying;
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
        Scanner chose1 = new Scanner(System.in);
        Scanner chose2 = new Scanner(System.in);
        //code TODO in next build of player class
        //ask the player after rolling which dice they would like to set aside by having them type a number 1 through 5
        // where each number corresponds to a dice, and then asks them if they want to set aside another dice to allow
        // them to set aside more than just one dice, but set it up so they can't set aside they same dice more than
        // once to avoid potential errors? Then set up a for loop so that when the player next rolls, it only re-rolls
        // the dice that they didn't set aside. (We could make variables called dice(dice #) re-roll which would be
        // boolean variables initially initialized as false, then change them to true if the player wants to re-roll
        // that certain dice, but set any of them that are true back to false after the roll.)


        boolean[] heldDie = new boolean[5];

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


        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.
        // if (rollNumber<2) { //should not ask player if they want to roll again after last roll.
        //System.out.println("i initial:"+i);

        String playersTurnPhrase = "It is now player " + getName() + "'s turn.";
        System.out.println(playersTurnPhrase); //returns the name of the player who's
        // turn it is
        for (int i = 0; i < playersTurnPhrase.length(); i++) {
            System.out.print("_");
        }
        System.out.println("");


        while (rollNumber <= 2) {

            for (int d = 0; d < dice.length; d++) {
                if (!heldDie[d]) {
                    dice[d].rollDie();
                } else {
                    continue;
                }
            }

            System.out.println("You Rolled: " + dice[0].getFaceValue() + " " + dice[1].getFaceValue() + " " +
                    dice[2].getFaceValue() + " " + dice[3].getFaceValue() + " " + dice[4].getFaceValue());

            System.out.println(" ");

            boolean answeredCorrectly = false;

            //need to figure out how to solve the two bugs that cause confusion within the user interface during a turn.
            do {
                System.out.println("Would you like to roll again?");
                String reRollDice = reRoll.nextLine();

                if (reRollDice.equalsIgnoreCase("yes")) {

                    Arrays.fill(heldDie, false);

                    rollNumber = rollNumber + 1;
                    System.out.println("How many dice would you like to set aside? (This is amount of dice, not the " +
                            "dice themselves.");
                    int desiredHeldDie = reRoll.nextInt();

                    if (desiredHeldDie > 5) {
                        throw new IllegalArgumentException(
                                "For the safety of our game of Yahtzee, trying to enter a \nvalue >5 here is dangerous and " +
                                        "would crash the game if you managed to get past this message when entering a value >5. \n\nTL " +
                                        "DR: Don't enter a number >5.");
                    }

                    for (int h = 1; h < (desiredHeldDie + 1); h++) {
                        System.out.println("Which dice would you like to set aside? (This is the actual dice, not the " +
                                "amount of dice you want to set aside.");
                        int hold2 = reRoll.nextInt();

                        if (hold2 > 5) {
                            throw new IllegalArgumentException(
                                    "For the safety of our game of Yahtzee, trying to enter a \nvalue >5 here is dangerous " +
                                            "and would crash the game if you managed to get past this message when entering " +
                                            "a value >5. \n\nTL DR:Don't enter a number >5.");
                        }

                        heldDie[hold2 - 1] = true;
                    }

                    answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                } else if (reRollDice.equalsIgnoreCase("no")) {
                    rollNumber = 3; //sets the roll count to 3,
                    answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                } else {
                    System.out.println("This is a yes/no question. Please respond with \"yes\" or \"no\".");
                    answeredCorrectly = false;
                }

            } while (!answeredCorrectly)/*||if(rollNumber<2)*/;
        }

        System.out.println("placeholder text for when choosing what category to score roll under.");
        int chose = 0;


        while (chose < 1 || chose > 13) {
            System.out.println("Please choose one of the following categories.");
            CategoryUse();


            // System.out.println("1=Aces\n2=Twos\n3=Threes\n4=Fours\n5=Fives\n6=Sixes\n7=3OfAKind\n8=4OfAKind\n9=SmallStraight\n10=LargeStraight\n11=FullHouse\n12=Yahtzee\n13=Chance");
            chose = chose1.nextInt();


            if (!rules.checkCategory(chose)) {
                rules.checkCategoryInput(dice, chose);
            } else {
                System.out.println("You have previously selected that category and currently have a score of ");
                chose = 0;
            }
            System.out.println();
            System.out.println();
            System.out.println();
            for (int x = 1; x<=13;x++){
                System.out.println("Category check for "+ x +" is " + (rules.checkCategory(x)));
            }
            System.out.println();
            System.out.println();
            System.out.println();

            //currently, the code gets stuck and prevents the player from progressing (or in case of FullHouse
            // or others that print text for testing values, keeps printing the text and would crash the
            // computer if the game is not terminated.)
        }
    }

    public void CategoryUse() {
        for (int index = 1; index <= 13; index++) {

            if (!rules.checkCategory(index)) {

                String display = (index) + "= ";
                switch (index) {
                    case 1:
                        display += "Aces";
                        break;
                    case 2:
                        display += "Bces";
                        break;
                    case 3:
                        display += "Cces";
                        break;
                    case 4:
                        display += "Dces";
                        break;
                    case 5:
                        display += "Eces";
                        break;
                    case 6:
                        display += "Fces";
                        break;
                    case 7:
                        display += "Gces";
                        break;
                    case 8:
                        display += "Hces";
                        break;
                    case 9:
                        display += "Ices";
                        break;
                    case 10:
                        display += "Jces";
                        break;
                    case 11:
                        display += "Kces";
                        break;
                    case 12:
                        display += "Lces";
                        break;
                    case 13:
                        display += "Mces";
                        break;
                }
                System.out.println(display);
            }
        }
    }

}