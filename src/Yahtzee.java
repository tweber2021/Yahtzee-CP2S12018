public class Yahtzee {
    public static void main(String[] args){
        // Die test, nothing pertaining to the actual game yet
        Die D = new Die();
        System.out.println("Before reroll: "+D.getFaceValue());
        D.rollDie();
        System.out.println("After reroll: "+D.getFaceValue());
    }
}
