package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import jeu.application.Hanabi;
import jeu.modele.Carte;
import jeu.modele.Couleur;
import jeu.modele.Joueur;
import jeu.modele.Partie;

/**
 * Contrôleur de la table de jeux à cinq joueurs
 */
public class TableCinqJoueurs {

    /** La partie à contrôler */
    private Partie partieEnCours;

    /** La carte sélectionnée */
    private Carte carteSelectionnee;

    /* Joueurs correspondant aux positions*/
    private Joueur joueurBas;

    private Joueur joueurGauche1;

    private Joueur joueurGauche2;

    private Joueur joueurDroite1;

    private Joueur joueurDroite2;

    @FXML
    private Label joueurBasLabel;

    @FXML
    private Label joueurGauche1Label;

    @FXML
    private Label joueurGauche2Label;

    @FXML
    private Label joueurDroite1Label;

    @FXML
    private Label joueurDroite2Label;

    @FXML
    private Label nbJetonsRouge;

    @FXML
    private Label nbJetonsBleu;

    @FXML
    private Label nbCartesDefausse;

    @FXML
    private Label nbCartesPioche;

    @FXML
    private Button joueurBasCarte1;

    @FXML
    private Button joueurBasCarte2;

    @FXML
    private Button joueurBasCarte3;

    @FXML
    private Button joueurBasCarte4;

    @FXML
    private Button joueurGauche1Carte1;

    @FXML
    private Button joueurGauche1Carte2;

    @FXML
    private Button joueurGauche1Carte3;

    @FXML
    private Button joueurGauche1Carte4;

    @FXML
    private Button joueurGauche2Carte1;

    @FXML
    private Button joueurGauche2Carte2;

    @FXML
    private Button joueurGauche2Carte3;

    @FXML
    private Button joueurGauche2Carte4;

    @FXML
    private Button joueurDroite1Carte1;

    @FXML
    private Button joueurDroite1Carte2;

    @FXML
    private Button joueurDroite1Carte3;

    @FXML
    private Button joueurDroite1Carte4;

    @FXML
    private Button joueurDroite2Carte1;

    @FXML
    private Button joueurDroite2Carte2;

    @FXML
    private Button joueurDroite2Carte3;

    @FXML
    private Button joueurDroite2Carte4;

    @FXML
    private Button btnIndiceCouleur;
    
    @FXML
    private VBox overlayActions;

    @FXML
    private VBox overlayJoueurCourant;

    @FXML
    private Button menuPause;

    /**
     * @param aAffecter la partie à jouer
     */
    public void setPartie(Partie aAffecter) {
        this.partieEnCours = aAffecter;
        System.out.println(partieEnCours);
        updatePositionJoueurs();
        if (aAffecter != null) {
            joueurBasLabel.setText(aAffecter.getJoueur1().getPseudo());
            joueurGauche1Label.setText(aAffecter.getJoueur2().getPseudo());
            joueurGauche2Label.setText(aAffecter.getJoueur3().getPseudo());
            joueurDroite1Label.setText(aAffecter.getJoueur4().getPseudo());
            joueurDroite2Label.setText(aAffecter.getJoueur5().getPseudo());

            nbJetonsRouge.setText(Integer.toString(aAffecter.getJetons().getRouges()));
            nbJetonsBleu.setText(Integer.toString(aAffecter.getJetons().getBleus()));

            nbCartesPioche.setText(Integer.toString(aAffecter.getPioche().size()));
            nbCartesDefausse.setText(Integer.toString(aAffecter.getDefausse().size()));

            joueurGauche1Carte1.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur2().getCartesEnMains().get(0).getCouleur()) + ";");
            joueurGauche1Carte2.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur2().getCartesEnMains().get(1).getCouleur()) + ";");
            joueurGauche1Carte3.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur2().getCartesEnMains().get(2).getCouleur()) + ";");
            joueurGauche1Carte4.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur2().getCartesEnMains().get(3).getCouleur()) + ";");

            joueurGauche1Carte1.setText(
                    Integer.toString(aAffecter.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
            joueurGauche1Carte2.setText(
                    Integer.toString(aAffecter.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
            joueurGauche1Carte3.setText(
                    Integer.toString(aAffecter.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
            joueurGauche1Carte4.setText(
                    Integer.toString(aAffecter.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

            joueurGauche2Carte1.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur3().getCartesEnMains().get(0).getCouleur()) + ";");
            joueurGauche2Carte2.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur3().getCartesEnMains().get(1).getCouleur()) + ";");
            joueurGauche2Carte3.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur3().getCartesEnMains().get(2).getCouleur()) + ";");
            joueurGauche2Carte4.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur3().getCartesEnMains().get(3).getCouleur()) + ";");

            joueurGauche2Carte1.setText(
                    Integer.toString(aAffecter.getJoueur3().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
            joueurGauche2Carte2.setText(
                    Integer.toString(aAffecter.getJoueur3().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
            joueurGauche2Carte3.setText(
                    Integer.toString(aAffecter.getJoueur3().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
            joueurGauche2Carte4.setText(
                    Integer.toString(aAffecter.getJoueur3().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

            joueurDroite1Carte1.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur4().getCartesEnMains().get(0).getCouleur()) + ";");
            joueurDroite1Carte2.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur4().getCartesEnMains().get(1).getCouleur()) + ";");
            joueurDroite1Carte3.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur4().getCartesEnMains().get(2).getCouleur()) + ";");
            joueurDroite1Carte4.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur4().getCartesEnMains().get(3).getCouleur()) + ";");

            joueurDroite1Carte1.setText(
                    Integer.toString(aAffecter.getJoueur4().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
            joueurDroite1Carte2.setText(
                    Integer.toString(aAffecter.getJoueur4().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
            joueurDroite1Carte3.setText(
                    Integer.toString(aAffecter.getJoueur4().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
            joueurDroite1Carte4.setText(
                    Integer.toString(aAffecter.getJoueur4().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

            joueurDroite2Carte1.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur5().getCartesEnMains().get(0).getCouleur()) + ";");
            joueurDroite2Carte2.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur5().getCartesEnMains().get(1).getCouleur()) + ";");
            joueurDroite2Carte3.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur5().getCartesEnMains().get(2).getCouleur()) + ";");
            joueurDroite2Carte4.setStyle("-fx-background-color: #"
                    + convertirCouleurEnHex(aAffecter.getJoueur5().getCartesEnMains().get(3).getCouleur()) + ";");

            joueurDroite2Carte1.setText(
                    Integer.toString(aAffecter.getJoueur5().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
            joueurDroite2Carte2.setText(
                    Integer.toString(aAffecter.getJoueur5().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
            joueurDroite2Carte3.setText(
                    Integer.toString(aAffecter.getJoueur5().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
            joueurDroite2Carte4.setText(
                    Integer.toString(aAffecter.getJoueur5().getCartesEnMains().get(3).getValeur().getValeurNumerique()));
        }
    }

    private String convertirCouleurEnHex(Couleur couleur) {
        switch (couleur) {
        case ROUGE:
            return "FF0000";
        case VERT:
            return "008000";
        case BLEU:
            return "0000FF";
        case JAUNE:
            return "FFFF00";
        case BLANC:
            return "FFFFFF";
        default:
            return "000000";
        }
    }

    @FXML
    private void gererClicCarteEquipier(ActionEvent event) {
        String identifiant = recupererIdentifiantBoutonCarte(event);
        setCarteSelectionnee(identifiant);
        overlayActions.setVisible(true);
        overlayJoueurCourant.setVisible(false);
    }

    @FXML
    private void gererClicCarteJoueurCourant(ActionEvent event) {
        String identifiant = recupererIdentifiantBoutonCarte(event);
        setCarteSelectionnee(identifiant);
        overlayJoueurCourant.setVisible(true);
        overlayActions.setVisible(false);
    }

    /**
     * @param event l'évenement de clic sur la carte
     * @return l'identifiant du bouton représentant la carte cliquée
     */
    private String recupererIdentifiantBoutonCarte(ActionEvent event) {
        Button buttonClicked = (Button) event.getSource();
        return buttonClicked.getId();
    }

    /**
     * initialisation de la scène
     */
    @FXML
    public void initialize() {

        overlayActions.setVisible(false);
        overlayJoueurCourant.setVisible(false);
    }

    @FXML
    private void FermerOverlay() {
        overlayActions.setVisible(false);
        overlayJoueurCourant.setVisible(false);
    }


    @FXML
    private void gererClicParametres() {
        Parametres.partieActive = true;
        Hanabi.activerParametres();
    }

    private void gererClicCouleur() {
        //Tour.donnerIndice(TODO trouver la carte selectionnée, 'c');
    } 	

    @FXML
    private void gererClicValeur() {
        //Tour.donnerIndice(TODO trouver la carte selectionnée, 'v');
    }

    @FXML
    private void gererClicPoser() {
        //Tour.poser(TODO Trouver la carte selectionnée);
    }

    @FXML
    private void donnerIndiceCouleur(ActionEvent event) {
        System.out.println("Avant indice = " + carteSelectionnee);
        partieEnCours.getTourCourant()
            .donnerIndice(carteSelectionnee, 'c');
        System.out.println(((Control)event.getSource()).getId());
        System.out.println("Après indice = " + carteSelectionnee);
    }

    /**
     * Met à jour la position des joueurs en fonction du 
     * numéro de tour
     */
    private void updatePositionJoueurs() {
        switch(partieEnCours.getTourCourant().getNumero() % 5) {
        case 0:
            joueurBas = partieEnCours.getJoueur5();
            joueurGauche1 = partieEnCours.getJoueur1();
            joueurGauche2 = partieEnCours.getJoueur2();
            joueurDroite1 = partieEnCours.getJoueur3();
            joueurDroite2 = partieEnCours.getJoueur4();
            break;
        case 1:
            joueurBas = partieEnCours.getJoueur1();
            joueurGauche1 = partieEnCours.getJoueur2();
            joueurGauche2 = partieEnCours.getJoueur3();
            joueurDroite1 = partieEnCours.getJoueur4();
            joueurDroite2 = partieEnCours.getJoueur5();
            break;
        case 2:
            joueurBas = partieEnCours.getJoueur2();
            joueurGauche1 = partieEnCours.getJoueur3();
            joueurGauche2 = partieEnCours.getJoueur4();
            joueurDroite1 = partieEnCours.getJoueur5();
            joueurDroite2 = partieEnCours.getJoueur1();
            break;
        case 3:
            joueurBas = partieEnCours.getJoueur3();
            joueurGauche1 = partieEnCours.getJoueur4();
            joueurGauche2 = partieEnCours.getJoueur5();
            joueurDroite1 = partieEnCours.getJoueur1();
            joueurDroite2 = partieEnCours.getJoueur2();
            break;
        case 4:
            joueurBas = partieEnCours.getJoueur4();
            joueurGauche1 = partieEnCours.getJoueur5();
            joueurGauche2 = partieEnCours.getJoueur1();
            joueurDroite1 = partieEnCours.getJoueur2();
            joueurDroite2 = partieEnCours.getJoueur3();
            break;
        default:
            break;
        }
    }

    /** 
     * Définie la carte liée au bouton cliqué comme étant la
     * carte sélectionnée.
     * 
     * @param idBouton l'identifiant du bouton cliqué
     */
    private void setCarteSelectionnee(String idBouton) {
        System.out.println(idBouton);
        switch(idBouton) {

        /* Joueur bas */
        case "joueurBasCarte1":
            carteSelectionnee = joueurBas.getCartesEnMains().get(0);
            break;
        case "joueurBasCarte2":
            carteSelectionnee = joueurBas.getCartesEnMains().get(1);
            break;
        case "joueurBasCarte3":
            carteSelectionnee = joueurBas.getCartesEnMains().get(2);
            break;
        case "joueurBasCarte4":
            carteSelectionnee = joueurBas.getCartesEnMains().get(3);
            break;

            /* Joueur gauche 1 */    
        case "joueurGauche1Carte1":
            carteSelectionnee = joueurGauche1.getCartesEnMains().get(0);
            break;
        case "joueurGauche1Carte2":
            carteSelectionnee = joueurGauche1.getCartesEnMains().get(1);
            break;
        case "joueurGauche1Carte3":
            carteSelectionnee = joueurGauche1.getCartesEnMains().get(2);
            break;
        case "joueurGauche1Carte4":
            carteSelectionnee = joueurGauche1.getCartesEnMains().get(3);
            break;

            /* Joueur gauche 2 */    
        case "joueurGauche2Carte1":
            carteSelectionnee = joueurGauche2.getCartesEnMains().get(0);
            break;
        case "joueurGauche2Carte2":
            carteSelectionnee = joueurGauche2.getCartesEnMains().get(1);
            break;
        case "joueurGauche2Carte3":
            carteSelectionnee = joueurGauche2.getCartesEnMains().get(2);
            break;
        case "joueurGauche2Carte4":
            carteSelectionnee = joueurGauche2.getCartesEnMains().get(3);
            break;

            /* Joueur droite 1 */    
        case "joueurDroite1Carte1":
            carteSelectionnee = joueurDroite1.getCartesEnMains().get(0);
            break;
        case "joueurDroite1Carte2":
            carteSelectionnee = joueurDroite1.getCartesEnMains().get(1);
            break;
        case "joueurDroite1Carte3":
            carteSelectionnee = joueurDroite1.getCartesEnMains().get(2);
            break;
        case "joueurDroite1Carte4":
            carteSelectionnee = joueurDroite1.getCartesEnMains().get(3);
            break;

            /* Joueur droite 1 */    
        case "joueurDroite2Carte1":
            carteSelectionnee = joueurDroite2.getCartesEnMains().get(0);
            break;
        case "joueurDroite2Carte2":
            carteSelectionnee = joueurDroite2.getCartesEnMains().get(1);
            break;
        case "joueurDroite2Carte3":
            carteSelectionnee = joueurDroite2.getCartesEnMains().get(2);
            break;
        case "joueurDroite2Carte4":
            carteSelectionnee = joueurDroite2.getCartesEnMains().get(3);
            break;
        default:
            break;
        }
        System.out.println(carteSelectionnee);
    }
}
