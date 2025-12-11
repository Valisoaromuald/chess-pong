package projetEchecPong.models;
import javafx.scene.shape.Circle;

public class Balle extends Circle{
    // Position du centre
    private double posX;
    private double posY;

    // Angle de déviation (en radians ou degrés selon ton choix)
    private double angleDeviation;

    // Rayon de la balle
    private double rayon;

    // Vitesse sur chaque axe
    private double velocityX;
    private double velocityY;

    // Constructeur
    public Balle(double posX, double posY, double rayon,
                 double velocityX, double velocityY, double angleDeviation) {
        this.posX = posX;
        this.posY = posY;
        this.rayon = rayon;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.angleDeviation = angleDeviation;
    }
    // Getters et Setters
    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getAngleDeviation() {
        return angleDeviation;
    }

    public void setAngleDeviation(double angleDeviation) {
        this.angleDeviation = angleDeviation;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
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
        this.setPosX(this.getPosX()+this.velocityX);
        this.setPosY(this.getPosY()+this.velocityX);
    }

}
