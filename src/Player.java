public class Player { // NOT REAL Player class - for demo purposes only
    private String name;
    private boolean isPlaying = true;
    private int finalScore = 0;

    public Player(String name){ // Player constructor
        this.name=name;
    }

    public void takeTurn(){
        try{Thread.sleep(1000);} // Pretend to take a turn
        catch(Exception e){} // Handle possible exception
        System.out.println("Player "+this.name+" has taken their turn.");
        this.finalScore += (int)(Math.floor(Math.random()*10));
        if(Math.random()>0.8){ // 20% chance to stop playing randomly
            isPlaying=false;
            System.out.println("Player "+this.name+" has stopped playing.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public int getFinalScore() {
        return finalScore;
    }
}
