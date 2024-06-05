/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi;

/**
 * Joue le rôle de contrôleur pour la vue Paramètres de l'application
 * Hanabi.
 * {@link jeu.modele}.
 *
 * @author Corentin Solignac
 */
public class Parametres {

    /**
     * Indique si la partie est active ou non pour gerer le retour de la
     * page paramètre à la page menu ou à la page de la partie
     */
    public static boolean partieActive = false;

    /**
     * Prépare le modèle et la vue.
     */
    @FXML
    private void initialize() {
        /* Préparation des éléments FXML */
        // TODO 
    }

    @FXML
    private void changerLeTheme() {
        Hanabi.activerChangerTheme();
    }

    @FXML
    private void personnaliserLaPartie() {
        Hanabi.activerPersonnaliserPartie();
    }

    @FXML
    private void choixSauvegardePartie() {
        Hanabi.activerChoixSauvegardePartie();
    }

    @FXML
    private void retourMenu(ActionEvent event) {
        if (partieActive) {
            Hanabi.activerTableCinqJoueurs(ChoixJoueurs.partieCinqJoueurs);
        } else {
            Hanabi.activerPrincipale();
        }
    }
}
