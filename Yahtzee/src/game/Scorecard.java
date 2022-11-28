package game;



import javafx.scene.layout.GridPane;

import java.util.HashMap;


public class Scorecard {

   private HashMap<String, Score> scores1;
   private HashMap<String, Score> scores2;

   private int winner;

   public Scorecard(){
      scores1 = new HashMap<>();
      scores2 = new HashMap<>();
     /** for(Combinations combo : Combinations.values()){
         scores1.put(combo.getName(), null);
         scores2.put(combo.getName(), null);
         //System.out.println(combo.name());
      } **/
   }
   public void addScore(int p, String key, int score){
      HashMap<String, Score> map;
      if(p == 1){map = scores1;}
      else{map = scores2;}
      map.put(key, new Score(score));
   }

   public HashMap<String, Score> getScoreMap(int p){
      if(p == 1){ return scores1;}
      else{return scores2;}
   }


}
