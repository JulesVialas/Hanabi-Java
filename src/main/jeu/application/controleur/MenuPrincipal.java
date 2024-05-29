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
 * Joue le rôle de controlleur pour l'application Hanabi.
 * Fait le lien entre la vue présente dans le package
 * {@link jeu.application.vue#MenuPrincipal.fxml} et le modele
 * présent dans le package {@link jeu.modele}.
 * FIXME idk si lien avec modele tbh
 * @author Corentin Solignac
 */
public class MenuPrincipal {
    
    //TODO ajouter tous les @FXML des éléments dynamiques :D
    
    /**
     * Prépare le modèle et la vue.
     */
    @FXML 
    private void initialize() {
        /* Préparation des éléments FXML */
        //TODO ajouter les @FXML des éléments du menu (ptet tous ? idk)
        
        //FIXME je suppose qu'on ne créé pas de partie yet ?
    }
    
    @FXML
    private Button nouvellePartieButton;
    
    @FXML
    private Button parametresButton;

    @FXML
    private Button chargerPartieButton;
    
    /**
     * Créé et lance une nouvelle partie de Hanabi.
     */
    @FXML
    public void basculerVersChoixJoueurs(ActionEvent event) {
        try {
            Stage stage = (Stage) nouvellePartieButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jeu/application/vue/ChoixJoueurs.fxml"));
            Parent root = loader.load();
            Scene sceneChoixJoueurs = new Scene(root, 600, 400);
            stage.setScene(sceneChoixJoueurs);
        } catch (Exception e) {
            e.printStackTrace(); //TODO 
        }
    }
    
    /**
     * Charge et lance une partie de Hanabi sauvegardée
     */    
    @FXML 
    void chargerPartie(ActionEvent event) {
    	//TODO
    }
    
    /**
     * Ouvre la page de paramètres
     */    
    @FXML 
    void ouvrirParametres(ActionEvent event) {
    	try {
            Stage stage = (Stage) parametresButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jeu/application/vue/Parametres.fxml"));
            Parent root = loader.load();
            Scene sceneChoixJoueurs = new Scene(root, 600, 400);
            stage.setScene(sceneChoixJoueurs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
