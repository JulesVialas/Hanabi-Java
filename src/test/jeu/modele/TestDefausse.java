/*
 * TestDefausse.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link jeu.modele.Defausse}
 */
class TestDefausse {

    /**
     * Méthode de test pour {@link jeu.modele.Defausse#Defausse()}.
     */
    @Test
    void testDefausse() {
        Defausse defausse = new Defausse();
        assertDoesNotThrow(() -> new Defausse());
        assertNotNull(defausse.getPaquet(),
                "La défausse ne doit pas être " + "null.");
        assertTrue(defausse.getPaquet().isEmpty(),
                "La défausse doit " + "être vide à l'initialisation.");
    }

    /**
     * Méthode de test pour {@link jeu.modele.Defausse#getPaquet()}.
     */
    @Test
    void testgetPaquet() {
        Defausse defausse = new Defausse();
        Stack<Carte> pile = defausse.getPaquet();
        assertNotNull(defausse.getPaquet(),
                "La pile de la défausse ne doit " + "pas être null.");
        assertTrue(defausse.getPaquet().isEmpty(),
                "La pile de la défausse " + "doit être vide.");

        // Vérifie que la défausse contient la même chose que la pile
        assertSame(pile, defausse.getPaquet(), "La méthode getPaquet() doit"
                + " renvoyer la même référence à la pile.");
    }

    /**
     * Méthode de test pour
     * {@link jeu.modele.Defausse#setDefausse(java.util.Stack)}.
     */
    @Test
    void testSetDefausse() {
        Defausse defausse = new Defausse();
        Stack<Carte> nouvellePile = new Stack<>();
        nouvellePile.push(new Carte(Couleur.ROUGE, Valeur.UN));
        nouvellePile.push(new Carte(Couleur.JAUNE, Valeur.DEUX));

        defausse.setDefausse(nouvellePile);
        assertEquals(nouvellePile, defausse.getPaquet(),
                "La défausse doit " + "être remplacée par la nouvelle pile.");
        assertEquals(2, defausse.getPaquet().size(),
                "La défausse doit " + "contenir 2 cartes.");

        // Avec une pile vide
        Stack<Carte> pileVide = new Stack<>();
        defausse.setDefausse(pileVide);
        assertEquals(pileVide, defausse.getPaquet(),
                "La défausse doit être " + "remplacée par une pile vide.");
        assertTrue(defausse.getPaquet().isEmpty(),
                "La défausse contenir 0 " + "carte.");

        // Avec une pile contenant une seule carte
        Stack<Carte> pileUnique = new Stack<>();
        pileUnique.push(new Carte(Couleur.BLEU, Valeur.TROIS));
        defausse.setDefausse(pileUnique);
        assertEquals(pileUnique, defausse.getPaquet(),
                "La défausse doit être" + " remplacée par la pile unique.");
        assertEquals(1, defausse.getPaquet().size(),
                "La défausse doit " + "contenir 1 carte.");
    }

}
