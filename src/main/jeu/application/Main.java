/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene; 

/**
 * Point d'entrée de l'application Hanabi.
 * @author Corentin Solignac
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        /* Chargement de la vue de l'application */
        FXMLLoader chargeurFXML = new FXMLLoader();
        chargeurFXML.setLocation(getClass().getResource("MenuPrincipal.fxml"));
        Parent racine;
        try {
            racine = chargeurFXML.load();
            Scene sceneMenuPrincipal = new Scene(racine);
            sceneMenuPrincipal.getRoot().requestFocus();
            
            /* Caractéristiques de la fenêtre de l'application */
            primaryStage.setTitle("Hanabi - Menu Principal");
            primaryStage.setHeight(600);
            primaryStage.setWidth(800);
            primaryStage.setScene(sceneMenuPrincipal);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
