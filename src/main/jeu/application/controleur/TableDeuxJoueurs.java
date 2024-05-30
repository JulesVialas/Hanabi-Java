package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jeu.modele.Couleur;
import jeu.modele.Partie;

public class TableDeuxJoueurs {

	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

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
	private Button joueur1Carte5;

	@FXML
	private Button joueur2Carte1;

	@FXML
	private Button joueur2Carte2;

	@FXML
	private Button joueur2Carte3;

	@FXML
	private Button joueur2Carte4;

	@FXML
	private Button joueur2Carte5;

	public void setPartie(Partie partie) {
		if (partie != null) {
			joueur1Label.setText(partie.getJoueur1().getPseudo());
			joueur2Label.setText(partie.getJoueur2().getPseudo());

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
			joueur2Carte5.setStyle("-fx-background-color: #"
					+ convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(4).getCouleur()) + ";");

			joueur2Carte1.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
			joueur2Carte2.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
			joueur2Carte3.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
			joueur2Carte4.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));
			joueur2Carte5.setText(
					Integer.toString(partie.getJoueur2().getCartesEnMains().get(4).getValeur().getValeurNumerique()));
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

	@FXML
	public void initialize() {
		// Ne pas accéder aux données ici, elles seront définies via setPartie()
	}
}
