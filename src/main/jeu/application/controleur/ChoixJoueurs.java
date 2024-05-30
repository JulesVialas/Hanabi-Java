/**
 * Contrôleur pour la sélection du nombre de joueurs et de leurs noms avant de lancer une partie.
 * Permet de définir le nombre de joueurs et leurs noms, puis de naviguer vers les interfaces
 * correspondantes en fonction du nombre de joueurs choisi.
 * <p>
 * Cette classe gère également le retour au menu principal.
 * </p>
 *
 * @author JulesVialas
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jeu.application.Hanabi;
import jeu.modele.Partie;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class ChoixJoueurs {
	@FXML
	private TextField joueur1TextField;

	@FXML
	private TextField joueur2TextField;

	@FXML
	private TextField joueur3TextField;

	@FXML
	private TextField joueur4TextField;

	@FXML
	private TextField joueur5TextField;

	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

	@FXML
	private Label joueur3Label;

	@FXML
	private Label joueur4Label;

	@FXML
	private Label joueur5Label;

	@FXML
	private Button bouton2J;

	@FXML
	private Button bouton3J;

	@FXML
	private Button bouton4J;

	@FXML
	private Button bouton5J;

	private int nbJoueurs;

	static Partie partieDeuxJoueurs;

	Partie partieTroisJoueurs;

	Partie partieQuatreJoueurs;

	Partie partieCinqJoueurs;

	/**
	 * Méthode d'initialisation appelée après que tous les éléments FXML ont été injectés.
	 */
	@FXML
	private void initialize() {
		// Initialiser le contrôleur
	}

	/**
	 * Méthode appelée lorsqu'on clique sur le bouton "Lancer Partie".
	 *
	 * @param event L'événement de clic sur le bouton
	 */
	@FXML
	private void lancerPartie(ActionEvent event) {
		switch (nbJoueurs) {
		case 2:
			partieDeuxJoueurs = new Partie(joueur1TextField.getText(), joueur2TextField.getText());
			Hanabi.activerTableDeuxJoueurs(partieDeuxJoueurs);
			break;
		case 3:
			partieTroisJoueurs = new Partie(joueur1TextField.getText(), joueur2TextField.getText(), joueur3TextField.getText());
			Hanabi.activerTableTroisJoueurs(partieTroisJoueurs);
			break;
		case 4:
			partieQuatreJoueurs = new Partie(joueur1TextField.getText(), joueur2TextField.getText(), joueur3TextField.getText(), joueur4TextField.getText());
			Hanabi.activerTableQuatreJoueurs(partieQuatreJoueurs);
			break;
		case 5:
			partieCinqJoueurs = new Partie(joueur1TextField.getText(), joueur2TextField.getText(), joueur3TextField.getText(), joueur4TextField.getText(), joueur5TextField.getText());
			Hanabi.activerTableCinqJoueurs(partieCinqJoueurs);
			break;
		default:
			return;
		}
	}

	/**
	 * Méthode appelée lorsqu'on sélectionne l'option "2 Joueurs".
	 *
	 * @param event L'événement de sélection de l'option
	 */
	@FXML
	private void select2Joueurs(ActionEvent event) {
		nbJoueurs = 2;
		joueur3Label.setVisible(false);
		joueur3TextField.setVisible(false);
		joueur4Label.setVisible(false);
		joueur4TextField.setVisible(false);
		joueur5Label.setVisible(false);
		joueur5TextField.setVisible(false);
	}

	/**
	 * Méthode appelée lorsqu'on sélectionne l'option "3 Joueurs".
	 *
	 * @param event L'événement de sélection de l'option
	 */
	@FXML
	private void select3Joueurs(ActionEvent event) {
		nbJoueurs = 3;
		joueur3Label.setVisible(true);
		joueur3TextField.setVisible(true);
		joueur4Label.setVisible(false);
		joueur4TextField.setVisible(false);
		joueur5Label.setVisible(false);
		joueur5TextField.setVisible(false);
	}

	/**
	 * Méthode appelée lorsqu'on sélectionne l'option "4 Joueurs".
	 *
	 * @param event L'événement de sélection de l'option
	 */
	@FXML
	private void select4Joueurs(ActionEvent event) {
		nbJoueurs = 4;
		joueur3Label.setVisible(true);
		joueur3TextField.setVisible(true);
		joueur4Label.setVisible(true);
		joueur4TextField.setVisible(true);
		joueur5Label.setVisible(false);
		joueur5TextField.setVisible(false);
		bouton4J.setStyle("-fx-background-color: Black");
	}

	/**
	 * Méthode appelée lorsqu'on sélectionne l'option "5 Joueurs".
	 *
	 * @param event L'événement de sélection de l'option
	 */
	@FXML
	private void select5Joueurs(ActionEvent event) {
		nbJoueurs = 5;
		joueur3Label.setVisible(true);
		joueur3TextField.setVisible(true);
		joueur4Label.setVisible(true);
		joueur4TextField.setVisible(true);
		joueur5Label.setVisible(true);
		joueur5TextField.setVisible(true);
		bouton5J.setStyle("-fx-background-color: Black");
	}

	/**
	 * Méthode appelée lorsqu'on clique sur le bouton "Retour au Menu Principal".
	 *
	 * @param event L'événement de clic sur le bouton
	 */
	@FXML
	private void retourMenu(ActionEvent event) {
		Hanabi.activerPrincipale();
	}
}