package projetEchecPong.models.piece;

import java.util.List;

import javafx.scene.image.Image;

public class Piece {  
    public Piece(double pointVie, int numero, int nombre, Image image) {
        this.pointVie = pointVie;
        this.numero = numero;
        this.nombre = nombre;
        this.image = image;
    }
        public Piece(double pointVie,int numero,int nombre) {
            this.pointVie = pointVie;
            this.numero = numero;
            this.nombre = nombre;
        }
    double pointVie;
    int numero;
    int nombre;
    Image image;
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public Piece() {
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
    public void DecrementerVie()throws Exception{
        if(this.pointVie > 0){
            this.pointVie--;
        }
        else{
            throw new Exception("le point de vie est deja nul");
        }
    }
    
}
