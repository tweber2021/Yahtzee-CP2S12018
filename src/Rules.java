public class Rules {

    private static int Playeramount;
    private boolean[] Scoring;
    private int totalScore;
    private int[] categoryScore;
    private boolean[] categoryCheck;
    private Player player;
    boolean random = true;
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
    public int checkScore(player.Die[] dice) {
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
           }


        return diceValue;
    }


    private boolean checkAces(int[] dice) {

                for(int faceValue: dice){
                    if(faceValue ==1){
                        return true;

                    }

                }
                return false;
            }

    private boolean checkTwos(int[] dice) {
        for(int faceValue: dice){
            if(faceValue ==2){
                return true;

            }

        }
        return false;
    }

    }

    public boolean[] getScoring() {
        return Scoring;
    }

    public int getTotalScore() {
        getTotalScore(Player player) = totalScore;
        totalScore = categoryScore[1] + categoryScore[2] + categoryScore[3] + categoryScore[4]
        + categoryScore[5]+categoryScore[6]+categoryScore[7]+categoryScore[8]+categoryScore[9]
        +categoryScore[10]+categoryScore[11]+categoryScore[12]+categoryScore[13];


    }

}