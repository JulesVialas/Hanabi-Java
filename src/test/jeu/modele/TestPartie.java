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
    
    /**
     * Méthode de test pour 
     * {@link jeu.modele.Partie#calculerScore()}.
     */
    @Test
    void testCalculerScore() {

        /* Score maximal car trop forts :D */
        Partie partie1 = new Partie("SOLIGNAC", "VALAT", "VIALAS");
        partie1.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.UN));
        partie1.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.DEUX));
        partie1.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.TROIS));
        partie1.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.QUATRE));
        partie1.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.CINQ));
        
        partie1.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.UN));
        partie1.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.DEUX));
        partie1.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.TROIS));
        partie1.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.QUATRE));
        partie1.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.CINQ));
        
        partie1.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.UN));
        partie1.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.DEUX));
        partie1.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.TROIS));
        partie1.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.QUATRE));
        partie1.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.CINQ));
        
        partie1.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.UN));
        partie1.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.DEUX));
        partie1.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.TROIS));
        partie1.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.QUATRE));
        partie1.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.CINQ));
        
        partie1.getFeuxPosesBlanc().push(new Carte(Couleur.BLANC, Valeur.UN));
        partie1.getFeuxPosesBlanc().push(new Carte(Couleur.BLANC, Valeur.DEUX));
        partie1.getFeuxPosesBlanc().push(new Carte(Couleur.BLANC, Valeur.TROIS));
        partie1.getFeuxPosesBlanc().push(new Carte(Couleur.BLANC, Valeur.QUATRE));
        partie1.getFeuxPosesBlanc().push(new Carte(Couleur.BLANC, Valeur.CINQ));
        
        assertEquals(25, partie1.calculerScore());
        
        /* Score égal à 0 car aucune carte posée */
        Partie partie2 = new Partie("Les", "Gens", "Pas", "Forts");

        assertEquals(0, partie2.calculerScore());
        
        /* Score égal à 14, (feux: 4, 2, 5, 3, 0) */
        Partie partie3 = new Partie("Un", "Score", "Honorable");
        partie3.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.UN));
        partie3.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.DEUX));
        partie3.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.TROIS));
        partie3.getFeuxPosesRouge().push(new Carte(Couleur.ROUGE, Valeur.QUATRE));
        
        partie3.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.UN));
        partie3.getFeuxPosesJaune().push(new Carte(Couleur.JAUNE, Valeur.DEUX));
        
        partie3.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.UN));
        partie3.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.DEUX));
        partie3.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.TROIS));
        partie3.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.QUATRE));
        partie3.getFeuxPosesVert().push(new Carte(Couleur.VERT, Valeur.CINQ));
        
        partie3.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.UN));
        partie3.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.DEUX));
        partie3.getFeuxPosesBleu().push(new Carte(Couleur.BLEU, Valeur.TROIS));
        
        assertEquals(14, partie3.calculerScore());
    }
}
