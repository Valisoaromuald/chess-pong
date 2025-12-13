package projetEchecPong.models.forme_geometrique;

import javafx.geometry.Point2D;

public class Segment {
    Point2D point1;
    Point2D point2;
    public Segment(){
    }
    public Segment(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public double getXMin(){
        double resultat = 0.;
        resultat = point1.getX() <=point2.getX() ? point1.getX():point2.getX();
        return resultat;
        
    }
    public double getXMax(){
        double resultat = 0.;
        resultat = point1.getX() >=point2.getX() ? point1.getX():point2.getX();
        return resultat;
    }
    public double getYMin(){
        double resultat = 0.;
        resultat = point1.getY() <=point2.getY() ? point1.getY():point2.getY();
        return resultat;
    }
    public double getYMax(){
        double resultat = 0.;
        resultat = point1.getY() >=point2.getY() ? point1.getY():point2.getY();
        return resultat;
    }
    public Point2D getPoint1() {
        return point1;
    }
    public void setPoint1(Point2D point1) {
        this.point1 = point1;
    }
    public Point2D getPoint2() {
        return point2;
    }
    public void setPoint2(Point2D point2) {
        this.point2 = point2;
    };
    public Point2D resoudreSystemeEquation(Segment s){
        Point2D resultat = null;
        double x1 = this.getPoint1().getX()
        ,y1 = this.getPoint1().getY(),
        x2 = this.getPoint2().getX(),
        y2 = this.getPoint2().getY(),
        x3 = s.getPoint1().getX()
        ,y3 = s.getPoint1().getY(),
        x4 = s.getPoint2().getX()
        ,y4 = s.getPoint2().getY(),
        a1 = y1-y2,
        b1 = x2-x1,
        c1 = x1*(y1-y2)+y1*(x2-x1),
        a2 = y3-y4,
 		b2 = x4-x3,
 		c2 = x3*(y3-y4)+y3*(x4-x3),
        delta = a1*b2-a2*b1;
        double x ,y = 0.;
        if(delta == 0.){
            return null;
        }
        x = (c1*b2-b1*c2)/delta;
        y = (a1*c2-a2*c1)/delta;
        resultat = new Point2D(x, y);
        return resultat;
    }

    public Point2D findPointIntersection(Segment s) {
        Point2D resultat = resoudreSystemeEquation(s);
        if(estInclus(resultat) && s.estInclus(resultat))
            return resultat;
        else
            return null;
    }
    public boolean estInclus(Point2D p){
        double xInf = this.getXMin(),
        yInf = this.getYMin(), 
        xSup = this.getXMax(),
        ySup = this.getYMax(),
        x = p.getX(),y = p.getY();
        return x>=xInf && x<=xSup && y>=yInf && y<=ySup;
    }
}