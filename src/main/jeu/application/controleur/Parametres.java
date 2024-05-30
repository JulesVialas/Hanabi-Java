/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jeu.application.Hanabi; 

/**
 * Joue le rôle de contrôleur pour la vue Paramètres de
 * l'application Hanabi.
 * Fait le lien entre la vue {@link jeu.application.vue#Parametres.fxml}
 * et le FIXME je doute que ça fasse lien avec modele tbh
 * modele présent dans le package {@link jeu.modele}.
 * @author Corentin Solignac
 */
public class Parametres {

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
        Hanabi.activerPrincipale();
    }
}
