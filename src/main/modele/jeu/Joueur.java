package modele.jeu;

/**
 * La classe Joueur représente un joueur dans un jeu de cartes. Chaque joueur a
 * un pseudo, un ensemble de cartes en main, et un rang qui indique le nombre de
 * cartes en main.
 */
public class Joueur {

    /** Le pseudo du joueur. */
    private String pseudo;

    /** Les cartes en main du joueur. */
    private Carte[] cartesEnMain;

    /** Le rang indique le nombre de cartes actuellement en main. */
    private int rang = 0;

    /**
     * Constructeur pour créer un joueur avec un pseudo et un ensemble de cartes
     * initiales.
     *
     * @param pseudo       le pseudo du joueur.
     * @param cartesEnMain les cartes initiales en main du joueur.
     */
    public Joueur(String pseudo, Carte[] cartesEnMain) {
	this.pseudo = pseudo;
	this.cartesEnMain = cartesEnMain;
    }

    /**
     * Retourne le pseudo du joueur.
     *
     * @return le pseudo du joueur.
     */
    public String getPseudo() {
	return pseudo;
    }

    /**
     * Retourne une chaîne de caractères représentant les cartes en main du
     * joueur.
     *
     * @return une chaîne de caractères listant les cartes en main avec leur
     *         couleur et hauteur.
     */
    public String getCartesEnMains() {
	String resultat = " ";
	for (Carte element : cartesEnMain) {
	    resultat += "couleur = " + element.getCouleur() + " hauteur = "
		    + element.getValeur() + "\n";
	}
	return resultat;
    }

    /**
     * Ajoute une carte à la main du joueur. La carte est ajoutée à la prochaine
     * position disponible dans le tableau.
     *
     * @param carte la carte à ajouter.
     */
    public void setCartesEnMains(Carte carte) {
	cartesEnMain[rang] = carte;
	rang++;
    }
}
