public class Die {
    private int faceValue;

    public Die(){ // Die constructor
        rollDie(); // Automatically roll die upon creation
    }

    
    public void rollDie(){
        this.faceValue = (int)(Math.floor(Math.random()*6)+1); // Randomize Die's faceValue
    }

    public int getFaceValue() { // use [objectName].getFaceValue in code to get the Die's value
        return this.faceValue;
    }
}
