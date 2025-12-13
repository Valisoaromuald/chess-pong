package projetEchecPong.models.forme_geometrique;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Cercle extends Circle {
    public Cercle(double x, double y, double rayon) {
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(rayon);
    }

    public double distanceCentre(Point2D point) {
        double distance = 0.;
        double deltaX = point.getX() - this.getCenterX();
        double deltaY = point.getY() - this.getCenterY();
        distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distance;
    }

    public boolean appartientASoi(Point2D p) {
         return distanceCentre(p)<=this.getRadius();
    }
}
