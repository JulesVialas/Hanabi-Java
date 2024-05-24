/*
 * Pioche.java                  18/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;

import java.util.Stack;

/**
 * La classe Pioche représente la pioche de carte dans jeu Hanabi. La pioche est
 * une pile de cartes. Les cartes présentes dans la pioche sont inutilisées et
 * ne le sont qu'une fois que le joueur à piocher la carte.
 */
public class Pioche {

    /** Nombre de carte total dans le jeu */
    // private final int NOMBRE_TOTAL_CARTE = 50;

    /** La pile de carte de la pioche. */
    private Stack<Carte> pile;

    // private Carte[] jeuCarteComplet;

    /**
     * Instancie un objet de type Pioche.
     *
     * @param pile une pile de carte
     */
    public Pioche(Carte[] paquet) {
        this.pile = new Stack<>();
    }

//    /**
//     *
//     * @return
//     */
//    private Carte[] jeuComplet() {
//        jeuCarteComplet.forEach();
//        return null;
//
//    }

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