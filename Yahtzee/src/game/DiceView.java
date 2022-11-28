package game;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class DiceView extends Parent {
    private Dice die;
    private Rectangle dv;

    private ImagePattern d1 = new ImagePattern(new Image("game/1.png"));
    private ImagePattern d2 = new ImagePattern(new Image("game/2.png"));
    private ImagePattern d3 = new ImagePattern(new Image("game/3.png"));
    private ImagePattern d4 = new ImagePattern(new Image("game/4.png"));
    private ImagePattern d5 = new ImagePattern(new Image("game/5.png"));
    private ImagePattern d6 = new ImagePattern(new Image("game/6.png"));





    public DiceView(Dice d, int i) {
        die = d;
        dv = new Rectangle(50, 50);
        roll(i);
        dv.setOnMouseClicked( mouseEvent -> {
            die.toggleKept();
            if(die.isKept()){ dv.setEffect(new Glow(1.0));}
            else{ dv.setEffect(null);
            }
        });
        getChildren().add(dv);
    }

    public void roll(int i){
        if(!die.isKept()) {
            dv.getTransforms().add(new Rotate(((Math.random() * (360 - 0)) + 0), 25, 25));
            dv.setTranslateX((i + 0.5) * 74);
            dv.setTranslateY((Math.random() * (250 - 15)) + 15);
            if (die.getValue() == 1) {
                dv.setFill(d1);
            } else if (die.getValue() == 2) {
                dv.setFill(d2);
            } else if (die.getValue() == 3) {
                dv.setFill(d3);
            } else if (die.getValue() == 4) {
                dv.setFill(d4);
            } else if (die.getValue() == 5) {
                dv.setFill(d5);
            } else if (die.getValue() == 6) {
                dv.setFill(d6);
            }
        }
    }

}
