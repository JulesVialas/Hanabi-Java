/*
 * TestTour.java                                            19 mai 2024
 * IUT de Rodez, TP42, pas de copyright.
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link modele.jeu.Tour}.
 * 
 * @author Corentin Solignac
 */
class TestTour {

    /**
     * Méthode de test pour {@link modele.jeu.Tour#Tour(modele.jeu.Joueur, int)}.
     */
    @Test
    void testTour() {

        assertDoesNotThrow(() -> new Tour(new Joueur("Coucou"), 1));
        assertDoesNotThrow(() -> new Tour(new Joueur("John"), 2));
        assertDoesNotThrow(() -> new Tour(new Joueur("Coltrane"), 3));
        assertDoesNotThrow(() -> new Tour(new Joueur("Charles"), 4));
        assertDoesNotThrow(() -> new Tour(new Joueur("Mingus"), 5));

        assertThrows(IllegalArgumentException.class, () -> new Tour(new Joueur("Mingus"), -1));
        assertThrows(IllegalArgumentException.class, () -> new Tour(new Joueur("Mingus"), 0));
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#getJoueurCourant()}.
     */
    @Test
    void testGetJoueurCourant() {

        Joueur Charles = new Joueur("Charles");
        Joueur Mingus = new Joueur("Mingus");
        assertEquals(Charles, new Tour(Charles, 5).getJoueurCourant());
        assertEquals(Mingus, new Tour(Mingus, 15).getJoueurCourant());
        assertNotEquals(Mingus, new Tour(Charles, 5).getJoueurCourant());
        assertNotEquals(Charles, new Tour(Mingus, 15).getJoueurCourant());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#getNumero()}.
     */
    @Test
    void testGetNumero() {

        assertEquals(5, new Tour(new Joueur("Charles"), 5).getNumero());
        assertEquals(15, new Tour(new Joueur("Mingus"), 15).getNumero());
        assertNotEquals(15, new Tour(new Joueur("Charles"), 5).getNumero());
        assertNotEquals(5, new Tour(new Joueur("Mingus"), 15).getNumero());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#getJetonsBleus()}.
     */
    @Test
    void testGetJetonsBleus() {
        Partie partie1 = new Partie("Coco", "Sol");
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        roundUn.setPartieDuTour(partie1);
        
        /* 8 jetons au début d'une partie, valeur par défaut */
        assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().setBleus(4);
        assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(4, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().incrementBleus();
        assertNotEquals(4, roundUn.getPartieDuTour().getJetons().getBleus());
        assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(5, roundUn.getPartieDuTour().getJetons().getBleus());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#getJetonsRouges()}.
     */
    @Test
    void testGetJetonsRouges() {
        Partie partie1 = new Partie("Coco", "Sol");
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        roundUn.setPartieDuTour(partie1);
        
        assertEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());

        roundUn.getPartieDuTour().getJetons().incrementRouges();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
        assertEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());

        roundUn.getPartieDuTour().getJetons().incrementRouges();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
        assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());
        assertEquals(2, roundUn.getPartieDuTour().getJetons().getRouges());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#incrementJetonsBleus()}.
     */
    @Test
    void testIncrementJetonsBleus() {
        Partie partie1 = new Partie("Coco", "Sol");
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        roundUn.setPartieDuTour(partie1);
        
        /* 8 jetons par défaut en début de partie */
        assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
        roundUn.getPartieDuTour().getJetons().setBleus(0);

        roundUn.getPartieDuTour().getJetons().incrementBleus();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(1, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().incrementBleus();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getBleus());
        assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(2, roundUn.getPartieDuTour().getJetons().getBleus());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#setJetonsBleus()}.
     */
    @Test
    void testSetJetonsBleus() {
        Partie partie1 = new Partie("Coco", "Sol");
        
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        Tour roundDeux = new Tour(new Joueur("Parisien"), 2);
        roundUn.setPartieDuTour(partie1);
        roundDeux.setPartieDuTour(partie1);
        
        /* Nombre par défaut est 8 jetons lors de création d'une partie */
        assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().decrementBleus();
        assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(7, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().decrementBleus();
        assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
        assertNotEquals(7, roundUn.getPartieDuTour().getJetons().getBleus());
        assertEquals(6, roundUn.getPartieDuTour().getJetons().getBleus());

        roundUn.getPartieDuTour().getJetons().decrementBleus();
        roundDeux.getPartieDuTour().getJetons().setBleus(
                (roundUn.getPartieDuTour().getJetons().getBleus()));
        assertEquals(5, roundDeux.getPartieDuTour().getJetons().getBleus());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#decrementJetonsBleus()}.
     */
    @Test
    void testDecrementJetonsBleus() {
        Partie partie1 = new Partie("Coco", "Sol");
        Tour roundTrois = new Tour(new Joueur("Parker"), 3);
        roundTrois.setPartieDuTour(partie1);

        roundTrois.getPartieDuTour().getJetons().setBleus(4);
        assertEquals(4, roundTrois.getPartieDuTour().getJetons().getBleus());

        roundTrois.getPartieDuTour().getJetons().decrementBleus();
        assertEquals(3, roundTrois.getPartieDuTour().getJetons().getBleus());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#incrementJetonsRouges()}.
     */
    @Test
    void testIncrementJetonsRouges() {

        Partie partie1 = new Partie("Coco", "Sol");
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        roundUn.setPartieDuTour(partie1);
        
        assertEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());

        roundUn.getPartieDuTour().getJetons().incrementRouges();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
        assertEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());

        roundUn.getPartieDuTour().getJetons().incrementRouges();
        assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
        assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());
        assertEquals(2, roundUn.getPartieDuTour().getJetons().getRouges());
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#donnerIndice(modele.jeu.Carte, char)}.
     */
    @Test
    void testDonnerIndice() {
        /* Partie et Tours de test */
        Partie partie1 = new Partie("Coltrane", "John");
        
        Carte carte1 = new Carte(Couleur.ROUGE, Valeur.TROIS);
        Carte carte2 = new Carte(Couleur.BLEU, Valeur.CINQ);
        partie1.getJoueur1().setCartesEnMains(carte1);
        partie1.getJoueur2().setCartesEnMains(carte2);
        
        Tour tour1 = new Tour(partie1.getJoueur1(), 1);
        Tour tour2 = new Tour(partie1.getJoueur2(), 2);
        tour1.setPartieDuTour(partie1);
        tour2.setPartieDuTour(partie1);
        
        /* On initialise les jetons bleus à 1 */
        tour1.getPartieDuTour().getJetons().setBleus(1);
        tour2.getPartieDuTour().getJetons().setBleus(1);

        /* On peut donner un indice car 1 jeton est dispo */
        assertDoesNotThrow(() -> tour1.donnerIndice(partie1.getJoueur1(),
                                                    carte1, 'c'));
        /* 
         * L'indice est donné, donc le booleen de la carte qui a reçu
         *  l'indice est true, et false pour celle qui ne l'a pas reçu 
         */
        assertTrue(carte1.getCouleurConnue());
        assertFalse(carte2.getCouleurConnue());
        assertEquals(0, tour1.getPartieDuTour().getJetons().getBleus());

        /* Tentative de donner indice lorsque zéro jetons bleus */
        assertThrows(IllegalStateException.class,
                () -> tour2.donnerIndice(partie1.getJoueur2(),
                                                    carte2, 'v'));
        /* On redonne un jeton */
        tour2.getPartieDuTour().getJetons().setBleus(1);
        
        /* On donne un indice */
        assertDoesNotThrow(() -> tour2.donnerIndice(partie1.getJoueur2(),
                                                    carte2, 'v'));
        /* 
         * L'indice est donné, donc le booleen de la carte qui a reçu
         * l'indice est true, et false pour celle qui ne l'a pas reçu
         */
        assertTrue(carte2.getValeurConnue());
        assertFalse(carte1.getValeurConnue());
        
        /* 
         * On essaie de redonner le même indice à une carte, ce qui ne 
         * doit pas poser de problèmes 
         */
        tour2.getPartieDuTour().getJetons().setBleus(1);
        assertDoesNotThrow(() -> tour2.donnerIndice(partie1.getJoueur2(),
                carte2, 'v'));
        
        /* Il n'y a plus de jetons bleus */
        assertEquals(0, tour2.getPartieDuTour().getJetons().getBleus());

        /* Les saisies d'indices sont invalides ( != 'c' et 'v') */
        assertThrows(IllegalStateException.class, () -> 
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'c'));
        
        /* On redonne un jeton mais les saisies d'indices sont invalides */
        tour2.getPartieDuTour().getJetons().setBleus(1);
        assertThrows(IllegalArgumentException.class, () ->
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'x'));
        
        /* On essaie de redonner le même indice à une carte */
        tour2.getPartieDuTour().getJetons().setBleus(1);
        assertDoesNotThrow(()-> 
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'c'));
        
        /* Création de joueurs pour tester la propagation de l'indice */
        Joueur joueur1 = new Joueur("Kyle");
        Joueur joueur2 = new Joueur("Poole");
        Tour tour3 = new Tour(joueur2, 3);
        tour3.setPartieDuTour(partie1);
        partie1.getJetons().setBleus(8);
        
        Carte unJaune1 = new Carte(Couleur.JAUNE, Valeur.UN);
        
        joueur1.setCartesEnMains(unJaune1);
        joueur1.setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.DEUX));
        joueur1.setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.TROIS));
        joueur1.setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.QUATRE));
        
        /* On vérifie qu'aucun carte n'a l'indice de couleur */
        for (Carte cartesDuJoueur : joueur1.getCartesEnMains()) {
            assertFalse(cartesDuJoueur.getCouleurConnue());
        }
        
        /* L'indice est donné par joueur 2 à joueur 1 */
        tour3.donnerIndice(joueur1, unJaune1, 'c');
        
        /* On vérifie que toutes les cartes ont reçu l'indice */
        for (Carte cartesDuJoueur : joueur1.getCartesEnMains()) {
            assertTrue(cartesDuJoueur.getCouleurConnue());
        }
        
        /* Même démarche pour l'indice valeur */
        Carte unRouge1 = new Carte(Couleur.ROUGE, Valeur.UN);
        Carte unJaune2 = new Carte(Couleur.JAUNE, Valeur.UN);
        Carte quatreVert1 = new Carte(Couleur.VERT, Valeur.QUATRE);
        joueur2.setCartesEnMains(unJaune1);
        joueur2.setCartesEnMains(unRouge1);
        joueur2.setCartesEnMains(unJaune2);
        joueur2.setCartesEnMains(quatreVert1);
        
        /* On vérifie qu'aucun carte n'a l'indice de valeur */
        for (Carte cartesDuJoueur : joueur2.getCartesEnMains()) {
            assertFalse(cartesDuJoueur.getValeurConnue());
        }
        
        /* 
         * L'indice est donné par joueur 2 à lui-même, comportement
         * accepté pour les classes métiers, sera empeché par l'IHM
         * FIXME peut-être throw si donneur = receveur
         */
        tour3.donnerIndice(joueur2, unJaune1, 'v');
        
        /* 
         * On vérifie que seules les cartes répondant
         * au critère ont reçu l'indice
         */
        assertTrue(unJaune1.getValeurConnue());
        assertTrue(unRouge1.getValeurConnue());
        assertTrue(unJaune2.getValeurConnue());
        assertFalse(quatreVert1.getValeurConnue());
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#poser(modele.jeu.Carte)}.
     */
    @Test
    void testPoser() {
    }

    /**
     * Méthode de test pour {@link modele.jeu.Tour#defausser(modele.jeu.Carte)}.
     */
    @Test
    void testDefausser() {
    }

}
