package projetEchecPong.views;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GroupExampleView extends Group{
    public GroupExampleView(){
        Rectangle blackRect = new Rectangle(50,50);
        blackRect.setFill(Color.rgb(0,0,0));
        Rectangle purpleRect =  new Rectangle(150,80);
        purpleRect.setFill(Color.rgb(115,85,225));
        purpleRect.setLayoutX(25);
        purpleRect.setLayoutY(25);
        Rectangle greenRect = new Rectangle(60,20);
        greenRect.setFill(Color.rgb(50,200,20));
        greenRect.setLayoutX(18);
        greenRect.setLayoutY(19);

        Rectangle redRect = new Rectangle(120,120);
        redRect.setFill(Color.rgb(203,55,55)) ;
        this.getChildren().addAll(blackRect,purpleRect,greenRect,redRect);
    } 

}