/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import jeu.modele.Partie; 

/**
 * Joue le rôle de contrôleur pour la vue Paramètres de
 * l'application Hanabi.
 * Fait le lien entre la vue {@link jeu.application.vue#Parametres.fxml}
 * et le FIXME je doute que ça fasse lien avec modele tbh
 * modele présent dans le package {@link jeu.modele}.
 * @author Corentin Solignac
 */
public class Parametres {

    //TODO ajouter tous les @FXML des éléments dynamiques :D
	
	@FXML
	private Button retourMenuPrincipal;
    
    /**
     * Prépare le modèle et la vue.
     */
    @FXML 
    private void initialize() {
        /* Préparation des éléments FXML */
        //TODO ajouter les @FXML des éléments 
        
    }
    
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
