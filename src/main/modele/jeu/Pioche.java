/*
 * Pioche.java			18/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;


/**
 * La classe Pioche représente la pioche de carte dans jeu Hanabi. La pioche
 * est une pile de cartes. Les cartes présentes dans la pioche sont inutilisées
 * et ne le sont qu'une fois que le joueur à piocher la carte. 
 */
public class Pioche {
    
    /** La pile de carte de la pioche. */
    private Carte[] pile; 
    
    /** Le rang indique le nombre de cartes actuellement dans la pioche. */
    private int taille;

    /** Constructeur pour initialiser une pioche.
     * 
     * @param pile 
     */
    public Pioche(Carte[] pile) {
        this.pile = pile;
        this.taille = pile.length;
    }

    /**
     * Retourne la pile de cartes actuelle.
     * @return 
     */
    public Carte[] getPile() {
        return this.pile;
    }
    
    /**
     * Remplace la pile de cartes par une nouvelle pile
     *
     * @param pile Nouvelle pile de cartes qui constitue la pioche.
     */
    public void setPile(Carte[] pile) {
        this.pile = pile;
        this.taille = pile.length;
    }
}

