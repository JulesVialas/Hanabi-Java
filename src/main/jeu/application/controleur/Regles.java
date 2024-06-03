package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi;

public class Regles {
    public static boolean partieActive = false;
    
    @FXML
    private void retourMenu(ActionEvent event) {
        if(partieActive) {
            Hanabi.activerTableCinqJoueurs(ChoixJoueurs.partieCinqJoueurs);
        } else {
            Hanabi.activerPrincipale();
        }
    }
}
