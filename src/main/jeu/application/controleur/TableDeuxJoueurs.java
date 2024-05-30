package jeu.application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jeu.modele.Carte;
import jeu.modele.Couleur;
import jeu.modele.Partie;

public class TableDeuxJoueurs {

        private static final String ERREUR_PARTIE_NULL 
        = "Erreur: une partie ne peut pas être null";

        /** La partie à gérer */
        private Partie partieEnCours;
    
	@FXML
	private Label joueur1Label;

	@FXML
	private Label joueur2Label;

	@FXML
	private Label nbJetonsRouge;

	@FXML
	private Label nbJetonsBleu;

	@FXML
	private Label nbCartesDefausse;

	@FXML
	private Label nbCartesPioche;

	@FXML
	private Button joueur1Carte1;

	@FXML
	private Button joueur1Carte2;

	@FXML
	private Button joueur1Carte3;

	@FXML
	private Button joueur1Carte4;

	@FXML
	private Button joueur1Carte5;

	@FXML
	private Button joueur2Carte1;

	@FXML
	private Button joueur2Carte2;

	@FXML
	private Button joueur2Carte3;

	@FXML
	private Button joueur2Carte4;

	@FXML
	private Button joueur2Carte5;

	@FXML
        private Button btnDonnerCouleur;
	
	@FXML
        private Button btnDonnerValeur;
	
	@FXML
	private VBox overlayActions;

	@FXML
	private AnchorPane mainPane;

	private BoxBlur blurEffect = new BoxBlur(10, 10, 3);

	public void setPartie(Partie partie) {
	        
		if (partie != null) {
		    partieEnCours = partie;
		    
		    // FIXME mettre ça dans un updateView
		    joueur1Label.setText(partie.getJoueur1().getPseudo());
		    joueur2Label.setText(partie.getJoueur2().getPseudo());

		    nbJetonsRouge.setText(Integer.toString(partie.getJetons().getRouges()));
		    nbJetonsBleu.setText(Integer.toString(partie.getJetons().getBleus()));

		    nbCartesPioche.setText(Integer.toString(partie.getPioche().size()));
		    nbCartesDefausse.setText(Integer.toString(partie.getDefausse().size()));

		    // FIXME mettre ça dans un updateMains
		    joueur2Carte1.setStyle("-fx-background-color: #"
		            + convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(0).getCouleur()) + ";");
		    joueur2Carte2.setStyle("-fx-background-color: #"
		            + convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(1).getCouleur()) + ";");
		    joueur2Carte3.setStyle("-fx-background-color: #"
		            + convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(2).getCouleur()) + ";");
		    joueur2Carte4.setStyle("-fx-background-color: #"
		            + convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(3).getCouleur()) + ";");
		    joueur2Carte5.setStyle("-fx-background-color: #"
		            + convertirCouleurEnHex(partie.getJoueur2().getCartesEnMains().get(4).getCouleur()) + ";");

		    joueur2Carte1.setText(
		            Integer.toString(partie.getJoueur2().getCartesEnMains().get(0).getValeur().getValeurNumerique()));
		    joueur2Carte2.setText(
		            Integer.toString(partie.getJoueur2().getCartesEnMains().get(1).getValeur().getValeurNumerique()));
		    joueur2Carte3.setText(
		            Integer.toString(partie.getJoueur2().getCartesEnMains().get(2).getValeur().getValeurNumerique()));
		    joueur2Carte4.setText(
		            Integer.toString(partie.getJoueur2().getCartesEnMains().get(3).getValeur().getValeurNumerique()));
		    joueur2Carte5.setText(
		            Integer.toString(partie.getJoueur2().getCartesEnMains().get(4).getValeur().getValeurNumerique()));
		} else {
		    throw new IllegalArgumentException(ERREUR_PARTIE_NULL);
		}
	}

	@FXML
	private void gererClicActions() {
		mainPane.setEffect(blurEffect); // Apply blur effect to main pane
		overlayActions.setVisible(true);
	}

	@FXML
	private void FermerOverlay() {
		overlayActions.setVisible(false);
		mainPane.setEffect(null); // Remove blur effect from main pane
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
	public void initialize() {
		overlayActions.setVisible(false);
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
}
