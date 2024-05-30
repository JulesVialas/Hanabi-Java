/*
 * Carte.java			                         11/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */

package jeu.modele;

/**
 * La classe Carte représente une carte du jeu Hanabi. Chaque carte possède une
 * couleur et une valeur. Le jeu Hanabi comporte :
 * <ul>
 * <li>50 cartes</li>
 * <li>8 jetons bleus</li>
 * <li>3 jetons rouges</li>
 * </ul>
 * <br>
 * Pour chacune des 5 couleurs des cartes, la distribution des valeurs est 1, 1,
 * 1, 2, 2, 3, 3, 4, 4, 5.
 */
public class Carte {

	/** Nombre de carte total dans le jeu de base */
	private final static int NOMBRE_TOTAL_CARTE = 50;

	/** La couleur de la carte */
	private Couleur couleur;

	/** La valeur de la carte */
	private Valeur valeur;

	/** Indique si la couleur est connue ou non par le joueur qui l'a */
	private boolean couleurConnue;

	/** Indique si la valeur est connu ou non par le joueur qui l'a */
	private boolean valeurConnue;

	/**
	 * La valeur et la couleur connue sont définis sur faux par défaut
	 *
	 * @param couleur la couleur de la carte
	 * @param valeur  la valeur de la carte
	 */
	public Carte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
		this.valeurConnue = false;
		this.couleurConnue = false;
	}

	/**
	 * @return couleur La couleur de la carte
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * @return valeur La valeur de la carte
	 */
	public Valeur getValeur() {
		return this.valeur;
	}

	/**
	 * @return couleurConnue Le status de la visibilité de la couleur de la carte
	 */
	public boolean getCouleurConnue() {
		return this.couleurConnue;
	}

	/**
	 * @return valeurConnue Le status de la visibilité de la valeur de la carte
	 */
	public boolean getValeurConnue() {
		return this.valeurConnue;
	}

	/**
	 * Défini si la couleur est visible ou non.
	 *
	 * @param etat État de la visibilité de la couleur. True pour couleur connue
	 *             sinon false
	 */
	public void setCouleurConnue(boolean etat) {
		this.couleurConnue = etat;
	}

	/**
	 * Défini si la valeur est visible ou non.
	 *
	 * @param etat État de la visibilité de la valeur. True pour valeur connue sinon
	 *             false
	 */
	public void setValeurConnue(boolean etat) {
		this.valeurConnue = etat;
	}

	/**
	 * Créé les cartes du jeu de base d'Hanabi. Chacune des cinq couleurs comporte
	 * la suit la répartition suivante: 1,1,1,2,2,3,3,4,4,5
	 *
	 * @return le jeu de base de Hanabi
	 */
	public static Carte[] jeuComplet() {
		// FIXME Trouver plus propre ? :D
		Carte[] paquet = new Carte[NOMBRE_TOTAL_CARTE];

		/* Toutes les 50 cartes du jeu de base */
		Carte unRouge1 = new Carte(Couleur.ROUGE, Valeur.UN);
		Carte unRouge2 = new Carte(Couleur.ROUGE, Valeur.UN);
		Carte unRouge3 = new Carte(Couleur.ROUGE, Valeur.UN);
		Carte deuxRouge1 = new Carte(Couleur.ROUGE, Valeur.DEUX);
		Carte deuxRouge2 = new Carte(Couleur.ROUGE, Valeur.DEUX);
		Carte troisRouge1 = new Carte(Couleur.ROUGE, Valeur.TROIS);
		Carte troisRouge2 = new Carte(Couleur.ROUGE, Valeur.TROIS);
		Carte quatreRouge1 = new Carte(Couleur.ROUGE, Valeur.QUATRE);
		Carte quatreRouge2 = new Carte(Couleur.ROUGE, Valeur.QUATRE);
		Carte cinqRouge1 = new Carte(Couleur.ROUGE, Valeur.CINQ);
		Carte unJaune1 = new Carte(Couleur.JAUNE, Valeur.UN);
		Carte unJaune2 = new Carte(Couleur.JAUNE, Valeur.UN);
		Carte unJaune3 = new Carte(Couleur.JAUNE, Valeur.UN);
		Carte deuxJaune1 = new Carte(Couleur.JAUNE, Valeur.DEUX);
		Carte deuxJaune2 = new Carte(Couleur.JAUNE, Valeur.DEUX);
		Carte troisJaune1 = new Carte(Couleur.JAUNE, Valeur.TROIS);
		Carte troisJaune2 = new Carte(Couleur.JAUNE, Valeur.TROIS);
		Carte quatreJaune1 = new Carte(Couleur.JAUNE, Valeur.QUATRE);
		Carte quatreJaune2 = new Carte(Couleur.JAUNE, Valeur.QUATRE);
		Carte cinqJaune1 = new Carte(Couleur.JAUNE, Valeur.CINQ);
		Carte unVert1 = new Carte(Couleur.VERT, Valeur.UN);
		Carte unVert2 = new Carte(Couleur.VERT, Valeur.UN);
		Carte unVert3 = new Carte(Couleur.VERT, Valeur.UN);
		Carte deuxVert1 = new Carte(Couleur.VERT, Valeur.DEUX);
		Carte deuxVert2 = new Carte(Couleur.VERT, Valeur.DEUX);
		Carte troisVert1 = new Carte(Couleur.VERT, Valeur.TROIS);
		Carte troisVert2 = new Carte(Couleur.VERT, Valeur.TROIS);
		Carte quatreVert1 = new Carte(Couleur.VERT, Valeur.QUATRE);
		Carte quatreVert2 = new Carte(Couleur.VERT, Valeur.QUATRE);
		Carte cinqVert1 = new Carte(Couleur.VERT, Valeur.CINQ);
		Carte unBleu1 = new Carte(Couleur.BLEU, Valeur.UN);
		Carte unBleu2 = new Carte(Couleur.BLEU, Valeur.UN);
		Carte unBleu3 = new Carte(Couleur.BLEU, Valeur.UN);
		Carte deuxBleu1 = new Carte(Couleur.BLEU, Valeur.DEUX);
		Carte deuxBleu2 = new Carte(Couleur.BLEU, Valeur.DEUX);
		Carte troisBleu1 = new Carte(Couleur.BLEU, Valeur.TROIS);
		Carte troisBleu2 = new Carte(Couleur.BLEU, Valeur.TROIS);
		Carte quatreBleu1 = new Carte(Couleur.BLEU, Valeur.QUATRE);
		Carte quatreBleu2 = new Carte(Couleur.BLEU, Valeur.QUATRE);
		Carte cinqBleu1 = new Carte(Couleur.BLEU, Valeur.CINQ);
		Carte unBlanc1 = new Carte(Couleur.BLANC, Valeur.UN);
		Carte unBlanc2 = new Carte(Couleur.BLANC, Valeur.UN);
		Carte unBlanc3 = new Carte(Couleur.BLANC, Valeur.UN);
		Carte deuxBlanc1 = new Carte(Couleur.BLANC, Valeur.DEUX);
		Carte deuxBlanc2 = new Carte(Couleur.BLANC, Valeur.DEUX);
		Carte troisBlanc1 = new Carte(Couleur.BLANC, Valeur.TROIS);
		Carte troisBlanc2 = new Carte(Couleur.BLANC, Valeur.TROIS);
		Carte quatreBlanc1 = new Carte(Couleur.BLANC, Valeur.QUATRE);
		Carte quatreBlanc2 = new Carte(Couleur.BLANC, Valeur.QUATRE);
		Carte cinqBlanc1 = new Carte(Couleur.BLANC, Valeur.CINQ);

		/*
		 * On stocke les cartes dans le tableau paquet pour eviter un return encore
		 * moins lisible que ça :')
		 */
		paquet[0] = unRouge1;
		paquet[1] = unRouge2;
		paquet[2] = unRouge3;
		paquet[3] = deuxRouge1;
		paquet[4] = deuxRouge2;
		paquet[5] = troisRouge1;
		paquet[6] = troisRouge2;
		paquet[7] = quatreRouge1;
		paquet[8] = quatreRouge2;
		paquet[9] = cinqRouge1;
		paquet[10] = unJaune1;
		paquet[11] = unJaune2;
		paquet[12] = unJaune3;
		paquet[13] = deuxJaune1;
		paquet[14] = deuxJaune2;
		paquet[15] = troisJaune1;
		paquet[16] = troisJaune2;
		paquet[17] = quatreJaune1;
		paquet[18] = quatreJaune2;
		paquet[19] = cinqJaune1;
		paquet[20] = unVert1;
		paquet[21] = unVert2;
		paquet[22] = unVert3;
		paquet[23] = deuxVert1;
		paquet[24] = deuxVert2;
		paquet[25] = troisVert1;
		paquet[26] = troisVert2;
		paquet[27] = quatreVert1;
		paquet[28] = quatreVert2;
		paquet[29] = cinqVert1;
		paquet[30] = unBleu1;
		paquet[31] = unBleu2;
		paquet[32] = unBleu3;
		paquet[33] = deuxBleu1;
		paquet[34] = deuxBleu2;
		paquet[35] = troisBleu1;
		paquet[36] = troisBleu2;
		paquet[37] = quatreBleu1;
		paquet[38] = quatreBleu2;
		paquet[39] = cinqBleu1;
		paquet[40] = unBlanc1;
		paquet[41] = unBlanc2;
		paquet[42] = unBlanc3;
		paquet[43] = deuxBlanc1;
		paquet[44] = deuxBlanc2;
		paquet[45] = troisBlanc1;
		paquet[46] = troisBlanc2;
		paquet[47] = quatreBlanc1;
		paquet[48] = quatreBlanc2;
		paquet[49] = cinqBlanc1;

		return paquet;
	}

	/**
	 * Renvoie la couleur et la valeur de la carte ainsi que l'état de la visibilité
	 * de ces deux champs.
	 *
	 * @return Une chaîne de caractères représentant la carte au format [Couleur
	 *         Valeur couleurConnue valeurConnue].
	 */
	@Override
	public String toString() {
		return "[" + getCouleur() + " " + getValeur() + " couleur visible " + getCouleurConnue() + " valeur visible "
				+ getValeurConnue() + "]";
	}
}
