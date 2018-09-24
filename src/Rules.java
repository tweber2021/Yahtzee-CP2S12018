public class Rules {

    private boolean[] Scoring;
    private int totalScore;
    private int[] catagoryScore;
    private boolean[] catagoryCheck;

    //needs to get created for every player at the time that the player is created

    public Rules() {
        catagoryCheck = new boolean[13];
        for (int i = 0; i < catagoryCheck.length; i++) {
            catagoryCheck[i] = false;

        }
        totalScore = 0;
        catagoryScore = new int[13];
        for (int i = 0; i < catagoryScore.length; i++) {
            catagoryScore[i] = 0;

        }
    }

    public int checkScore(Die[] dice) {
        for (int i = 0; i < this.catagoryCheck.length; i++) {
            if (catagoryCheck[i]) {
                return dice;
            } else if (checkAces()) {

            }
        }
    return dice;
    }


    private boolean checkAces(){
        if(catagoryCheck[0]==true){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean[] getScoring() {
        return Scoring;
    }

    public int getTotalScore() {
        return totalScore;
        //get player: + all 1-13 catagories added up;
    }




}