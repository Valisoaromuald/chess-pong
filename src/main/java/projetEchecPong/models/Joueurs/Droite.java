package projetEchecPong.models.Joueurs;

import javafx.geometry.Point2D;
import javafx.scene.effect.Light.Point;

public class Droite{
    private Point2D p1;
    private Point2D p2;
    public Droite(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public Droite(){
    }
    public Point2D getP1() {
        return p1;
    }
    public void setP1(Point2D p1) {
        this.p1 = p1;
    }
    public Point2D getP2() {
        return p2;
    }
    public void setP2(Point2D p2) {
        this.p2 = p2;
    }
}
