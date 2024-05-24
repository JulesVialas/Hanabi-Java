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
        Partie partie1 = new Partie("Coltrane", "John");
        
        Carte carte1 = new Carte(Couleur.ROUGE, Valeur.TROIS);
        Carte carte2 = new Carte(Couleur.BLEU, Valeur.CINQ);
        partie1.getJoueur1().setCartesEnMains(carte1);
        partie1.getJoueur2().setCartesEnMains(carte2);
        
        Tour tour1 = new Tour(partie1.getJoueur1(), 1);
        Tour tour2 = new Tour(partie1.getJoueur2(), 2);
        tour1.setPartieDuTour(partie1);
        tour2.setPartieDuTour(partie1);
        
        
        tour1.getPartieDuTour().getJetons().setBleus(1);
        
        tour2.getPartieDuTour().getJetons().setBleus(1);

        assertDoesNotThrow(() -> tour1.donnerIndice(partie1.getJoueur1(),
                                                    carte1, 'c'));
        assertTrue(carte1.getCouleurConnue());
        assertFalse(carte2.getCouleurConnue());
        assertEquals(0, tour1.getPartieDuTour().getJetons().getBleus());

        assertDoesNotThrow(() -> tour2.donnerIndice(partie1.getJoueur2(),
                                                    carte2, 'v'));
        assertTrue(carte2.getValeurConnue());
        assertFalse(carte1.getValeurConnue());
        assertEquals(0, tour2.getPartieDuTour().getJetons().getBleus());

        assertThrows(IllegalStateException.class, () -> 
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'c'));
        tour2.getPartieDuTour().getJetons().setBleus(1);;
        assertThrows(IllegalArgumentException.class, () ->
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'x'));
        tour2.getPartieDuTour().getJetons().setBleus(1);;
        assertThrows(IllegalArgumentException.class, () -> 
            tour2.donnerIndice(partie1.getJoueur2(), carte1, 'c'));
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
