public class Rules {

    private boolean[] Scoring;
    private int totalScore;
    private int[] categoryScore;
    private boolean[] categoryCheck;
    private Player player;


    // Player class creates new player in here
    public Rules(Player player) {


        // Getting whichever players going
        this.player = player;


        // Created 13 true or false categories
        categoryCheck = new boolean[13];

/*

        // length i is starting at 0, Category 1 would be 0, and so on.
        for (int i = 0; i < categoryCheck.length;i++) {
            // Counting up to .length = [13]
            // Since i less than, will start 0-12, i is not <= so we -1 from regular categories to match them
            // When returned false and not true, then the category is available for this.player to use
            categoryCheck[i] = false;
        }
*/





            // Creating 13 default 0 categories with categoryScore holding dice values
            categoryScore = new int[13];
            // Just like categoryCheck but with int, 0-12 , 13 available numbers
            for (int i = 0; i < categoryScore.length; i++) {


                // This is where the players score starts at, 0 for default
                // If a player scores a 0 it will count as a new score and flip the boolean from false to true
                categoryScore[i] = 0;
            }

    }




    public boolean checkCategoryInput(int chose) {
        if(checkCategory(chose-1)){
            if(chose<7 && chose>0){
                if(checkUpper(player.getDice(),chose)){
                    categoryScore[chose-1] = sumDice(player.getDice(),chose);
                    categoryCheck[chose-1] = true;
                    return true;
                }
            }
            else{
                //todo lowersection
                return true;
            }

        }
        return false;
    }

    private boolean checkUpper(Die[] dice, int value) {
        for (Die mFaceValue: dice) {
            if (mFaceValue.getFaceValue() == value) {
                return true;
            }}
        return false;
    }

    public boolean checkCategory(int pValue) {
        int fixedNumber;
        if (pValue < 1 || pValue > 12) {
            return false;
        } else {
            return categoryCheck[pValue];
        }



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
            }
        }


        // subTotal is switched from 0 to the new score of the 5 dices
        return subTotal;


    }


    /*// Back to category check, when a category is checked by a successful method, we will return it to true.
    public int checkScore(int[] dice) {


        // Now getting this. (certain category, looks into each one until it finds categoryCheck[0-12]
        // Will check the score if 0 return the dice to the player and either end or next turn created by Player
        for (int i = 0; i < this.categoryCheck.length; i++) {


            // if category is false categoryCheck[i=false]      { return dice; to player
            if (categoryCheck[i]) {


                // Now giving the player the dice back since they cant do anything with it
                return dice;


                // This is part 1 of 2 of checking, with this part were grabbing the dice for whichever upper/lower section they selected
                // Once it goes throughout the code for the upper/lower sectioned game rules code, and if they scored an actual score
                // Then we will flip the category from false to true for the selection they chose


                // ------ This section still needs tweaked and fixed a little ------
            } else if (checkUpper()) {


                // Category check is now switched to true
                categoryCheck[0] = true;


                // Category Score is done in the part 2 of 2, which is called checkDie

                // Doing the same thing as checkUpper but for checking checkTwos die requirements
                // Will be done during beta
            }

            }}
            return dice;

        }
*/



    // Getting int[0-12] and a new value to add up the (sub) total, not initial score (These are where the 5 dices are placed and checked)





    //Checking the real score from the dice values
   /*  public void checkDieRealScore (Die[] dice){


        // Created new diceValue now is this.players score, then getting the score to return to diceValue
        int NewDvalue = this.player.setScore();
        int diceValue = this.player.getScore();

        // now checking part 2 of 2 of upper section and lower later, getting the dice score which whatever value is needed
        for(int i = 1; i<=6;i++){
        if (checkUpper(dice, i)) {


            //Trying to get the 5 dice and
            diceValue += sumDice(dice,i);
            // diceValue now equals the amount of dices that equalled a one, so 1-5, and this score will be set into the categoryScore[0] later

            //New ]]
            //NewDvalue += totalDice()



        }
        }

        this.player.setScore(diceValue);

        // Gets the new diceValue depending on which check method was chosen and how many dice landed or scored that

    }*/


        // mFaceValue is a temporary hold for holding class Die's Die array



    //Lower section will be worked on during beta


    public void calculatePlayerScore(){
        int subtotal = 0;
        for(int value: categoryScore){
            subtotal += value;
        }
        totalScore = subtotal;

    }





    public boolean[] getScoring() {
        return Scoring;
    }

    // This obviously cant be done until atleast beta because alpha will not have lower section complete yet to add up
    // this is available for any class so its set public if you need it for main
    public int getTotalScore() {
        return totalScore;

    }

}

