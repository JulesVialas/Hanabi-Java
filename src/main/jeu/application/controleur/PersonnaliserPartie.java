/*
 * PersonnaliserPartie.java                                          31 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi;

/**
 * Gere la page de configuration des éléments de la partie
 */
public class PersonnaliserPartie {

    @FXML
    private void retourMenu(ActionEvent event) {
        Hanabi.activerParametres();
    }
}
