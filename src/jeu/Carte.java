/*
 * Carte.java			11/05/2024
 * IUT de Rodez, pas de copyright
 */

package jeu;

/**
 * La classe Carte représente une carte du jeu Hanabi. Chaque carte possède une
 * couleur et une hauteur. Le jeu hanabi comporte .... 
 */
public class Carte {
    /** La couleur de la carte. */
    private String couleur;

    /** La hauteur de la carte. */
    private int hauteur;

    /** Indique si la hauteur est connu ou non. */
    private boolean hauteurConnue;

    /** Indique si la couleur est connue ou non. */
    private boolean couleurConnue;
    
    /**
     * La hauteur et la couleur connue sont définis sur faux.
     */
    public Carte(String couleur, int hauteur) {
	this.couleur = couleur;
	this.hauteur = hauteur;
	this.hauteurConnue = false;
	this.couleurConnue = false;
    }

    /**
     * @return La couleur de la carte
     */
    public String getCouleur() {
	return couleur;
    }

    /**
     * @return La hauteur de la carte
     */
    public int getHauteur() {
	return hauteur;
    }

    /**
     * @return le status de la visibilité de la couleur de la carte
     */
    public boolean getCouleurConnue() {
	return couleurConnue;
    }

    /**
     * @return le status de la visibilité de la hauteur de la carte
     */
    public boolean getHauteurConnue() {
	return hauteurConnue;
    }

    /**
     * Défini si la couleur est visible ou non.
     * @param etat de la visibilité de la couleur. True pour couleur connue sinon false
     */
    public void setCouleurConnue(boolean etat) {
	couleurConnue = etat;
    }

    /**
     * Défini si la hauteur est visible ou non.
     *
     * @param etat de la visibilité de la hauteur. True pour hauteur connue sinon false
     */
    public void setHauteurConnue(boolean etat) {
	hauteurConnue = etat;
    }

    /**
     * Renvoie la couleur et la hauteur de la carte ainsi que l'état de la visiblité de ces deux champs.
     * @return Une chaîne de caractères représentant la carte au format [Couleur
     *         Numéro].
     */
    @Override
    public String toString() {
	return "[" + getCouleur() + " " + getHauteur() + " couleur visible " + getCouleurConnue() + " hauteur visible " + gethauteurConnue() "]";
    }
}
