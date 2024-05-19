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
     * Méthode de test pour
     * {@link modele.jeu.Carte#getCouleur()}.
     */
    @Test
    void testGetCouleur() {
        assertEquals(Couleur.ROUGE, new Carte(Couleur.ROUGE, Valeur.UN)
                .getCouleur());
        assertEquals(Couleur.ROUGE, new Carte(Couleur.ROUGE, Valeur.DEUX)
                .getCouleur());
        assertEquals(Couleur.ROUGE, new Carte(Couleur.ROUGE, Valeur.TROIS)
                .getCouleur());
        assertEquals(Couleur.ROUGE, new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getCouleur());
        assertEquals(Couleur.ROUGE, new Carte(Couleur.ROUGE, Valeur.CINQ)
                .getCouleur());

        assertNotEquals(Couleur.JAUNE, new Carte(Couleur.ROUGE, Valeur.UN)
                .getCouleur());
        assertNotEquals(Couleur.VERT, new Carte(Couleur.ROUGE, Valeur.DEUX)
                .getCouleur());
        assertNotEquals(Couleur.BLEU, new Carte(Couleur.ROUGE, Valeur.TROIS)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.ROUGE, Valeur.CINQ)
                .getCouleur());
        
        
        assertEquals(Couleur.JAUNE, new Carte(Couleur.JAUNE, Valeur.UN)
                .getCouleur());
        assertEquals(Couleur.JAUNE, new Carte(Couleur.JAUNE, Valeur.DEUX)
                .getCouleur());
        assertEquals(Couleur.JAUNE, new Carte(Couleur.JAUNE, Valeur.TROIS)
                .getCouleur());
        assertEquals(Couleur.JAUNE, new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getCouleur());
        assertEquals(Couleur.JAUNE, new Carte(Couleur.JAUNE, Valeur.CINQ)
                .getCouleur());

        assertNotEquals(Couleur.ROUGE, new Carte(Couleur.JAUNE, Valeur.UN)
                .getCouleur());
        assertNotEquals(Couleur.VERT, new Carte(Couleur.JAUNE, Valeur.DEUX)
                .getCouleur());
        assertNotEquals(Couleur.BLEU, new Carte(Couleur.JAUNE, Valeur.TROIS)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.JAUNE, Valeur.CINQ)
                .getCouleur());

        assertEquals(Couleur.VERT, new Carte(Couleur.VERT, Valeur.UN)
                .getCouleur());
        assertEquals(Couleur.VERT, new Carte(Couleur.VERT, Valeur.DEUX)
                .getCouleur());
        assertEquals(Couleur.VERT, new Carte(Couleur.VERT, Valeur.TROIS)
                .getCouleur());
        assertEquals(Couleur.VERT, new Carte(Couleur.VERT, Valeur.QUATRE)
                .getCouleur());
        assertEquals(Couleur.VERT, new Carte(Couleur.VERT, Valeur.CINQ)
                .getCouleur());

        assertNotEquals(Couleur.ROUGE, new Carte(Couleur.VERT, Valeur.UN)
                .getCouleur());
        assertNotEquals(Couleur.JAUNE, new Carte(Couleur.VERT, Valeur.DEUX)
                .getCouleur());
        assertNotEquals(Couleur.BLEU, new Carte(Couleur.VERT, Valeur.TROIS)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.VERT, Valeur.QUATRE)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.VERT, Valeur.CINQ)
                .getCouleur());
        
        assertEquals(Couleur.BLEU, new Carte(Couleur.BLEU, Valeur.UN)
                .getCouleur());
        assertEquals(Couleur.BLEU, new Carte(Couleur.BLEU, Valeur.DEUX)
                .getCouleur());
        assertEquals(Couleur.BLEU, new Carte(Couleur.BLEU, Valeur.TROIS)
                .getCouleur());
        assertEquals(Couleur.BLEU, new Carte(Couleur.BLEU, Valeur.QUATRE)
                .getCouleur());
        assertEquals(Couleur.BLEU, new Carte(Couleur.BLEU, Valeur.CINQ)
                .getCouleur());

        assertNotEquals(Couleur.ROUGE, new Carte(Couleur.BLEU, Valeur.UN)
                .getCouleur());
        assertNotEquals(Couleur.JAUNE, new Carte(Couleur.BLEU, Valeur.DEUX)
                .getCouleur());
        assertNotEquals(Couleur.VERT, new Carte(Couleur.BLEU, Valeur.TROIS)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.BLEU, Valeur.QUATRE)
                .getCouleur());
        assertNotEquals(Couleur.BLANC, new Carte(Couleur.BLEU, Valeur.CINQ)
                .getCouleur());
        
        assertEquals(Couleur.BLANC, new Carte(Couleur.BLANC, Valeur.UN)
                .getCouleur());
        assertEquals(Couleur.BLANC, new Carte(Couleur.BLANC, Valeur.DEUX)
                .getCouleur());
        assertEquals(Couleur.BLANC, new Carte(Couleur.BLANC, Valeur.TROIS)
                .getCouleur());
        assertEquals(Couleur.BLANC, new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getCouleur());
        assertEquals(Couleur.BLANC, new Carte(Couleur.BLANC, Valeur.CINQ)
                .getCouleur());

        assertNotEquals(Couleur.ROUGE, new Carte(Couleur.BLANC, Valeur.UN)
                .getCouleur());
        assertNotEquals(Couleur.JAUNE, new Carte(Couleur.BLANC, Valeur.DEUX)
                .getCouleur());
        assertNotEquals(Couleur.VERT, new Carte(Couleur.BLANC, Valeur.TROIS)
                .getCouleur());
        assertNotEquals(Couleur.BLEU, new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getCouleur());
        assertNotEquals(Couleur.BLEU, new Carte(Couleur.BLANC, Valeur.CINQ)
                .getCouleur());
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Carte#getValeur()}.
     */
    @Test
    void testGetValeur() {

        assertEquals(Valeur.UN, new Carte(Couleur.ROUGE, Valeur.UN)
                .getValeur());
        assertEquals(Valeur.DEUX, new Carte(Couleur.ROUGE, Valeur.DEUX)
                .getValeur());
        assertEquals(Valeur.TROIS, new Carte(Couleur.ROUGE, Valeur.TROIS)
                .getValeur());
        assertEquals(Valeur.QUATRE, new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getValeur());
        assertEquals(Valeur.CINQ, new Carte(Couleur.ROUGE, Valeur.CINQ)
                .getValeur());

        assertNotEquals(Valeur.DEUX, new Carte(Couleur.ROUGE, Valeur.UN)
                .getValeur());
        assertNotEquals(Valeur.TROIS, new Carte(Couleur.ROUGE, Valeur.DEUX)
                .getValeur());
        assertNotEquals(Valeur.QUATRE, new Carte(Couleur.ROUGE, Valeur.TROIS)
                .getValeur());
        assertNotEquals(Valeur.CINQ, new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getValeur());
        assertNotEquals(Valeur.UN, new Carte(Couleur.ROUGE, Valeur.CINQ)
                .getValeur());
        
        
        assertEquals(Valeur.UN, new Carte(Couleur.JAUNE, Valeur.UN)
                .getValeur());
        assertEquals(Valeur.DEUX, new Carte(Couleur.JAUNE, Valeur.DEUX)
                .getValeur());
        assertEquals(Valeur.TROIS, new Carte(Couleur.JAUNE, Valeur.TROIS)
                .getValeur());
        assertEquals(Valeur.QUATRE, new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getValeur());
        assertEquals(Valeur.CINQ, new Carte(Couleur.JAUNE, Valeur.CINQ)
                .getValeur());

        assertNotEquals(Valeur.TROIS, new Carte(Couleur.JAUNE, Valeur.UN)
                .getValeur());
        assertNotEquals(Valeur.QUATRE, new Carte(Couleur.JAUNE, Valeur.DEUX)
                .getValeur());
        assertNotEquals(Valeur.CINQ, new Carte(Couleur.JAUNE, Valeur.TROIS)
                .getValeur());
        assertNotEquals(Valeur.UN, new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getValeur());
        assertNotEquals(Valeur.DEUX, new Carte(Couleur.JAUNE, Valeur.CINQ)
                .getValeur());

        assertEquals(Valeur.UN, new Carte(Couleur.VERT, Valeur.UN)
                .getValeur());
        assertEquals(Valeur.DEUX, new Carte(Couleur.VERT, Valeur.DEUX)
                .getValeur());
        assertEquals(Valeur.TROIS, new Carte(Couleur.VERT, Valeur.TROIS)
                .getValeur());
        assertEquals(Valeur.QUATRE, new Carte(Couleur.VERT, Valeur.QUATRE)
                .getValeur());
        assertEquals(Valeur.CINQ, new Carte(Couleur.VERT, Valeur.CINQ)
                .getValeur());

        assertNotEquals(Valeur.QUATRE, new Carte(Couleur.VERT, Valeur.UN)
                .getValeur());
        assertNotEquals(Valeur.CINQ, new Carte(Couleur.VERT, Valeur.DEUX)
                .getValeur());
        assertNotEquals(Valeur.UN, new Carte(Couleur.VERT, Valeur.TROIS)
                .getValeur());
        assertNotEquals(Valeur.DEUX, new Carte(Couleur.VERT, Valeur.QUATRE)
                .getValeur());
        assertNotEquals(Valeur.TROIS, new Carte(Couleur.VERT, Valeur.CINQ)
                .getValeur());
        
        assertEquals(Valeur.UN, new Carte(Couleur.BLEU, Valeur.UN)
                .getValeur());
        assertEquals(Valeur.DEUX, new Carte(Couleur.BLEU, Valeur.DEUX)
                .getValeur());
        assertEquals(Valeur.TROIS, new Carte(Couleur.BLEU, Valeur.TROIS)
                .getValeur());
        assertEquals(Valeur.QUATRE, new Carte(Couleur.BLEU, Valeur.QUATRE)
                .getValeur());
        assertEquals(Valeur.CINQ, new Carte(Couleur.BLEU, Valeur.CINQ)
                .getValeur());

        assertNotEquals(Valeur.CINQ, new Carte(Couleur.BLEU, Valeur.UN)
                .getValeur());
        assertNotEquals(Valeur.UN, new Carte(Couleur.BLEU, Valeur.DEUX)
                .getValeur());
        assertNotEquals(Valeur.DEUX, new Carte(Couleur.BLEU, Valeur.TROIS)
                .getValeur());
        assertNotEquals(Valeur.TROIS, new Carte(Couleur.BLEU, Valeur.QUATRE)
                .getValeur());
        assertNotEquals(Valeur.QUATRE, new Carte(Couleur.BLEU, Valeur.CINQ)
                .getValeur());
        
        assertEquals(Valeur.UN, new Carte(Couleur.BLANC, Valeur.UN)
                .getValeur());
        assertEquals(Valeur.DEUX, new Carte(Couleur.BLANC, Valeur.DEUX)
                .getValeur());
        assertEquals(Valeur.TROIS, new Carte(Couleur.BLANC, Valeur.TROIS)
                .getValeur());
        assertEquals(Valeur.QUATRE, new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getValeur());
        assertEquals(Valeur.CINQ, new Carte(Couleur.BLANC, Valeur.CINQ)
                .getValeur());

        assertNotEquals(Valeur.DEUX, new Carte(Couleur.BLANC, Valeur.UN)
                .getValeur());
        assertNotEquals(Valeur.TROIS, new Carte(Couleur.BLANC, Valeur.DEUX)
                .getValeur());
        assertNotEquals(Valeur.UN, new Carte(Couleur.BLANC, Valeur.TROIS)
                .getValeur());
        assertNotEquals(Valeur.CINQ, new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getValeur());
        assertNotEquals(Valeur.QUATRE, new Carte(Couleur.BLANC, Valeur.CINQ)
                .getValeur());
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
