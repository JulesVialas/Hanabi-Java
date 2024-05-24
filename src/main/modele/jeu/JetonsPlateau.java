/*
 * JetonsPlateau.java			24/05/2024
 * IUT de Rodez, TP42, pas de copyright
 */

package modele.jeu;

/**
 * La classe JetonsPlateau représente les jetons du jeu Hanabi. Il existe deux
 * types de jetons :
 * <ul>
 * <li>Les jetons bleus, 8 en début de partie. L'équipe perd un jeton bleu
 * lorsqu'il donne une information.L'équipe gagne un jeton bleu lorsqu'il
 * défausse une carte de sa main.</li>
 * <li>Les jetons rouges, 0 en début de partie. L'équipe reçoit un jeton rouge
 * lorsqu'une carte est jouée et qu'elle ne vient compléter aucun feu d’artifice
 * </li>
 * </ul>
 * 
 * @author Jules Vialas
 */

public class JetonsPlateau {

    /** Message d'erreur concernant le nombre de jetons bleus */
    public static final String ERREUR_NB_JETONS_BLEUS = "Erreur : Le nombre de jetons bleus n'est pas compris entre 0 et 8 inclut.";

    /** Message d'erreur concernant le nombre de jetons rouges */
    public static final String ERREUR_NB_JETONS_ROUGES = "Erreur : le nombre de jetons rouges n'est pas compris entre 0 et 3 inclut.";

    /** Le nombre de jetons bleu minimal */
    public final int NB_JETONS_BLEUS_MIN = 0;

    /** Le nombre de jetons bleus en début de partie */
    public final int NB_JETONS_BLEUS_MAX = 8;

    /** Le nombre de jetons rouges en début de partie */
    public final int NB_JETONS_ROUGES_MIN = 0;

    /** Le nombre de jetons rouges maximal */
    public final int NB_JETONS_ROUGES_MAX = 3;

    /** Jeton bleu */
    private int bleu;

    /** Jeton rouge */
    private int rouge;

    /**
     * jeton bleu est instancié avec la valeur par défaut NB_JETONS_BLEUS_MAX jeton
     * rouge est instancié avec la valeur par défaut NB_JETONS_ROUGES_MIN
     * 
     * @param bleu
     * @param rouge
     */
    public JetonsPlateau() {
        this.bleu = NB_JETONS_BLEUS_MAX;
        this.rouge = NB_JETONS_ROUGES_MIN;
    }

    /**
     * Défini le nombre de jetons bleus
     * 
     * @param nombre
     * @throws IllegalStateException si le nombre de jetons bleus inscrit en
     *                               paramètre n'est pas valide.
     */
    public void setBleus(int nombre) {
        if (nombre > NB_JETONS_BLEUS_MAX || nombre < NB_JETONS_BLEUS_MIN) {
            throw new IllegalStateException(ERREUR_NB_JETONS_BLEUS);
        }
        this.bleu = nombre;
    }

    /**
     * Défini le nombre de jetons rouges
     * 
     * @param nombre
     * @throws IllegalStateException si le nombre de jetons rouges inscrit en
     *                               paramètre n'est pas valide.
     */
    public void setRouges(int nombre) {
        if (nombre > NB_JETONS_ROUGES_MAX || nombre < NB_JETONS_ROUGES_MIN) {
            throw new IllegalStateException(ERREUR_NB_JETONS_ROUGES);
        }
        this.rouge = nombre;
    }

    /**
     * Augmente le nombre de jetons bleus de l'équipe
     * 
     * @throws IllegalStateException si le nombre de jetons bleus n'est pas valide
     *                               lors d'une incrémentation.
     */
    public void incrementBleus() {
        if (this.bleu + 1 > NB_JETONS_BLEUS_MAX) {
            throw new IllegalStateException(ERREUR_NB_JETONS_BLEUS);
        }
        this.bleu++;
    }

    /**
     * Réduit le nombre de jetons bleus de l'équipe
     * 
     * @throws IllegalStateException si le nombre de jetons bleus n'est pas valide
     *                               lors d'une décrémentation.
     */
    public void decrementBleus() {
        if (this.bleu - 1 < NB_JETONS_BLEUS_MIN) {
            throw new IllegalStateException(ERREUR_NB_JETONS_BLEUS);
        }
        this.bleu--;
    }

    /**
     * Augmente le nombre de jetons rouges de l'équipe
     * 
     * @throws IllegalStateException si le nombre de jetons rouges n'est pas valide
     *                               lors d'une incrémentation.
     */
    public void incrementRouges() {
        if (this.rouge + 1 > NB_JETONS_ROUGES_MAX) {
            throw new IllegalStateException(ERREUR_NB_JETONS_ROUGES);
        }
        this.rouge++;
    }

    /**
     * Réduit le nombre de jetons rouges de l'équipe
     * 
     * @throws IllegalStateException si le nombre de jetons rouges n'est pas valide
     *                               lors d'une décrémentation.
     */
    public void decrementRouges() {
        if (this.rouge - 1 < NB_JETONS_ROUGES_MIN) {
            throw new IllegalStateException(ERREUR_NB_JETONS_ROUGES);
        }
        this.rouge--;
    }

    /**
     * @return le nombre de jetons bleus
     */
    public int getBleus() {
        return this.bleu;
    }

    /**
     * @return le nombre de jetons rouges
     */
    public int getRouges() {
        return this.rouge;
    }
}