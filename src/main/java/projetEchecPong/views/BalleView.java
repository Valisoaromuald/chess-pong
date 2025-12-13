package projetEchecPong.views;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import projetEchecPong.models.Balle;

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
        circle = new Circle(balle.getRadius());
        circle.setFill(Color.GREEN);

        // Position initiale
        circle.setLayoutX(balle.getCenterX());
        circle.setLayoutY(balle.getCenterY());
        circle.getLayoutX();

        // On stocke le node dans ViewWithNode
        this.setNode(circle);
    }

    public void update() {
        // Mise à jour de la position du node
        circle.setLayoutX(balle.getCenterX());
        circle.setLayoutY(balle.getCenterY());
    }
}
