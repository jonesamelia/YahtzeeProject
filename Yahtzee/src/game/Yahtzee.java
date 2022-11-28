package game;

public class Yahtzee {
    private int player;
    private int round;
    private int rolls;

    private int winner;

    private boolean gameWon;


    public Yahtzee(){
        player = 1;
        round = 1;
        rolls = 3;
    }

    public int getRolls() {
        return rolls;
    }

    public int getPlayer(){
        return player;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void nextPlayer(ScorecardView sv){
        if(player == 1){
            player = 2;
        }
        else{
            if(round == 13){
            endGame(sv);
            }
            player = 1;

            round ++;
        }
        rolls = 3;
    }
    public void roll(){
        rolls --;
    }

    public void endGame(ScorecardView view){
        winner = view.calculateTotal();
        gameWon = true;
    }
    public int getWinner(){
        return winner;
    }
}
