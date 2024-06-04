/*
 * ChangerTheme.java                                            31 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import jeu.application.Hanabi;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class ChangerTheme {

    @FXML
    private void changerTheme1(ActionEvent evenement) {
        Scene scene = Hanabi.fenetrePrincipale.getScene();
        scene.getStylesheets()
                .remove(getClass()
                        .getResource("/jeu/application/vue/css/menus.css")
                        .toExternalForm());
        scene.getStylesheets()
                .add(getClass()
                        .getResource("/jeu/application/vue/css/menus2.css")
                        .toExternalForm());
    }

    @FXML
    private void changerTheme2(ActionEvent evenement) {
        Scene scene = Hanabi.fenetrePrincipale.getScene();
        scene.getStylesheets()
                .remove(getClass()
                        .getResource("/jeu/application/vue/css/menus2.css")
                        .toExternalForm());
        scene.getStylesheets()
                .add(getClass()
                        .getResource("/jeu/application/vue/css/menus.css")
                        .toExternalForm());
    }

    @FXML
    private void retourMenu(ActionEvent event) {
        Hanabi.activerParametres();
    }
}
