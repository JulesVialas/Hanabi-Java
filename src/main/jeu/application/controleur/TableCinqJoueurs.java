package jeu.application.controleur;

import java.util.EmptyStackException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
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
    
    /** La nature de l'indice à donner */
    private char natureIndice;
    
    /** La nature de la pose de carte: p pour poser et d pour défausser */
    private char naturePose;

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
    private Button pileFeuxRouges;
    
    @FXML
    private Button pileFeuxJaunes;
    
    @FXML
    private Button pileFeuxVerts;
    
    @FXML
    private Button pileFeuxBleus;
    
    @FXML
    private Button pileFeuxBlancs;
    
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
    private Button btnIndiceValeur;

    @FXML
    private VBox overlayActions;

    @FXML
    private VBox overlayJoueurCourant;
    
    @FXML
    private VBox Pause;
    
    @FXML
    private AnchorPane effetPause;
    
    private BoxBlur blurEffect = new BoxBlur(10, 10, 3);

    /**
     * @param aAffecter la partie à jouer
     */
    public void setPartie(Partie aAffecter) {
        /* Initialise la partie lors du lancement */
        this.partieEnCours = aAffecter;
        initializeCouleurFeuxArtifice();
        updateView();
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
        Pause.setVisible(false);
    }

    @FXML
    private void FermerOverlay() {
        overlayActions.setVisible(false);
        overlayJoueurCourant.setVisible(false);
    }


    @FXML
    private void gererClicParametres() {
    	effetPause.setEffect(blurEffect);
        Parametres.partieActive = true;
        Pause.setVisible(true);
    }

    @FXML
    private void gererClicCouleur() {
        natureIndice = 'c';
        //TODO mettre en évidence les cartes correspondantes
        //Tour.donnerIndice(TODO trouver la carte selectionnée, 'c');
    } 	

    @FXML
    private void gererClicValeur() {
        natureIndice = 'v';
        System.out.println(natureIndice);
        //Tour.donnerIndice(TODO trouver la carte selectionnée, 'v');
    }

    @FXML
    private void gererClicPoser() {
        naturePose = 'p';
        //Tour.poser(TODO Trouver la carte selectionnée);
    }
    
    @FXML
    private void gererClicDefausser() {
        naturePose = 'd';
        //Tour.poser(TODO Trouver la carte selectionnée);
    }

    @FXML 
    private void poserDefausserCarte() {
        if (naturePose == 'p') {
            partieEnCours.getTourCourant().poser(carteSelectionnee);
        } else { // naturePose = 'd'
            partieEnCours.getTourCourant().defausser(carteSelectionnee);
        }
        naturePose = ' ';
        carteSelectionnee = null;
        System.out.println(carteSelectionnee);
        updateView();
    }
    
    @FXML
    private void donnerIndice(ActionEvent event) {
        System.out.println(natureIndice);
        partieEnCours.getTourCourant()
                     .donnerIndice(carteSelectionnee, natureIndice);
        System.out.println(((Control)event.getSource()).getId());
        natureIndice = ' ';
        carteSelectionnee = null;
        resetCarteSelectionnee();
        updateView();
    }
    
    @FXML
    private void retourJeu(ActionEvent event) {
        Hanabi.activerTableCinqJoueurs(ChoixJoueurs.partieCinqJoueurs);
    }

    @FXML
    private void versParametres(){
        Hanabi.activerParametres();
    }
    
    @FXML
    private void retourMenuPrincipal(){
        Hanabi.activerSauvegarder();
    }
    
    /**
     * Vider le champ carteSelectionnee
     */
    private void resetCarteSelectionnee() {
        carteSelectionnee = null;
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

    /**
     * Met à jour tous les éléments de la vue.
     */
    public void updateView() {
        //TODO updateView

        updatePositionJoueurs();
        updateAffichageCartes();
        //TODO update cases indices équipiers
        //TODO affichage cartes joueur courant en fonction indices
        updateJetons();
        updatePiocheDefausse();
        // TODO MAJ Cartes feux artifice
        updateFeuxArtifice();
    }

    /**
     * Initialise la couleur des tas de feux d'artifice sur la table
     */
    private void initializeCouleurFeuxArtifice() {
        //TODO enlever animation si cliqués !
        pileFeuxRouges.setStyle("-fx-background-color: #"
                               + convertirCouleurEnHex(Couleur.ROUGE));
        pileFeuxJaunes.setStyle("-fx-background-color: #"
                               + convertirCouleurEnHex(Couleur.JAUNE));
        pileFeuxVerts.setStyle("-fx-background-color: #"
                               + convertirCouleurEnHex(Couleur.VERT));
        pileFeuxBleus.setStyle("-fx-background-color: #"
                               + convertirCouleurEnHex(Couleur.BLEU));
        pileFeuxBlancs.setStyle("-fx-background-color: #"
                               + convertirCouleurEnHex(Couleur.BLANC));
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
            updateLabelsJoueurs();
            break;
        case 1:
            joueurBas = partieEnCours.getJoueur1();
            joueurGauche1 = partieEnCours.getJoueur2();
            joueurGauche2 = partieEnCours.getJoueur3();
            joueurDroite1 = partieEnCours.getJoueur4();
            joueurDroite2 = partieEnCours.getJoueur5();
            updateLabelsJoueurs();
            break;
        case 2:
            joueurBas = partieEnCours.getJoueur2();
            joueurGauche1 = partieEnCours.getJoueur3();
            joueurGauche2 = partieEnCours.getJoueur4();
            joueurDroite1 = partieEnCours.getJoueur5();
            joueurDroite2 = partieEnCours.getJoueur1();
            updateLabelsJoueurs();
            break;
        case 3:
            joueurBas = partieEnCours.getJoueur3();
            joueurGauche1 = partieEnCours.getJoueur4();
            joueurGauche2 = partieEnCours.getJoueur5();
            joueurDroite1 = partieEnCours.getJoueur1();
            joueurDroite2 = partieEnCours.getJoueur2();
            updateLabelsJoueurs();
            break;
        case 4:
            joueurBas = partieEnCours.getJoueur4();
            joueurGauche1 = partieEnCours.getJoueur5();
            joueurGauche2 = partieEnCours.getJoueur1();
            joueurDroite1 = partieEnCours.getJoueur2();
            joueurDroite2 = partieEnCours.getJoueur3();
            updateLabelsJoueurs();
            break;
        default:
            break;
        }
    }

    /**
     * Met à jour le pseudo des joueurs sur le plateau
     */
    private void updateLabelsJoueurs() {
        joueurBasLabel.setText(partieEnCours.getJoueur1().getPseudo());
        joueurGauche1Label.setText(partieEnCours.getJoueur2().getPseudo());
        joueurGauche2Label.setText(partieEnCours.getJoueur3().getPseudo());
        joueurDroite1Label.setText(partieEnCours.getJoueur4().getPseudo());
        joueurDroite2Label.setText(partieEnCours.getJoueur5().getPseudo());
    }
    
    /**
     * Met à jour l'affichage du nombre de jetons rouges et bleus 
     * disponibles
     */
    private void updatePiocheDefausse() {
        nbCartesPioche.setText(Integer.toString(partieEnCours.getPioche().size()));
        nbCartesDefausse.setText(Integer.toString(partieEnCours.getDefausse().size()));
    }
    
    /**
     * Met à jour le nombre de jetons rouges et bleus disponibles
     */
    private void updateJetons() {
        nbJetonsRouge.setText(Integer.toString(partieEnCours.getJetons().getRouges()));
        nbJetonsBleu.setText(Integer.toString(partieEnCours.getJetons().getBleus()));
    }
    
    /**
     * Met à jour l'affichage des mains des joueurs
     */
    private void updateAffichageCartes() {
        joueurGauche1Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur2().getCartesEnMains().get(0).getCouleur()) + ";");
        joueurGauche1Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur2().getCartesEnMains().get(1).getCouleur()) + ";");
        joueurGauche1Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur2().getCartesEnMains().get(2).getCouleur()) + ";");
        joueurGauche1Carte4.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur2().getCartesEnMains().get(3).getCouleur()) + ";");

        joueurGauche1Carte1.setText(
                Integer.toString(partieEnCours.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurGauche1Carte2.setText(
                Integer.toString(partieEnCours.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurGauche1Carte3.setText(
                Integer.toString(partieEnCours.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
        joueurGauche1Carte4.setText(
                Integer.toString(partieEnCours.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

        joueurGauche2Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur3().getCartesEnMains().get(0).getCouleur()) + ";");
        joueurGauche2Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur3().getCartesEnMains().get(1).getCouleur()) + ";");
        joueurGauche2Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur3().getCartesEnMains().get(2).getCouleur()) + ";");
        joueurGauche2Carte4.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur3().getCartesEnMains().get(3).getCouleur()) + ";");

        joueurGauche2Carte1.setText(
                Integer.toString(partieEnCours.getJoueur3().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurGauche2Carte2.setText(
                Integer.toString(partieEnCours.getJoueur3().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurGauche2Carte3.setText(
                Integer.toString(partieEnCours.getJoueur3().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
        joueurGauche2Carte4.setText(
                Integer.toString(partieEnCours.getJoueur3().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

        joueurDroite1Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur4().getCartesEnMains().get(0).getCouleur()) + ";");
        joueurDroite1Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur4().getCartesEnMains().get(1).getCouleur()) + ";");
        joueurDroite1Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur4().getCartesEnMains().get(2).getCouleur()) + ";");
        joueurDroite1Carte4.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur4().getCartesEnMains().get(3).getCouleur()) + ";");

        joueurDroite1Carte1.setText(
                Integer.toString(partieEnCours.getJoueur4().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurDroite1Carte2.setText(
                Integer.toString(partieEnCours.getJoueur4().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurDroite1Carte3.setText(
                Integer.toString(partieEnCours.getJoueur4().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
        joueurDroite1Carte4.setText(
                Integer.toString(partieEnCours.getJoueur4().getCartesEnMains().get(3).getValeur().getValeurNumerique()));

        joueurDroite2Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur5().getCartesEnMains().get(0).getCouleur()) + ";");
        joueurDroite2Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur5().getCartesEnMains().get(1).getCouleur()) + ";");
        joueurDroite2Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur5().getCartesEnMains().get(2).getCouleur()) + ";");
        joueurDroite2Carte4.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(partieEnCours.getJoueur5().getCartesEnMains().get(3).getCouleur()) + ";");

        joueurDroite2Carte1.setText(
                Integer.toString(partieEnCours.getJoueur5().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurDroite2Carte2.setText(
                Integer.toString(partieEnCours.getJoueur5().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurDroite2Carte3.setText(
                Integer.toString(partieEnCours.getJoueur5().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
        joueurDroite2Carte4.setText(
                Integer.toString(partieEnCours.getJoueur5().getCartesEnMains().get(3).getValeur().getValeurNumerique()));
    }
    
    /**
     * Met à jour l'affichage des feux d'artifice posés sur la table.
     */
    private void updateFeuxArtifice() {
        try {
            pileFeuxRouges.setText(
                    Integer.toString(partieEnCours.getFeuxPosesRouge().peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxJaunes.setText(
                    Integer.toString(partieEnCours.getFeuxPosesJaune().peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxVerts.setText(
                    Integer.toString(partieEnCours.getFeuxPosesVert().peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxBleus.setText(
                    Integer.toString(partieEnCours.getFeuxPosesBleu().peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxBlancs.setText(
                    Integer.toString(partieEnCours.getFeuxPosesBlanc().peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
    }    
}
