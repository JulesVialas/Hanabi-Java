/*
 * PersistanceHanabi.java                                    24/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.utilitaire;

/**
 * Propose des méthodes permettant la sauvegarde et le chargement de parties de
 * Hanabi.
 *
 * @author Corentin Solignac
 */
public class PersistanceHanabi {

	/**
	 * Génère un entier qui sera utilisé comme identifiant de la partie. Il
	 * correspond à la date, en millisecondes à partir du 1 janvier 1970 UTC, à
	 * laquelle la partie a été enregistrée.
	 *
	 * @return l'identifiant de la partie
	 */
	public static long genererIDPartie() {
		return System.currentTimeMillis();
	}
}
