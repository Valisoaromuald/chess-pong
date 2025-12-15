package projetEchecPong.models.jeu;
import javafx.scene.paint.Color;
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
    public double getUNITE() {
        return UNITE;
    }

    private List<Case> cases;

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    // Constructeur principal
    public Echiquier(double posX, double posY, int ligne, int colonne, double width, double height) {
        super(posX, posY, width-(8-colonne)*80, height);
        this.ligne = ligne;
        this.colonne = colonne;
        this.cases = new ArrayList<>();
        initCases(UNITE, UNITE);
    }


    // Initialiser les cases de l'échiquier
    private void initCases(double carreauWidth, double carreauHeight) {
        Color cl = Color.WHITE;
        for (int i = 0; i < ligne; i++) {

            for (int j = 0; j < colonne; j++) {
                Case c = new Case(this.getX()+ j * carreauWidth, this.getY() + i * carreauHeight, carreauWidth, carreauHeight,cl);
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
