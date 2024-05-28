/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */

package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import jeu.modele.Partie; 

/**
 * Joue le rôle de controlleur pour l'application Hanabi.
 * Fait le lien entre la vue présente dans le package
 * {@link jeu.application.vue} et le modele présent dans le package
 * {@link jeu.modele}.
 * @author Corentin Solignac
 */
public class ControleurHanabi {
    
    /** Modèle géré par le contrôleur */
    private Partie partieEnCours;
    
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
    
    /**
     * Créé et lance une nouvelle partie de Hanabi.
     */
    @FXML
    void lancerNouvellePartie(ActionEvent event) {
        //TODO lancerNouvellePartie
    }
    
    /**
     * Charge et lance une partie de Hanabi sauvegardée
     */
    @FXML 
    void chargerPartie(ActionEvent event) {
        //TODO chargerPartie
    }
    
    /**
     * Ouvre la page de paramètres
     */
    @FXML 
    void ouvrirParametres(ActionEvent event) {
        //TODO ouvrirParametres
    }
}
