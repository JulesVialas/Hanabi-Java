package jeu.application.controleur;

import java.util.EmptyStackException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jeu.application.Hanabi;
import jeu.modele.Carte;
import jeu.modele.Couleur;
import jeu.modele.Joueur;
import jeu.modele.Partie;
import jeu.modele.Tour;

/**
 * Contrôleur de la table de jeux à cinq joueurs
 */
public class TableCinqJoueurs {

    private static final String ERREUR_PARTIE_TERMINEE = "Erreur: impossible de créer un nouveau tour, la partie est terminée.";

    /** La partie à contrôler */
    private Partie partieEnCours;

    /** La carte sélectionnée */
    private Carte carteSelectionnee;

    /** La nature de l'indice à donner */
    private char natureIndice;

    /** La nature de la pose de carte: p pour poser et d pour défausser */
    private char naturePose;

    /* Joueurs correspondant aux positions */
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
    private Button joueurBasIndice1;

    @FXML
    private Button joueurBasIndice2;

    @FXML
    private Button joueurBasIndice3;

    @FXML
    private Button joueurBasIndice4;

    @FXML
    private Button joueurDroite1Indice1;

    @FXML
    private Button joueurDroite1Indice2;

    @FXML
    private Button joueurDroite1Indice3;

    @FXML
    private Button joueurDroite1Indice4;

    @FXML
    private Button joueurDroite2Indice1;

    @FXML
    private Button joueurDroite2Indice2;

    @FXML
    private Button joueurDroite2Indice3;

    @FXML
    private Button joueurDroite2Indice4;

    @FXML
    private Button joueurGauche1Indice1;

    @FXML
    private Button joueurGauche1Indice2;

    @FXML
    private Button joueurGauche1Indice3;

    @FXML
    private Button joueurGauche1Indice4;

    @FXML
    private Button joueurGauche2Indice1;

    @FXML
    private Button joueurGauche2Indice2;

    @FXML
    private Button joueurGauche2Indice3;

    @FXML
    private Button joueurGauche2Indice4;

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

        masquerOrverlays();
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
        // TODO mettre en évidence les cartes correspondantes
    }

    @FXML
    private void gererClicValeur() {
        natureIndice = 'v';
        System.out.println(natureIndice);
        // TODO mettre en évidence les cartes correspondantes
    }

    @FXML
    private void gererClicPoser() {
        naturePose = 'p';
    }

    @FXML
    private void gererClicDefausser() {
        naturePose = 'd';
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
        lancerTourSuivant(creerTourSuivant());
        updateView(); // STUB
    }

    @FXML
    private void donnerIndice(ActionEvent event) {
        System.out.println(natureIndice);
        partieEnCours.getTourCourant().donnerIndice(carteSelectionnee,
                natureIndice);
        System.out.println(((Control) event.getSource()).getId());
        natureIndice = ' ';
        carteSelectionnee = null;
        resetCarteSelectionnee();
        updateView();
        lancerTourSuivant(creerTourSuivant());
        updateView(); // STUB
    }

    @FXML
    private void retourJeu(ActionEvent event) {
        Hanabi.activerTableCinqJoueurs(ChoixJoueurs.partieCinqJoueurs);
    }

    @FXML
    private void versParametres() {
        Hanabi.activerParametres();
    }

    @FXML
    private void retourMenuPrincipal() {
        Hanabi.activerSauvegarder();
    }

    /**
     * Vider le champ carteSelectionnee
     */
    private void resetCarteSelectionnee() {
        carteSelectionnee = null;
    }

    /**
     * Définie la carte liée au bouton cliqué comme étant la carte
     * sélectionnée.
     *
     * @param idBouton l'identifiant du bouton cliqué
     */
    private void setCarteSelectionnee(String idBouton) {
        System.out.println(idBouton);
        switch (idBouton) {

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
        masquerOrverlays();
        updatePositionJoueurs();
        updateLabelsJoueurs();
        updateAffichageCartes();
        masquerIndices();
        // TODO update cases indices des équipiers
        // TODO affichage cartes joueur courant en fonction indices
        updateJetons();
        updatePiocheDefausse();
        updateFeuxArtifice();
        if (partieEnCours
                .isPartieFinie(partieEnCours.getTourCourant().getNumero())) {

            /* Désactive tous ce qui ne sert pas à sortir de la partie */
            desactiverBoutonsPartie();
            masquerOrverlays();
            Hanabi.activerPartieFinie(partieEnCours);
        }
    }

    /**
     * Masque les overlays d'actions et de menus
     */
    private void masquerOrverlays() {
        overlayActions.setVisible(false);
        overlayJoueurCourant.setVisible(false);
        Pause.setVisible(false);
    }

    /**
     * Masque les boutons d'indices en début de partie
     */
    private void masquerIndices() {

        joueurBasIndice1.setVisible(false);
        joueurBasIndice2.setVisible(false);
        joueurBasIndice3.setVisible(false);
        joueurBasIndice4.setVisible(false);

        joueurGauche1Indice1.setVisible(false);
        joueurGauche1Indice2.setVisible(false);
        joueurGauche1Indice3.setVisible(false);
        joueurGauche1Indice4.setVisible(false);

        joueurGauche2Indice1.setVisible(false);
        joueurGauche2Indice2.setVisible(false);
        joueurGauche2Indice3.setVisible(false);
        joueurGauche2Indice4.setVisible(false);

        joueurDroite1Indice1.setVisible(false);
        joueurDroite1Indice2.setVisible(false);
        joueurDroite1Indice3.setVisible(false);
        joueurDroite1Indice4.setVisible(false);

        joueurDroite2Indice1.setVisible(false);
        joueurDroite2Indice2.setVisible(false);
        joueurDroite2Indice3.setVisible(false);
        joueurDroite2Indice4.setVisible(false);
    }

    /**
     * Désactive tous les boutons en lien avec la réalisation d'actions de
     * la partie.
     */
    private void desactiverBoutonsPartie() {
        joueurBasCarte1.setDisable(true);
        joueurBasCarte2.setDisable(true);
        joueurBasCarte3.setDisable(true);
        joueurBasCarte4.setDisable(true);

        joueurGauche1Carte1.setDisable(true);
        joueurGauche1Carte2.setDisable(true);
        joueurGauche1Carte3.setDisable(true);
        joueurGauche1Carte4.setDisable(true);

        joueurGauche2Carte1.setDisable(true);
        joueurGauche2Carte2.setDisable(true);
        joueurGauche2Carte3.setDisable(true);
        joueurGauche2Carte4.setDisable(true);

        joueurDroite1Carte1.setDisable(true);
        joueurDroite1Carte2.setDisable(true);
        joueurDroite1Carte3.setDisable(true);
        joueurDroite1Carte4.setDisable(true);

        joueurDroite2Carte1.setDisable(true);
        joueurDroite2Carte2.setDisable(true);
        joueurDroite2Carte3.setDisable(true);
        joueurDroite2Carte4.setDisable(true);

    }

    /**
     * Initialise la couleur des tas de feux d'artifice sur la table
     */
    private void initializeCouleurFeuxArtifice() {
        // TODO enlever animation si cliqués
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
     * Met à jour la position des joueurs en fonction du numéro de tour
     */
    private void updatePositionJoueurs() {
        switch (partieEnCours.getTourCourant().getNumero() % 5) {
        case 0:
            joueurBas = partieEnCours.getJoueur5();
            joueurGauche1 = partieEnCours.getJoueur4();
            joueurGauche2 = partieEnCours.getJoueur3();
            joueurDroite1 = partieEnCours.getJoueur2();
            joueurDroite2 = partieEnCours.getJoueur1();
            updateLabelsJoueurs();
            break;
        case 1:
            joueurBas = partieEnCours.getJoueur1();
            joueurGauche1 = partieEnCours.getJoueur5();
            joueurGauche2 = partieEnCours.getJoueur4();
            joueurDroite1 = partieEnCours.getJoueur3();
            joueurDroite2 = partieEnCours.getJoueur2();
            updateLabelsJoueurs();
            break;
        case 2:
            joueurBas = partieEnCours.getJoueur2();
            joueurGauche1 = partieEnCours.getJoueur1();
            joueurGauche2 = partieEnCours.getJoueur5();
            joueurDroite1 = partieEnCours.getJoueur4();
            joueurDroite2 = partieEnCours.getJoueur3();
            updateLabelsJoueurs();
            break;
        case 3:
            joueurBas = partieEnCours.getJoueur3();
            joueurGauche1 = partieEnCours.getJoueur2();
            joueurGauche2 = partieEnCours.getJoueur1();
            joueurDroite1 = partieEnCours.getJoueur5();
            joueurDroite2 = partieEnCours.getJoueur4();
            updateLabelsJoueurs();
            break;
        case 4:
            joueurBas = partieEnCours.getJoueur4();
            joueurGauche1 = partieEnCours.getJoueur3();
            joueurGauche2 = partieEnCours.getJoueur2();
            joueurDroite1 = partieEnCours.getJoueur1();
            joueurDroite2 = partieEnCours.getJoueur5();
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
        joueurBasLabel.setText(joueurBas.getPseudo());
        joueurGauche1Label.setText(joueurGauche1.getPseudo());
        joueurGauche2Label.setText(joueurGauche2.getPseudo());
        joueurDroite1Label.setText(joueurDroite1.getPseudo());
        joueurDroite2Label.setText(joueurDroite2.getPseudo());
    }

    /**
     * Met à jour l'affichage du nombre de jetons rouges et bleus
     * disponibles
     */
    private void updatePiocheDefausse() {
        nbCartesPioche
                .setText(Integer.toString(partieEnCours.getPioche().size()));
        nbCartesDefausse
                .setText(Integer.toString(partieEnCours.getDefausse().size()));
    }

    /**
     * Met à jour le nombre de jetons rouges et bleus disponibles
     */
    private void updateJetons() {
        nbJetonsRouge.setText(
                Integer.toString(partieEnCours.getJetons().getRouges()));
        nbJetonsBleu.setText(
                Integer.toString(partieEnCours.getJetons().getBleus()));
    }

    /**
     * Met à jour l'affichage des mains des joueurs
     */
    private void updateAffichageCartes() {
        joueurGauche1Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche1.getCartesEnMains().get(0).getCouleur())
                + ";");
        joueurGauche1Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche1.getCartesEnMains().get(1).getCouleur())
                + ";");
        joueurGauche1Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche1.getCartesEnMains().get(2).getCouleur())
                + ";");
        try {
            joueurGauche1Carte4
                    .setStyle("-fx-background-color: #"
                            + convertirCouleurEnHex(joueurGauche1
                                    .getCartesEnMains().get(3).getCouleur())
                            + ";");
            joueurGauche1Carte4
                    .setText(Integer.toString(joueurDroite2.getCartesEnMains()
                            .get(3).getValeur().getValeurNumerique()));
        } catch (IndexOutOfBoundsException piocheVide) {
            // La main du joueur n'est plus complète car pioche vide
            joueurGauche1Carte4.setStyle("-fx-background-color: #000000");
            joueurGauche1Carte4.setText("");
        }

        joueurGauche1Carte1.setText(Integer.toString(joueurGauche1
                .getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurGauche1Carte2.setText(Integer.toString(joueurGauche1
                .getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurGauche1Carte3.setText(Integer.toString(joueurGauche1
                .getCartesEnMains().get(2).getValeur().getValeurNumerique()));

        joueurGauche2Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche2.getCartesEnMains().get(0).getCouleur())
                + ";");
        joueurGauche2Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche2.getCartesEnMains().get(1).getCouleur())
                + ";");
        joueurGauche2Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurGauche2.getCartesEnMains().get(2).getCouleur())
                + ";");
        try {
            joueurGauche2Carte4
                    .setStyle("-fx-background-color: #"
                            + convertirCouleurEnHex(joueurGauche2
                                    .getCartesEnMains().get(3).getCouleur())
                            + ";");
            joueurGauche2Carte4
                    .setText(Integer.toString(joueurDroite2.getCartesEnMains()
                            .get(3).getValeur().getValeurNumerique()));
        } catch (IndexOutOfBoundsException piocheVide) {
            // La main du joueur n'est plus complète car pioche vide
            joueurGauche2Carte4.setStyle("-fx-background-color: #000000");
            joueurGauche2Carte4.setText("");
        }

        joueurGauche2Carte1.setText(Integer.toString(joueurGauche2
                .getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurGauche2Carte2.setText(Integer.toString(joueurGauche2
                .getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurGauche2Carte3.setText(Integer.toString(joueurGauche2
                .getCartesEnMains().get(2).getValeur().getValeurNumerique()));

        joueurDroite1Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite1.getCartesEnMains().get(0).getCouleur())
                + ";");
        joueurDroite1Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite1.getCartesEnMains().get(1).getCouleur())
                + ";");
        joueurDroite1Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite1.getCartesEnMains().get(2).getCouleur())
                + ";");
        try {
            joueurDroite1Carte4
                    .setStyle("-fx-background-color: #"
                            + convertirCouleurEnHex(joueurDroite1
                                    .getCartesEnMains().get(3).getCouleur())
                            + ";");
            joueurDroite1Carte4
                    .setText(Integer.toString(joueurDroite2.getCartesEnMains()
                            .get(3).getValeur().getValeurNumerique()));
        } catch (IndexOutOfBoundsException piocheVide) {
            // La main du joueur n'est plus complète car pioche vide
            joueurDroite1Carte4.setStyle("-fx-background-color: #000000");
            joueurDroite1Carte4.setText("");
        }

        joueurDroite1Carte1.setText(Integer.toString(joueurDroite1
                .getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurDroite1Carte2.setText(Integer.toString(joueurDroite1
                .getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurDroite1Carte3.setText(Integer.toString(joueurDroite1
                .getCartesEnMains().get(2).getValeur().getValeurNumerique()));

        joueurDroite2Carte1.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite2.getCartesEnMains().get(0).getCouleur())
                + ";");
        joueurDroite2Carte2.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite2.getCartesEnMains().get(1).getCouleur())
                + ";");
        joueurDroite2Carte3.setStyle("-fx-background-color: #"
                + convertirCouleurEnHex(
                        joueurDroite2.getCartesEnMains().get(2).getCouleur())
                + ";");
        try {
            joueurDroite2Carte4
                    .setStyle("-fx-background-color: #"
                            + convertirCouleurEnHex(joueurDroite2
                                    .getCartesEnMains().get(3).getCouleur())
                            + ";");
            joueurDroite2Carte4
                    .setText(Integer.toString(joueurDroite2.getCartesEnMains()
                            .get(3).getValeur().getValeurNumerique()));
        } catch (IndexOutOfBoundsException piocheVide) {
            // La main du joueur n'est plus complète car pioche vide
            joueurDroite2Carte4.setStyle("-fx-background-color: #000000");
            joueurDroite2Carte4.setText("");
        }

        joueurDroite2Carte1.setText(Integer.toString(joueurDroite2
                .getCartesEnMains().get(0).getValeur().getValeurNumerique()));
        joueurDroite2Carte2.setText(Integer.toString(joueurDroite2
                .getCartesEnMains().get(1).getValeur().getValeurNumerique()));
        joueurDroite2Carte3.setText(Integer.toString(joueurDroite2
                .getCartesEnMains().get(2).getValeur().getValeurNumerique()));

    }

    /**
     * Met à jour l'affichage des feux d'artifice posés sur la table.
     */
    private void updateFeuxArtifice() {

        try {
            pileFeuxRouges
                    .setText(Integer.toString(partieEnCours.getFeuxPosesRouge()
                            .peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxJaunes
                    .setText(Integer.toString(partieEnCours.getFeuxPosesJaune()
                            .peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxVerts
                    .setText(Integer.toString(partieEnCours.getFeuxPosesVert()
                            .peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxBleus
                    .setText(Integer.toString(partieEnCours.getFeuxPosesBleu()
                            .peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
        try {
            pileFeuxBlancs
                    .setText(Integer.toString(partieEnCours.getFeuxPosesBlanc()
                            .peek().getValeur().getValeurNumerique()));
        } catch (EmptyStackException e) {
            // Empty body
        }
    }

    /**
     * Créé le tour suivant à partir du tour actuel. Si la partie est
     * terminée (3 jetons rouges, feux d'artifices complets ou dernier
     * tour de table après pioche vide), une exception sera propagée pour
     * empêcher de poursuivre la partie.
     *
     * @throws IllegalStateException si une des conditions de fin de
     *                               partie est respectée
     */
    private Tour creerTourSuivant() {

        if (partieEnCours
                .isPartieFinie(partieEnCours.getTourCourant().getNumero())) {

            Hanabi.activerPartieFinie(partieEnCours);
        }

        Tour nouveau = new Tour(joueurDroite2,
                partieEnCours.getTourCourant().getNumero() + 1);

        nouveau.setPartieDuTour(partieEnCours);

        return nouveau;
    }

    /**
     * Lance le nouveau tour suivant si aucune condition de fin de partie
     * n'est remplie.
     *
     * <p>
     * Si une condition de fin de partie est remplie (trois jetons rouges,
     * feux d'artifices complétés, dernier tour de table après pioche
     * vidée a eu lieu), alors la séquence de partie terminée sera lancée.
     *
     * @param aLancer le tour à lancer
     */
    private void lancerTourSuivant(Tour aLancer) {

        try {
            System.out.println("JBas avant = " + joueurBas.getPseudo());
            partieEnCours.setTourCourant(aLancer);
            updateView();
            System.out.println("JBas après = " + joueurBas.getPseudo());
            // TODO écran de changement de joueur pour transition
        } catch (IllegalStateException partieTerminee) {
            System.out.println("La partie est terminée");
        }
    }

    @FXML
    private void regles() {
        Regles.partieActive = true;
        Hanabi.activerRegles();
    }

}
