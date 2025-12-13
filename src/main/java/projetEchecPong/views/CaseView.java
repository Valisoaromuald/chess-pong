package projetEchecPong.views;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import projetEchecPong.models.Case;

public class CaseView {
    public CaseView() {
    }
    public CaseView(Case carreau) {
        this.carreau = carreau;
    }
    private Case carreau;
    
    public Case getCarreau() {
        return carreau;
    }
    public void setCarreau(Case carreau) {
        this.carreau = carreau;
    }
    public Rectangle drawCase() {
    Rectangle r = new Rectangle(
        carreau.getWidth(),
        carreau.getHeight()
    );  
    r.setFill(carreau.getColor());
    r.setLayoutX(carreau.getX());
    r.setLayoutY(carreau.getY());
    return r;
}
  
}
