package projetEchecPong.views;

import javafx.scene.Node;

public class ViewWithNode {
    public ViewWithNode(Node node) {
        this.node = node;
    }

    public ViewWithNode() {
    }

    Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

}
