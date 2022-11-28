package game;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Stack;

import static javafx.scene.layout.GridPane.*;


public class ScorecardView {

    private Scorecard scores;
    private GridPane pane;

    private Yahtzee game;


    public ScorecardView(GridPane pane, Scorecard scores, Yahtzee game){
        this.pane = pane;
        this.scores = scores;
        this.game = game;
        for(int i = 0; i < Combinations.values().length; i++){
            Combinations[] combinations = Combinations.values();
            Label c = new Label(combinations[i].getName());
            pane.add(c, 0, i);
        }
        pane.add(new Label("Total"), 0, Combinations.values().length);
    }

    public void posScore(String c, int s){
        String l = String.valueOf(s);
        Label pScore = new Label(l);
        pScore.setTextFill(Color.ORANGE);
        pScore.setOnMouseClicked(mouseEvent -> {

            scores.addScore(game.getPlayer(), c, s);
            Label ns = new Label(l);
            pane.add(ns, game.getPlayer(), findCategory(c));
            pane.getChildren().remove(pScore);
            clearPScores();
            game.nextPlayer(this);
        });
        //pane.getChildren().remove(1, findCategory(c) + 1);
        pane.add(pScore, game.getPlayer(), findCategory(c));
    }

    public boolean checkKey(String k){
        return scores.getScoreMap(game.getPlayer()).containsKey(k);
    }
    public void clearPScores(){
        Combinations[] combos = Combinations.values();
       // HashMap<String, Score> scoreMap = scores.getScoreMap(game.getPlayer());

        Stack<Node> rs = new Stack<>();

       for(Node label : pane.getChildren()){
           if (label.getClass().equals(Label.class)){
               int row = getRowIndex(label);
               int col = getColumnIndex(label);
               if (col == game.getPlayer()) {
                   if (!checkKey(combos[row].getName())) {
                       rs.push(label);
                   }
               }
           }
       }
       for(Node n : rs){
           pane.getChildren().remove(n);
       }
    }
    public int findCategory(String c){
        Combinations[] categories = Combinations.values();
        for(int i = 0; i < categories.length; i ++){
            if (categories[i].getName().equals(c)){
                return i;
            }
        }
        return 0;
    }

    public int calculateTotal(){
        HashMap<String, Score> scores1 = scores.getScoreMap(1);
        HashMap<String, Score> scores2 = scores.getScoreMap(2);
        int total1 = 0;
        int total2 = 0;
        int winner = 1;
        for(Combinations c : Combinations.values()){
            total1 += scores1.get(c.getName()).getValue();
            total2 += scores2.get(c.getName()).getValue();
        }
        pane.add(new Label("" + total1), 1, Combinations.values().length);
        pane.add(new Label("" + total2), 2, Combinations.values().length);
        if(total2 > total1){
            winner = 2;
        }
        return winner;
    }

}
