package projetEchecPong.models.joueur;

import java.util.ArrayList;
import java.util.List;

import projetEchecPong.models.jeu.Case;
import projetEchecPong.models.jeu.Raquette;
import projetEchecPong.models.piece.Piece;

public class Joueur {
    
    private String nom;
    private List<Piece>pieces = new ArrayList<Piece>();
    private List<Case> zones = new ArrayList<Case>();
    private Raquette raquette;
    public Raquette getRaquette() {
        return raquette;
    }
    public void setRaquette(Raquette raquette) {
        this.raquette = raquette;
    }
    public List<Case> getZones() {
        return zones;
    }
    public void setZones(List<Case> zones) {
        this.zones = zones;
    }
    String couleur;
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
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

    public Joueur(String nom, List<Piece> pieces,String couleur) {
        this.nom = nom;
        if(pieces != null)
        this.pieces = pieces;
        this.couleur = couleur;
    }
    public Joueur() {
    }
    public void addPiece(Piece p){
        this.pieces.add(p);
    }
}
