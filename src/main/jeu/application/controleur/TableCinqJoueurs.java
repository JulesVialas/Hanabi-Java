package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jeu.application.Hanabi;
import jeu.modele.Couleur;
import jeu.modele.Partie;

/**
 * Controleur de la table de jeux à cinq joueurs
 */
public class TableCinqJoueurs {

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
	private Label nbJetonsRouge;

	@FXML
	private Label nbJetonsBleu;

	@FXML
	private Label nbCartesDefausse;

	@FXML
	private Label nbCartesPioche;

	@FXML
	private Button joueur1Carte1;

	@FXML
	private Button joueur1Carte2;

	@FXML
	private Button joueur1Carte3;

	@FXML
	private Button joueur1Carte4;

	@FXML
	private Button joueur2Carte1;

	@FXML
	private Button joueur2Carte2;

	@FXML
	private Button joueur2Carte3;

	@FXML
	private Button joueur2Carte4;

	@FXML
	private Button joueur3Carte1;

	@FXML
	private Button joueur3Carte2;

	@FXML
	private Button joueur3Carte3;

	@FXML
	private Button joueur3Carte4;

	@FXML
	private Button joueur4Carte1;

	@FXML
	private Button joueur4Carte2;

	@FXML
	private Button joueur4Carte3;

	@FXML
	private Button joueur4Carte4;

	@FXML
	private Button joueur5Carte1;

	@FXML
	private Button joueur5Carte2;

	@FXML
	private Button joueur5Carte3;

	@FXML
	private Button joueur5Carte4;
	
	@FXML
	private HBox overlayActions;
	
	@FXML
	private HBox overlayJoueurCourant;
	
	@FXML
	private Button menuPause;

	/**
	 * @param partie la partie à jouer
	 */
	public void setPartie(Partie partie) {
		if (partie != null) {
			joueur1Label.setText(partie.getJoueur1().getPseudo());
			joueur2Label.setText(partie.getJoueur2().getPseudo());
			joueur3Label.setText(partie.getJoueur3().getPseudo());
			joueur4Label.setText(partie.getJoueur4().getPseudo());
			joueur5Label.setText(partie.getJoueur5().getPseudo());

			nbJetonsRouge.setText(Integer.toString(partie.getJetons().getRouges()));
			nbJetonsBleu.setText(Integer.toString(partie.getJetons().getBleus()));

			nbCartesPioche.setText(Integer.toString(partie.getPioche().size()));
			nbCartesDefausse.setText(Integer.toString(partie.getDefausse().size()));

			joueur2Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(0).getCouleur()) + ";");
			joueur2Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(1).getCouleur()) + ";");
			joueur2Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(2).getCouleur()) + ";");
			joueur2Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(3).getCouleur()) + ";");

			joueur2Carte1.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueur2Carte2.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueur2Carte3.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueur2Carte4.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueur3Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(0).getCouleur()) + ";");
			joueur3Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(1).getCouleur()) + ";");
			joueur3Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(2).getCouleur()) + ";");
			joueur3Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur3().getCartesEnMains().get(3).getCouleur()) + ";");

			joueur3Carte1.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueur3Carte2.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueur3Carte3.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueur3Carte4.setText(
					Integer.toString(partie.getJoueur3().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueur4Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(0).getCouleur()) + ";");
			joueur4Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(1).getCouleur()) + ";");
			joueur4Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(2).getCouleur()) + ";");
			joueur4Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur4().getCartesEnMains().get(3).getCouleur()) + ";");

			joueur4Carte1.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueur4Carte2.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueur4Carte3.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueur4Carte4.setText(
					Integer.toString(partie.getJoueur4().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

			joueur5Carte1.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(0).getCouleur()) + ";");
			joueur5Carte2.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(1).getCouleur()) + ";");
			joueur5Carte3.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(2).getCouleur()) + ";");
			joueur5Carte4.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur5().getCartesEnMains().get(3).getCouleur()) + ";");

			joueur5Carte1.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueur5Carte2.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueur5Carte3.setText(
					Integer.toString(partie.getJoueur5().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueur5Carte4.setText(
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
	private void Carte1Joueur1(ActionEvent event) {
	    System.out.println(joueur1Carte1.getLayoutX());
	    System.out.println(joueur1Carte1.getLayoutY());
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
	private void gererClicParametres() {
	    Parametres.partieActive = true;
	    Hanabi.activerParametres();
	}
}
