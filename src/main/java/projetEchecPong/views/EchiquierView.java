package projetEchecPong.views;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projetEchecPong.animations.AnimationBalle;
import projetEchecPong.models.Balle;
import projetEchecPong.models.Case;
import projetEchecPong.models.Echiquier;
import projetEchecPong.models.Joueurs.Joueur;

public class EchiquierView extends StackPane {
    private Echiquier echiquier;
    private List<Joueur> joueurs;

    public EchiquierView(Echiquier echiquier) throws Exception {
        this.echiquier = echiquier;

        Pane boardPane = new Pane(); // pour positionner les cases et la balle

        // Ajouter toutes les cases
        for (Case carreau : echiquier.getCarreaux()) {
            CaseView carreauView = new CaseView();
            carreauView.setCarreau(carreau);
            Node carreauNode = carreauView.drawCase();
            carreauNode.setLayoutX(carreau.getX());
            carreauNode.setLayoutY(carreau.getY());
            boardPane.getChildren().add(carreauNode);
        }

        // Ajouter la balle
        Balle b = new Balle(400, 240.0, 20.0, 0.5, 0.5, 0.0);
        BalleView bv = new BalleView(b);
        AnimationBalle animationBalle =  new AnimationBalle(bv);
        animationBalle.startTimer();
        bv.drawBalle();
        bv.getNode().setLayoutX(b.getPosX());
        bv.getNode().setLayoutY(b.getPosY());
        boardPane.getChildren().add(bv.getNode());

        // Ajouter le pane à ce StackPane
        this.getChildren().add(boardPane);
    }
}
