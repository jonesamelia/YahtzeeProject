package game;

import java.util.ArrayList;

public class Cup {
    private ArrayList<Dice> dice;
    private ArrayList<DiceView> dvs;

    private ScorecardView sView;


    public Cup(ArrayList<Dice> d, ArrayList<DiceView> dv, ScorecardView sv){
        dice = d;
        dvs = dv;
        sView = sv;
    }

    public void rollDice(){
            for (Dice d : dice) {
                d.roll();
            }
            for (int i = 0; i < dvs.size(); i++) {
                dvs.get(i).roll(i);
            }
            checkDie();
    }

    public void checkDie(){
        int[] nums = new int[6];
        int[] numsCount = new int[6];
        Combinations[] combos = Combinations.values();
        for(int i = 0; i < dice.size(); i++){
            numsCount[dice.get(i).getValue() - 1] += 1;
            nums[i] = dice.get(i).getValue();
        }
        String c = "";
        for(int i = 0; i < numsCount.length; i++){
                c += numsCount[i];

        }
        sView.clearPScores();
        for(int i = 0; i < combos.length; i ++){
            if(!sView.checkKey(combos[i].getName())) {
                sView.posScore(combos[i].getName(), combos[i].getScore(nums, c));
            }
        }

       /** System.out.println(c);
        Combinations combo;
        if(c.contains("3")){
            combo = Combinations.ThreeOfAKind;
            sView.posScore(combo.getName(), combo.getScore(nums));
            if(c.contains("2")){
                combo = Combinations.FullHouse;
                sView.posScore(combo.getName(), 25);
            }

        }
        System.out.println(c); **/
    }



}
