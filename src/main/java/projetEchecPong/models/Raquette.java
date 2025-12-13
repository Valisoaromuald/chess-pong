package projetEchecPong.models;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.forme_geometrique.FormeRectangulaire;

public class Raquette extends FormeRectangulaire {
    private double velocityX;
    private double velocityY;
    public Raquette(double posX, double posY, double width, double height,double velocityX,double velocityY) {
        super(posX, posY, width, height);
        this.velocityX = velocityX;
        this.velocityY = velocityY;        
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
        this.setX(this.getX()+this.velocityX) ;
        this.setX(this.getY()+this.velocityY) ;
    }
    public void stop() {
        this.velocityX = 0;
        this.velocityY = 0;
    }
}
