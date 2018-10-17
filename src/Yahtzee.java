import java.util.InputMismatchException;
import java.util.Scanner;
public class Yahtzee {
        public static void main(String[] args){


                System.out.println("Welcome to Yahtzee!\n");

                // Ask for number of players and their names
                boolean legalPlayerNum = false;
                Player players[];
                int totalPlayers = 1;
                while(!legalPlayerNum) {
                    totalPlayers = promptInt("How many players are there?");
                    if(totalPlayers>=1&&totalPlayers<=1000){legalPlayerNum=true;}
                    else{System.out.println("Please enter a number between 1 and 1000.");}
                }
                players = new Player[totalPlayers];
                for(int i=0;i<totalPlayers;i++){
                        players[i] = new Player(promptString("What is Player "+(i+1)+"'s name?"));
                }
                System.out.println();

                // Gameplay loop
                while(anyPlaying(players)){ // While anyone is playing, allow players to take their turn only if they are playing
                       for(int p=0;p<totalPlayers;p++){
                              if(players[p].getIsPlaying()){players[p].takeTurn();}
                       }
                }

                // Display final scores and declare the winner
                System.out.println("- Final Scores -");
                printFinalScores(players);
                System.out.println("\n"+getWinnerName(players)+" wins!");
        }

        // ------------------------------------------------------------------------------------------------------ //
        static void checkIntInput(String prompt) throws InputMismatchException {
            int output = 0;
          try{
             output = promptInt(prompt);
          }
          catch (InputMismatchException e){
              System.out.println("You did not use a valid number\nPlease try again");
              checkIntInput(prompt);
            }

        }

        static int promptInt(String prompt) throws InputMismatchException{
                Scanner sc = new Scanner(System.in);
                //boolean success = false;
                int output = 0;
                String response;
                //while(!success) {
                    System.out.print(prompt + " ");
                    //success = true; // Allow user input to pass unless exception occurs.
                     //response = sc.nextLine();
                     //output = (Integer.parseInt(response);
                    try{
                      output = sc.nextInt();
                    }
                    catch (InputMismatchException e){
                        System.err.println("You have not entered a valid integer.");
                        output = 0;
                    }

                        //System.err.println("You have not entered a valid integer.");
                       // success = false;
                //}


                return output;
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

        static void printFinalScores(Player players[]){
                for(int i=0;i<players.length;i++){
                        System.out.println(players[i].getName()+": "+players[i].getScore()+" pts.");
                }
        }

        static String getWinnerName(Player players[]){
                int winner = 0; // Replaced if "Player 0" does not win
                for(int i=0;i<players.length;i++){
                        if(players[i].getScore() > players[winner].getScore()){winner = i;}
                }
                return players[winner].getName();
        }
}