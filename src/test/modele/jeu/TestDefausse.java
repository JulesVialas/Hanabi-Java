package modele.jeu;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class TestDefausse {

    Defausse defausse = new Defausse();


    Stack<Carte>PileCarteVide = new Stack<>();

    Stack<Carte> PileCarte = new Stack<>();

    @Test
    void testDefausse() {
        assertDoesNotThrow(() -> new Defausse());
        assertTrue(defausse.getDefausse().empty());

    }

    @Test
    void testGetDefausse() {
        PileCarte.push(new Carte(Couleur.ROUGE, Valeur.UN));
        PileCarte.push(new Carte(Couleur.VERT, Valeur.TROIS));
        PileCarte.push(new Carte(Couleur.BLEU, Valeur.CINQ));
        defausse.setDefausse(PileCarte);

        assertDoesNotThrow(() -> defausse);
        assertFalse(defausse.getDefausse().empty());
        assertEquals(PileCarte, defausse.getDefausse());
        assertNotEquals(PileCarteVide, defausse.getDefausse());
    }

    @Test
    void testSetDefausse() {
        defausse.setDefausse(PileCarteVide);

        assertDoesNotThrow(() -> defausse);
        assertTrue(defausse.getDefausse().empty());

        PileCarte.push(new Carte(Couleur.JAUNE, Valeur.QUATRE));
        PileCarte.push(new Carte(Couleur.JAUNE, Valeur.UN));
        PileCarte.push(new Carte(Couleur.BLEU, Valeur.DEUX));
        defausse.setDefausse(PileCarte);
        assertDoesNotThrow(() -> defausse);
        assertFalse(defausse.getDefausse().empty());

    }
}