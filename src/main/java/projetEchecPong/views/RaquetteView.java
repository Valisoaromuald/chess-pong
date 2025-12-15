package projetEchecPong.views;

import javafx.scene.Node;
import projetEchecPong.models.jeu.Raquette;

public class RaquetteView extends ViewWithNode{
    private Raquette raquette;

    public RaquetteView(Node node, Raquette raquette) {
        super(node);
        this.raquette = raquette;
    }

    public RaquetteView(Raquette raquette) {
        this.raquette = raquette;
    }


    public Raquette getRaquette() {
        return raquette;
    }

    public void setRaquette(Raquette raquette) {
        this.raquette = raquette;
    }
    
}
