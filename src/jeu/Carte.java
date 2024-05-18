/*
 * Carte.java			11/05/2024
 * IUT de Rodez, pas de copyright
 */

package jeu;

/**
 * La classe Carte représente une carte du jeu Hanabi. Chaque carte possède une
 * couleur et une valeur. 
 * Le jeu Hanabi comporte : 
 * <ul>
 * 	<li>50 cartes</li>
 * 	<li>8 jetons bleus</li>
 * 	<li>3 jetons rouges</li>
 * </ul>
 * <br>
 *  Pour chacune des 5 couleurs des cartes,  la distribution des valeurs est 
 *  1, 1, 1, 2, 2, 3, 3, 4, 4, 5.
 */
public class Carte {
    
    /** La couleur de la carte. */
    private String couleur;

    /** La valeur de la carte. */
    private int valeur;

    /** Indique si la couleur est connue ou non. */
    private boolean couleurConnue;
    
    /** Indique si la valeur est connu ou non. */
    private boolean valeurConnue;
    
    /**
     * La valeur et la couleur connue sont définis sur faux.
     */
    public Carte(String couleur, int valeur) {
	this.couleur = couleur;
	this.valeur = valeur;
	this.valeurConnue = false;
	this.couleurConnue = false;
    }

    /**
     * @return couleur	La couleur de la carte
     */
    public String getCouleur() {
	return couleur;
    }

    /**
     * @return valeur	La valeur de la carte
     */
    public int getValeur() {
	return valeur;
    }

    /**
     * @return couleurConnue	Le status de la visibilité de la couleur 
     * 			        de la carte
     */
    public boolean getCouleurConnue() {
	return couleurConnue;
    }

    /**
     * @return valeurConnue  Le status de la visibilité de la valeur
     * 			     de la carte
     */
    public boolean getValeurConnue() {
	return valeurConnue;
    }

    /**
     * Défini si la couleur est visible ou non.
     * 
     * @param etat	État de la visibilité de la couleur. True pour couleur
     *  		connue sinon false
     */
    public void setCouleurConnue(boolean etat) {
	couleurConnue = etat;
    }

    /**
     * Défini si la valeur est visible ou non.
     *
     * @param etat	État de la visibilité de la valeur. True pour valeur
     * 			connue sinon false
     */
    public void setValeurConnue(boolean etat) {
	valeurConnue = etat;
    }

    /**
     * Renvoie la couleur et la valeur de la carte ainsi que l'état de la 
     * visibilité de ces deux champs.
     * 
     * @return Une chaîne de caractères représentant la carte au format 
     * [Couleur Valeur].
     */
    @Override
    public String toString() {
	return "[" + getCouleur() + " " + getValeur() + " couleur visible " + getCouleurConnue() + " valeur visible " + getValeurConnue() + "]";
    }
}
