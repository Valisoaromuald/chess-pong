package projetEchecPong.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Représente un carreau de l'échiquier
 */
public class Case extends Rectangle {

    private int x; // colonne
    private int y; // ligne
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Case(int x, int y, double width, double height,Color color) {
        super(width, height); // width et height du Rectangle
        this.x = x;
        this.y = y;
        this.setWidth(width);
        this.setHeight(height);
        this.setColor(color);
    }

    // Getter / Setter
    public int getXCoord() {
        return x;
    }

    public void setXCoord(int x) {
        this.x = x;
    }

    public int getYCoord() {
        return y;
    }

    public void setYCoord(int y) {
        this.y = y;
    }
}
