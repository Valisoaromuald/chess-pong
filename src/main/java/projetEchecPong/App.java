package projetEchecPong;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projetEchecPong.models.Echiquier;
import projetEchecPong.views.EchiquierView;
import projetEchecPong.views.FormulaireConfigurationPiece;
import projetEchecPong.views.FormulaireConfigurationVie;
import projetEchecPong.views.HBoxExampleView;
import projetEchecPong.views.MainView;
/**
 * Hello world!
 *
 */
public class App extends Application
{  
    private final String WINDOW_TITLE = "Chess Pong";
    private final double WINDOW_WIDTH = 1000;
    private final double WINDOW_HEIGHT = 1000;
    @Override
    public void start(Stage ps) throws Exception{
        FormulaireConfigurationPiece fcp = new FormulaireConfigurationPiece(16);
        Scene sc  = new Scene(fcp);
        ps.setScene(sc);
        ps.setWidth(WINDOW_WIDTH);
        ps.setHeight(WINDOW_HEIGHT);
        ps.setResizable(false);
        ps.show();
    }
        public static void main( String[] args )
    {
        launch(args);
    }
}
