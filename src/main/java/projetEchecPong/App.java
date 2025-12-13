package projetEchecPong;
import javafx.geometry.Point2D;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projetEchecPong.models.Balle;
import projetEchecPong.models.Echiquier;
import projetEchecPong.models.Raquette;
import projetEchecPong.models.forme_geometrique.Cercle;
import projetEchecPong.models.forme_geometrique.Segment;
import projetEchecPong.views.FormulaireConfigurationPiece;

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
        ps.setTitle(WINDOW_TITLE);
        ps.setWidth(WINDOW_WIDTH);
        ps.setHeight(WINDOW_HEIGHT);
        ps.setResizable(false);
        ps.show();
    }
        public static void main( String[] args ) throws Exception
    {
         launch(args);
        //  try {
            
        //      Balle  b1 = new Balle(230,230, 20, 15, 15, 0);
        //      Balle  b2 = new Balle(320,320, 20, 15, 15, 0);
        //      Echiquier ech = new Echiquier(80, 80, 8, 8, 560, 560);
        //      Raquette raq = new Raquette(280,280 , 50, 10, 0, 0);
        //      Point2D point = b1.findPointCollision(b2, ech);
        //       System.out.println(ech.getCentreGravite());
        //  } catch (Exception e) {
        //      System.out.println(e.getMessage());
        //  }
    
    }
}
