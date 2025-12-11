package projetEchecPong.models.Joueurs;

import java.util.List;

import projetEchecPong.models.Piece;

public class Joueur {
    
    private String nom;
    private List<Piece>pieces;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Joueur(String nom, List<Piece> pieces) {
        this.nom = nom;
        this.pieces = pieces;
    }
    public Joueur() {
    }
}
