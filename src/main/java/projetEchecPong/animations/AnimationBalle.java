package projetEchecPong.animations;

import javafx.animation.AnimationTimer;
import projetEchecPong.models.Balle;
import projetEchecPong.views.BalleView;


public class AnimationBalle extends AnimationTimer {
    BalleView bv;
    public AnimationBalle(BalleView bv) {
        this.bv = bv;
    }

    public void handle(long now){
        if(bv != null){
            bv.getBalle().deplacer();
            bv.getNode().setLayoutX(bv.getBalle().getPosX());
            bv.getNode().setLayoutY(bv.getBalle().getPosY());
        }
    }
    public void startTimer(){
        this.start();
    }
    public void stopTimer(){
        this.stop();
    }
}
