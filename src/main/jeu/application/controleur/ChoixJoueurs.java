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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jeu.modele.Joueur;

import java.io.IOException;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class ChoixJoueurs {

	@FXML
	private Button lancerPartieButton;

	@FXML
	private Button retourMenuPrincipal;

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

	private int nbJoueurs;

	Joueur joueur1;
	Joueur joueur2;
	Joueur joueur3;
	Joueur joueur4;
	Joueur joueur5;

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
		try {
			Stage stage = (Stage) lancerPartieButton.getScene().getWindow();
			Parent root;
			switch (nbJoueurs) {
			case 2:
				root = FXMLLoader.load(getClass().getResource("/jeu/application/vue/TableDeuxJoueurs.fxml"));
				joueur1 = new Joueur(joueur1TextField.getText());
				joueur2 = new Joueur(joueur2TextField.getText());
				break;
			case 3:
				root = FXMLLoader.load(getClass().getResource("/jeu/application/vue/TableTroisJoueurs.fxml"));
				joueur1 = new Joueur(joueur1TextField.getText());
				joueur2 = new Joueur(joueur2TextField.getText());
				joueur3 = new Joueur(joueur3TextField.getText());
				break;
			case 4:
				root = FXMLLoader.load(getClass().getResource("/jeu/application/vue/TableQuatreJoueurs.fxml"));
				joueur1 = new Joueur(joueur1TextField.getText());
				joueur2 = new Joueur(joueur2TextField.getText());
				joueur3 = new Joueur(joueur3TextField.getText());
				joueur4 = new Joueur(joueur4TextField.getText());
				break;
			case 5:
				root = FXMLLoader.load(getClass().getResource("/jeu/application/vue/TableCinqJoueurs.fxml"));
				joueur1 = new Joueur(joueur1TextField.getText());
				joueur2 = new Joueur(joueur2TextField.getText());
				joueur3 = new Joueur(joueur3TextField.getText());
				joueur4 = new Joueur(joueur4TextField.getText());
				joueur5 = new Joueur(joueur5TextField.getText());
				break;
			default:
				return;
			}
			Scene scene = new Scene(root, 600, 400);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
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
	}

	/**
	 * Méthode appelée lorsqu'on clique sur le bouton "Retour au Menu Principal".
	 *
	 * @param event L'événement de clic sur le bouton
	 */
	@FXML
	private void retourMenu(ActionEvent event) {
		try {
			Stage stage = (Stage) retourMenuPrincipal.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/jeu/application/vue/MenuPrincipal.fxml"));
			Parent root = loader.load();
			Scene sceneMenuPrincipal = new Scene(root, 600, 400);
			stage.setScene(sceneMenuPrincipal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}