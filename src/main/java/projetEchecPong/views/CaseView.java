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
    public Rectangle  drawCase() throws Exception{
        Rectangle carreau = null;
        if(this.carreau != null){
            carreau = new Rectangle(this.carreau.getXCoord(), this.carreau.getYCoord(), this.carreau.getWidth(), this.carreau.getHeight());
            carreau.setLayoutX(this.carreau.getX());
            carreau.setLayoutY(this.carreau.getY());
            carreau.setWidth(this.carreau.getWidth());
            carreau.setHeight(this.carreau.getHeight());
            carreau.setFill(this.carreau.getColor());
        } 
        return carreau;
    }   
}
