/*
 * Tour.java                                            18/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

/**
 * Le tour d'une partie d'Hanabi est caractérisé par un numéro et un joueur.
 * Durant un tour, le joueur doit effectuer une action parmi les quatre
 * suivantes :
 * <ul>
 * <li>donner un indice sur la couleur d'une carte d'un de ses équipiers;</li>
 * <li>donner un indice sur la valeur d'une carte d'un de ses équipiers;</li>
 * <li>défausser une carte pour récupérer un jeton bleu;</li>
 * <li>poser une carte, pour compléter les feux d'artifices</li>
 * </ul>
 * 
 * @author Corentin Solignac
 */
public class Tour {

    /** Message d'erreur en cas de numéro de tour invalide */
    private static final String ERREUR_NUMERO_TOUR_INVALIDE
    = "Erreur: le numéro de tour doit être supérieur ou égal à 1";

    private static final String INDICE_DEJA_CONNU 
    = "L'indice est déjà connu par le joueur";

    private static final String ERREUR_JETONS_BLEUS_INSUFFISANTS 
    = "Erreur: il n'y a pas assez de jetons bleus pour donner un indice" ;

    private static final String ERREUR_SAISIE_NATURE_INDICE
    = "Erreur: la nature de l'indice doit être 'c' pour couleur " 
        + "ou 'v' pour valeur" ;

    /** La partie dans laquelle le tour s'inscrit */
    private Partie partieDuTour;
    
    /** Le joueur qui doit effectuer une action durant le tour */
    private Joueur joueurCourant;

    /** Le numéro de tour */
    private int numero;

    /**
     * Instancie un objet de type Tour. Un numéro de tour ne peut pas être
     * strictement inférieur à un.
     * 
     * @param artificier le joueur à qui ce sera le tour
     * @param numeroTour le numéro de tour
     * @param partieDuTour la partie dans laquelle le tour s'inscrit
     * @throws IllegalArgumentException si le numéro de tour est strictement
     *                                  inférieur à 1
     */
    public Tour(Joueur artificier, int numeroTour) {

        if (numeroTour < 1) {
            throw new IllegalArgumentException(ERREUR_NUMERO_TOUR_INVALIDE);
        }

        this.joueurCourant = artificier;
        this.numero = numeroTour;
        this.partieDuTour = null;
    }

    /**
     * @return la partie dans laquelle le tour s'incrit
     */
    public Partie getPartieDuTour() {
        return this.partieDuTour;
    }
    
    /**
     * @param partieALier la partie à lier au tour
     */
    public void setPartieDuTour(Partie partieALier) {
        this.partieDuTour = partieALier;
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
     * Donne un indice sur une carte, couleur ou valeur, si le 
     * nombre de jetons bleus disponibles est strictement supérieur
     * à zéro.
     * Une carte peut recevoir plusieurs fois le même indice sans que
     * cela pose problème.
     * Lorsqu'un indice est donné, on le propage aux cartes de la main 
     * du joueur répondant au même critère.
     * 
     * @param recepteur    Le joueur qui reçoit l'indice
     * @param recoitIndice la carte qui reçoit l'indice
     * @param natureIndice la nature de l'indice: 'c' pour la couleur, 'v' pour la
     *                     valeur
     * @throws IllegalArgumentException si natureIndice n'est ni 'c' ni 'v'
     * @throws IllegalArgumentException si le joueur recevant 
     *         l'indice est le même qui donne l'indice 
     * @throws IllegalStateException    si le nombre de jetons bleus est égal à zéro
     */
    public void donnerIndice(Joueur recepteur, Carte recoitIndice, 
        char natureIndice) {
        // FIXME Empecher joueur de se donner indice à soi-même ?
        // ou alors qu'en graphique ?
        
        if (partieDuTour.getJetons().getBleus() <= 0) {
            throw new IllegalStateException(ERREUR_JETONS_BLEUS_INSUFFISANTS);
        }
        if (natureIndice != 'c' && natureIndice != 'v') {
            throw new IllegalArgumentException(ERREUR_SAISIE_NATURE_INDICE);
        }
        
        for (Carte carte : recepteur.getCartesEnMains()) {
            if (natureIndice == 'c' 
                    && carte.getCouleurConnue() == recoitIndice
                                                   .getCouleurConnue() ) {
                carte.setCouleurConnue(true);
            } else if (natureIndice == 'v' 
                           && carte.getValeurConnue() 
                               == recoitIndice.getValeurConnue()) {
                carte.setValeurConnue(true);
            }
        }
        /* On propage l'indice */
        propagerIndice(natureIndice, recoitIndice, recepteur);
        
        /* On enlève un jeton bleu */
        partieDuTour.getJetons().decrementBleus();
    }

    /** 
     * Propage l'indice donné à une carte aux autres cartes
     * de la main du joueur répondant au même critères.
     * 
     * @param natureIndice la nature de l'indice que l'on souhaite 
     *        propager
     * @param valeurIndice la carte dont on souhaite connaitre les
     *        caractéristiques pour pouvoir les propager
     * @param artificier le joueur qui possède la main dans laquelle
     *        on souhaite propager l'indice      
     * @throws IllegalStateException si la carte n'est pas dans la 
     *         main d'un joueur.
     */
    private static void propagerIndice(char natureIndice, Carte valeurIndice,
            Joueur artificier) {
        
        /* Indique si la nature de l'indice est couleur ou valeur */
        boolean indiceCouleur;
        
        indiceCouleur = natureIndice == 'c';
        
        if (indiceCouleur) {
            for (Carte cartes : artificier.getCartesEnMains()) {
                if (cartes.getCouleur() == valeurIndice.getCouleur()) {
                    cartes.setCouleurConnue(true);
                }
            }
        } else { // La nature de l'indice est valeur
            for (Carte cartes : artificier.getCartesEnMains()) {
                if (cartes.getValeur() == valeurIndice.getValeur()) {
                    cartes.setValeurConnue(true);
                }
            }
        }
    }
    
    /**
     * Pose une carte sur les cartes posées sur le plateau si elle est valide, sinon
     * octroi un jeton rouge à l'équipe. Si la carte posée complète un feu
     * d'artifice, un jeton bleu est octroyé à l'équipe si elle n'en possède pas
     * déjà le nombre maximal. Si la pioche n'est pas vide, une carte est ensuite
     * ajoutée à la main du joueur.
     * 
     * @param carteAPoser la carte que le joueur pose sur le plateau
     */
    public void poser(Carte carteAPoser) {
        // TODO vérif que carte complète
        // TODO si complète pas, rouge++
        // TODO mais jsais pas où: stop game si rouge == 3
        // TODO si valeur de posée == 5, bleu++ si bleu < 8
        // TODO Filer carte joueur si pioche pas vide
        // TODO lastTour si pioche vide, trouver pour end
    }

    /**
     * Défausse la carte du joueur et octroie un jeton bleu à l'équipe si elle n'en
     * possède pas déjà le nombre maximal. Si la pioche n'est pas vide, une carte
     * est ensuite ajoutée à la main du joueur.
     * 
     * @param carteADefausser la carte que le joueur souhaite défausser
     */
    public void defausser(Carte carteADefausser) {
        // TODO Si bleu < nbMaxJetonsBleus, bleus++
        // TODO Filer carte joueur si pioche pas vide
        // TODO lastTour si pioche vide, trouver pour end
    }
}
