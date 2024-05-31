package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import jeu.application.Hanabi;
import jeu.modele.Carte;
import jeu.modele.Couleur;
import jeu.modele.Partie;

/**
 * Contrôleur de la table de jeux à cinq joueurs
 */
public class TableCinqJoueurs {

    /** La partie à contrôler */
    private Partie partieEnCours;

    /** La carte sélectionnée */
    private Carte carteSelectionnee;
    
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
    private HBox overlayActions;

    @FXML
    private HBox overlayJoueurCourant;

    @FXML
    private Button menuPause;
    
    /**
     * @param aAffecter la partie à jouer
     */
    public void setPartie(Partie aAffecter) {
        this.partieEnCours = aAffecter;
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
	private void gererClicActions(ActionEvent event) {
	    Button buttonClicked = (Button) event.getSource();
	    String fxId = buttonClicked.getId();
	    System.out.println("Bouton cliqué : " + fxId);
	    overlayActions.setVisible(true);
	    overlayJoueurCourant.setVisible(false);
	}

	@FXML
	private void gererClicJoueurCourant(ActionEvent event) {
	    Button buttonClicked = (Button) event.getSource();
	    String fxId = buttonClicked.getId();
	    System.out.println("Bouton cliqué : " + fxId);
	    overlayJoueurCourant.setVisible(true);
	    overlayActions.setVisible(false);
	}
	
	/**
	 * initialisation de la scène
	 */
	@FXML
	public void initialize() {
		overlayActions.setVisible(false);
		overlayJoueurCourant.setVisible(false);
	}
	
	/**
	 * Carte 1 du joueur 1 cliquée
	 */
	@FXML
	private void Carte1joueurBas(ActionEvent event) {
	    System.out.println(joueurBasCarte1.getLayoutX());
	    System.out.println(joueurBasCarte1.getLayoutY());
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
            //TODO faut récupérer la carte liée au bouton
            // => switch case en private en fcontion de la source
            //partieEnCours.getTourCourant()
            //    .donnerIndice(Carte recoitIndice, 'c');
            System.out.println(((Control)event.getSource()).getId());
            System.out.println("Coucou");
        }
	
//	/**
//	 * Défini la carte sélectionnée
//	 */
//	private void setCarteSelectionnee(Control btnClique) {
//	    switch((Control)event.getSource()) {
//	        case joueur1Carte1:
//	        carteSelectionnee = 
//	    }                
//	}
	
	/**
	 * Met à jour la position des joueurs en fonction du 
	 * numéro de tour
	 */
	private void updatePositionJoueurs() {
	    switch(partieEnCours.getTourCourant().getNumero() % 5) {
	    case 0:
	        
	    }
	    
	}
}
