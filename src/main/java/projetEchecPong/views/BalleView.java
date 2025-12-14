package projetEchecPong.views;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import projetEchecPong.models.jeu.Balle;

public class BalleView extends ViewWithNode {

    private Balle balle;
    private Circle circle;

    public Balle getBalle() {
        return balle;
    }

    public BalleView(Balle balle) {
        this.balle = balle;
        createNode();     // On crée le cercle UNE SEULE FOIS
    }

    public BalleView() {}

    private void createNode() {
        circle = new Circle(balle.getCenterX(),balle.getCenterY(),balle.getRadius());
        circle.setFill(Color.GREEN);

      
        // On stocke le node dans ViewWithNode
        this.setNode(circle);
    }

    public void update() {
        // Mise à jour de la position du node
        circle.setCenterX(balle.getCenterX());
        circle.setCenterY(balle.getCenterY());
    }
}
