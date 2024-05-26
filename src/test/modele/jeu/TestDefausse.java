/*
 * TestDefausse.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link modele.jeu.Defausse}
 */
class TestDefausse {

    /**
     * Méthode de test pour
     * {@link modele.jeu.Defausse#Defausse()}.
     */
    @Test
    void testDefausse() {
        Defausse defausse = new Defausse();
        assertDoesNotThrow(() -> new Defausse());
        assertNotNull(defausse.getDefausse(), "La défausse ne doit pas être "
                + "null.");
        assertTrue(defausse.getDefausse().isEmpty(), "La défausse doit "
                + "être vide à l'initialisation.");
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Defausse#getDefausse()}.
     */
    @Test
    void testGetDefausse() {
        Defausse defausse = new Defausse();
        Stack<Carte> pile = defausse.getDefausse();
        assertNotNull(defausse.getDefausse(), "La pile de la défausse ne doit "
                + "pas être null.");
        assertTrue(defausse.getDefausse().isEmpty(), "La pile de la défausse "
                + "doit être vide.");

        // Vérifie que la défausse contient la même chose que la pile 
        assertSame(pile, defausse.getDefausse(), "La méthode getDefausse() doit"
                + " renvoyer la même référence à la pile.");
    }

    /**
     * Méthode de test pour
     * {@link modele.jeu.Defausse#setDefausse(java.util.Stack)}.
     */
    @Test
    void testSetDefausse() {
        Defausse defausse = new Defausse();
        Stack<Carte> nouvellePile = new Stack<>();
        nouvellePile.push(new Carte(Couleur.ROUGE, Valeur.UN));
        nouvellePile.push(new Carte(Couleur.JAUNE, Valeur.DEUX));
        
        defausse.setDefausse(nouvellePile);
        assertEquals(nouvellePile, defausse.getDefausse(), "La défausse doit "
                + "être remplacée par la nouvelle pile.");
        assertEquals(2, defausse.getDefausse().size(), "La défausse doit "
                + "contenir 2 cartes.");
        
        // Avec une pile vide
        Stack<Carte> pileVide = new Stack<>();
        defausse.setDefausse(pileVide);
        assertEquals(pileVide, defausse.getDefausse(), "La défausse doit être "
                + "remplacée par une pile vide.");
        assertTrue(defausse.getDefausse().isEmpty(), "La défausse contenir 0 "
                + "carte.");
        
        // Avec une pile contenant une seule carte
        Stack<Carte> pileUnique = new Stack<>();
        pileUnique.push(new Carte(Couleur.BLEU, Valeur.TROIS));
        defausse.setDefausse(pileUnique);
        assertEquals(pileUnique, defausse.getDefausse(), "La défausse doit être"
                + " remplacée par la pile unique.");
        assertEquals(1, defausse.getDefausse().size(), "La défausse doit "
                + "contenir 1 carte.");
    }

}

