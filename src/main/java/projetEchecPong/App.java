package projetEchecPong;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import projetEchecPong.models.forme_geometrique.Cercle;
import projetEchecPong.models.forme_geometrique.Segment;
import projetEchecPong.models.jeu.Balle;
import projetEchecPong.models.jeu.Case;
import projetEchecPong.models.jeu.Echiquier;
import projetEchecPong.models.jeu.Jeu;
import projetEchecPong.models.jeu.Raquette;
import projetEchecPong.models.joueur.Joueur;
import projetEchecPong.models.piece.Piece;
import projetEchecPong.views.EchiquierView;
import projetEchecPong.views.FormulaireConfigurationPiece;

/**
 * Hello world!
 *
 */
public class App extends Application
{  
    private final String WINDOW_TITLE = "Chess Pong";
    private final double WINDOW_WIDTH = 800;
    private final double WINDOW_HEIGHT = 800;
    @Override
    public void start(Stage ps) throws Exception{
        // FormulaireConfigurationPiece fcp = new FormulaireConfigurationPiece(16);
        // fcp.setStyle("-fx-background-color: green;");
        Echiquier ech = new Echiquier(160.0, 30.0, 8, 4, 640.0, 640.0);
        EchiquierView echiquierView  = new EchiquierView(ech);
        echiquierView.setStyle("-fx-background-color: gray;");
        Scene sc  = new Scene(echiquierView);
        ps.setScene(sc);
        ps.setTitle(WINDOW_TITLE);
        ps.setWidth(WINDOW_WIDTH);
        ps.setHeight(WINDOW_HEIGHT);
        ps.show();
    }
        public static void main( String[] args ) throws Exception
    {
         launch(args);
        //  try {
            // int nbPiece = 6;
            // Echiquier ech  = new Echiquier(160.0, 30.0, 8, nbPiece, 640.0, 640.0);
            // List<Joueur> joueurs = new ArrayList<>();
            // joueurs.add(new Joueur("beloha", null,"noir"));
            // joueurs.add(new Joueur("bemoko", null,"blanc"));
            // Jeu j = new Jeu(joueurs, nbPiece, ech, null);
            // j.configurerZoneJoueurs();
            // j.configurerPieceJoueurs();
            // for(Piece c: joueurs.get(0).getPieces()){
            //     System.out.println(c+";"+j.determinerCasePourPiece(joueurs.get(0),c));
            //     // System.out.println(c);
            // }
        //     Balle  b1 = new Balle(650,650, 20, 15, 15, 0);
        //     Balle  b2 = new Balle(650,800, 20, 15, 15, 0);
        //     Echiquier ech = new Echiquier(120.0, 120.0, 8, 4, 640.0, 640.0);
        //     Segment s1 = new Segment(new Point2D(650, 650),new Point2D(650, 800));
        //     Segment s2 = new Segment(new Point2D(120.0, 760),new Point2D(760, 760));
        //      Point2D solut = s1.findPointIntersection(s2);
        //     System.out.println(solut);
        //     System.out.println("am S1: "+s1.estInclus(solut));
        //     System.out.println("am S2: "+s2.estInclus(solut));
        //     //  Raquette raq = new Raquette(280,280 , 50, 10, 0, 0);
        //     Point2D point = b1.findPointCollision(b2, ech);
        //     System.out.println("valiny: "+point);
        //     // List<Segment> segments = ech.getAllSegments();
        //     // for(Segment s: segments){
        //     //     System.out.println("point1 :"+s.getPoint1()+"; point2:"+s.getPoint2());
        //     // }

        //  } catch (Exception e) {
        //      System.out.println(e.getMessage());
        //  }
    
    }
}
