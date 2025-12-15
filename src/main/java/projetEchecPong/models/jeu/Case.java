package projetEchecPong.models.jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.forme_geometrique.FormeRectangulaire;

/**
 * Représente un carreau de l'échiquier
 */
public class Case extends FormeRectangulaire {

    
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Case(double x, double y, double width, double height,Color color) {
        super(x, y, width, height);
        this.setColor(color);
    }

}
