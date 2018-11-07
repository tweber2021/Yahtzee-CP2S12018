public class Rules {


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

    }


    // This is getting the sc category and checking it
    // pValue is temporary there choice every time sc is chosen, since its not in index form were -1 to make sure it selects 0-12
    // As long as they sc categories 1-6 this will recognise certain number for the category
    // checkUpper is making sure a number equals that ruled number and getting how many dice values equal up to it
    // Now were setting the score for chosen category and making it there score which is sumDice that holds the score
    // We check that category off by turning it true so it is not re usable


    public boolean checkCategoryInput(Die [] dice, int chose) { // Sets scores (maybe)
        if (!checkCategory(chose)) {


                //case 1 is Aces

                if(chose>0 && chose<7){ // Deal with cases 1-6 since they're all handled the same
                    if (checkUpper(dice, chose)) {
                        categoryScore[chose - 1] = sumDice(dice, chose);
                        categoryCheck[chose - 1] = true;
                    }
                    else{
                        categoryScore[chose - 1] = 0;
                        categoryCheck[chose - 1] = true;
                    }
                    //System.out.println(categoryCheck[sc - 1]);
                    return categoryCheck[chose - 1];
                }

            switch (chose) { // Switch for 7-13 since they're all handled differently
                //case 7 is ThreeOfAKind
                case (7):
                    //test print lines were for testing.
                    /*System.out.println("Test 7");*/
                    System.out.println(checkMatch(dice, 3));
                    return checkMatch(dice, 3);

                    // TODO


                //case 8 is FourOfAKind
                case (8):
                    //test print lines were for testing.
                    /* System.out.println("Test 8");*/
                    System.out.println(checkMatch(dice, 4));
                    return checkMatch(dice, 4);

                    // TODO


                //case 9 is SmallStraight
                case (9):
                    //test print lines were for testing.
                    System.out.println("Test 9");
                    categoryScore[chose - 1] = scoreStraight(false,dice);
                    categoryCheck[chose - 1] = true;
                    return true;


                //case 10 is LargeStraight
                case (10):
                    //test print lines were for testing.
                    System.out.println("Test 10");
                    categoryScore[chose - 1] = scoreStraight(true,dice);
                    categoryCheck[chose - 1] = true;
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
//            if (sc < 7 && sc > 0) {
//                if (checkUpper(player.getDice(), sc)) {
//                    categoryScore[sc - 1] = sumDice(player.getDice(), sc);
//                    categoryCheck[sc - 1] = true;
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


    private boolean checkMatch(Die[] dice, int numberOfDice) { // multipurpose "of a kind" function

        for(int i=0;i<5;i++){ // Test how many matches each faceValue of Die i has
            int matches = 0;
            for(int j=0;j<5;j++){
                if(dice[i].getFaceValue()==dice[j].getFaceValue()){matches++;} // Goes through each die faceValue and tests how many times it equals a die in the array, counting itself
            }
            if(matches >= numberOfDice){return true;} // Match quota met!
            matches = 0; // Otherwise, try again with another faceValue
        }
        return false;
    }



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
            }}return subTotal;}

    // Methods for straight scoring only

    private static int scoreStraight(boolean large, Die[] dice){
        int score = 0;
        boolean scored = false;
        if(large){ // Large straight
            for(int ofs = 0;ofs < 2; ofs++) { // Large straights have two possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i < 6+ofs; i++) { // Iterate to all 5 dice
                    if (!inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
            }
            if(scored){return 40;}
        }
        else{ // Small straight
            for(int ofs = 0;ofs < 3; ofs++) { // Small straights have three possible sets of integers to look for
                scored = true;
                for (int i = 1+ofs; i < 5+ofs; i++) { // Iterate to four dice
                    if (!inDice(dice, i)) { // Check for the existence of iterated numbers
                        scored = false;
                    }
                }
            }
            if(scored){return 30;}
        }
        return 0;
    }

    // Check for the existence of a certain faceValue in the dice array
    private static boolean inDice(Die[] dice, int query){
        for(int i=0;i<dice.length;i++){
            if(dice[i].getFaceValue()==query){return true;}

        }
        return false;
    }

    public static void testOfAKind(){
        System.out.println("Test of a Kind:");

        Rules rules = new Rules(new Player("TestUser"));

        Die[] testDice = new Die[5];
        for(int r=0;r<1000;r++){
        for(int i=0;i<testDice.length;i++){
            testDice[i] = new Die();
            System.out.print(testDice[i].getFaceValue()+" ");
        }
            System.out.println();
            for(int j=1;j<=5;j++){
                System.out.println(j+" of a Kind: "+rules.checkMatch(testDice,j));
            }
            System.out.println();
        }

        System.out.println("Test complete.");
    }

}