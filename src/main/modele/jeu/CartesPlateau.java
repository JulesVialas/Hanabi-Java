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
     * La taille des piles est définie par la constante 
     * TAILLE_MAX_PILES_CARTES.
     */
    public CartesPlateau() {
        
        /* Initialise les piles en indiquant leur taille maximum */
        pileRouge.setSize(TAILLE_MAX_PILES_CARTES);
        pileJaune.setSize(TAILLE_MAX_PILES_CARTES);
        pileBleu.setSize(TAILLE_MAX_PILES_CARTES);
        pileVert.setSize(TAILLE_MAX_PILES_CARTES);
        pileBlanc.setSize(TAILLE_MAX_PILES_CARTES);
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
     * La carte doit être de couleur rouge.
     * 
     * @param aPoser la carte a poser sur la pile de cartes rouges 
     * @throws IllegalArgumentException si la couleur de la carte
     *                                  n'est pas ROUGE
     */
    public void setPileRouge(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes jaunes du plateau.
     * La carte doit être de couleur jaune.
     * 
     * @param aPoser la carte a poser sur la pile de cartes jaunes 
     * @throws IllegalArgumentException si la couleur de la carte
     *                                  n'est pas JAUNE
     */
    public void setPileJaune(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes vertes du plateau.
     * La carte doit être de couleur verte.
     * 
     * @param aPoser la carte a poser sur la pile de cartes vertes 
     * @throws IllegalArgumentException si la couleur de la carte
     *                                  n'est pas VERT
     */
    public void setPileVert(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes bleues du plateau.
     * La carte doit être de couleur bleue.
     * 
     * @param aPoser la carte a poser sur la pile de cartes bleues 
     * @throws IllegalArgumentException si la couleur de la carte
     *                                  n'est pas BLEU
     */
    public void setPileBleu(Carte aPoser) {
        //TODO
    }
    
    /**
     * Pose une carte sur la pile de cartes blanches du plateau.
     * La carte doit être de couleur blanche.
     * 
     * @param aPoser la carte a poser sur la pile de cartes blanches 
     * @throws IllegalArgumentException si la couleur de la carte
     *                                  n'est pas BLANC
     */
    public void setPileBlanc(Carte aPoser) {
        //TODO
    }
}