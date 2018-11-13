import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

class Player {

    //initializes variables
    private String name;
    private int score;
    private Die[] dice;

   private Rules rules;
 //   private boolean diceHeld;
 //   private int finalScore;
Scanner chose = new Scanner(System.in);
<<<<<<< HEAD
=======
    private Rules rules;
    private Scanner sc = new Scanner(System.in); // Scanner used for everything

>>>>>>> pr/14


    //initializes constructors, getters, setters, and the array that holds the dice.
    Player(String name) {
=======


    //initializes constructors, getters, setters, and the array that holds the dice.
    public Player(String name) {
>>>>>>> parent of e45ef93... Merge branch 'pr/14'
        this.name = name;
        dice = new Die[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();

          

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



    //   public Player(int finalScore) {this.finalScore = finalScore;}

    public int getScore() {
<<<<<<< HEAD
=======
        }
        rules = new Rules();
    }

    int getScore() {
>>>>>>> pr/14
        return score;
=======
        return score;
    }

    private void setScore(int score) {
        this.score = score;
>>>>>>> parent of e45ef93... Merge branch 'pr/14'
    }

    String getName() {
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



boolean [] heldDie = new boolean[5];
Arrays.fill(heldDie,false);


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
        System.out.println();


        while (rollNumber <= 2) {

            for (int d = 0; d < dice.length; d++) {
                if (!heldDie[d]) {
                    dice[d].rollDie();
                } else {
                    continue;
                }
            }

            System.out.println("\n"+getName()+" rolled: ");
            // printDice(dice); (Temporarily disabled for incompatibility issues)
            printDice2(dice); // Temporary fix
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
        System.out.print("Would you like to roll again? ");
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

            /*int desiredHeldDie = -1;
            while(desiredHeldDie>5||desiredHeldDie<1){
                desiredHeldDie=promptInt("How many dice would you like to set aside? (This is amount of dice, not the " +
                        "dice themselves.");
            }

            for (int h = 1; h < (desiredHeldDie + 1); h++) {
                int hold2=-1;
                while(hold2>5||hold2<1){
                hold2 = promptInt("[Die "+h+"] Which dice would you like to set aside? (This is the actual dice, not the " +
                        "amount of dice you want to set aside.");
                }

                heldDie[hold2 - 1] = true;
            }*/

            int[] desiredHeldDice = new int[1]; desiredHeldDice[0]=-1; // Initialize array to loop state (resized later)
            while(desiredHeldDice[0]==-1){
            desiredHeldDice = promptIntList("Which dice would you like to set aside? (Separated by commas. Dice are ordered 1-5.)");
            for(int h=1;h<6;h++){
                if(inIntArr(h,desiredHeldDice)){heldDie[h-1]=true;}
                 }
            }

        System.out.println("placeholder text for when choosing what category to score roll under.");
        int chose = 0;


            answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

        } else if (reRollDice.equalsIgnoreCase("no")) {
            rollNumber = 3; //sets the roll count to 3,
            answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'


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
<<<<<<< HEAD
=======
    void takeTurn() {

        boolean[] heldDie = new boolean[5];
        int rollNumber = 0; //initializes a variable i that keeps track of the number of the times the dice were rolled.


        String playersTurnPhrase = getName() + "'s turn.";
        System.out.println(playersTurnPhrase); //returns the name of the player who's turn it is
        for (int i = 0; i < playersTurnPhrase.length(); i++) {System.out.print("‾");}
        printScoreCard();

        while (rollNumber <= 2) {

            for (int d = 0; d < dice.length; d++) {
                if (!heldDie[d]) {dice[d].rollDie();}
            }

            System.out.println("\n"+getName() + " rolled: ");
            printDice(dice);
            System.out.println();


            boolean answeredCorrectly = false; //initializes answeredCorrectly to false. this is used to ask the player
            // if they would like to re-roll, but it will keep them here unless they answer yes or no.

            if (rollNumber < 2) {
                do {
                    System.out.print("Would you like to roll again? ");
                    String reRollDice = sc.nextLine();

                    if (reRollDice.equalsIgnoreCase("yes")) {

                        Arrays.fill(heldDie, false);
                        rollNumber = rollNumber + 1; //increases roll count by 1. If i=1 then it is now the second roll, and if i=2
                        // then it is now the third roll.

                        int[] desiredHeldDice = new int[1];
                        desiredHeldDice[0] = -1; // Initialize array to loop state (resized later)
                        while (desiredHeldDice[0] == -1) {
                            desiredHeldDice = promptDiceList();
                            for (int h = 1; h < 6; h++) {
                                if (inIntArr(h, desiredHeldDice)) {
                                    heldDie[h - 1] = true;
                                }
                            }
                        }
                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'

                    } else if (reRollDice.equalsIgnoreCase("no")) {
                        rollNumber = 3; //sets the roll count to 3,
                        answeredCorrectly = true; //releases the user from the answeredCorrectly 'loop'
                    }
                } while (!answeredCorrectly);}
            else{rollNumber++;}
        }

        rules.checkBonuses(dice); // Allow Yahtzee and Upper Bonuses to be scored
        promptCategory(); // Prompt the user to choose a category and score that roll for them
>>>>>>> pr/14
=======
>>>>>>> parent of e45ef93... Merge branch 'pr/14'

        //below line is supposed to call the instance of the Rules class that the current player has, and then
        //calculate the score of the roll before starting the next player's turn.

        int prevScore = score;
        score = rules.getTotalScore();
        System.out.println("Current Score: "+score+" (+"+(score-prevScore)+")"); // Print the score, and how many points the player gained during that turn
        System.out.println();
    }

    private void listCategories() { // List available categories
        for (int index = 1; index <= 13; index++) {
            if (!rules.checkCategory(index)) { // Show categories if they haven't been used yet
                System.out.print(index+": "+getCategoryName(index)+"    "); // Spacing like this may need to be adjusted
            }
        }
        System.out.println();
    }

    private static void printDice(Die[] dice){ // List the dice - graphical dice have been scrapped
        for(int i=0;i<5;i++){System.out.print(dice[i].getFaceValue()+" ");}
    }

    private static int promptCategoryID() throws InputMismatchException {
        System.out.print("Please choose a category to score under. ");
        Scanner sc = new Scanner(System.in);
        int output;
        try{
            output = sc.nextInt();
        }
        catch (InputMismatchException e){
            output = -1; // Set the output to -1 if an error is found
        }

        return output;
    }

    private static int[] promptDiceList() throws InputMismatchException{
        System.out.print("Which dice would you like to set aside? (Separated by commas. Dice are ordered 1-5.) ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int items = 1;
        for(int i=0;i<input.length();i++){if(input.substring(i,i+1).equals(",")){items++;}} // Count up the number of items in the list
        int[] output = new int[items];
        for(int i=0;i<items;i++){
            try{output[i]=Integer.parseInt(fetchParam(input,i));} // Error checking
            catch(Exception e){Arrays.fill(output,-1);return output;}
        }
        return output;
    }

    private static String fetchParam(String str, int index){ // Get a set parameter from a formatted input, like "1,2,3"
        int currentIndex = 0;
        int lastDelimPos = -1;
        int i;
        for(i=0;i<str.length();i++){
            if(str.substring(i,i+1).equals(",")){
                if(currentIndex==index){return str.substring(lastDelimPos+1,i);}
                currentIndex++;
                lastDelimPos=i;
            }
        }
        return str.substring(lastDelimPos+1,i);
    }

    private static boolean inIntArr(int query,int[] arr){ // Searches for an integer in an array
        for (int anArr : arr) {
            if (anArr == query) {
                return true;
            }
        }
        return false;

    }

    private void promptCategory(){ // Prompts for AND scores in the category
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println();
            listCategories();
            choice = promptCategoryID();
            valid = ((choice >= 1 && choice <= 13) && !rules.checkCategory(choice));
            if (!valid) {System.out.println("The category you've picked has been used or is an invalid number.");}
        }
        rules.scoreCategory(dice,choice); // Score in the category
        printScoreCard();
    }

    private static String getCategoryName(int categoryID){ // Returns a category's name
        switch(categoryID){
            case 1: return "Aces";
            case 2: return "Twos";
            case 3: return "Threes";
            case 4: return "Fours";
            case 5: return "Fives";
            case 6: return "Sixes";
            case 7: return "3 of a Kind";
            case 8: return "4 of a Kind";
            case 9: return "Small Straight";
            case 10: return "Large Straight";
            case 11: return "Full House";
            case 12: return "Yahtzee";
            case 13: return "Chance";
        }
        throw new IllegalArgumentException("Expected number 1-13, got "+categoryID);
    }

    private void printScoreCard(){  // Print the scores of previously scored categories
        System.out.println("\n"+name+"'s Scorecard:");
        boolean empty = true;
        for (int x = 1; x <= 13; x++) {
            if(rules.checkCategory(x)){System.out.print(getCategoryName(x)+": " + rules.getCategoryScore(x)+" pts.   ");empty=false;}
        }
        if(rules.getBonusPoints()>0){System.out.print("Bonus: "+rules.getBonusPoints()+" pts.");} // No need to factor into emptiness because a bonus on the first turn is impossible
        if(empty){System.out.print("No scores yet.");}
        System.out.println();
    }
}