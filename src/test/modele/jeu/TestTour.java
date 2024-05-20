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
     * Méthode de test pour 
     * {@link modele.jeu.Tour#Tour(modele.jeu.Joueur, int)}.
     */
    @Test
    void testTour() {
        
        assertDoesNotThrow(()->new Tour(new Joueur("Coucou"), 1));
        assertDoesNotThrow(()->new Tour(new Joueur("John"), 2));
        assertDoesNotThrow(()->new Tour(new Joueur("Coltrane"), 3));
        assertDoesNotThrow(()->new Tour(new Joueur("Charles"), 4));
        assertDoesNotThrow(()->new Tour(new Joueur("Mingus"), 5));
        
        assertThrows(IllegalArgumentException.class,
                ()->new Tour(new Joueur("Mingus"), -1));
        assertThrows(IllegalArgumentException.class,
                ()->new Tour(new Joueur("Mingus"), 0));
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#getJoueurCourant()}.
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
     * Méthode de test pour
     * {@link modele.jeu.Tour#getNumero()}.
     */
    @Test
    void testGetNumero() {
        
        assertEquals(5, new Tour(new Joueur("Charles"), 5).getNumero());
        assertEquals(15, new Tour(new Joueur("Mingus"), 15).getNumero());
        assertNotEquals(15, new Tour(new Joueur("Charles"), 5).getNumero());
        assertNotEquals(5, new Tour(new Joueur("Mingus"), 15).getNumero());
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#getJetonsBleus()}.
     */
    @Test
    void testGetJetonsBleus() {

        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        assertEquals(0, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertEquals(1, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertNotEquals(1, roundUn.getJetonsBleus());
        assertEquals(2, roundUn.getJetonsBleus());
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#getJetonsRouges()}.
     */
    @Test
    void testGetJetonsRouges() {
        fail("Not yet implemented");
    }
    
    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#incrementJetonsBleus()}.
     */
    @Test
    void testIncrementJetonsBleus() {
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        assertEquals(0, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertEquals(1, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertNotEquals(1, roundUn.getJetonsBleus());
        assertEquals(2, roundUn.getJetonsBleus());
    }
    
    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#setJetonsBleus()}.
     */
    @Test
    void testSetJetonsBleus() {    
        Tour roundUn = new Tour(new Joueur("Emile"), 1);
        Tour roundDeux = new Tour(new Joueur("Parisien"), 2);
        assertEquals(0, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertEquals(1, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        assertNotEquals(0, roundUn.getJetonsBleus());
        assertNotEquals(1, roundUn.getJetonsBleus());
        assertEquals(2, roundUn.getJetonsBleus());
        
        roundUn.incrementJetonsBleus();
        roundDeux.setJetonsBleus(roundUn.getJetonsBleus());
        assertEquals(3, roundDeux.getJetonsBleus());
    }
    
    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#decrementJetonsBleus()}.
     */
    @Test
    void testDecrementJetonsBleus() {
        Tour roundTrois = new Tour(new Joueur("Parker"), 3);
        
        roundTrois.setJetonsBleus(4);
        assertEquals(4, roundTrois.getJetonsBleus());
        
        roundTrois.decrementJetonsBleus();
        assertEquals(3, roundTrois.getJetonsBleus());
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#incrementJetonsRouges()}.
     */
    @Test
    void testIncrementJetonsRouges() {
        fail("Not yet implemented");
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#donnerIndice(modele.jeu.Carte, char)}.
     */
    @Test
    void testDonnerIndice() {
        fail("Not yet implemented");
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#poser(modele.jeu.Carte)}.
     */
    @Test
    void testPoser() {
        fail("Not yet implemented");
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Tour#defausser(modele.jeu.Carte)}.
     */
    @Test
    void testDefausser() {
        fail("Not yet implemented");
    }

}
