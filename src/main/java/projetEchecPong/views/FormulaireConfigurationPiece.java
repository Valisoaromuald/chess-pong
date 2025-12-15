package projetEchecPong.views;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FormulaireConfigurationPiece extends VBox {

    public FormulaireConfigurationPiece(double spacing) {
        super(spacing);

        HBox hb1 = new HBox(spacing);
        HBox hb2 = new HBox(spacing);
        
        Label label = new Label("Entrer le nombre de piece");
        TextField textField = new TextField("2");

        hb1.getChildren().addAll(label, textField);

        Button btn = new Button("Valider");
        Text text = new Text();
        text.setFill(Color.RED);

        btn.setOnAction(e -> {
            Scene scene = this.getScene();
            String textValue = textField.getText();
            if (textValue.trim().isEmpty()) {
                text.setText("Vous avez oublié de mettre le nombre de pièces");
                return;
            }
            try {
                int valeur = Integer.parseInt(textValue.trim());
                if (scene != null) {
                    scene.setRoot(new FormulaireConfigurationVie(16, valeur));
                }
            } catch (Exception ex) {
                if(ex instanceof NumberFormatException)
                {
                    text.setText("Veuillez entrer un nombre valide");
                }   
                else{
                    text.setText(ex.getMessage());
                }
            }
        });

        hb2.getChildren().add(btn);
        this.getChildren().addAll(hb1, hb2, text);
    }
}
