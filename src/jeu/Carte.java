/*
 * Carte.java			11/05/2024
 * IUT de Rodez, pas de copyrights
 */

package jeu;

/**
 * La classe Carte représente une carte du jeu Hanabi. Chaque carte possède une
 * couleur et un numéro.
 */
public class Carte {
    /** La couleur de la carte. */
    private String couleur;

    /** Le numéro de la carte. */
    private int hauteur;

    /** Indique si le numéro est connu ou non. */
    private boolean hauteurConnue;

    /** Indique si la carte est connue ou non. */
    private boolean couleurConnue;

    /**
     * Constructeur de la classe Carte.
     *
     * @param couleur La couleur de la carte.
     * @param numero  Le numéro de la carte.
     */
    public Carte(String couleur, int hauteur) {
	this.couleur = couleur;
	this.hauteur = hauteur;
	this.hauteurConnue = false;
	this.couleurConnue = false;
    }

    /**
     * Retourne la couleur de la carte.
     *
     * @return La couleur de la carte.
     */
    public String getCouleur() {
	return couleur;
    }

    /**
     * Retourne le numéro de la carte.
     *
     * @return Le numéro de la carte.
     */
    public int getHauteur() {
	return hauteur;
    }

    /**
     * Retourne si la couleur est visible ou non.
     *
     * @return le status de la visibilité de la carte .
     */
    public boolean getCouleurConnue() {
	return couleurConnue;
    }

    /**
     * Retourne si la hauteur est visible ou non.
     *
     * @return le status de la visibilité de la carte .
     */
    public boolean getHauteurConnue() {
	return hauteurConnue;
    }

    /**
     * Défini si la couleur est visible ou non. * @param etat de la couleur.
     */
    public void setCouleurConnue(boolean etat) {
	couleurConnue = etat;
    }

    /**
     * Défini si la hauteur est visible ou non.
     *
     * @param etat de la hauteur.
     */
    public void setHauteurConnue(boolean etat) {
	hauteurConnue = etat;
    }

    /**
     * Renvoie une représentation textuelle de la carte.
     *
     * @return Une chaîne de caractères représentant la carte au format [Couleur
     *         Numéro].
     */
    @Override
    public String toString() {
	return "[" + couleur + " " + hauteur + "]";
    }
}
