public class Rules {

    private boolean[] Scoring;
    private int totalScore;
    private int[] categoryScore;
    private boolean[] categoryCheck;
    private Player player;

    //needs to get created for every player at the time that the player is created


    public Rules(Player player) {
        this.player = player;
        categoryCheck = new boolean[13];
        for (int i = 0; i < categoryCheck.length; i++) {
            categoryCheck[i] = false;

        }

        for (Player player) {
            categoryScore = new int[13];
            for (int i = 0; i < categoryScore.length; i++) {
                categoryScore[i] = 0;
            }
        }
    }

    //what score is in that catagory
    public int checkScore(Die[] dice) {
        for (int i = 0; i < this.categoryCheck.length; i++) {
            if (categoryCheck[i]) {
                return dice;
            } else if (checkAces()) {
                Player.Die[] =categoryScore[1];
            } else if (checkTwos()) {

            }
        }

    }
        private int sumDice(int[] dice, int value){
            int subTotal = 0;
            for(int facevalue: dice){
               if(facevalue == value){
                   subTotal += facevalue;
               }
            }
            return subTotal;
        }

        public int checkDie (int[] dice){

        int diceValue = this.player.getScore();
           if(checkAces(dice)){
              diceValue += sumDice(dice, 1);
              this.player.setScore = diceValue;
           } else if (checkTwos(dice)) {
           diceValue += sumDice(dice, 2);
           this.player.setScore = diceValue;
           }


        return diceValue;
    }


    private boolean checkAces(Die[] dice) {

                for(int faceValue: dice){
                    if(faceValue. ==1){
                        return true;
                    } }
                return false;
            } private boolean checkTwos(int[] dice) {
        for (int faceValue : dice) {
            if (faceValue == 2) {
                return true;
            } }
        return false;
    } private boolean checkThrees(int[] dice) {
        for(int faceValue: dice){
            if(faceValue == 3){
                return true;
            } }
        return false;
    } private boolean checkFours(int[] dice) {
        for(int faceValue: dice){
            if(faceValue == 4){
                return true;
            } }
        return false;
    } private boolean checkFives(int[] dice) {
        for(int faceValue: dice){
            if(faceValue == 5){
                return true;
            } }
        return false;
    } private boolean checkSixes(int[] dice) {
        for(int faceValue: dice){
            if(faceValue == 6){
                return true;
            } }
        return false;
    }

    //Lower section will be worked on during beta








    public boolean[] getScoring() {
        return Scoring;
    }

    // This obvoiusly cant be done until atleast beta because alpha will not have lower section complete yet to add up
    // this is aviable for any class so its set public if you need it for main
    public int getTotalScore() {
        getTotalScore(Player player) = totalScore;
        totalScore =

    }

}