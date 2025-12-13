package projetEchecPong.views;

import java.util.List;

import javafx.geometry.Point2D;
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
        for (Case carreau : echiquier.getCases()) {
            CaseView carreauView = new CaseView();
            carreauView.setCarreau(carreau);
            Node carreauNode = carreauView.drawCase();
            carreauNode.setLayoutX(carreau.getX());
            carreauNode.setLayoutY(carreau.getY());
            boardPane.getChildren().add(carreauNode);
        }
        Point2D centreGravite = this.echiquier.getCentreGravite();
        System.out.println("centre de gravite: "+centreGravite);
        // Ajouter la balle
        Balle b = new Balle(centreGravite.getX(), centreGravite.getY(), 20.0, 0.5, 0.5, 0.0);
        BalleView bv = new BalleView(b);
        AnimationBalle animationBalle = new AnimationBalle(bv);
        // animationBalle.start();
        bv.getNode().setLayoutX(b.getCenterX());
        bv.getNode().setLayoutY(b.getCenterY());
        boardPane.getChildren().add(bv.getNode());

        // Ajouter le pane à ce StackPane
        this.getChildren().add(boardPane);
    }
}
