import java.util.Scanner;
public class Yahtzee {
    public static void main(String[] args){
        int totalPlayers = promptInt("How many players are there?");
        Player players[] = new Player[totalPlayers];
        for(int i=0;i<totalPlayers;i++){
            players[i] = new Player(promptString("What is Player "+(i+1)+"'s name?"));
        }
        System.out.println();
        while(anyPlaying(players)){ // While anyone is playing, allow players to take their turn only if they are playing
            for(int p=0;p<totalPlayers;p++){
                if(players[p].getIsPlaying()){players[p].takeTurn();}
            }
        }
    }

    static int promptInt(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+" ");
        return sc.nextInt();
    }

    static String promptString(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+" ");
        return sc.nextLine();
    }

    static boolean anyPlaying(Player players[]){
        for(int i=0;i<players.length;i++){
            if(players[i].getIsPlaying()){return true;}
        }
        return false;
    }
}
