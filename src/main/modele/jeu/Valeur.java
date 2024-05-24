/*
 * Valeur.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

/**
 * Défini les valeurs de cartes valides pour le jeu Hanabi
 */
public enum Valeur {

    UN(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5);

    /** La valeur de la carte sous forme d'entier */
    private int valeurNumerique;

    Valeur(int valeurNumerique) {
        this.valeurNumerique = valeurNumerique;
    }

    /**
     * @return la valeur de la carte
     */
    public int getValeurNumerique() {
        return this.valeurNumerique;
    }
};
