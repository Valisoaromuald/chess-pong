package projetEchecPong.animations;
import javafx.animation.AnimationTimer;
import projetEchecPong.models.jeu.Raquette;
public class AnimationRaquette extends AnimationTimer {
    Raquette raquette;
    public Raquette getRaquette() {
        return raquette;
    }
    public void setRaquette(Raquette raquette) {
        this.raquette = raquette;
    }
    @Override
    public void handle(long now){
        // raquette.deplacer();
    }
    public void start(){
        this.start();
    }
    public void stop(){
        this.stop();
    }
}
