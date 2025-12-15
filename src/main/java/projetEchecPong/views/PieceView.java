package projetEchecPong.views;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.jeu.Case;
import projetEchecPong.models.piece.Piece;

public class PieceView extends ViewWithNode {
    private Piece piece;

    public Piece getPiece() {
        return piece;
    }
    public PieceView (Piece piece){
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public StackPane drawPiece(Case carreau) {
        Rectangle caseEchiquier = new Rectangle(64, 64);
        caseEchiquier.setFill(Color.BEIGE);
        ImageView piece = new ImageView(this.piece.getImage());
        piece.setFitWidth(carreau.getWidth());
        piece.setFitHeight(carreau.getHeight());
        StackPane cell = new StackPane();
        cell.getChildren().addAll(caseEchiquier, piece);
        return cell;
    }

}
