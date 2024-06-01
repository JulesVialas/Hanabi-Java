/*
 * Sauvegarde.java                                            1 juin 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.fxml.FXML;
import jeu.application.Hanabi;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class Sauvegarde {

    @FXML
    private void retourJeu() {
        Hanabi.activerTableCinqJoueurs(ChoixJoueurs.partieCinqJoueurs);  
    }
    
    @FXML
    private void confirmationSauvegarde() {
        Hanabi.activerConfirmationSauvegarde();
    }
}
