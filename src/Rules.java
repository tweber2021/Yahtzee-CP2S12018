public class Rules {

    private static int Playeramount;
    private boolean[] Scoring;
    private int totalScore;
    private int[] catagoryScore;
    private boolean[] catagoryCheck;
    private Player player;
    //needs to get created for every player at the time that the player is created

    public Rules(Player player) {
        this.player = player;
        catagoryCheck = new boolean[13];
        for (int i = 0; i < catagoryCheck.length; i++) {
            catagoryCheck[i] = false;

        }

        for (Player player) {
        catagoryScore = new int[13];
        for (int i = 0; i < catagoryScore.length; i++) {
            catagoryScore[i] = 0;
        }
        }
    }

    public int checkScore(player.Die[] dice) {
        for (int i = 0; i < this.catagoryCheck.length; i++) {
            if (catagoryCheck[i]) {
                return dice;
            } else if (checkAces()) {
                catagoryScore[] = 
            }

            public int checkDie(int faceValue) {
                for (faceValue = player.Die[]);

            }

        }
    return Die[];
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