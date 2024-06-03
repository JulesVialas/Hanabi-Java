package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.application.Hanabi;
import jeu.modele.Partie;

public class PartiePerdue {

    @FXML
    private static Label score;

    @FXML
    private void retourMenuPrincipal() {
        Hanabi.activerPrincipale();
    }

    public static void afficherScore(Partie partieFinie) {
        score.setText(Integer.toString(partieFinie.calculerScore()));
    }
}
