/*
 * Defausse.java			19/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */
package modele.jeu;

import java.util.ArrayList;

/**
 * La classe Defausse représente la défausse de carte dans jeu Hanabi. La
 * défausse est une pile de cartes. Les cartes présentes dans la défausse sont
 * inutilisées et sont seulement visible par le joueur pour prendre des bonnes
 * décisions.
 */
public class Defausse {

    /** La pile de cartes de la défausse. */
    private ArrayList<Carte> pile;

    /**
     * Instancie un objet de type Defausse.
     */
    public Defausse() {
        this.pile = new ArrayList<>();
    }

    /**
     * Remplace la pile de cartes par une nouvelle pile.
     *
     * @param pile Nouvelle pile de cartes qui constitue la défausse.
     */
    public void setPile(ArrayList<Carte> pile) {
        this.pile = pile;
    }
}
