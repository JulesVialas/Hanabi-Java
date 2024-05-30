package jeu.application.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.modele.Partie;

public class TableDeuxJoueurs {

	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

	public void setPartie(Partie partie) {
		if (partie != null) {
			joueur1Label.setText(partie.getJoueur1().getPseudo());
			joueur2Label.setText(partie.getJoueur2().getPseudo());
		}
	}

	@FXML
	public void initialize() {
		// Ne pas accéder aux données ici, elles seront définies via setPartie()
	}
}
