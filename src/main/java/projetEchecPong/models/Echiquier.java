package projetEchecPong.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un échiquier constitué de plusieurs carreaux
 */
public class Echiquier extends Rectangle {

    private double posX;
    private double posY;
    private int ligne;
    private int colonne;
    private List<Case> carreaux;

    // Constructeur principal
    public Echiquier(double posX, double posY, int ligne, int colonne, double width, double height) {
        super(width, height); // width et height de Rectangle
        this.posX = posX;
        this.posY = posY;
        this.ligne = ligne;
        this.colonne = colonne;
        this.setX(posX);
        this.setY(posY);
        this.carreaux = new ArrayList<>();
        initCarreaux((width+posX) / 8, (height+posY) / 8);
    }

    // Initialiser les carreaux de l'échiquier
    private void initCarreaux(double carreauWidth, double carreauHeight) {
        Color cl = Color.BEIGE;
        for (int i = 0; i < ligne; i++) {

            for (int j = 0; j < colonne; j++) {
                Case c = new Case(j, i, carreauWidth, carreauHeight,cl);
                c.setX(posX + j * carreauWidth);
                c.setY(posY + i * carreauHeight);
                carreaux.add(c);
                if(cl == Color.BROWN){
                    cl = Color.BEIGE;
                }
                else{
                    cl = Color.BROWN;
                }
            }
            if(cl == Color.BROWN){
                    cl = Color.BEIGE;
            }
            else{
                cl = Color.BROWN;
            }

        }
    }

    // Getter / Setter
    public List<Case> getCarreaux() {
        return carreaux;
    }

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

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}
