package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.modele.Joueur;

/**
 * Joue le rôle de contrôleur pour la vue TableDeuxJoueurs de
 * l'application Hanabi.
 * Fait le lien entre la vue {@link jeu.application.vue#TableDeuxJoueurs.fxml}
 * et le modele présent dans le package {@link jeu.modele}.
 * @author Corentin Solignac
 */
public class TableDeuxJoueurs {

	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

	//TODO Centrer la table :)
}
