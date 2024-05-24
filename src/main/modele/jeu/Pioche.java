/*
 * Pioche.java                  18/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;

import java.util.Collections;
import java.util.Stack;

/**
 * La classe Pioche représente la pioche de carte dans jeu Hanabi. La pioche est
 * une pile de cartes. Les cartes présentes dans la pioche sont inutilisées et
 * ne le sont qu'une fois que le joueur à piocher la carte.
 */
public class Pioche {

    /** La pile de carte de la pioche. */
    private Stack<Carte> pile;

    // TODO initialiser toutes les cartes
    private Carte[] jeuCarteComplet;

    /**
     * Instancie un objet de type Pioche.
     *
     * @param paquet    le paquet de carte qui constitue la pioche
     */
    public Pioche() {
        this.pile = new Stack<>();

        /* Rempli la pioche avec les cartes du jeu de base */
        for (Carte carte : Carte.jeuComplet()) {
            pile.push(carte);
        }
        /* Mélange les cartes */
        Collections.shuffle(pile);
    }

    /**
     * @return pile la pile de cartes de la pioche
     */
    public Stack<Carte> getPioche() {
        return this.pile;
    }

    /**
     * Remplace la pile de cartes par une nouvelle pile
     *
     * @param pile Nouvelle pile de cartes qui constitue la pioche.
     */
    public void setPioche(Stack<Carte> pile) {
        this.pile = pile;
    }
}