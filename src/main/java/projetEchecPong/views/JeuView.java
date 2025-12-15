package projetEchecPong.views;

import java.util.List;

import javafx.scene.layout.StackPane;
import projetEchecPong.models.jeu.Balle;

public class JeuView extends StackPane {
    private BalleView bv;
    private EchiquierView echiquierView;
    private List<JoueurView> joueursView;
    public JeuView(EchiquierView echiquierView,BalleView bv,List<JoueurView> joueursView){
        this.bv = bv;
        this.joueursView = joueursView;
        this.echiquierView = echiquierView;
    }


}
