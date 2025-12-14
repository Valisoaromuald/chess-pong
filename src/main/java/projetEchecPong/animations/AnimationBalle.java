package projetEchecPong.animations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import projetEchecPong.models.jeu.Echiquier;
import projetEchecPong.models.jeu.Raquette;
import projetEchecPong.views.BalleView;

public class AnimationBalle {

    private final Timeline timeline;
    private Echiquier echiquier;
    private Raquette raquette;
    public Raquette getRaquette() {
        return raquette;
    }


    public void setRaquette(Raquette raquette) {
        this.raquette = raquette;
    }


    public Echiquier getEchiquier() {
        return echiquier;
    }


    public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    private final BalleView bv;
    public Timeline getTimeline() {
        return timeline;
    }


    public BalleView getBv() {
        return bv;
    }

    public AnimationBalle(BalleView bv,Echiquier ech) {
        this.bv = bv;
        this.echiquier = ech;
        this.timeline = new Timeline(
            new KeyFrame(Duration.millis(16), e -> {
                bv.getBalle().deplacer(this.echiquier);
                bv.update();
            })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}
