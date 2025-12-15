package projetEchecPong.views;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.jeu.Case;

public class CaseView extends ViewWithNode {

    private final Case carreau;
    private final Rectangle rectangle;

    public CaseView(Case carreau) {
        this.carreau = carreau;
        this.rectangle = new Rectangle(
                carreau.getWidth(),
                carreau.getHeight()
        );
        init();
        this.node = rectangle;
    }

    private void init() {
        rectangle.setFill(carreau.getColor());
        rectangle.setLayoutX(carreau.getX());
        rectangle.setLayoutY(carreau.getY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Case getCarreau() {
        return carreau;
    }
}

