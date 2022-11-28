package game;

public class Dice {
    private int value = 1;
    private boolean kept;

    public Dice(int i){
        value = i + 1;
    }

    public void toggleKept(){
        kept = !kept;
    }
    public void roll() {
        if(!kept) {
            value = (int) (Math.random() * 6.0 + 1);
            System.out.println(value);
        }
    }

    public int getValue(){
        return value;
    }

    public boolean isKept(){
        return kept;
    }

}
