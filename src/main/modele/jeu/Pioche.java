package modele.jeu;


/**
 * La classe Pioche représente la pioche de carte dans jeu Hanabi. La pioche
 * est une pile de cartes. Les cartes présentes dans la pioche sont inutilisées
 * et ne le sont qu'une fois que le joueur à piocher la carte. 
 */
public class Pioche {
    
    /** La pile de carte de la pioche. */
    private Carte[] pileDeCarte; 

    /** Constructeur pour initialiser une pioche.
     * 
     * @param pile 
     */
    public Pioche(Carte[] pile) {
        this.pileDeCarte = pile;
    }

    
    /**
     * 
     *
     * @param pile	Pile de carte qui constitue la pioche.
     */
    public void setPile(Carte[] pile) {
	    pileDeCarte = pile; 
    }
}

