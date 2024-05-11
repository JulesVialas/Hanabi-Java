/*
 * Carte.java			11/05/2024
 * IUT de Rodez, pas de copyrights
 */

package jeu;

/**
 * La classe Carte représente une carte du jeu Hanabi.
 * Chaque carte possède une couleur et un numéro.
 */
public class Carte {
    /** La couleur de la carte. */
    String couleur;
    
    /** Le numéro de la carte. */
    int numero;

    /**
     * Constructeur de la classe Carte.
     *
     * @param couleur La couleur de la carte.
     * @param numero Le numéro de la carte.
     */
    public Carte(String couleur, int numero) {
        this.couleur = couleur;
        this.numero = numero;
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
    public int getNumero() {
        return numero;
    }

    /**
     * Renvoie une représentation textuelle de la carte.
     *
     * @return Une chaîne de caractères représentant la carte au format [Couleur Numéro].
     */
    @Override
    public String toString() {
        return "["+ couleur + " " + numero +"]";
    }
}
