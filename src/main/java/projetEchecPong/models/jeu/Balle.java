package projetEchecPong.models.jeu;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import projetEchecPong.models.forme_geometrique.Cercle;
import projetEchecPong.models.forme_geometrique.Segment;
import projetEchecPong.models.piece.Piece;

public class Balle extends Cercle {

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

    public void deplacer(Echiquier ech) {

        double nextX = getCenterX() + velocityX;
        double nextY = getCenterY() + velocityY;

        // Mur vertical
        if (nextX - getRadius() <= ech.getMinX()
                || nextX + getRadius() >= ech.getMaxX()) {
            velocityX = -velocityX;
        }

        // Mur horizontal
        if (nextY - getRadius() <= ech.getMinY()
                || nextY + getRadius() >= ech.getMaxY()) {
            velocityY = -velocityY;
        }

        setCenterX(getCenterX() + velocityX);
        setCenterY(getCenterY() + velocityY);
    }

    /**
     * Change la direction de la balle selon getTypeDirection :
     * 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1
     */
    public void changerDirection() {
        int type = getTypeDirection();
        double vx = Math.abs(this.velocityX);
        double vy = Math.abs(this.velocityY);

        switch (type) {
            case 1: // vx>0, vy>0
                this.velocityX = vx;
                this.velocityY = -vy;
                break;
            case 2: // vx>0, vy<=0
                this.velocityX = -vx;
                this.velocityY = -vy;
                break;
            case 3: // vx<=0, vy<=0
                this.velocityX = -vx;
                this.velocityY = vy;
                break;
            case 4: // vx<=0, vy>0
                this.velocityX = vx;
                this.velocityY = vy;
                break;
        }
    }

    public int getTypeDirection() {
        int resultat = 0;
        if (this.velocityX > 0) {
            if (this.velocityY > 0) {
                resultat = 1;
            } else {
                resultat = 2;
            }
        } else {
            if (this.velocityY <= 0) {
                resultat = 3;
            } else {
                resultat = 4;
            }
        }
        return resultat;
    }

    public Segment buildSegmentAvec(Balle b) {
        Segment s = new Segment();
        Point2D p1 = new Point2D(this.getCenterX(), this.getCenterY());
        Point2D p2 = new Point2D(b.getCenterX(), b.getCenterY());
        s.setPoint1(p1);
        s.setPoint2(p2);
        return s;
    }

    public Point2D findPointCollision(Balle b, Object obj) throws Exception {
        Point2D resultat = null;
        Segment segmentReference = buildSegmentAvec(b);
        double distanceMin = 0.,
                distancePoint = 0,
                distanceResultCentre = 0.;
        List<Point2D> points = new ArrayList<Point2D>();
        List<Segment> segments = new ArrayList<>();

        if (obj instanceof Echiquier) {
            Echiquier ech = (Echiquier) obj;
            segments = ech.getAllSegments();
        } else if (obj instanceof Piece) {

        } else if (obj instanceof Raquette) {
            Raquette raquette = (Raquette) obj;
            segments = raquette.getAllSegments();
        }
        int i = 0;
        for (Segment s : segments) {
            resultat = s.findPointIntersection(segmentReference);
            if (resultat != null) {
                distancePoint = distanceCentre(resultat);
                System.out.println("distance eee:" + distancePoint);
                distanceMin = i == 0 ? distancePoint : distanceMin;
                distanceMin = Math.min(distanceMin, distancePoint);
                points.add(resultat);
                i++;
            }
        }

        for (Point2D p : points) {
            distanceResultCentre = distanceCentre(p);

            if (distanceMin == distanceResultCentre) {
                resultat = p;
                break;
            }
        }
        return resultat;

    }

}