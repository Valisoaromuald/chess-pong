package projetEchecPong.animations;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import projetEchecPong.views.BalleView;

public class AnimationBalle {

    private final Timeline timeline;
    private final BalleView bv;

    public AnimationBalle(BalleView bv) {
        this.bv = bv;

        this.timeline = new Timeline(
            new KeyFrame(Duration.millis(16), e -> {
                bv.getBalle().deplacer();
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
