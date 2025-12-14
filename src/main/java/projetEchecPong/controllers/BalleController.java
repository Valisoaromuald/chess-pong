package projetEchecPong.controllers;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import projetEchecPong.animations.AnimationBalle;
import projetEchecPong.models.jeu.Balle;
import projetEchecPong.views.BalleView;
import java.util.ArrayList;
import java.util.List;

public class BalleController {

    private Balle balle;
    private BalleView balleView;

    private AnimationBalle animationBalle;
    private Pane pane; // Pane contenant la balle
    private List<Line> trajectoireLines = new ArrayList<>();

    public BalleController(AnimationBalle animationBalle, Pane pane) {
        this.animationBalle = animationBalle;
        this.balleView = animationBalle.getBv();
        this.balle = this.balleView.getBalle();
        this.pane = pane;
        setupMouseEvents();
    }

    private void setupMouseEvents() {
        pane.setOnMouseClicked(this::handleMouseClick);
    }

    private void handleMouseClick(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        if (event.getButton() == MouseButton.SECONDARY) {
            // Clic droit : afficher la trajectoire initiale
            afficherTrajectoire(mouseX, mouseY);
        } else if (event.getButton() == MouseButton.PRIMARY) {
            // Clic gauche : lancer la balle vers le point choisi
            lancerBalle(mouseX, mouseY);
        }
    }

    private void afficherTrajectoire(double x, double y) {
        clearTrajectoire();
        
        Line line = new Line(balle.getCenterX(), balle.getCenterY(), x, y);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        trajectoireLines.add(line);
        pane.getChildren().add(line);
    }

    private void clearTrajectoire() {
        for (Line l : trajectoireLines) {
            pane.getChildren().remove(l);
        }
        trajectoireLines.clear();
    }

    private void lancerBalle(double targetX, double targetY) {


        double dx = targetX - balle.getCenterX();
        double dy = targetY - balle.getCenterY();

        double norm = Math.sqrt(dx * dx + dy * dy);
        if (norm < 1e-6) {
            return;
        }

        double vitesse = 0.5;

        balle.setVelocityX(vitesse * dx / norm);
        balle.setVelocityY(vitesse * dy / norm);

        animationBalle.start();
        clearTrajectoire();
    }

}
