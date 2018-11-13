class Rules {

    private int[] categoryScore;
    private boolean[] categoryCheck;
    private int bonusPoints = 0;

    Rules() {
        categoryCheck = new boolean[13];

        //Creating categoryScore to 13 new int's 0-12 in index form
        // We use i as an index just to replicate a for () for temp use in this method
        categoryScore = new int[13];

    }

    void scoreCategory(Die[] dice, int chose) { // Sets category scores
        if ((!checkCategory(chose)) || chose == 12) { // Disallow already previously scored categories to be scored again with the exception of Yahtzees.

            // Cases 1-6 are Aces, Twos, etc
            // Cases 7-13 are the other categories

            if(getMatch(dice,5)!=-1 && categoryCheck[11] && !categoryCheck[getMatch(dice,5)-1]){ // Joker Rules: Upper deck has priority. A bonus Yahtzee of fours needs to be used in the fours category instead.
                System.out.println("Joker Rules: This Yahtzee must be used to fill out the "+getMatch(dice,5)+"'s.");
                chose = getMatch(dice,5);
            }

            if(chose>0 && chose<7){ // Deal with cases 1-6 since they're all handled the same
                if (checkUpper(dice, chose)) {
                    categoryScore[chose - 1] = sumDice(dice, chose);
                }
            }

            switch (chose) { // Switch for 7-13 since they're all handled differently

                //case 7 is ThreeOfAKind
                case (7):
                    if(getMatch(dice,3)!=-1){categoryScore[chose - 1] = sumDice(dice);}
                    break;

                //case 8 is FourOfAKind
                case (8):
                    if(getMatch(dice,4)!=-1){categoryScore[chose - 1] = sumDice(dice);}
                    break;

                //case 9 is SmallStraight
                case (9):
                    categoryScore[chose - 1] = scoreStraight(false,dice);
                    if(getMatch(dice,5)!=-1){categoryScore[chose - 1] = 30;} // Joker Rule: Yahtzee counts
                    break;

                //case 10 is LargeStraight
                case (10):
                    categoryScore[chose - 1] = scoreStraight(true,dice);
                    if(getMatch(dice,5)!=-1){categoryScore[chose - 1] = 40;} // Joker Rule: Yahtzee counts
                    break;

                //case 11 is FullHouse
                case (11):
                    if (checkFullHouse(dice) || getMatch(dice,5)!=-1) {categoryScore[chose - 1] = 25;} // Joker Rule: Yahtzee counts
                    break;

                //case 12 is Yahtzee
                case (12):
                    if(getMatch(dice,5)!=-1 && !categoryCheck[chose-1]){categoryScore[chose - 1]= 50;}
                    break;

                //case 13 is Chance
                case (13):
                    categoryScore[chose - 1] = sumDice(dice); // Chance adds up all dice values, not just those of specific faceValues
                    break;
            }
            categoryCheck[chose - 1] = true;
        }
        if(chose<1||chose>13){
            throw new IllegalArgumentException("Invalid Category: "+chose); // Crash because this shouldn't happen
        }
    }

    private boolean checkUpper(Die[] dice, int value) {
        for (Die mFaceValue : dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }
        }
        return false;
    }

    private int getMatch(Die[] dice, int numberOfDice) { // multipurpose "of a kind" function that returns what number has the matches, -1 if none

        for(int i=0;i<5;i++){ // Test how many matches each faceValue of Die i has
            int matches = 0;
            for(int j=0;j<5;j++){
                if(dice[i].getFaceValue()==dice[j].getFaceValue()){matches++;} // Goes through each die faceValue and tests how many times it equals a die in the array, counting itself
            }
            if(matches >= numberOfDice){return dice[i].getFaceValue();} // Match quota met!
        }
        return -1; // No matches found
    }

    private boolean getSpecificMatch(Die[] dice, int faceValue, int numberOfDice) { // Check for a specific chain of numbers, like a yahtzee of threes, or a four-of-a-kind of sixes.
        int matches = 0;
        for(int i=0;i<5;i++){
            if(dice[i].getFaceValue()==faceValue){matches++;} // Goes through each die faceValue and tests how many times it equals a die in the array, counting itself
        }
        // Exact match!
        return matches == numberOfDice;
    }

    private boolean checkFullHouse(Die[] dice) {
        boolean hasShortSegment = false;
        boolean hasLongSegment = false;
        for(int i=1;i<=6;i++) { // Check for the small segment, iterating to all of the possible two-of-a-kinds
            if(getSpecificMatch(dice,i,2)){hasShortSegment=true;}
        }
        for(int i=1;i<=6;i++) { // Check for the large segment, iterating to all of the possible three-of-a-kinds
            if(getSpecificMatch(dice,i,3)){hasLongSegment=true;}
        }
        return hasShortSegment&&hasLongSegment; // If we have both segments, then we have a full house!
    }

    // Just to clarify if the category is available for use, if it's false
    // the return value may look switched but default was set to check as long as its default it can be used.
    boolean checkCategory(int pValue) {
        if (pValue < 1 || pValue > 13) {
            return false;
        } else {
            return categoryCheck[pValue-1];
        }
    }

    int getCategoryScore(int pValue) {
        if (pValue < 1 || pValue > 13) {
            return 0;
        } else {
            return categoryScore[pValue-1];
        }
    }

    private int sumDice(Die[] dice){
        int subTotal = 0;

        // facevalue is getting the dice now
        for (Die die : dice) {
            subTotal += die.getFaceValue();

        }
        return subTotal;
    }

    private int sumDice(Die[] dice, int value){


        // The subtotal will be 0, until returned with the new faceValue
        // We want to grab all dice and check them as well, not only score them
        int subTotal = 0;

        // facevalue is getting the dice now
        for(Die die: dice){
            int facevalue = die.getFaceValue();

            // If facevalue equals to the value then subtotal will be returnable as long as there is a matched int
            if(facevalue == value){


                // subTotal will be greater or equals to faceValue then
                subTotal += facevalue;
            }}return subTotal;}


    private boolean[] Scoring;
    private int totalScore;
    private int[] categoryScore;
    private boolean[] categoryCheck;
    private Player player;
    private boolean[] checkLowerSector = new boolean[7];

    public boolean[] getCategoryCheck() {
        return categoryCheck;
    }

    // Player class holds a play from its class, then will grab this.player to be specifice to correctly grabbing the right player
    // categoryCheck is a new 13 array list, the index is 0-12 however, but we have the program set all to false.
    public Rules(Player player) {
        this.player = player;
        categoryCheck = new boolean[13];



/*      For later on

        // length i is starting at 0, Category 1 would be 0, and so on.
        for (int i = 0; i < categoryCheck.length;i++) {
            // Counting up to .length = [13]
            // Since i less than, will start 0-12, i is not <= so we -1 from regular categories to match them
            // When returned false and not true, then the category is available for this.player to use
            categoryCheck[i] = false;
        }
*/


        //Creating categoryScore to 13 new int's 0-12 in index form
        // We use I as an index just to replicate a for () for temp use in this method
        categoryScore = new int[13];
        for (int i = 0; i < categoryScore.length; i++) {
            categoryScore[i] = 0;
        }

    }


    // This is getting the chose category and checking it
    // pValue is temporary there choice every time chose is chosen, since its not in index form were -1 to make sure it selects 0-12
    // As long as they chose categories 1-6 this will recognise certain number for the category
    // checkUpper is making sure a number equals that ruled number and getting how many dice values equal up to it
    // Now were setting the score for chosen category and making it there score which is sumDice that holds the score
    // We check that category off by turning it true so it is not re usable


    public boolean checkCategoryInput(Die [] dice, int chose) {
        if (!checkCategory(chose)) {

            switch (chose) {
                //case 1 is Aces
                case (1):
                case (2):
                case (3):
                case (4):
                case (5):
                case (6):
                    if (checkUpper(dice, chose)) {
                        categoryScore[chose - 1] = sumDice(dice, chose);
                        categoryCheck[chose - 1] = true;
                    }
                    else{
                        categoryScore[chose - 1] = 0;
                        categoryCheck[chose - 1] = true;
                    }
                    //System.out.println(categoryCheck[chose - 1]);
                    return categoryCheck[chose - 1];


                //case 7 is ThreeOfAKind
                case (7):
                    //test print lines were for testing.
                    /*System.out.println("Test 7");*/
                    System.out.println(checkMatch(dice, 3));
                    return checkMatch(dice, 3);


                //case 8 is FourOfAKind
                case (8):
                    //test print lines were for testing.
                    /* System.out.println("Test 8");*/
                    System.out.println(checkMatch(dice, 4));
                    return checkMatch(dice, 4);


                //case 9 is SmallStraight
                case (9):
                    //test print lines were for testing.
                     System.out.println("Test 9");
                     return true;


                //case 10 is LargeStraight
                case (10):
                    //test print lines were for testing.
                     System.out.println("Test 10");
                    return true;

                //case 11 is FullHouse
                case (11):
                    //test print lines were for testing.
                    /* System.out.println("Test 11");*/
                    if (checkMatch(dice, 3) &&
                            checkMatch(dice, 2)) {
                        System.out.println("this works.");
                        return true;
                    }
                    //not sure if i need the !checkMatch(5)
                    break;

                //case 12 is Yahtzee
                case (12):
                    //test print lines were for testing.
                    /* System.out.println("Test 12");*/
                    System.out.println(checkMatch(dice, 5));
                    return checkMatch(dice, 5);
//case 12 crashes the game, not good.

                //case 13 is Chance
                case (13):
                    sumDice(dice, chose);
                    System.out.println(sumDice(dice, chose));
                    return true;
                //test print lines were for testing.
              /*  System.out.println("Test 13"); */


                default:
                    System.out.println("Invalid number or faulty code.");
                    break;
            }
//            if (chose < 7 && chose > 0) {
//                if (checkUpper(player.getDice(), chose)) {
//                    categoryScore[chose - 1] = sumDice(player.getDice(), chose);
//                    categoryCheck[chose - 1] = true;
//                    return true;
//                }
//            } else {
//
//
//                //todo lowersection
//                return true;
//            }

        } else {
            return false;

        }

        return false;

    }

    //This goes throw each dice, so it will loop 5 times checking each value and setting it
    // as long as certain values match up will count them as score but is depended on the category that's selected.

    private boolean checkUpper(Die[] dice, int value) {
        for (Die mFaceValue : dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;

            }
        }
        return false;
    }


    private boolean checkMatch(Die[] dice, int numberOfDice) {

        switch (numberOfDice) {
            case 1:
                boolean[] checkChance = new boolean[1];
                    if (checkChance[1] == true) {
                        return false;
                    } else {
                        checkLowerSector[4] = true;
                        return true;
                }
            case 2:
                for (int i = 0; i <= (dice.length); i++) {
                    for (int a = 0; a <= (dice.length); i++) {
                        if ((dice[i] == dice[i + a])) {
                            return true;
                        }
                    }
                }
                return false;
            case 3:
                for (int i = 0; i < dice.length; i++) { //3 of kind
                    for (int a = 0; a < dice.length; a++) {
                        for (int b = 0; b < dice.length; b++) {
                            if (dice[i] == dice[a] &&
                                    dice[i] == dice[b] &&
                                    dice[a] == dice[b]);
                            checkLowerSector[1] = true;
                            return true;
                        }
                    }
                }
            case 4: //chance is 13 category
                boolean[] checkYahtzee = new boolean[1];
                if (checkYahtzee[1] = false) {
                for (int i = 0; i < 5; i++) { //4 of kind
                    for (int a = 0; a < 5; a++) {
                        for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                                if (dice[i] == dice[a] &&
                                        dice[i] == dice[b] &&
                                        dice[i] == dice[c] &&
                                        dice[a] == dice[b] &&
                                        dice[a] == dice[c] &&
                                        dice[b] == dice[c]) ;
                                checkLowerSector[2] = true;
                                return true;
                            }
                        }
                        }
                    }

                }
            case 5:

                for (int i = 0; i < 5; i++) { //5 of kind
                    for (int a = 0; a < 5; a++) {
                        for (int b = 0; b < 5; b++) {
                            for (int c = 0; c < 5; c++) {
                                for (int e = 0; e < 5; e++) {
                                    if (dice[i] == dice[a] &&
                                            dice[i] == dice[b] &&
                                            dice[i] == dice[c] &&
                                            dice[i] == dice[e] &&
                                            dice[a] == dice[b] &&
                                            dice[a] == dice[c] &&
                                            dice[a] == dice[e] &&
                                            dice[b] == dice[c] &&
                                            dice[b] == dice[e] &&
                                            dice[c] == dice[e]) ;
                                    checkLowerSector[3] = true;
                                    return true;
                                }
                            }
                        }
                    }
                }
        }
        return false;
    }

        /*
        for (Die mFaceValue: dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }}
        return false;
    }*/


  /*  private boolean presetCheckCategoryLower(Die[] dice, int value) {
        for (int i=0; i <= 6; i++) {

            boolean[] checkingLowerSection = new boolean[7];
            int[] matchLowerSection = new int[7];


            for (Die mFaceValue: dice) {
                if (mFaceValue.getFaceValue() ==)
                    value = matchLowerSection[i];

            if (checkingLowerSection[i] == true) {

                checkingLowerSection[i] =
                }
            }
            }

        } */



    // Just to clarify if the category is available for use, if false it is
    // the return value may look switched but default was set to check as long as its default it can be used.
    public boolean checkCategory(int pValue) {
        int fixedNumber;
        if (pValue < 1 || pValue > 13) {
            return false;
        } else {
            return categoryCheck[pValue-1];
        }



    }


    public int sumDice(Die[] dice){
            int subTotal = 0;

            // facevalue is getting the dice now
            for (Die die : dice) {
                subTotal += die.getFaceValue();

            }
            return subTotal;
        }

    public int sumDice(Die[] dice, int value){


        // The subtotal will be 0, until returned with the new faceValue
        // We want to grab all dice and check them as well, not only score them
        int subTotal = 0;

        // facevalue is getting the dice now
        for(Die die: dice){
            int facevalue = die.getFaceValue();

            // If facevalue equals to the value then subtotal will be returnable as long as there is a matched int
            if(facevalue == value){


                // subTotal will be greater or equals to faceValue then
                subTotal += facevalue;
            }

    // Methods for straight scoring only

    private static int scoreStraight(boolean large, Die[] dice){
        boolean scored;
        if(large){ // Large straight
            for(int ofs = 0;ofs < 2; ofs++) { // Large straights have two possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i <= 5+ofs; i++) {
                    if (inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
                if(scored){return 40;}
            }
        }
        else{ // Small straight
            for(int ofs = 0;ofs < 3; ofs++) { // Small straights have three possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i <= 4+ofs; i++) {
                    if (inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
                if(scored){return 30;}
            }
        }
        return 0;
    }

    // Check for the existence of a certain faceValue in the dice array
    private static boolean inDice(Die[] dice, int query){
        for(int i=0;i<dice.length;i++){
            if(dice[i].getFaceValue()==query){return true;}
<<<<<<< HEAD
=======
        for (Die aDice : dice) {
            if (aDice.getFaceValue() == query) {
                return false;
            }
>>>>>>> pr/14
=======
>>>>>>> parent of e45ef93... Merge branch 'pr/14'

        }
        return true;
    }

    // End of methods used for straight scoring only

    void checkBonuses(Die[] dice){ // Grant bonuses if possible
        if(getMatch(dice,5)!=-1 && categoryScore[11]==50){
            // Yahtzee bonus
            System.out.println("Congratulations! You got a Yahtzee Bonus! (+100)");
            bonusPoints+=100;
        }
        int sumUpper = 0;
        for (int i=1;i<=6;i++) {
            sumUpper += categoryScore[i];
        }
        if(sumUpper >= 63 && bonusPoints%2==0){ // Make sure the upper bonus hasn't been given already - if the bonus was already given, the bonus number will be odd for the rest of the game.
            // Upper Bonus
            System.out.println("You got an Upper Bonus! (+35)");
            bonusPoints+=35;
        }
    }

    int getBonusPoints() {
        return bonusPoints;
    }

    int getTotalScore(){ // Calculates the player's definitive score
        int subTotal=0;
        for (int aCategoryScore : categoryScore) {
            subTotal += aCategoryScore;
        }
        subTotal += bonusPoints;
        return subTotal;
    }

}