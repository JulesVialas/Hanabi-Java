/*
 * PartieFinie.java                                            3 juin 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.application.Hanabi;
import jeu.modele.Partie;

/**
 * Contrôleur pour la scène de fin de partie. Cette classe est
 * responsable de l'affichage du score de la partie terminée et de
 * fournir un moyen de retourner au menu principal.
 */
public class PartieFinie {

    @FXML
    private Label textePartieFinie;

    @FXML
    private Label score;

    /**
     * Retourne au menu principal.
     */
    @FXML
    private void retourMenu() {
        Hanabi.activerPrincipale();
    }

    /**
     * Affiche le score de la partie terminée.
     *
     * @param partieFinie la partie terminée
     */
    public void afficherScore(Partie partieFinie) {
        score.setText(Integer.toString(partieFinie.calculerScore()));

        int scoreValeur = partieFinie.calculerScore();
        String message;
        switch (scoreValeur) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            message = "Horrible, huées de la foule...";
            break;
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
            message = "Médiocre, à peine quelques applaudissements.";
            break;
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
            message = "Honorable, mais ne restera pas dans les mémoires...";
            break;
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
            message = "Excellente, ravit la foule.";
            break;
        case 21:
        case 22:
        case 23:
        case 24:
            message = "Extraordinaire, restera gravée dans les mémoires !";
            break;
        case 25:
            message = "Légendaire, petits et grands sans voix, des étoiles dans les yeux.";
            break;
        default:
            message = "Score invalide.";
            break;
        }
        textePartieFinie.setText(message);
    }
}
