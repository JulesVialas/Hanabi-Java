/*
 * Partie.java                                            24/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import java.util.EmptyStackException;
import java.util.Stack;

import jeu.utilitaire.PersistanceHanabi;

/**
 * Le jeu de société Hanabi est un jeu coopératif, c'est-à-dire un jeu
 * dans lequel les joueurs ne s'affrontent pas mais font équipe pour
 * atteindre un objectif commum. Ils interprètent ici des artificiers
 * distraits qui ont mélangé par mégarde les pourdres, mèches et
 * fusées d'un grand feu d'artifice. La représentation va commencer et
 * c'est un peu la panique. Il leur faudra s'entraider pour que le
 * spectacle ne tourne pas à la catastrophe !
 *
 * Le but des artificiers est de composer 5 feux d'artifice, un de
 * chaque couleur (BLANC, ROUGE, BLEU, JAUNE, VERT), en constituant
 * des suites croissantes (1,2,3,4,5) avec des cartes de même couleur.
 *
 * Les règles du jeu sont disponibles à l'adresse
 * {@link "https://www.ludicbox.fr/ressources/9088-regle-du-jeu-Hanabi.pdf"}.
 */
public class Partie {

    /* Nombre de cartes dans la main des joueurs pour partie à 2 et 3 */
    private static final int NB_CARTES_2_3_JOUEURS = 5;

    /* Nombre de cartes dans la main des joueurs pour partie à 4 et 5 */
    private static final int NB_CARTES_4_5_JOUEURS = 4;

    /** L'identifiant de la partie */
    private long identifiant;

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
     * allant de 2 à 5, des paquets de cartes posés sur le plateau (vides
     * au début de la partie) qui sont en fait les suites des feux
     * d'artifices posés, des jetons bleus et rouges, une pioche et une
     * défausse.
     *
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     */
    public Partie(String pseudoJ1, String pseudoJ2) {
        identifiant = PersistanceHanabi.genererIDPartie();

        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur1.setNumero(1);
        joueur2.setNumero(2);

        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();

        /* Distribution des cartes */
        distribuerCartes(joueur1, NB_CARTES_2_3_JOUEURS);
        distribuerCartes(joueur2, NB_CARTES_2_3_JOUEURS);

        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }

    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau (vides
     * au début de la partie) qui sont en fait les suites des feux
     * d'artifices posés, des jetons bleus et rouges, une pioche et une
     * défausse.
     *
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3) {
        identifiant = PersistanceHanabi.genererIDPartie();

        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        joueur1.setNumero(1);
        joueur2.setNumero(2);
        joueur3.setNumero(3);

        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();

        /* Distribution des cartes */
        distribuerCartes(joueur1, NB_CARTES_2_3_JOUEURS);
        distribuerCartes(joueur2, NB_CARTES_2_3_JOUEURS);
        distribuerCartes(joueur3, NB_CARTES_2_3_JOUEURS);

        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }

    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau (vides
     * au début de la partie) qui sont en fait les suites des feux
     * d'artifices posés, des jetons bleus et rouges, une pioche et une
     * défausse.
     *
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     * @param pseudoJ4 le pseudo du joueur 4
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3,
            String pseudoJ4) {
        identifiant = PersistanceHanabi.genererIDPartie();

        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        joueur4 = new Joueur(pseudoJ4);
        joueur1.setNumero(1);
        joueur2.setNumero(2);
        joueur3.setNumero(3);
        joueur4.setNumero(4);

        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();

        /* Distribution des cartes */
        distribuerCartes(joueur1, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur2, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur3, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur4, NB_CARTES_4_5_JOUEURS);

        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
    }

    /**
     * Une partie de Hanabi est caractérisée par un nombre de joueurs
     * allant de 2 à 5, des paquets de cartes posés sur le plateau (vides
     * au début de la partie) qui sont en fait les suites des feux
     * d'artifices posés, des jetons bleus et rouges, une pioche et une
     * défausse.
     *
     * @param pseudoJ1 le pseudo du joueur 1
     * @param pseudoJ2 le pseudo du joueur 2
     * @param pseudoJ3 le pseudo du joueur 3
     * @param pseudoJ4 le pseudo du joueur 4
     * @param pseudoJ5 le pseudo du joueur5
     */
    public Partie(String pseudoJ1, String pseudoJ2, String pseudoJ3,
            String pseudoJ4, String pseudoJ5) {
        identifiant = PersistanceHanabi.genererIDPartie();

        /* Instanciation des joueurs */
        joueur1 = new Joueur(pseudoJ1);
        joueur2 = new Joueur(pseudoJ2);
        joueur3 = new Joueur(pseudoJ3);
        joueur4 = new Joueur(pseudoJ4);
        joueur5 = new Joueur(pseudoJ5);
        joueur1.setNumero(1);
        joueur2.setNumero(2);
        joueur3.setNumero(3);
        joueur4.setNumero(4);
        joueur5.setNumero(5);

        /* Préparation du jeu */
        feuxPoses = new CartesPlateau();
        jetons = new JetonsPlateau();
        pioche = new Pioche();
        defausse = new Defausse();

        /* Distribution des cartes */
        distribuerCartes(joueur1, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur2, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur3, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur4, NB_CARTES_4_5_JOUEURS);
        distribuerCartes(joueur5, NB_CARTES_4_5_JOUEURS);

        /* Lancement de la partie */
        tourCourant = new Tour(joueur1, 1);
        tourCourant.setPartieDuTour(this);
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

    /**
     * @return la pioche
     */
    public Stack<Carte> getPioche() {
        return this.pioche.getPaquet();
    }

    /**
     * @return la défausse
     */
    public Stack<Carte> getDefausse() {
        return this.defausse.getPaquet();
    }

    /**
     * @return la pile de feux d'artifices jaunes posés
     */
    public Stack<Carte> getFeuxPosesJaune() {
        return this.feuxPoses.getPileJaune();
    }

    /**
     * @return la pile de feux d'artifices verts posés
     */
    public Stack<Carte> getFeuxPosesVert() {
        return this.feuxPoses.getPileVert();
    }

    /**
     * @return la pile de feux d'artifices bleu posés
     */
    public Stack<Carte> getFeuxPosesBleu() {
        return this.feuxPoses.getPileBleu();
    }

    /**
     * @return la pile de feux d'artifices blancs posés
     */
    public Stack<Carte> getFeuxPosesBlanc() {
        return this.feuxPoses.getPileBlanc();
    }

    /**
     * @return la pile de feux d'artifices rouges posés
     */
    public Stack<Carte> getFeuxPosesRouge() {
        return this.feuxPoses.getPileRouge();
    }

    /**
     * Distribue le nombre de cartes souhaité de la pioche à un joueur.
     * Cette méthode sert uniquement à la distribution lors du début de
     * partie.
     *
     * @param receveurCarte le joueur recevant les cartes
     * @param nbCarte       le nombre de cartes à donner au joueur
     */
    private void distribuerCartes(Joueur receveurCarte, int nbCarte) {
        for (int index = 0; index < nbCarte; index++) {
            receveurCarte.getCartesEnMains().add(pioche.getPaquet().pop());
        }
    }

    /**
     * Calcule le score de l'équipe. Pour rappel le score est calculé en
     * additionnant la plus haute valeur de chacun des 5 feux d'artifice.
     *
     * @return le score de l'équipe
     */
    public int calculerScore() {

        int somme;
        somme = 0;

        try {
            somme = somme + getFeuxPosesRouge().peek().getValeur()
                    .getValeurNumerique();
        } catch (EmptyStackException e) {
            // empty body; => si pile vide alors aucune carte du feu posée
        }

        try {
            somme = somme + getFeuxPosesJaune().peek().getValeur()
                    .getValeurNumerique();
        } catch (EmptyStackException e) {
            // empty body;
        }

        try {
            somme = somme + getFeuxPosesVert().peek().getValeur()
                    .getValeurNumerique();
        } catch (EmptyStackException e) {
            // empty body;
        }

        try {
            somme = somme + getFeuxPosesBleu().peek().getValeur()
                    .getValeurNumerique();
        } catch (EmptyStackException e) {
            // empty body;
        }

        try {
            somme = somme + getFeuxPosesBlanc().peek().getValeur()
                    .getValeurNumerique();
        } catch (EmptyStackException e) {
            // empty body;
        }

        return somme;
    }

    /**
     * Indique si la partie est terminée. Pour que la partie soit terminée
     * il faut que l'un des 3 cas suivant se présente:
     * <ul>
     * <li>les jetons rouges sont au nombre de 3</li>
     * <li>tous les feux d'artifices sont complétés</li>
     * <li>chaque joueur a joué une dernière fois après qu'un membre de
     * l'équipe ait pioché la dernière carte (y compris ce dernier)</li>
     * </ul>
     *
     * @return true si la partie est finie, false sinon
     */
    public boolean isPartieFinie() {
        // TODO trouver pour le cas de la pioche finie donc
        // dernier tour pour chaque joueur

        return getJetons().getRouges() == 3 || areFireworksCompleted();
        // TODO dernier tour de table a eu lieu
        // TODO Tests :D
    }

    /**
     * Indique si tous les feux d'artifices ont été complétés.
     *
     * @return true si tous les feux d'artifices sont complets, sinon
     *         false
     */
    public boolean areFireworksCompleted() {
        return getFeuxPosesRouge().size() == 5
                && getFeuxPosesJaune().size() == 5
                && getFeuxPosesVert().size() == 5
                && getFeuxPosesBleu().size() == 5
                && getFeuxPosesBlanc().size() == 5;
    }

    /**
     * @return le tour courant
     */
    public Tour getTourCourant() {
        return tourCourant;
    }

    /**
     * Change le tour courant pour un autre
     *
     * @param aDefinirCourant le tour que l'on souhaite définir comme tour
     *                        courant
     */
    public void setTourCourant(Tour aDefinirCourant) {
        tourCourant = aDefinirCourant;
    }
}
