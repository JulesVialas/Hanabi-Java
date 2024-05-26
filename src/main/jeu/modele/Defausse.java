/*
 * Defausse.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import java.util.Stack;

/**
 * La classe Defausse représente la défausse de cartes dans le jeu 
 *  Hanabi. Il s'agit d'une pile de cartes. Les cartes présentes dans
 * la défausse sont consultables par les joueurs pour orienter leurs
 * décisions.
 * 
 * @author Aurélien Valat
 */
public class Defausse {

    /** La pile de cartes de la défausse. */
    private Stack<Carte> pile;

    /**
     * Instancie un objet de type Defausse.
     * La defausse est vide par défaut.
     */
    public Defausse() {
        this.pile = new Stack<>();
    }

    /**
     * @return la pile de cartes de la défausse
     */
    public Stack<Carte> getDefausse() {
        return this.pile;
    }

    /**
     * Remplace la pile de cartes par une nouvelle pile.
     *
     * @param pileAInserer Nouvelle pile de cartes qui constitue
     *        la défausse.
     */
    public void setDefausse(Stack<Carte> pileAInserer) {
        this.pile = pileAInserer;
    }
}