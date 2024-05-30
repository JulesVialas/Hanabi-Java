/*
 * Valeur.java                                           19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

/**
 * Défini les valeurs de cartes valides pour le jeu Hanabi
 */
public enum Valeur {

	UN(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5);

	/** La valeur de la carte sous forme d'entier */
	private int valeurNumerique;

	Valeur(int valeurNumerique) {
		this.valeurNumerique = valeurNumerique;
	}

	/**
	 * @return la valeur de la carte
	 */
	public int getValeurNumerique() {
		return this.valeurNumerique;
	}
}
