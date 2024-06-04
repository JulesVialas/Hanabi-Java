/*
 * ChoixSauvegardePartie.java                                      31 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package jeu.application.controleur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import jeu.application.Hanabi;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
public class ChoixSauvegardePartie {

    @FXML
    private void choisirEmplacementDefaut(ActionEvent event) {
        DirectoryChooser selecteurDossier = new DirectoryChooser();
        File dossierSelectionne = selecteurDossier.showDialog(new Stage());
        if (dossierSelectionne != null) {
            sauvegarderEmplacementParDefaut(dossierSelectionne);
        }
    }

    private void sauvegarderEmplacementParDefaut(File dossier) {
        try (FileWriter writer = new FileWriter("emplacement_defaut.txt")) {
            writer.write(dossier.getAbsolutePath());
            System.out.println("Emplacement de sauvegarde par défaut : "
                    + dossier.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void retourMenu(ActionEvent event) {
        Hanabi.activerParametres();
    }
}
