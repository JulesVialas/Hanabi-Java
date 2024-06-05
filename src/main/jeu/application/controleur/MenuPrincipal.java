/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
/*
 * Classe principale de l'application permettant d'afficher des fenêtres au contenu
 * différent : ChoixJoueurs, Parametres ... (ce sont les vues qui changent)
 */
package jeu.application.controleur;

import javafx.fxml.FXML;
import jeu.application.Hanabi;

/**
 * Gère le menu principal
 */
public class MenuPrincipal {
    @FXML
    private void gererClicNouvellePartie() {
        Hanabi.activerChoixJoueurs();
    }

    @FXML
    private void gererClicChargerPartie() {
        // TODO chargement de la partie
    }

    @FXML
    private void gererClicParametres() {
        Hanabi.activerParametres();
    }

    @FXML
    private void regles() {
        Hanabi.activerRegles();
    }
}
