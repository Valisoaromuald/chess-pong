package projetEchecPong.models.jeu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import projetEchecPong.models.factory.PieceFactory;
import projetEchecPong.models.joueur.Joueur;
import projetEchecPong.models.piece.Cavalier;
import projetEchecPong.models.piece.Fou;
import projetEchecPong.models.piece.Piece;
import projetEchecPong.models.piece.Pion;
import projetEchecPong.models.piece.Reine;
import projetEchecPong.models.piece.Roi;
import projetEchecPong.models.piece.Tour;

public class Jeu {

    public Jeu() {
    }

    private List<Joueur> joueurs;
    private int nbPiece;
    private Echiquier echiquier;
    private Balle balle;

    public Jeu(List<Joueur> joueurs, int nbPiece, Echiquier echiquier, Balle balle) {
        this.joueurs = joueurs;
        this.nbPiece = nbPiece;
        this.echiquier = echiquier;
        this.balle = balle;
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }

    public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public Balle getBalle() {
        return balle;
    }

    public void setBalle(Balle balle) {
        this.balle = balle;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNbPiece() {
        return nbPiece;
    }

    public void setNbPiece(int nbPiece) {
        this.nbPiece = nbPiece;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void configurerPieceJoueurs() {
        List<Piece> piecesBlanches = PieceFactory.creerPiecesBlanches();
        List<Piece> piecesNoires = PieceFactory.creerPiecesNoires();
        for (Joueur j : joueurs) {
            if (j.getCouleur().equals("noir")) {
                j.setPieces(piecesNoires);
            } else {
                j.setPieces(piecesBlanches);
            }
            changerNumeroPiece(j);
            j.setPieces(limiterNombrePiece(j));
        }
    }

    public List<Piece> limiterNombrePiece(Joueur j) {
        List<Piece> pieces = new ArrayList<>();
        int reste = 8 - nbPiece;
        for (int i = 0; i < nbPiece; i++) {
            pieces.add(j.getPieces().get(i));
        }
        for (int i = 8; i < j.getPieces().size() - reste; i++) {
            pieces.add(j.getPieces().get(i));
        }
        return pieces;
    }

    private List<Class<? extends Piece>> ordrePiecesMajeures(int nbPiece) {

        return switch (nbPiece) {
            case 2 -> List.of(Reine.class, Roi.class);
            case 4 -> List.of(Fou.class, Reine.class, Roi.class, Fou.class);
            case 6 -> List.of(
                    Cavalier.class, Fou.class, Reine.class,
                    Roi.class,
                    Fou.class, Cavalier.class);
            case 8 -> List.of(
                    Tour.class, Cavalier.class, Fou.class,
                    Reine.class, Roi.class,
                    Fou.class, Cavalier.class, Tour.class);
            default -> throw new IllegalArgumentException("nbPiece invalide");
        };
    }

    public void changerNumeroPiece(Joueur joueur) {

        List<Piece> pieces = joueur.getPieces();
        boolean noir = joueur.getCouleur().equals("noir");

        int nbLignes = echiquier.getLigne();

        /*
         * =============================
         * 1. PIECES MAJEURES
         * =============================
         */
        int ligneMajeures = noir ? 0 : nbLignes - 1;
        int index = ligneMajeures * nbPiece;

        for (Class<? extends Piece> type : ordrePiecesMajeures(nbPiece)) {
            for (Piece p : pieces) {
                if (type.isInstance(p) && p.getNumero() == 0 && !(p instanceof Pion)) {
                    p.setNumero(index++);
                    break;
                }
            }
        }
        /*
         * =============================
         * 2. PIONS
         * =============================
         */
        int lignePions = noir ? 1 : nbLignes - 2;
        index = lignePions * nbPiece;

        for (Piece p : joueur.getPieces()) {
            if (p instanceof Pion) {
                p.setNumero(index);
                index++;
            }
        }

    }

    public void configurerZoneJoueurs() {
        List<Case> zonesBlanches = new ArrayList<Case>();
        List<Case> zonesNoires = new ArrayList<Case>();
        for (int j = 0; j < 2 * nbPiece; j++) {
            zonesNoires.add(echiquier.getCases().get(j));
        }

        for (int i = (nbPiece * 6); i < nbPiece * 8; i++) {
            zonesBlanches.add(echiquier.getCases().get(i));
        }
        for (Joueur j : joueurs) {
            if (j.getCouleur().equals("noir")) {
                j.setZones(zonesNoires);
            } else {

                j.setZones(zonesBlanches);
            }
        }
    }

    public Case determinerCasePourPiece(Joueur joueur, Piece p) {

        if (!joueur.getPieces().contains(p)) {
            throw new IllegalArgumentException("La pièce n'appartient pas à ce joueur");
        }

        List<Case> zones = joueur.getZones();
        int numero = p.getNumero();

        // Cas joueur NOIR
        if (joueur.getCouleur().equals("noir")) {

            int index = 0;

            while (index < zones.size()) {
                if (index == numero) {
                    return zones.get(index);
                }
                index++;
            }

        }
        // Cas joueur BLANC
        else {

            int indicePremier = zones.size() + 4 * nbPiece;
            int copie = indicePremier;
            int limite = indicePremier + zones.size();
            // int numero = p.getNumero()+index;
            while (copie < limite) {
                if (copie == numero) {
                    return zones.get(copie - indicePremier);
                }
                copie++;
            }
        }

        throw new IllegalStateException(
                "Impossible de déterminer la case pour la pièce : " + p);
    }

    public static List<Case> filtrerCasesLibres(List<Case> cases, List<Joueur> joueurs) {
        List<Case> casesLibres = new ArrayList<>();
        int i = 0;
        for (Case c : cases) {
            
            boolean occupee = false;

            for (Joueur j : joueurs) {
                for (Piece p : j.getPieces()) {
                    if (p.getNumero() == i) { // on compare le numéro de la pièce avec l'indice de la case
                        occupee = true;
                        break;
                    }
                }
                if (occupee)
                    break;
            }

            if (!occupee) {
                casesLibres.add(c);
            }
            i++;
        }

        return casesLibres;
    }
    public void attribuerRaquette(Joueur j){
        if(j.getCouleur().equals("noir")){
            
        }
    }
}
