package projetEchecPong.views;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import projetEchecPong.animations.AnimationBalle;
import projetEchecPong.controllers.BalleController;
import projetEchecPong.models.jeu.Balle;
import projetEchecPong.models.jeu.Case;
import projetEchecPong.models.jeu.Echiquier;
import projetEchecPong.models.jeu.Jeu;
import projetEchecPong.models.joueur.Joueur;
import projetEchecPong.models.piece.Piece;

public class EchiquierView extends StackPane {
    private Echiquier echiquier;
    private List<Joueur> joueurs;

    public EchiquierView(Echiquier echiquier) throws Exception {
        this.echiquier = echiquier;

        Pane boardPane = new Pane(); // pour positionner les cases et la balle

        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur("beloha", null, "noir"));
        joueurs.add(new Joueur("bemoko", null, "blanc"));
        // Ajouter toutes les cases

        Point2D centreGravite = this.echiquier.getCentreGravite();
        Jeu j = new Jeu(joueurs, this.echiquier.getColonne(), this.echiquier, null);
        j.configurerZoneJoueurs();
        j.configurerPieceJoueurs();
        boolean occupe = false;
        for(int i = 0; i< this.echiquier.getCases().size();i++){
            occupe = false;
            for (Joueur joueur : joueurs) {
                for (Piece p : joueur.getPieces()) {
                    if(p.getNumero() == i){
                        Case carreau =  this.echiquier.getCases().get(i);
                        // CASE
                        CaseView caseView = new CaseView(carreau);
                        boardPane.getChildren().add(caseView.getNode());
        
                        // PIECE
                        ImageView pieceView = new ImageView(p.getImage());
                        pieceView.setFitWidth(carreau.getWidth() * 0.8);
                        pieceView.setFitHeight(carreau.getHeight() * 0.8);
                        pieceView.setPreserveRatio(true);
        
                        pieceView.setLayoutX(
                                carreau.getX() + (carreau.getWidth() - pieceView.getFitWidth()) / 2);
                        pieceView.setLayoutY(
                                carreau.getY() + (carreau.getHeight() - pieceView.getFitHeight()) / 2);
        
                        boardPane.getChildren().add(pieceView);
                        occupe = true;
                    }

                }
                if(!occupe){
                    CaseView caseView = new CaseView(this.echiquier.getCases().get(i));
            boardPane.getChildren().add(caseView.getNode());
                }
            }
        }
        

        // Ajouter la balle
        Balle b = new Balle(centreGravite.getX(), centreGravite.getY(), 20.0, 0.5, 0.5, 0.0);
        j.setBalle(b);
        BalleView bv = new BalleView(b);
        AnimationBalle animationBalle = new AnimationBalle(bv, this.echiquier);

        // Créer le controller
        BalleController controller = new BalleController(animationBalle, boardPane);

        boardPane.getChildren().add(bv.getNode());
        // Ajouter le pane à ce StackPane
        this.getChildren().add(boardPane);
    }
}
