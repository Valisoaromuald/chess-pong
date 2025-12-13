package projetEchecPong.models;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.forme_geometrique.Cercle;
import projetEchecPong.models.forme_geometrique.Segment;

public class Balle extends Cercle{

    // Angle de déviation (en radians ou degrés selon ton choix)
    private double angleDeviation;

    // Vitesse sur chaque axe
    private double velocityX;
    private double velocityY;

    // Constructeur
    public Balle(double posX, double posY, double rayon,
                 double velocityX, double velocityY, double angleDeviation) {
        super(posX, posY, rayon);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.angleDeviation = angleDeviation;
    }

    public double getAngleDeviation() {
        return angleDeviation;
    }

    public void setAngleDeviation(double angleDeviation) {
        this.angleDeviation = angleDeviation;
    }


    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    public void deplacer(){
        this.setCenterX(this.getCenterX()+this.velocityX);
        this.setCenterY(this.getCenterY()+this.velocityY);
    }
    public int getTypeDirection(){
        int resultat = 0;
        if(this.velocityX > 0){
            if(this.velocityY > 0){
                resultat = 1;
            }
            else{
                resultat = 2;
            }
        }
        else{
            if(this.velocityY <= 0){
                resultat = 3;
            }
            else{
                resultat = 4;
            }
        }
        return resultat;
    }
    public Segment buildSegmentAvec(Balle b){
        Segment s = new Segment();
        Point2D p1 = new Point2D(this.getCenterX(), this.getCenterY());
        Point2D p2 = new Point2D(b.getCenterX(), b.getCenterY());
        s.setPoint1(p1);
        s.setPoint2(p2);
        return s;
    }
    public Point2D findPointCollision(Balle b, Object obj)throws Exception{
        Point2D resultat = null;
        Segment segmentReference = buildSegmentAvec(b);
        double distanceMin = 0., 
        distancePoint = 0,
        distanceResultCentre = 0.;
        List<Point2D> points = new ArrayList<Point2D>();
        List<Segment> segments = new ArrayList<>();

        if(obj instanceof Echiquier){
            Echiquier ech = (Echiquier) obj;
            segments = ech.getAllSegments();
        }
        else if(obj instanceof Piece){

        }
        else if(obj instanceof Raquette){
            Raquette raquette = (Raquette) obj;
            segments = raquette.getAllSegments();
        }
        int i = 0; 
        for(Segment s : segments){
            resultat = s.findPointIntersection(segmentReference);
            System.out.println("resultat:"+resultat);
            if(resultat != null){
                distancePoint = distanceCentre(resultat);
                distanceMin =  i == 0 ? distancePoint : distanceMin;
                System.out.println("izay kely: "+distanceMin+"; distance point: "+distancePoint);
                distanceMin = Math.min(distanceMin,distancePoint);
                points.add(resultat);
            }
            i++;
        }
        for(Point2D p : points){
            distanceResultCentre = distanceCentre(p);
            System.out.println("distence centre: "+distanceResultCentre);
            if(distanceMin == distanceResultCentre){
                resultat = p;
                break;
            }
        }
        return resultat;

    }
    
}