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
        assertDoesNotThrow(()->new Joueur("O U I "));
        
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
        
        assertEquals("Kamasi", new Joueur("Kamasi").getPseudo());
        assertEquals("Washington", new Joueur("Washington").getPseudo());
        assertEquals("Magda", new Joueur("Magda").getPseudo());
        assertEquals("Kuras", new Joueur("Kuras").getPseudo());
        assertEquals("12", new Joueur("12").getPseudo());
        assertEquals("0123456789", new Joueur("0123456789").getPseudo());
        assertEquals("O U I ", new Joueur("O U I ").getPseudo());
        
        assertNotEquals("kamasi", new Joueur("Kamasi").getPseudo());
        assertNotEquals(" Washington", new Joueur("Washington").getPseudo());
        assertNotEquals("Magda ", new Joueur("Magda").getPseudo());
        assertNotEquals("KURAS", new Joueur("Kuras").getPseudo());
        assertNotEquals(" 12 ", new Joueur("12").getPseudo());
        assertNotEquals("0...9", new Joueur("0123456789").getPseudo());
        assertNotEquals("o_u_i_", new Joueur("O U I ").getPseudo());
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
