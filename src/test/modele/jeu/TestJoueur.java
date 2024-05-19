/*
 * TestJoueur.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
class TestJoueur {

    /**
     * Test method for {@link modele.jeu.Joueur#Joueur(java.lang.String)}.
     */
    @Test
    void testJoueur() {
        assertDoesNotThrow(()->new Joueur("Kamasi"));
        assertDoesNotThrow(()->new Joueur("Washington"));
        assertDoesNotThrow(()->new Joueur("Magda"));
        assertDoesNotThrow(()->new Joueur("Kuras"));
        assertDoesNotThrow(()->new Joueur("12"));
        assertDoesNotThrow(()->new Joueur("0123456789"));
        
        assertThrows(IllegalArgumentException.class,
                ()->new Joueur(""));
        assertThrows(IllegalArgumentException.class,
                ()->new Joueur("          "));
        assertThrows(NullPointerException.class,
                ()->new Joueur(null));
        assertThrows(IllegalArgumentException.class,
                ()->new Joueur("01234567890"));
        assertThrows(IllegalArgumentException.class,
                ()->new Joueur("a"));
    }

    /**
     * Test method for {@link modele.jeu.Joueur#getPseudo()}.
     */
    @Test
    void testGetPseudo() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Joueur#getCartesEnMains()}.
     */
    @Test
    void testGetCartesEnMains() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.Joueur#setCartesEnMains(modele.jeu.Carte)}.
     */
    @Test
    void testSetCartesEnMains() {
        fail("Not yet implemented");
    }

}
