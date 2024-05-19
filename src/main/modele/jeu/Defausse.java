/*
 * Defausse.java			19/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;

/**
 * 
 */
public class Defausse {
	
	/** La pile de cartes de la défausse. */
    private Carte[] pile;

    /**
     * Constructeur pour initialiser la défausse.
     */
    public Defausse() {
        this.pile = new Carte[0]; 
    }

    /**
     * Remplace la pile de cartes par une nouvelle pile.
     *
     * @param pile Nouvelle pile de cartes qui constitue la défausse.
     */
    public void setPile(Carte[] pile) {
        this.pile = pile;
    }
}
