package projetEchecPong.views;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import projetEchecPong.models.Cavalier;
import projetEchecPong.models.Echiquier;
import projetEchecPong.models.Fou;
import projetEchecPong.models.Piece;
import projetEchecPong.models.Pion;
import projetEchecPong.models.Reine;
import projetEchecPong.models.Roi;
import projetEchecPong.models.Tour;

public class FormulaireConfigurationVie extends VBox{
    int nombrePiece;
    List<TextField> listeTextField=new ArrayList<TextField>();
    public FormulaireConfigurationVie(double spacing,int nombrePiece) throws Exception{
        super(spacing);
        this.nombrePiece = nombrePiece;
        this.buildFormulaire(spacing);
        Button btn = new Button("Jouer");
        Text text = new Text();
        text.setFill(Color.RED);
        btn.setOnMouseClicked(
            event->{
                Scene sc = this.getScene();
                try {
                    boolean allFiled = tousLesChampsRemplis(listeTextField);
                    if(sc != null){
                        if(allFiled){
                            
                            Echiquier ech = new Echiquier(120.0, 120.0, 8, nombrePiece, 640.0, 640.0);
                            System.out.println("eto indray hoe: "+ech.getCentreGravite());
                            sc.setRoot(new EchiquierView(ech));
                        }
                        else{ 
                            text.setText("fenoy daholo ny point de vie");
                            return;
                        }
                    }
                } catch (Exception e) {
                    text.setText(e.getMessage());
                }
            }
        );
        this.getChildren().addAll(btn,text);
    }
    public void buildFormulaire(double spacing){
        
        List<Piece> pieces = new ArrayList<Piece>();
        pieces.add(new Roi(0,1,false));
        pieces.add(new Reine(0,2,false));
        pieces.add(new Fou(0,3,true));
        pieces.add(new Cavalier(0,4,true));
        pieces.add(new Tour(0,5,true));
        pieces.add(new Pion(0,6,true));
        if(nombrePiece >=2){
            int lastIndex = pieces.size() -1 ;
            int vraiNombre = modifNombrePiece(nombrePiece);
            for(int i = 0; i <=vraiNombre;i++){
                HBox hb = new HBox(spacing);
                TextField tf1 = new TextField(pieces.get(i).toString());
                tf1.setEditable(false);
                TextField tf2 = new TextField("8");
                
                hb.getChildren().addAll(tf1,tf2);
                this.listeTextField.add(tf2);
                this.getChildren().add(hb);
            }            
            HBox hb = new HBox(spacing);
            TextField tf1 = new TextField(pieces.get(lastIndex).toString());
            tf1.setEditable(false);
            TextField tf2 = new TextField("1");
            this.listeTextField.add(tf2);
            hb.getChildren().addAll(tf1,tf2);
            this.getChildren().add(hb);
        }
    }
    public int modifNombrePiece(int nombrePiece){
        int result = nombrePiece;
        switch (nombrePiece) {
            case 2:
                result = 1;
                break;
            case 4:
                result = 2;
                break;
            case 6:
                result = 3;
                break;
            default:
                result = 4;
                break;
        }
        return result;
    }
    public boolean tousLesChampsRemplis(List<TextField> listeTextField) {
    if (listeTextField == null || listeTextField.isEmpty()) {
        return false;
    }

    for (TextField tf : listeTextField) {
        if (tf == null || tf.getText().trim().isEmpty()) {
            return false;
        }
    }
    return true;
    }

}
