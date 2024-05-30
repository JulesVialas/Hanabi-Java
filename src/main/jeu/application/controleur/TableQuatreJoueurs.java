package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.modele.Partie;

public class TableQuatreJoueurs {

	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

	@FXML
	private Label joueur3Label;

	@FXML
	private Label joueur4Label;

	@FXML
	private void initialize() {
	}

	public void setPartie(Partie partie) {
		if (partie != null) {
			joueur1Label.setText(partie.getJoueur1().getPseudo());
			joueur2Label.setText(partie.getJoueur2().getPseudo());
			joueur3Label.setText(partie.getJoueur3().getPseudo());
			joueur4Label.setText(partie.getJoueur4().getPseudo());
		}
	}
}
