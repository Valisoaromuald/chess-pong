package projetEchecPong.views;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HBoxExampleView extends VBox {
     public HBoxExampleView(){
        Rectangle blackRect = new Rectangle(50,50);
        blackRect.setFill(Color.rgb(0,0,0));
        
        Rectangle purpleRect = new Rectangle(150,80);
        purpleRect.setFill(Color.rgb(115,85,225));

        Rectangle greenRect = new Rectangle(60,20);
        greenRect.setFill(Color.rgb(50,200,20));

        Rectangle redRect = new Rectangle(120,120);
        greenRect.setFill(Color.rgb(203,55,55));

        Rectangle blueRect = new Rectangle(15,10);
        blueRect.setFill(Color.rgb(33,134,204));

        this.getChildren().addAll(blackRect,purpleRect,greenRect,redRect); 
     }

}
