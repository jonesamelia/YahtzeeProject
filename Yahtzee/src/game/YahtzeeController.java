package game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class YahtzeeController {
    private Yahtzee game;
    private Cup dice;
    private Scorecard scores;

    private ScorecardView scoreView;
    @FXML
    private Button roll;
    @FXML
    private Label playerTurn;

    @FXML
    private Label rollsLeft;
    @FXML
    private Pane dicePane;

    @FXML
    private GridPane scorePane;

@FXML
    public void initialize(){
        game = new Yahtzee();
        ArrayList<Dice> dice = new ArrayList<>(5);
        ArrayList<DiceView> dvs = new ArrayList<>(5);
        scores = new Scorecard();
        scoreView = new ScorecardView(scorePane, scores, game);
        for(int i = 0; i < 5; i++){
          Dice die = new Dice(i);
         dice.add(die);
         DiceView dv = new DiceView(die, i);
         dvs.add(dv);
         dicePane.getChildren().add(dv);
        }
        this.dice = new Cup(dice, dvs, scoreView);
    }

    public void diceRoll(){
        if(game.getRolls() > 0){
            game.roll();
            dice.rollDice();
            update();
        }

    }
    public void update(){
        playerTurn.setText("Player " + game.getPlayer() + "'s Turn");
        rollsLeft.setText("Rolls left: " + game.getRolls());
        if(game.isGameWon()){
            playerTurn.setText("Player " + game.getWinner() + " has won!");
        }
    }
}
