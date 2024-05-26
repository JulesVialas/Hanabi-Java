package jeu.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPartie {

    /**
     * Méthode de test pour 
     * {@link jeu.modele.Partie#Partie(String, String)}.
     */
    @Test
    void testPartie2J() {
        Partie partie2J = new Partie("Brian", "Blade");

        /* Main des joueurs est initialisée à 5 cartes en début de partie à 2 */
        assertTrue(partie2J.getJoueur1().getCartesEnMains().size() == 5);
        assertTrue(partie2J.getJoueur2().getCartesEnMains().size() == 5);
    }

    /**
     * Méthode de test pour 
     * {@link jeu.modele.Partie#Partie(String, String, String)}.
     */
    @Test
    void testPartie3J() {
        Partie partie3J = new Partie("Blade", "McBride", "Chick");

        /* Main des joueurs est initialisée à 5 cartes en début de partie à 3 */
        assertTrue(partie3J.getJoueur1().getCartesEnMains().size() == 5);
        assertTrue(partie3J.getJoueur2().getCartesEnMains().size() == 5);
        assertTrue(partie3J.getJoueur3().getCartesEnMains().size() == 5);
    }

    /**
     * Méthode de test pour 
     * {@link jeu.modele.Partie#Partie(String, String,
     *                                 String, String)}.
     */
    @Test
    void testPartie4J() {
        Partie partie4J = new Partie("Christian", "McBride", "Brian", "Blade");

        /* Main des joueurs est initialisée à 4 cartes en début de partie à 4 */
        assertTrue(partie4J.getJoueur1().getCartesEnMains().size() == 4);
        assertTrue(partie4J.getJoueur2().getCartesEnMains().size() == 4);
        assertTrue(partie4J.getJoueur3().getCartesEnMains().size() == 4);
        assertTrue(partie4J.getJoueur4().getCartesEnMains().size() == 4);
    }
    
    /**
     * Méthode de test pour 
     * {@link jeu.modele.Partie#Partie(String, String,
     *                                 String, String, String)}.
     */
    @Test
    void testPartie5J() {
        Partie partie5J = new Partie("Christian", "McBride", "Brian", "Blade",
                "Spain");

        /* Main des joueurs est initialisée à 4 cartes en début de partie à 5 */
        assertTrue(partie5J.getJoueur1().getCartesEnMains().size() == 4);
        assertTrue(partie5J.getJoueur2().getCartesEnMains().size() == 4);
        assertTrue(partie5J.getJoueur3().getCartesEnMains().size() == 4);
        assertTrue(partie5J.getJoueur4().getCartesEnMains().size() == 4);
        assertTrue(partie5J.getJoueur5().getCartesEnMains().size() == 4);
    }

    @Test
    void testGetJetons() {
        fail("Not yet implemented");
    }

    @Test
    void testGetJoueur1() {
        fail("Not yet implemented");
    }

    @Test
    void testGetJoueur2() {
        fail("Not yet implemented");
    }

    @Test
    void testGetJoueur3() {
        fail("Not yet implemented");
    }

    @Test
    void testGetJoueur4() {
        fail("Not yet implemented");
    }

    @Test
    void testGetJoueur5() {
        fail("Not yet implemented");
    }

    @Test
    void testGetPioche() {
        fail("Not yet implemented");
    }
}
