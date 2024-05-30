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

    private static final String ERREUR_INDICE_SOI_MEME 
    = "Erreur: il n'est pas possible de donner un indice sur les cartes"
    + " de sa propre main";

    private static final String ERREUR_CARTE_PAS_DANS_MAIN 
    = "Erreur: aucun joueur ne possède la carte indiquée dans sa main";

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
     * @param natureIndice la nature de l'indice: 'c' pour la couleur, 
     *        'v' pour la valeur
     * @throws IllegalArgumentException si natureIndice n'est ni 'c' ni 'v'
     * @throws IllegalArgumentException si le joueur recevant 
     *         l'indice n'est pas le joueur possédant la carte recevant 
     *         l'indice 
     * @throws IllegalStateException si le joueur recevant 
     *         l'indice est le même qui donne l'indice 
     * @throws IllegalStateException si le nombre de jetons bleus est 
     *         égal à zéro
     */
    public void donnerIndice(Carte recoitIndice, char natureIndice) {
        
        /* On détermine quel joueur possède la carte */
        Joueur recepteur = determinerJoueurAyantCarte(recoitIndice);
        
        /* On empèche le joueur de se donner un indice à lui-même */
        if (recepteur == joueurCourant) {
            throw new IllegalStateException(ERREUR_INDICE_SOI_MEME);
        }
        
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
        propagerIndice(natureIndice, recoitIndice);
        
        /* On enlève un jeton bleu */
        partieDuTour.getJetons().decrementBleus();
    }

    /**
     * Détermine quel joueur possède la carte indiquée.
     * 
     * @param aSituer la carte dont on souhaite connaître le propriétaire
     * @return le joueur possédant la carte dans sa main
     * @throws IllegalStateException si aucun joueur ne possède la carte
     */
    private Joueur determinerJoueurAyantCarte(Carte aSituer) {
        
        if (partieDuTour.getJoueur1().getCartesEnMains().contains(aSituer)) {
            return partieDuTour.getJoueur1();
        }
        
        if (partieDuTour.getJoueur2().getCartesEnMains().contains(aSituer)) {
            return partieDuTour.getJoueur2();
        }
        
        if (partieDuTour.getJoueur2().getCartesEnMains().contains(aSituer)) {
            return partieDuTour.getJoueur2();
        }
        
        if (partieDuTour.getJoueur2().getCartesEnMains().contains(aSituer)) {
            return partieDuTour.getJoueur2();
        }
        
        if (partieDuTour.getJoueur2().getCartesEnMains().contains(aSituer)) {
            return partieDuTour.getJoueur2();
        }

        /* Si aucun joueur ne possède la carte */
        throw new IllegalStateException(ERREUR_CARTE_PAS_DANS_MAIN);
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
    private void propagerIndice(char natureIndice, Carte valeurIndice) {
        
        Joueur artificier = determinerJoueurAyantCarte(valeurIndice);
        
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
     * Pose une carte sur les cartes posées sur le plateau si elle 
     * est valide, sinon octroi un jeton rouge à l'équipe. Si la 
     * carte posée complète un feu d'artifice, un jeton bleu est 
     * octroyé à l'équipe si elle n'en possède pas déjà le nombre
     * maximal. Si la pioche n'est pas vide, une carte est ensuite 
     * ajoutée à la main du joueur.
     * 
     * @param carteAPoser la carte que le joueur pose sur le plateau
     */
    public void poser(Carte carteAPoser) {
        
        boolean doesContinueFirework; // Indique si la carte continue le feu
        doesContinueFirework = false;
        
        if (doesContinueFirework(carteAPoser)) {
            switch(carteAPoser.getCouleur()) {
                case ROUGE:
                        /* On mets la carte sur pile rouge */
                        partieDuTour.getFeuxPosesRouge().push(carteAPoser);
                    break;
                case JAUNE:
                        partieDuTour.getFeuxPosesJaune().push(carteAPoser);
                    break;
                case VERT:
                        partieDuTour.getFeuxPosesVert().push(carteAPoser);
                    break;
                case BLEU:
                        partieDuTour.getFeuxPosesBleu().push(carteAPoser);
                    break;
                default: //case Couleur.BLANC:
                        partieDuTour.getFeuxPosesBlanc().push(carteAPoser);
                    break;     
            }
            
            if (// Carte posée est 5 donc termine le feu
                carteAPoser.getValeur().getValeurNumerique() == 5
                    && partieDuTour.getJetons().getBleus() 
                       < JetonsPlateau.NB_JETONS_BLEUS_MAX) {
                
                /* On ajoute un jeton bleu s'il ne sont pas au maximum */
                    partieDuTour.getJetons().incrementBleus();
            }
            
        } else { // Carte invalide 
            /* On défausse la carte */
            partieDuTour.getDefausse().push(carteAPoser);                        
                
            /* On ajoute un jeton rouge */
            partieDuTour.getJetons().incrementRouges();
        }
        
        if (doesContinueFirework // Carte posée est 5 donc termine le feu
                && carteAPoser.getValeur().getValeurNumerique() == 5
                && partieDuTour.getJetons().getBleus() 
                   < JetonsPlateau.NB_JETONS_BLEUS_MAX) {
            
            /* On ajoute un jeton bleu s'il ne sont pas au maximum */
                partieDuTour.getJetons().incrementBleus();
        }

        /* On enlève la carte jouée de la main du joueur */
        joueurCourant.getCartesEnMains().remove(carteAPoser);
        
        /* On lui en donne une nouvelle s'il en reste dans la pioche */
        if (!partieDuTour.getPioche().isEmpty()) {
            
            joueurCourant.getCartesEnMains().add(partieDuTour
                                            .getPioche().pop());
        }
        // TODO mais jsais pas où: stop game si rouge == 3
        // TODO lastTour si pioche vide, trouver pour end => 
        // mettre vérif à chaque fin d'action en fonction de ce qui peut arriver
        // (0 pioche ou rouges) ? Pcq tour dépend de l'action !
    }

    /**
     * Vérifie qu'une carte peut continue le feu d'artifice de
     * sa couleur si elle est posée.
     * 
     * @param aTester la carte dont on veut déterminer si elle 
     *        continue ou non le feux d'artifice de sa couleur.
     * @return true si elle continue le feu d'artifice de sa couleur,
     *         sinon false
     */
    private boolean doesContinueFirework(Carte aTester) {
       
        switch(aTester.getCouleur()) {
            case ROUGE:
                /*
                 *  On teste si la valeur de la carte à poser est la suivante
                 *  attendue, et si la valeur == 1 si la pile est vide pour 
                 *  éviter de throw EmptyStackException.
                 */
                return partieDuTour.getFeuxPosesRouge().empty() 
                        && aTester.getValeur() == Valeur.UN
                  || aTester.getValeur().getValeurNumerique() 
                      == partieDuTour.getFeuxPosesRouge()
                                     .peek().getValeur().getValeurNumerique()
                                     + 1;
            case JAUNE:
                return partieDuTour.getFeuxPosesJaune().empty() 
                        && aTester.getValeur() == Valeur.UN
                  || aTester.getValeur().getValeurNumerique() 
                      == partieDuTour.getFeuxPosesJaune()
                                     .peek().getValeur().getValeurNumerique()
                                     + 1;
            case VERT:
                return partieDuTour.getFeuxPosesVert().empty() 
                        && aTester.getValeur() == Valeur.UN
                  || aTester.getValeur().getValeurNumerique() 
                      == partieDuTour.getFeuxPosesVert()
                                     .peek().getValeur().getValeurNumerique()
                                     + 1;    
            case BLEU:
                return partieDuTour.getFeuxPosesBleu().empty() 
                        && aTester.getValeur() == Valeur.UN
                  || aTester.getValeur().getValeurNumerique() 
                      == partieDuTour.getFeuxPosesBleu()
                                     .peek().getValeur().getValeurNumerique()
                                     + 1;   
            default: //case Couleur.BLANC:
                return partieDuTour.getFeuxPosesBlanc().empty() 
                        && aTester.getValeur() == Valeur.UN
                  || aTester.getValeur().getValeurNumerique() 
                      == partieDuTour.getFeuxPosesBlanc()
                                     .peek().getValeur().getValeurNumerique()
                                     + 1;
        }
    }

    /**
     * Défausse la carte du joueur et octroie un jeton bleu à 
     * l'équipe si elle n'en possède pas déjà le nombre maximal. 
     * Si la pioche n'est pas vide, une carte est ensuite ajoutée 
     * à la main du joueur.
     * 
     * @param carteADefausser la carte que le joueur souhaite défausser
     * @throws IllegalStateException si le nombre de jetons bleus
     *         est insuffisant
     */
    public void defausser(Carte carteADefausser) {
        
        /* On ajoute la carte à la défausse */
        getPartieDuTour().getDefausse().push(carteADefausser);
        
        /* On enlève la carte du jeu du joueur */
        joueurCourant.getCartesEnMains().remove(carteADefausser);
        
        /* Si la pioche n'est pas vide on donne une carte */
        if (!partieDuTour.getPioche().isEmpty()) {
            
            joueurCourant.getCartesEnMains().add(partieDuTour
                                            .getPioche().pop());
        }
        
        /* On ajoute 1 jeton bleu à la partie si le nb max n'est pas atteint */
        if (partieDuTour.getJetons().getBleus() 
                < JetonsPlateau.NB_JETONS_BLEUS_MAX) {
            
            partieDuTour.getJetons().incrementBleus();
        }
        // TODO lastTour si pioche vide, trouver pour end
    }
}
