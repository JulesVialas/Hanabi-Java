/*
 * CartesPlateau.java                                            24 mai 2024
 * IUT de Rodez, TP42, pas de copyright
 */
package modele.jeu;

import java.util.Stack;

/**
 * Les cinq piles de feux d'artifice posés sur le plateau de jeu.
 * Une pile de feux d'artifices peut être vide, ou comporter au 
 * maximum 5 cartes.
 * Cette classe permet la manipulation de ces piles.
 * 
 * @author Corentin Solignac
 */
public class CartesPlateau {
    
    private static final String ERREUR_MAUVAISE_COULEUR 
    = "Erreur: la couleur de la carte à poser doit être de la même couleur "
            + "que celle de la pile";

    private static final String ERREUR_MAUVAISE_VALEUR 
    = "Erreur: la valeur de la carte à poser doit être la valeur suivante"
    + " de la valeur de la dernière carte de la pile";

    /** La taille maximale des piles de cartes */
    public final int TAILLE_MAX_PILES_CARTES = 5;
    
    /** La pile de cartes rouges */
    private Stack<Carte> pileRouge;
    
    /** La pile de cartes jaunes */
    private Stack<Carte> pileJaune;
    
    /** La pile de cartes bleus */
    private Stack<Carte> pileBleu;
    
    /** La pile de cartes vertes */
    private Stack<Carte> pileVert;
    
    /** La pile de cartes blanches */
    private Stack<Carte> pileBlanc;
    
    /**
     * Instancie un objet de type CartesPlateau qui contient les 
     * piles de cartes de chaque couleur du jeu Hanabi.
     * Il n'est pas nécessaire de définir la longueur maximale
     * de la pile suite aux prérequis mis en place pour ajouter
     * une carte sur la pile.
     */
    public CartesPlateau() {
        
        /* Initialise les piles en indiquant leur taille maximum */
        pileRouge = new Stack<>();
        pileJaune = new Stack<>();
        pileBleu = new Stack<>();
        pileVert = new Stack<>();
        pileBlanc = new Stack<>();
    }
    
    /**
     * @return la pile de cartes rouges
     */
    public Stack<Carte> getPileRouge() {
        return pileRouge;

    }
    
    /**
     * @return la pile de cartes jaunes
     */
    public Stack<Carte> getPileJaune() {
        return pileJaune;
    }
    
    /**
     * @return la pile de cartes vertes
     */
    public Stack<Carte> getPileVert() {
        return pileVert;
    }
    
    /**
     * @return la pile de cartes bleues
     */
    public Stack<Carte> getPileBleu() {
        return pileBleu;
    }
    
    /**
     * @return la pile de cartes blanches
     */
    public Stack<Carte> getPileBlanc() {
        return pileBlanc;
    }
    
    /**
     * Pose une carte sur la pile de cartes rouges du plateau.
     * La carte doit être de couleur rouge, et sa valeur un cran
     * au dessus de la dernière carte posée.
     * 
     * @param aPoser la carte a poser sur la pile de cartes rouges 
     * @throws IllegalArgumentException si la couleur de la carte
     *         n'est pas ROUGE ou si la valeur n'est pas la suivante
     *         par rapport à la dernière carte de la pile
     */
    public void setPileRouge(Carte aPoser) {
        
        
        // Vérifie qu'il s'agit de la bonne couleur
        if (aPoser.getCouleur() != Couleur.ROUGE) {
            throw new IllegalArgumentException(ERREUR_MAUVAISE_COULEUR);
        } 
        
        if (pileRouge.empty() &&  aPoser.getValeur() != Valeur.UN
            || (!pileRouge.empty() 
                    && aPoser.getValeur().getValeurNumerique()
                      != pileRouge.peek().getValeur()
                                         .getValeurNumerique() + 1
               )
            ) {
            throw new IllegalArgumentException(ERREUR_MAUVAISE_VALEUR);
        }
        this.pileRouge.push(aPoser);
    }
    
    /**
     * Pose une carte sur la pile de cartes jaunes du plateau.
     * La carte doit être de couleur jaune, et sa valeur un cran
     * au dessus de la dernière carte posée.
     * 
     * @param aPoser la carte a poser sur la pile de cartes jaunes 
     * @throws IllegalArgumentException si la couleur de la carte
     *         n'est pas JAUNE ou si la valeur n'est pas la suivante
     *         par rapport à la dernière carte de la pile
     */
    public void setPileJaune(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes vertes du plateau.
     * La carte doit être de couleur verte, et sa valeur un cran
     * au dessus de la dernière carte posée.
     * 
     * @param aPoser la carte a poser sur la pile de cartes vertes 
     * @throws IllegalArgumentException si la couleur de la carte
     *         n'est pas VERT ou si la valeur n'est pas la suivante
     *         par rapport à la dernière carte de la pile
     */
    public void setPileVert(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes bleues du plateau.
     * La carte doit être de couleur bleue, et sa valeur un cran
     * au dessus de la dernière carte posée.
     * 
     * @param aPoser la carte a poser sur la pile de cartes bleues 
     * @throws IllegalArgumentException si la couleur de la carte
     *         n'est pas BLEU ou si la valeur n'est pas la suivante
     *         par rapport à la dernière carte de la pile
     */
    public void setPileBleu(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes blanches du plateau.
     * La carte doit être de couleur blanche, et sa valeur un cran
     * au dessus de la dernière carte posée.
     * 
     * @param aPoser la carte a poser sur la pile de cartes blanches 
     * @throws IllegalArgumentException si la couleur de la carte
     *         n'est pas BLANC ou si la valeur n'est pas la suivante
     *         par rapport à la dernière carte de la pile
     */
    public void setPileBlanc(Carte aPoser) {
        //TODO
    }
}