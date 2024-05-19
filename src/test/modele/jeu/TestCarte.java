/*
 * TestCarte.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour 
 * {@link modele.jeu.Carte}.
 * 
 * @author Corentin Solignac
 */
class TestCarte {

    /**
     * Test method for {@link modele.jeu.Carte#Carte(modele.jeu.Carte.Couleur, int)}.
     */
    @Test
    void testCarte() {
    
        
        /* Carte avec couleur & valeur valides */
        assertDoesNotThrow(()->new Carte(Couleur.ROUGE, Valeur.UN));
        assertDoesNotThrow(()->new Carte(Couleur.ROUGE, Valeur.DEUX));
        assertDoesNotThrow(()->new Carte(Couleur.ROUGE, Valeur.TROIS));
        assertDoesNotThrow(()->new Carte(Couleur.ROUGE, Valeur.QUATRE));
        assertDoesNotThrow(()->new Carte(Couleur.ROUGE, Valeur.CINQ));
        
        assertDoesNotThrow(()->new Carte(Couleur.JAUNE, Valeur.UN));
        assertDoesNotThrow(()->new Carte(Couleur.JAUNE, Valeur.DEUX));
        assertDoesNotThrow(()->new Carte(Couleur.JAUNE, Valeur.TROIS));
        assertDoesNotThrow(()->new Carte(Couleur.JAUNE, Valeur.QUATRE));
        assertDoesNotThrow(()->new Carte(Couleur.JAUNE, Valeur.CINQ));
        
        assertDoesNotThrow(()->new Carte(Couleur.VERT, Valeur.UN));
        assertDoesNotThrow(()->new Carte(Couleur.VERT, Valeur.DEUX));
        assertDoesNotThrow(()->new Carte(Couleur.VERT, Valeur.TROIS));
        assertDoesNotThrow(()->new Carte(Couleur.VERT, Valeur.QUATRE));
        assertDoesNotThrow(()->new Carte(Couleur.VERT, Valeur.CINQ));
        
        assertDoesNotThrow(()->new Carte(Couleur.BLEU, Valeur.UN));
        assertDoesNotThrow(()->new Carte(Couleur.BLEU, Valeur.DEUX));
        assertDoesNotThrow(()->new Carte(Couleur.BLEU, Valeur.TROIS));
        assertDoesNotThrow(()->new Carte(Couleur.BLEU, Valeur.QUATRE));
        assertDoesNotThrow(()->new Carte(Couleur.BLEU, Valeur.CINQ));
        
        assertDoesNotThrow(()->new Carte(Couleur.BLANC, Valeur.UN));
        assertDoesNotThrow(()->new Carte(Couleur.BLANC, Valeur.DEUX));
        assertDoesNotThrow(()->new Carte(Couleur.BLANC, Valeur.TROIS));
        assertDoesNotThrow(()->new Carte(Couleur.BLANC, Valeur.QUATRE));
        assertDoesNotThrow(()->new Carte(Couleur.BLANC, Valeur.CINQ));
        
        /* Carte avec couleur invalide */
        // Protégé grâce à l'enumération Couleur
        
        /* Carte avec couleur valide & valeur invalide */
        // Protégé grâce à l'enumération Valeur
        
        /* Carte avec couleur et valeur invalides */
        // Protégé grâce aux énumérations
        
        /* Carte valide, vérifier valeurConnue à false */
        //TODO nécessite tests des getters
    }

    /**
     * Test method for {@link modele.jeu.Carte#getCouleur()}.
     */
    @Test
    void testGetCouleur() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#getValeur()}.
     */
    @Test
    void testGetValeur() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#getCouleurConnue()}.
     */
    @Test
    void testGetCouleurConnue() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#getValeurConnue()}.
     */
    @Test
    void testGetValeurConnue() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#setCouleurConnue(boolean)}.
     */
    @Test
    void testSetCouleurConnue() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#setValeurConnue(boolean)}.
     */
    @Test
    void testSetValeurConnue() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Carte#toString()}.
     */
    @Test
    void testToString() {
        fail("Not yet implemented");
    }

}
