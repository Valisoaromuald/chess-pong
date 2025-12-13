package projetEchecPong.models;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.forme_geometrique.FormeRectangulaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un échiquier constitué de plusieurs cases
 */
public class Echiquier extends FormeRectangulaire {
    private int ligne;
    private int colonne;
    private final double UNITE = 80;
    private List<Case> cases;

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    // Constructeur principal
    public Echiquier(double posX, double posY, int ligne, int colonne, double width, double height) {
        super(posX, posY, width, height);
        this.ligne = ligne;
        this.colonne = colonne;
        this.cases = new ArrayList<>();
        initCases(UNITE, UNITE);
    }
    public Point2D getCentreGravite(){
        int  diviseur = 8/(colonne) ;
        double width = this.getWidth() - (diviseur) *UNITE;
        System.out.println("wre: "+this.getWidth());
        System.out.println("width: "+width);
        double x = this.getX()+(width/2 -UNITE),
        y = this.getY()+(this.getHeight()/2);
        return new Point2D(x, y);
    }

    // Initialiser les cases de l'échiquier
    private void initCases(double carreauWidth, double carreauHeight) {
        Color cl = Color.BEIGE;
        for (int i = 0; i < ligne; i++) {

            for (int j = 0; j < colonne; j++) {
                Case c = new Case(j, i, carreauWidth, carreauHeight,cl);
                c.setX(this.getX()+ j * carreauWidth);
                c.setY(this.getY() + i * carreauHeight);
                cases.add(c);
                c.setColor(cl);
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

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}
