/*
 * Partie.java                                            24 mai 2024
 * IUT de Rodez, TP42, pas de copyright
 */
package modele.jeu;

/**
 * Le jeu de société Hanabi est un jeu coopératif, c'est-à-dire un 
 * jeu dans lequel les joueurs ne s'affrontent pas mais font équipe
 * pour atteindre un objectif commum. Ils interprètent ici des 
 * artificiers distraits qui ont mélangé par mégarde les pourdres,
 * mèches et fusées d'un grand feu d'artifice. La représentation va
 * commencer et c'est un peu la panique. Il leur faudra s'entraider
 * pour que le spectacle ne tourne pas à la catastrophe !
 * 
 * Le but des artificiers est de composer 5 feux d'artifice, un de 
 * chaque couleur (BLANC, ROUGE, BLEU, JAUNE, VERT), en constituant 
 * des suites croissantes (1,2,3,4,5) avec des cartes de même couleur.
 * 
 * Les règles du jeu sont disponibles à l'adresse 
 * {@link "https://www.ludicbox.fr/ressources/9088-regle-du-jeu-Hanabi.pdf"}.
 */
public class Partie {

    /** L'identifiant de la partie */
    private int identifiant; //FIXME trouver qqc d'unique => hash datePseudosHeure ?
    
    /** Joueur 1 de la partie */
    private Joueur joueur1;
    
    /** Joueur 2 de la partie */
    private Joueur joueur2;
    
    /** Joueur 3 de la partie */
    private Joueur joueur3;
    
    /** Joueur 4 de la partie */
    private Joueur joueur4;
    
    /** Joueur 5 de la partie */
    private Joueur joueur5;
    
    /** Les piles de cartes accueillant les feux d'artifices */
    private CartesPlateau feuxPoses;
    
    /** Les piles de jetons bleus et rouges */
    private JetonsPlateau jetons;
    
    /** La pioche de la partie */
    private Pioche pioche;
    
    /** La défausse de la partie */
    private Defausse defausse;
    
    /** Le tour en cours */
    private Tour tourCourant;
    
    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau
     * (vides au début de la partie) qui sont en fait les suites des
     * feux d'artifices posés, des jetons bleus et rouges, 
     * une pioche et une défausse.
     * 
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     */
    public Partie(String pseudoJ1, String pseudoJ2) {
        identifiant = 1; //TODO stub
        
        //FIXME vérif si faut set NULL pour 3 autres
        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        
        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche(); 
        defausse = new Defausse();
        
        //TODO Distribuer les cartes aux joueurs pour débuter partie :)
        
        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }
    
    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau
     * (vides au début de la partie) qui sont en fait les suites des
     * feux d'artifices posés, des jetons bleus et rouges, 
     * une pioche et une défausse.
     * 
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3) {
        identifiant = 1; //TODO stub
        
        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        
        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();
        
        //TODO Distribuer les cartes aux joueurs pour débuter partie :)
        
        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }
    
    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau
     * (vides au début de la partie) qui sont en fait les suites des
     * feux d'artifices posés, des jetons bleus et rouges, 
     * une pioche et une défausse.
     * 
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     * @param pseudoJ4 le pseudo du joueur 4
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3,
        String pseudoJ4) {
        identifiant = 1; //TODO stub
        
        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        joueur4 = new Joueur(pseudoJ4);
        
        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();
        
        //TODO Distribuer les cartes aux joueurs pour débuter partie :)
        
        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }
    
    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau
     * (vides au début de la partie) qui sont en fait les suites des
     * feux d'artifices posés, des jetons bleus et rouges, 
     * une pioche et une défausse.
     * 
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     * @param pseudoJ4 le pseudo du joueur 4
     * @param pseudoJ5 le pseudo du joueur5
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3,
        String pseudoJ4, String pseudoJ5) {
        identifiant = 1; //TODO stub
        
        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        joueur4 = new Joueur(pseudoJ4);
        joueur4 = new Joueur(pseudoJ5);
        
        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();
        
        //TODO Distribuer les cartes aux joueurs pour débuter partie :)
        
        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }
    
    /**
     * @return les jetons du plateau
     */
    public JetonsPlateau getJetons() {
        return this.jetons;
    }
    
    /**
     * @return le joueur 1
     */
    public Joueur getJoueur1() {
        return this.joueur1;
    }
    
    /**
     * @return le joueur 2
     */
    public Joueur getJoueur2() {
        return this.joueur2;
    }
    
    /**
     * @return le joueur 3
     */
    public Joueur getJoueur3() {
        return this.joueur3;
    }
    
    /**
     * @return le joueur 4
     */
    public Joueur getJoueur4() {
        return this.joueur4;
    }
    
    /**
     * @return le joueur 5
     */
    public Joueur getJoueur5() {
        return this.joueur5;
    }
}
