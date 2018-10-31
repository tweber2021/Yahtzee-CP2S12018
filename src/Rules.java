public class Rules {

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

}
