/*
 * ControleurHanabi.java                                       28/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Point d'entrée de l'application Hanabi.
 * Ouvre l'application sur le menu principal.
 * @author Corentin Solignac
 * @author Jules Vialas
 */
public class Hanabi extends Application {
	
	/** Scène principale de l'application, celle qui contient les 2 boutons */
	private static Scene scenePrincipale;

	/** Scène permettant de gérer le choix des joueurs */
	private static Scene sceneChoixJoueurs;

	/** Scène permettant de gérer les paramètres */
	private static Scene sceneParametres;

	/** Scène permettant de gérer la table à 2 joueurs */
	private static Scene sceneTableDeuxJoueurs;

	/** Scène permettant de gérer la table à 3 joueurs */
	private static Scene sceneTableTroisJoueurs;

	/** Scène permettant de gérer la table à 4 joueurs */
	private static Scene sceneTableQuatreJoueurs;

	/** Scène permettant de gérer la table à 5 joueurs */
	private static Scene sceneTableCinqJoueurs;

	/** Fenêtre principale de l'application
	 * La scène qui lui est associée sera modifiée en fonction
	 * des clics de l'utilisateur
	 */
	private static Stage fenetrePrincipale;

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne la scène principale, celle qui
	 * affiche les 2 boutons ChoixJoueurs et Parametres
	 */
	public static void activerPrincipale() {
		fenetrePrincipale.setScene(scenePrincipale);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de ChoixJoueurs
	 */
	public static void activerChoixJoueurs() {
		fenetrePrincipale.setScene(sceneChoixJoueurs);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de Paramètres
	 */
	public static void activerParametres() {
		fenetrePrincipale.setScene(sceneParametres);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de TableDeuxJoueurs
	 */
	public static void activerTableDeuxJoueurs() {
		fenetrePrincipale.setScene(sceneTableDeuxJoueurs);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de TableTroisJoueurs
	 */
	public static void activerTableTroisJoueurs() {
		fenetrePrincipale.setScene(sceneTableTroisJoueurs);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de TableQuatreJoueurs
	 */
	public static void activerTableQuatreJoueurs() {
		fenetrePrincipale.setScene(sceneTableQuatreJoueurs);
	}

	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle de TableCinqJoueurs
	 */
	public static void activerTableCinqJoueurs() {
		fenetrePrincipale.setScene(sceneTableCinqJoueurs);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * chargement de la vue de la scène principale dans le conteneur
			 * de type Parent
			 */
			FXMLLoader chargeurFXML = new FXMLLoader();
			chargeurFXML.setLocation(getClass().getResource("vue/MenuPrincipal.fxml"));
			Parent conteneur = chargeurFXML.load();
			/*
			 * Création de la scène principale
			 */
			scenePrincipale = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue ChoixJoueurs et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLChoixJoueurs = new FXMLLoader();
			chargeurFXMLChoixJoueurs.setLocation(getClass().getResource("vue/ChoixJoueurs.fxml"));
			conteneur = chargeurFXMLChoixJoueurs.load();
			sceneChoixJoueurs = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue Parametres et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLParametres = new FXMLLoader();
			chargeurFXMLParametres.setLocation(getClass().getResource("vue/Parametres.fxml"));
			conteneur = chargeurFXMLParametres.load();
			sceneParametres = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue TableDeuxJoueurs et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLTableDeuxJoueurs = new FXMLLoader();
			chargeurFXMLTableDeuxJoueurs.setLocation(getClass().getResource("vue/TableDeuxJoueurs.fxml"));
			conteneur = chargeurFXMLTableDeuxJoueurs.load();
			sceneTableDeuxJoueurs = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue TableTroisJoueurs et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLTableTroisJoueurs = new FXMLLoader();
			chargeurFXMLTableTroisJoueurs.setLocation(getClass().getResource("vue/TableTroisJoueurs.fxml"));
			conteneur = chargeurFXMLTableTroisJoueurs.load();
			sceneTableTroisJoueurs = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue TableDeuxJoueurs et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLTableQuatreJoueurs = new FXMLLoader();
			chargeurFXMLTableQuatreJoueurs.setLocation(getClass().getResource("vue/TableQuatreJoueurs.fxml"));
			conteneur = chargeurFXMLTableQuatreJoueurs.load();
			sceneTableQuatreJoueurs = new Scene(conteneur, 800, 600);

			/*
			 * Chargement de la vue TableCinqJoueurs et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLTableCinqJoueurs = new FXMLLoader();
			chargeurFXMLTableCinqJoueurs.setLocation(getClass().getResource("vue/TableCinqJoueurs.fxml"));
			conteneur = chargeurFXMLTableCinqJoueurs.load();
			sceneTableCinqJoueurs = new Scene(conteneur, 800, 600);

			// on définit le titre, la hauteur et la largeur de la fenêtre principale
			primaryStage.setTitle("Hanabi");
			primaryStage.setHeight(600);
			primaryStage.setWidth(800);

			/*
			 * on associe la scène principale à la fenêtre principale
			 * Cette dernière est stockée en tant qu'attribut afin d'être accessible
			 * dans les méthodes activer... Celles qui permettent de rendre active
			 * l'une des 3 scènes
			 */
			primaryStage.setScene(scenePrincipale);
			fenetrePrincipale = primaryStage;
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Programme principal
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		launch(args);
	}
}