/*
 * Pioche.java			18/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;

import java.util.ArrayList;

/**
 * La classe Pioche représente la pioche de carte dans jeu Hanabi. La pioche est
 * une pile de cartes. Les cartes présentes dans la pioche sont inutilisées et
 * ne le sont qu'une fois que le joueur à piocher la carte.
 */
public class Pioche {

    /** La pile de carte de la pioche. */
    private ArrayList<Carte> pile;

    /**
     * Instancie un objet de type Pioche.
     * 
     * @param pile une pile de carte
     */
    public Pioche(ArrayList<Carte> pile) {
        this.pile = pile;
    }

    /**
     * Remplace la pile de cartes par une nouvelle pile
     *
     * @param pile Nouvelle pile de cartes qui constitue la pioche.
     */
    public void setPile(ArrayList<Carte> pile) {
        this.pile = pile;
    }
}
