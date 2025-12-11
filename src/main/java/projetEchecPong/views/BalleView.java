package projetEchecPong.views;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import projetEchecPong.models.Balle;

public class BalleView extends ViewWithNode{
    Balle balle;
    public Balle getBalle() {
        return balle;
    }

    public BalleView(Balle balle) {
        this.balle = balle;
    }

    public BalleView() {
    }

    public void drawBalle() {

        if (this.balle != null) {
            Circle c = new Circle(balle.getRayon());
            c.setFill(Color.GREEN);
            // positionnement relatif au parent
            c.setLayoutX(balle.getPosX());
            c.setLayoutY(balle.getPosY());
            this.setNode(c);
        }
    }

}
