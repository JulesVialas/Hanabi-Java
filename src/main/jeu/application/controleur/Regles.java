package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi;

public class Regles {
	@FXML
	private void retourMenu(ActionEvent event) {
		Hanabi.activerParametres();
	}
}
