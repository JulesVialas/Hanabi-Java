package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link modele.jeu.JetonsPlateau}.
 * 
 * @author Jules Vialas
 */
public class TestJetonsPlateau {

    private JetonsPlateau jetons;

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#JetonsPlateau()}.
     */
    @BeforeEach
    public void setUp() {
        jetons = new JetonsPlateau();
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#JetonsPlateau()}.
     */
    @Test
    public void testValeursInitiales() {
        assertEquals(8, jetons.getBleus());
        assertEquals(0, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setBleu(int)}.
     */
    @Test
    public void testSetBleuValide() {
        jetons.setBleu(5);
        assertEquals(5, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setBleu(int)}.
     */
    @Test
    public void testSetBleuInvalideTropHaut() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setBleu(9);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setBleu(int)}.
     */
    @Test
    public void testSetBleuInvalideTropBas() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setBleu(-1);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeValide() {
        jetons.setRouge(2);
        assertEquals(2, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeInvalideTropHaut() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setRouge(4);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeInvalideTropBas() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setRouge(-1);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementJetonsBleus()}.
     */
    @Test
    public void testIncrementeJetonsBleusValide() {
        jetons.setBleu(7);
        jetons.incrementJetonsBleus();
        assertEquals(8, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementJetonsBleus()}.
     */
    @Test
    public void testIncrementeJetonsBleusInvalide() {
        jetons.setBleu(8);
        assertThrows(IllegalStateException.class, () -> {
            jetons.incrementJetonsBleus();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementJetonsBleus()}.
     */
    @Test
    public void testDecrementeJetonsBleusValide() {
        jetons.setBleu(1);
        jetons.decrementJetonsBleus();
        assertEquals(0, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementJetonsBleus()}.
     */
    @Test
    public void testDecrementeJetonsBleusInvalide() {
        jetons.setBleu(0);
        assertThrows(IllegalStateException.class, () -> {
            jetons.decrementJetonsBleus();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementJetonsRouges()}.
     */
    @Test
    public void testIncrementeJetonsRougesValide() {
        jetons.setRouge(2);
        jetons.incrementJetonsRouges();
        assertEquals(3, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementJetonsRouges()}.
     */
    @Test
    public void testIncrementeJetonsRougesInvalide() {
        jetons.setRouge(3);
        assertThrows(IllegalStateException.class, () -> {
            jetons.incrementJetonsRouges();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementJetonsRouges()}.
     */
    @Test
    public void testDecrementeJetonsRougesValide() {
        jetons.setRouge(1);
        jetons.decrementJetonsRouges();
        assertEquals(0, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementJetonsRouges()}.
     */
    @Test
    public void testDecrementeJetonsRougesInvalide() {
        jetons.setRouge(0);
        assertThrows(IllegalStateException.class, () -> {
            jetons.decrementJetonsRouges();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#getBleus()}.
     */
    @Test
    void testGetBleus() {
        // testé dans{@link modele.jeu.TestJetonsPlateau#testValeursInitiales()}
        // {@link modele.jeu.TestJetonsPlateau#testSetBleuValide()}
        // {@link modele.jeu.TestJetonsPlateau#testIncrementeJetonsBleusValide()}

    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#getRouges()}.
     */
    @Test
    void testGetRouges() {
        // testé dans {@link modele.jeu.TestJetonsPlateau#testValeursInitiales()}
        // {@link modele.jeu.TestJetonsPlateau#testSetRougeValide()}
        // {@link modele.jeu.TestJetonsPlateau#testIncrementeJetonsRougesValide()}
    }
}
