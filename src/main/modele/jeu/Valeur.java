/*
 * Valeur.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

/**
 * Défini les valeurs de cartes valides pour le jeu Hanabi
 */
public enum Valeur {
    
    UN(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5)
    
    private int valeur;
    
    Valeur(int valeur) {
        this.valeur = valeur;
    }
    
    /**
     * @return la valeur de la carte
     */
    public int getValeur() {
        return this.valeur;
    }
};
