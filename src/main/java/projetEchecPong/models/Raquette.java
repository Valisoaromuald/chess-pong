package projetEchecPong.models;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.Joueurs.Droite;

public class Raquette extends Rectangle {

    private double posX;
    private double posY;
    private double velocityX;
    private double velocityY;
    private List<Droite> droites;

    public Raquette(double posX, double posY, double width, double height) {
        super(width, height);
        this.posX = posX;
        this.posY = posY;
        this.velocityX = 0;
        this.velocityY = 0;

        this.setX(posX);
        this.setY(posY);
    }

    /* =======================
       GETTERS / SETTERS
       ======================= */

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        this.setX(posX);
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
        this.setY(posY);
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

    public void update() {
        this.posX += velocityX;
        this.posY += velocityY;

        this.setX(posX);
        this.setY(posY);
    }

    
    public void stop() {
        this.velocityX = 0;
        this.velocityY = 0;
    }
    public void genererListeDroites(){
        List<Droite> listeDroites= new ArrayList<Droite>();
        Droite d1 = new Droite(new Point2D(this.posX,this.posY),new Point2D(this.posX,this.posY+this.getHeight()));
        Droite d2 = new Droite(new Point2D(this.posX,this.posY),new Point2D(this.posX+this.getWidth(),this.posY));
        Droite d3 = new Droite(new Point2D(this.posX,this.posY+this.getHeight()),new Point2D(this.posX+this.getWidth(),this.posY+this.getHeight()));
        Droite d4 = new Droite(new Point2D(this.posX+this.getWidth(),this.posY),new Point2D(this.posX+this.getWidth(),this.posY+this.getHeight()));
        listeDroites.addAll(List.of(d1,d2,d3,d4));
    }
    public void deplacer(){
        this.setPosX(this.getPosX()+this.velocityY);
        this.setPosY(this.getPosY()+this.velocityX);
    }
}
