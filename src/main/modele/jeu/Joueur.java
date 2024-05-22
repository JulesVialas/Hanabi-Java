package modele.jeu;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Joueur représente un joueur dans un jeu de cartes. 
 * Chaque joueur a un pseudo et une main de cartes.
 * 
 * @author Jules Vialas
 * @author Corentin Solignac
 */
public class Joueur {

	private static final String ERREUR_PSEUDO_INVALIDE = 
			"Erreur: Le pseudo doit comporter entre 2 et 10 caractères et ne doit "
					+ "pas être uniquement constitué d'espaces, ni être null.";

	/** Le pseudo du joueur. */
	private String pseudo;

	/** Les cartes en main du joueur. */
	private ArrayList<Carte> cartesEnMain;

	/**
	 * Instancie un objet de type Joueur à l'aide de son pseudo.
	 * Le pseudo peut comporter entre 2 et 10 caractères. Il ne peut 
	 * pas être composés uniquement d'espaces, ni être null.
	 * 
	 * @param pseudo le pseudo du joueur
	 * @throws IllegalArgumentException si les règles de validité de 
	 *         construction d'un pseudo ne sont pas respectées.
	 */
	public Joueur(String pseudo) {

		if(pseudo.isBlank() || pseudo.length() < 2 || pseudo.length() > 10) {
			throw new IllegalArgumentException(ERREUR_PSEUDO_INVALIDE);
		}
		this.pseudo = pseudo;
		this.cartesEnMain = new ArrayList<>();
	}

	/**
	 * @return le pseudo du joueur
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * @return les cartes dans la main du joueur
	 */
	public List<Carte> getCartesEnMains() {
		return this.cartesEnMain;
	}

	/**
	 * Ajoute une carte à la main du joueur, à la suite des autres.
	 *
	 * @param carte la carte à ajouter
	 */
	public void setCartesEnMains(Carte carte) {
		this.cartesEnMain.add(carte);
	}
}
