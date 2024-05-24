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
        jetons.setBleus(5);
        assertEquals(5, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setBleu(int)}.
     */
    @Test
    public void testSetBleuInvalideTropHaut() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setBleus(9);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setBleu(int)}.
     */
    @Test
    public void testSetBleuInvalideTropBas() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setBleus(-1);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeValide() {
        jetons.setRouges(2);
        assertEquals(2, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeInvalideTropHaut() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setRouges(4);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#setRouge(int)}.
     */
    @Test
    public void testSetRougeInvalideTropBas() {
        assertThrows(IllegalStateException.class, () -> {
            jetons.setRouges(-1);
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementBleus()}.
     */
    @Test
    public void testIncrementeBleusValide() {
        jetons.setBleus(7);
        jetons.incrementBleus();
        assertEquals(8, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementBleus()}.
     */
    @Test
    public void testIncrementeInvalide() {
        jetons.setBleus(8);
        assertThrows(IllegalStateException.class, () -> {
            jetons.incrementBleus();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementBleus()}.
     */
    @Test
    public void testDecrementeBleusValide() {
        jetons.setBleus(1);
        jetons.decrementBleus();
        assertEquals(0, jetons.getBleus());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementBleus()}.
     */
    @Test
    public void testDecrementeBleusInvalide() {
        jetons.setBleus(0);
        assertThrows(IllegalStateException.class, () -> {
            jetons.decrementBleus();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementRouges()}.
     */
    @Test
    public void testIncrementeJetonsRougesValide() {
        jetons.setRouges(2);
        jetons.incrementRouges();
        assertEquals(3, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#incrementRouges()}.
     */
    @Test
    public void testIncrementeJetonsRougesInvalide() {
        jetons.setRouges(3);
        assertThrows(IllegalStateException.class, () -> {
            jetons.incrementRouges();
        });
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementRouges()}.
     */
    @Test
    public void testDecrementeJetonsRougesValide() {
        jetons.setRouges(1);
        jetons.decrementRouges();
        assertEquals(0, jetons.getRouges());
    }

    /**
     * Test method for {@link modele.jeu.JetonsPlateau#decrementRouges()}.
     */
    @Test
    public void testDecrementeJetonsRougesInvalide() {
        jetons.setRouges(0);
        assertThrows(IllegalStateException.class, () -> {
            jetons.decrementRouges();
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
