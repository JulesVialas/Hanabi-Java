/*
 * PartieGagnee.java                                            3 juin 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.application.Hanabi;
import jeu.modele.Partie;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class PartieGagnee {
   
    @FXML
    static Label score;
    
    @FXML
    private void retourMenuPrincipal() {
        Hanabi.activerPrincipale();
    }
    
    public static void afficherScore(Partie partieFinie) {
        score.setText(Integer.toString(partieFinie.calculerScore()));
    }
}
