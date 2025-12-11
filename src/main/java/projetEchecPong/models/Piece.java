package projetEchecPong.models;

import javafx.scene.image.Image;

public class Piece {  
    double pointVie;
    int numero;
    boolean hasClone;
    Image image;
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isHasClone() {
        return hasClone;
    }

    public void setHasClone(boolean hasClone) {
        this.hasClone = hasClone;
    }

    public Piece() {
    }

    public Piece(double pointVie,int numero,boolean hasClone) {
        this.pointVie = pointVie;
        this.numero = numero;
        this.hasClone = hasClone;
    }

    public double getPointVie() {
        return pointVie;
    }
    public void setPointVie(double pointVie) {
        this.pointVie = pointVie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    } 
    public String getNomClasse() {
        return this.getClass().getSimpleName();
    }
    public String toString(){
        return getNomClasse();
    }
}
