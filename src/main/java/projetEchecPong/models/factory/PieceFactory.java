package projetEchecPong.models.factory;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import projetEchecPong.models.piece.*;

public class PieceFactory {

    /* ==============================
       PIECES BLANCHES
       ============================== */
    public static List<Piece> creerPiecesBlanches() {
        List<Piece> pieces = new ArrayList<>();

        Image roi = load("/images/roi_blanc.png");
        Image reine = load("/images/reine_blanc.png");
        Image fou = load("/images/fou_blanc.png");
        Image cavalier = load("/images/cavalier_blanc.png");
        Image tour = load("/images/tour_blanc.png");
        Image pion = load("/images/pion_blanc.png");

        ajouterPieces(pieces, new Roi(1, 0, 1, roi));
        ajouterPieces(pieces, new Reine(1, 0, 1, reine));
        ajouterPieces(pieces, new Fou(1, 0, 2, fou));
        ajouterPieces(pieces, new Cavalier(0, 0, 2, cavalier));
        ajouterPieces(pieces, new Tour(1, 0, 2, tour));
        ajouterPieces(pieces, new Pion(1, 0, 8, pion));

        return pieces;
    }

    /* ==============================
       PIECES NOIRES
       ============================== */
    public static List<Piece> creerPiecesNoires() {
        List<Piece> pieces = new ArrayList<>();

        Image roi = load("/images/roi_noir.png");
        Image reine = load("/images/reine_noir.png");
        Image fou = load("/images/fou_noir.png");
        Image cavalier = load("/images/cavalier_noir.png");
        Image tour = load("/images/tour_noir.png");
        Image pion = load("/images/pion_noir.png");

        ajouterPieces(pieces, new Roi(1, 0, 1, roi));
        ajouterPieces(pieces, new Reine(1, 0, 1, reine));
        ajouterPieces(pieces, new Fou(1, 0, 2, fou));
        ajouterPieces(pieces, new Cavalier(1, 0, 2, cavalier));
        ajouterPieces(pieces, new Tour(1, 0, 2, tour));
        ajouterPieces(pieces, new Pion(1, 0, 8, pion));

        return pieces;
    }

    /* ==============================
       METHODES UTILITAIRES
       ============================== */

    private static void ajouterPieces(List<Piece> list, Piece modele) {
        for (int i = 0; i < modele.getNombre(); i++) {
            list.add(cloner(modele));
        }
    }

    private static Piece cloner(Piece p) {
        if (p instanceof Roi) {
            return new Roi(p.getPointVie(), p.getNumero(), 1, p.getImage());
        } else if (p instanceof Reine) {
            return new Reine(p.getPointVie(), p.getNumero(), 1, p.getImage());
        } else if (p instanceof Fou) {
            return new Fou(p.getPointVie(), p.getNumero(), 1, p.getImage());
        } else if (p instanceof Cavalier) {
            return new Cavalier(p.getPointVie(), p.getNumero(), 1, p.getImage());
        } else if (p instanceof Tour) {
            return new Tour(p.getPointVie(), p.getNumero(), 1, p.getImage());
        } else if (p instanceof Pion) {
            return new Pion(p.getPointVie(), p.getNumero(), 1, p.getImage());
        }
        throw new IllegalArgumentException("Type de pièce inconnu");
    }

    private static Image load(String path) {
        return new Image(PieceFactory.class.getResourceAsStream(path));
    }
}
