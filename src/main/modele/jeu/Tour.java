/*
 * Tour.java                                            18 mai 2024
 * IUT de Rodez, TP42, pas de copyright.
 */
package modele.jeu;

/**
 * Le tour d'une partie d'Hanabi est caractérisé par un numéro et un 
 * joueur. Durant un tour, le joueur doit effectuer une action parmi
 * les quatre suivantes :
 * <ul>
 *     <li>
 *     donner un indice sur la couleur d'une carte d'un de ses 
 *     équipiers;
 *     </li>
 *     <li>
 *     donner un indice sur la valeur d'une carte d'un de ses 
 *     équipiers;
 *     </li>
 *     <li>
 *     défausser une carte pour récupérer un jeton bleu;
 *     </li>
 *     <li>
 *     poser une carte, pour compléter les feux d'artifices
 *     </li>
 * </ul>
 * 
 * @author Corentin Solignac
 */
public class Tour {
    
    /** Nombre maximal de jetons bleus que peut obtenir une équipe */
    private static final int NB_MAX_JETONS_BLEUS = 8;
    
    /** Nombre de jetons rouges impliquant la fin de la partie */
    private static final int NB_MAX_JETONS_ROUGES = 3;
    
    /** Message d'erreur en cas de numéro de tour invalide */
    private static final String ERREUR_NUMERO_TOUR_INVALIDE = 
    "Erreur: le numéro de tour doit être supérieur ou égal à 1";

    /** Le joueur qui doit effectuer une action durant le tour */
    private Joueur joueurCourant;

    /** Le numéro de tour */
    private int numero;
    
    /** Le nombre de jetons bleus disponibles pour ce tour */
    private int jetonsBleus;
    
    /** Le nombre de jetons rouges disponibles pour ce tour */
    private int jetonsRouges;
    
    /**
     * Instancie un objet de type Tour. Un numéro de tour ne peut pas
     * être strictement inférieur à un.
     * 
     * @param artificier le joueur à qui ce sera le tour
     * @param numeroTour le numéro de tour
     * @throws IllegalArgumentException si le numéro de tour est 
     *         strictement inférieur à 1
     */
    public Tour(Joueur artificier, int numeroTour) {
        
        if (numeroTour < 1) {
            throw new IllegalArgumentException(ERREUR_NUMERO_TOUR_INVALIDE);
        }
        
        this.joueurCourant = artificier;
        this.numero = numeroTour;
    }
    
    /**
     * @return le joueur dont c'est le tour de jouer
     * 
     */
    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }
    
    /**
     * @return le numéro du tour
     */
    public int getNumero() {
        return this.numero;
    }
    
    /**
     * @return le nombre de jetons bleus disponibles
     */
    public int getJetonsBleus() {
        return this.jetonsBleus;
    }
    
    /**
     * @return le nombre de jetons rouges obtenus
     */
    public int getJetonsRouges() {
        return this.jetonsBleus;
    }
    
    /**
     * Donne un indice sur une carte, couleur ou valeur, si le nombre
     * de jetons bleus disponibles est strictement supérieur à zéro.
     * @param recoitIndice la carte qui reçoit l'indice
     * @param natureIndice la nature de l'indice: 'c' pour la couleur,
     *        'v' pour la valeur
     * @throws IllegalArgumentException si natureIndice n'est ni 'c'
     *         ni 'v'
     * @throws IllegalStateException si le nombre de jetons bleus est
     *         égal à zéro
     */
    public void donnerIndice(Carte recoitIndice, char natureIndice) {
        //FIXME Trouver comment situer la carte pour donner indice
        //aux autres cartes de la main
        
        //TODO vérifier nb jetons bleus
        //TODO vérif que indice pas dja donné
        //TODO setIndice en fction de sa nature
    }
    
    /**
     * Pose une carte sur les cartes posées sur le plateau si elle 
     * est valide, sinon octroi un jeton rouge à l'équipe.
     * Si la carte posée complète un feu d'artifice, un jeton bleu
     * est octroyé à l'équipe si elle n'en possède pas déjà le nombre
     * maximal.
     * Si la pioche n'est pas vide, une carte est ensuite ajoutée à  
     * la main du joueur.
     * @param carteAPoser la carte que le joueur pose sur le plateau
     */
    public void poser(Carte carteAPoser) {
        //TODO vérif que carte complète
        //TODO si complète pas, rouge++
        //TODO mais jsais pas où: stop game si rouge == 3
        //TODO si valeur de posée == 5, bleu++ si bleu < 8
        //TODO Filer carte joueur si pioche pas vide
        //TODO lastTour si pioche vide, trouver pour end
    }

    /** 
     * Défausse la carte du joueur et octroie un jeton bleu à
     * l'équipe si elle n'en possède pas déjà le nombre maximal.
     * Si la pioche n'est pas vide, une carte est ensuite ajoutée à  
     * la main du joueur.
     * @param carteADefausser la carte que le joueur souhaite 
     *        défausser
     */
    public void defausser(Carte carteADefausser) {
        //TODO Si bleu < nbMaxJetonsBleus, bleus++
        //TODO Filer carte joueur si pioche pas vide
       //TODO lastTour si pioche vide, trouver pour end
    }
}
