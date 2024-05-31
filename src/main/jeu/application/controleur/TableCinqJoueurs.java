package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jeu.modele.Couleur;
import jeu.modele.Partie;

/**
 * Controleur de la table de jeux à cinq joueurs
 */
public class TableCinqJoueurs {

	@FXML
	private Label joueurBasLabel;

	@FXML
	private Label joueurGauche1Label;

	@FXML
	private Label joueurGauche2Label;

	@FXML
	private Label joueurDroite1Label;

	@FXML
	private Label joueurDroite2Label;

	@FXML
	private Label nbJetonsRouge;

	@FXML
	private Label nbJetonsBleu;

	@FXML
	private Label nbCartesDefausse;

	@FXML
	private Label nbCartesPioche;

	@FXML
	private Button joueurBasCarte1;

	@FXML
	private Button joueurBasCarte2;

	@FXML
	private Button joueurBasCarte3;

	@FXML
	private Button joueurBasCarte4;

	@FXML
	private Button joueurGauche1Carte1;

	@FXML
	private Button joueurGauche1Carte2;

	@FXML
	private Button joueurGauche1Carte3;

	@FXML
	private Button joueurGauche1Carte4;

	@FXML
	private Button joueurGauche2Carte1;

	@FXML
	private Button joueurGauche2Carte2;

	@FXML
	private Button joueurGauche2Carte3;

	@FXML
	private Button joueurGauche2Carte4;

	@FXML
	private Button joueurDroite1Carte1;

	@FXML
	private Button joueurDroite1Carte2;

	@FXML
	private Button joueurDroite1Carte3;

	@FXML
	private Button joueurDroite1Carte4;

	@FXML
	private Button joueurDroite2Carte1;

	@FXML
	private Button joueurDroite2Carte2;

	@FXML
	private Button joueurDroite2Carte3;

	@FXML
	private Button joueurDroite2Carte4;
	
	@FXML
	private HBox overlayActions;
	
	@FXML
	private HBox overlayJoueurCourant;

	/**
	 * @param partie la partie à jouer
	 */
	public void setPartie(Partie partie) {
		if (partie != null) {
			joueurBasLabel.setText(partie.getJoueur1().getPseudo());
			joueurGauche1Label.setText(partie.getJoueur2().getPseudo());
			joueurGauche2Label.setText(partie.getJoueur3().getPseudo());
			joueurDroite1Label.setText(partie.getJoueur4().getPseudo());
			joueurDroite2Label.setText(partie.getJoueur5().getPseudo());

			nbJetonsRouge.setText(Integer.toString(partie.getJetons().getRouges()));
			nbJetonsBleu.setText(Integer.toString(partie.getJetons().getBleus()));

			nbCartesPioche.setText(Integer.toString(partie.getPioche().size()));
			nbCartesDefausse.setText(Integer.toString(partie.getDefausse().size()));

			joueurGauche1Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(0).getCouleur()) + ";");
			joueurGauche1Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(1).getCouleur()) + ";");
			joueurGauche1Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(2).getCouleur()) + ";");
			joueurGauche1Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(3).getCouleur()) + ";");

			joueurGauche1Carte1.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueurGauche1Carte2.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueurGauche1Carte3.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueurGauche1Carte4.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueurGauche2Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(0).getCouleur()) + ";");
			joueurGauche2Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(1).getCouleur()) + ";");
			joueurGauche2Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(2).getCouleur()) + ";");
			joueurGauche2Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(3).getCouleur()) + ";");

			joueurGauche2Carte1.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueurGauche2Carte2.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueurGauche2Carte3.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueurGauche2Carte4.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueurDroite1Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(0).getCouleur()) + ";");
			joueurDroite1Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(1).getCouleur()) + ";");
			joueurDroite1Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(2).getCouleur()) + ";");
			joueurDroite1Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(3).getCouleur()) + ";");

			joueurDroite1Carte1.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueurDroite1Carte2.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueurDroite1Carte3.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueurDroite1Carte4.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueurDroite2Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(0).getCouleur()) + ";");
			joueurDroite2Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(1).getCouleur()) + ";");
			joueurDroite2Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(2).getCouleur()) + ";");
			joueurDroite2Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(3).getCouleur()) + ";");

			joueurDroite2Carte1.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueurDroite2Carte2.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueurDroite2Carte3.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueurDroite2Carte4.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(3).getValeur().getValeurNumerique()));
		}
	}

	private String convertirCouleurEnHex(Couleur couleur) {
		switch (couleur) {
		case ROUGE:
			return "FF0000";
		case VERT:
			return "008000";
		case BLEU:
			return "0000FF";
		case JAUNE:
			return "FFFF00";
		case BLANC:
			return "FFFFFF";
		default:
			return "000000";
		}
	}

	/**
	 * initialisation de la scène
	 */
	@FXML
	public void initialize() {
		overlayActions.setVisible(false);
		overlayJoueurCourant.setVisible(false);
	}
	
	/**
	 * Carte 1 du joueur 1 cliquée
	 */
	@FXML
	private void Carte1joueurBas(ActionEvent event) {
	    System.out.println(joueurBasCarte1.getLayoutX());
	    System.out.println(joueurBasCarte1.getLayoutY());
	}
	
	@FXML
	private void gererClicActions() {
		overlayActions.setVisible(true);
		overlayJoueurCourant.setVisible(false);
	}

	@FXML
	private void FermerOverlay() {
		overlayActions.setVisible(false);
		overlayJoueurCourant.setVisible(false);
	}
	
	@FXML
	private void gererClicJoueurCourant() {
		overlayJoueurCourant.setVisible(true);
		overlayActions.setVisible(false);
	}
	
	@FXML
	private void gererClicCouleur() {
		//Tour.donnerIndice(TODO trouver la carte selectionnée, 'c');
	}
	
	@FXML
	private void gererClicValeur() {
		//Tour.donnerIndice(TODO trouver la carte selectionnée, 'v');
	}
	
	@FXML
	private void gererClicPoser() {
		//Tour.poser(TODO Trouver la carte selectionnée);
	}
}
