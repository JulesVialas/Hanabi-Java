/*
 * TestCarte.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link jeu.modele.Carte}.
 *
 * @author Corentin Solignac
 */
class TestCarte {

    /**
     * Méthode de test pour
     * {@link jeu.modele.Carte#Carte(modele.jeu.Carte.Couleur, int)}.
     */
    @Test
    void testCarte() {

        /* Carte avec couleur & valeur valides */
        assertDoesNotThrow(() -> new Carte(Couleur.ROUGE, Valeur.UN));
        assertDoesNotThrow(() -> new Carte(Couleur.ROUGE, Valeur.DEUX));
        assertDoesNotThrow(() -> new Carte(Couleur.ROUGE, Valeur.TROIS));
        assertDoesNotThrow(() -> new Carte(Couleur.ROUGE, Valeur.QUATRE));
        assertDoesNotThrow(() -> new Carte(Couleur.ROUGE, Valeur.CINQ));

        assertDoesNotThrow(() -> new Carte(Couleur.JAUNE, Valeur.UN));
        assertDoesNotThrow(() -> new Carte(Couleur.JAUNE, Valeur.DEUX));
        assertDoesNotThrow(() -> new Carte(Couleur.JAUNE, Valeur.TROIS));
        assertDoesNotThrow(() -> new Carte(Couleur.JAUNE, Valeur.QUATRE));
        assertDoesNotThrow(() -> new Carte(Couleur.JAUNE, Valeur.CINQ));

        assertDoesNotThrow(() -> new Carte(Couleur.VERT, Valeur.UN));
        assertDoesNotThrow(() -> new Carte(Couleur.VERT, Valeur.DEUX));
        assertDoesNotThrow(() -> new Carte(Couleur.VERT, Valeur.TROIS));
        assertDoesNotThrow(() -> new Carte(Couleur.VERT, Valeur.QUATRE));
        assertDoesNotThrow(() -> new Carte(Couleur.VERT, Valeur.CINQ));

        assertDoesNotThrow(() -> new Carte(Couleur.BLEU, Valeur.UN));
        assertDoesNotThrow(() -> new Carte(Couleur.BLEU, Valeur.DEUX));
        assertDoesNotThrow(() -> new Carte(Couleur.BLEU, Valeur.TROIS));
        assertDoesNotThrow(() -> new Carte(Couleur.BLEU, Valeur.QUATRE));
        assertDoesNotThrow(() -> new Carte(Couleur.BLEU, Valeur.CINQ));

        assertDoesNotThrow(() -> new Carte(Couleur.BLANC, Valeur.UN));
        assertDoesNotThrow(() -> new Carte(Couleur.BLANC, Valeur.DEUX));
        assertDoesNotThrow(() -> new Carte(Couleur.BLANC, Valeur.TROIS));
        assertDoesNotThrow(() -> new Carte(Couleur.BLANC, Valeur.QUATRE));
        assertDoesNotThrow(() -> new Carte(Couleur.BLANC, Valeur.CINQ));

        /* Carte avec couleur invalide */
        // Protégé grâce à l'enumération Couleur

        /* Carte avec couleur valide & valeur invalide */
        // Protégé grâce à l'enumération Valeur

        /* Carte avec couleur et valeur invalides */
        // Protégé grâce aux énumérations

        /* Carte valide, vérifier valeurConnue à false */
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.CINQ).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.DEUX).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.TROIS).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.VERT, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.CINQ).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.TROIS).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getValeurConnue());
    }

    /**
     * Méthode de test pour {@link jeu.modele.Carte#getCouleur()}.
     */
    @Test
    void testGetCouleur() {
        assertEquals(Couleur.ROUGE,
                new Carte(Couleur.ROUGE, Valeur.UN).getCouleur());
        assertEquals(Couleur.ROUGE,
                new Carte(Couleur.ROUGE, Valeur.DEUX).getCouleur());
        assertEquals(Couleur.ROUGE,
                new Carte(Couleur.ROUGE, Valeur.TROIS).getCouleur());
        assertEquals(Couleur.ROUGE,
                new Carte(Couleur.ROUGE, Valeur.QUATRE).getCouleur());
        assertEquals(Couleur.ROUGE,
                new Carte(Couleur.ROUGE, Valeur.CINQ).getCouleur());

        assertNotEquals(Couleur.JAUNE,
                new Carte(Couleur.ROUGE, Valeur.UN).getCouleur());
        assertNotEquals(Couleur.VERT,
                new Carte(Couleur.ROUGE, Valeur.DEUX).getCouleur());
        assertNotEquals(Couleur.BLEU,
                new Carte(Couleur.ROUGE, Valeur.TROIS).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.ROUGE, Valeur.QUATRE).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.ROUGE, Valeur.CINQ).getCouleur());

        assertEquals(Couleur.JAUNE,
                new Carte(Couleur.JAUNE, Valeur.UN).getCouleur());
        assertEquals(Couleur.JAUNE,
                new Carte(Couleur.JAUNE, Valeur.DEUX).getCouleur());
        assertEquals(Couleur.JAUNE,
                new Carte(Couleur.JAUNE, Valeur.TROIS).getCouleur());
        assertEquals(Couleur.JAUNE,
                new Carte(Couleur.JAUNE, Valeur.QUATRE).getCouleur());
        assertEquals(Couleur.JAUNE,
                new Carte(Couleur.JAUNE, Valeur.CINQ).getCouleur());

        assertNotEquals(Couleur.ROUGE,
                new Carte(Couleur.JAUNE, Valeur.UN).getCouleur());
        assertNotEquals(Couleur.VERT,
                new Carte(Couleur.JAUNE, Valeur.DEUX).getCouleur());
        assertNotEquals(Couleur.BLEU,
                new Carte(Couleur.JAUNE, Valeur.TROIS).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.JAUNE, Valeur.QUATRE).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.JAUNE, Valeur.CINQ).getCouleur());

        assertEquals(Couleur.VERT,
                new Carte(Couleur.VERT, Valeur.UN).getCouleur());
        assertEquals(Couleur.VERT,
                new Carte(Couleur.VERT, Valeur.DEUX).getCouleur());
        assertEquals(Couleur.VERT,
                new Carte(Couleur.VERT, Valeur.TROIS).getCouleur());
        assertEquals(Couleur.VERT,
                new Carte(Couleur.VERT, Valeur.QUATRE).getCouleur());
        assertEquals(Couleur.VERT,
                new Carte(Couleur.VERT, Valeur.CINQ).getCouleur());

        assertNotEquals(Couleur.ROUGE,
                new Carte(Couleur.VERT, Valeur.UN).getCouleur());
        assertNotEquals(Couleur.JAUNE,
                new Carte(Couleur.VERT, Valeur.DEUX).getCouleur());
        assertNotEquals(Couleur.BLEU,
                new Carte(Couleur.VERT, Valeur.TROIS).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.VERT, Valeur.QUATRE).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.VERT, Valeur.CINQ).getCouleur());

        assertEquals(Couleur.BLEU,
                new Carte(Couleur.BLEU, Valeur.UN).getCouleur());
        assertEquals(Couleur.BLEU,
                new Carte(Couleur.BLEU, Valeur.DEUX).getCouleur());
        assertEquals(Couleur.BLEU,
                new Carte(Couleur.BLEU, Valeur.TROIS).getCouleur());
        assertEquals(Couleur.BLEU,
                new Carte(Couleur.BLEU, Valeur.QUATRE).getCouleur());
        assertEquals(Couleur.BLEU,
                new Carte(Couleur.BLEU, Valeur.CINQ).getCouleur());

        assertNotEquals(Couleur.ROUGE,
                new Carte(Couleur.BLEU, Valeur.UN).getCouleur());
        assertNotEquals(Couleur.JAUNE,
                new Carte(Couleur.BLEU, Valeur.DEUX).getCouleur());
        assertNotEquals(Couleur.VERT,
                new Carte(Couleur.BLEU, Valeur.TROIS).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.BLEU, Valeur.QUATRE).getCouleur());
        assertNotEquals(Couleur.BLANC,
                new Carte(Couleur.BLEU, Valeur.CINQ).getCouleur());

        assertEquals(Couleur.BLANC,
                new Carte(Couleur.BLANC, Valeur.UN).getCouleur());
        assertEquals(Couleur.BLANC,
                new Carte(Couleur.BLANC, Valeur.DEUX).getCouleur());
        assertEquals(Couleur.BLANC,
                new Carte(Couleur.BLANC, Valeur.TROIS).getCouleur());
        assertEquals(Couleur.BLANC,
                new Carte(Couleur.BLANC, Valeur.QUATRE).getCouleur());
        assertEquals(Couleur.BLANC,
                new Carte(Couleur.BLANC, Valeur.CINQ).getCouleur());

        assertNotEquals(Couleur.ROUGE,
                new Carte(Couleur.BLANC, Valeur.UN).getCouleur());
        assertNotEquals(Couleur.JAUNE,
                new Carte(Couleur.BLANC, Valeur.DEUX).getCouleur());
        assertNotEquals(Couleur.VERT,
                new Carte(Couleur.BLANC, Valeur.TROIS).getCouleur());
        assertNotEquals(Couleur.BLEU,
                new Carte(Couleur.BLANC, Valeur.QUATRE).getCouleur());
        assertNotEquals(Couleur.BLEU,
                new Carte(Couleur.BLANC, Valeur.CINQ).getCouleur());
    }

    /**
     * Méthode de test pour {@link jeu.modele.Carte#getValeur()}.
     */
    @Test
    void testGetValeur() {

        assertEquals(Valeur.UN,
                new Carte(Couleur.ROUGE, Valeur.UN).getValeur());
        assertEquals(Valeur.DEUX,
                new Carte(Couleur.ROUGE, Valeur.DEUX).getValeur());
        assertEquals(Valeur.TROIS,
                new Carte(Couleur.ROUGE, Valeur.TROIS).getValeur());
        assertEquals(Valeur.QUATRE,
                new Carte(Couleur.ROUGE, Valeur.QUATRE).getValeur());
        assertEquals(Valeur.CINQ,
                new Carte(Couleur.ROUGE, Valeur.CINQ).getValeur());

        assertNotEquals(Valeur.DEUX,
                new Carte(Couleur.ROUGE, Valeur.UN).getValeur());
        assertNotEquals(Valeur.TROIS,
                new Carte(Couleur.ROUGE, Valeur.DEUX).getValeur());
        assertNotEquals(Valeur.QUATRE,
                new Carte(Couleur.ROUGE, Valeur.TROIS).getValeur());
        assertNotEquals(Valeur.CINQ,
                new Carte(Couleur.ROUGE, Valeur.QUATRE).getValeur());
        assertNotEquals(Valeur.UN,
                new Carte(Couleur.ROUGE, Valeur.CINQ).getValeur());

        assertEquals(Valeur.UN,
                new Carte(Couleur.JAUNE, Valeur.UN).getValeur());
        assertEquals(Valeur.DEUX,
                new Carte(Couleur.JAUNE, Valeur.DEUX).getValeur());
        assertEquals(Valeur.TROIS,
                new Carte(Couleur.JAUNE, Valeur.TROIS).getValeur());
        assertEquals(Valeur.QUATRE,
                new Carte(Couleur.JAUNE, Valeur.QUATRE).getValeur());
        assertEquals(Valeur.CINQ,
                new Carte(Couleur.JAUNE, Valeur.CINQ).getValeur());

        assertNotEquals(Valeur.TROIS,
                new Carte(Couleur.JAUNE, Valeur.UN).getValeur());
        assertNotEquals(Valeur.QUATRE,
                new Carte(Couleur.JAUNE, Valeur.DEUX).getValeur());
        assertNotEquals(Valeur.CINQ,
                new Carte(Couleur.JAUNE, Valeur.TROIS).getValeur());
        assertNotEquals(Valeur.UN,
                new Carte(Couleur.JAUNE, Valeur.QUATRE).getValeur());
        assertNotEquals(Valeur.DEUX,
                new Carte(Couleur.JAUNE, Valeur.CINQ).getValeur());

        assertEquals(Valeur.UN, new Carte(Couleur.VERT, Valeur.UN).getValeur());
        assertEquals(Valeur.DEUX,
                new Carte(Couleur.VERT, Valeur.DEUX).getValeur());
        assertEquals(Valeur.TROIS,
                new Carte(Couleur.VERT, Valeur.TROIS).getValeur());
        assertEquals(Valeur.QUATRE,
                new Carte(Couleur.VERT, Valeur.QUATRE).getValeur());
        assertEquals(Valeur.CINQ,
                new Carte(Couleur.VERT, Valeur.CINQ).getValeur());

        assertNotEquals(Valeur.QUATRE,
                new Carte(Couleur.VERT, Valeur.UN).getValeur());
        assertNotEquals(Valeur.CINQ,
                new Carte(Couleur.VERT, Valeur.DEUX).getValeur());
        assertNotEquals(Valeur.UN,
                new Carte(Couleur.VERT, Valeur.TROIS).getValeur());
        assertNotEquals(Valeur.DEUX,
                new Carte(Couleur.VERT, Valeur.QUATRE).getValeur());
        assertNotEquals(Valeur.TROIS,
                new Carte(Couleur.VERT, Valeur.CINQ).getValeur());

        assertEquals(Valeur.UN, new Carte(Couleur.BLEU, Valeur.UN).getValeur());
        assertEquals(Valeur.DEUX,
                new Carte(Couleur.BLEU, Valeur.DEUX).getValeur());
        assertEquals(Valeur.TROIS,
                new Carte(Couleur.BLEU, Valeur.TROIS).getValeur());
        assertEquals(Valeur.QUATRE,
                new Carte(Couleur.BLEU, Valeur.QUATRE).getValeur());
        assertEquals(Valeur.CINQ,
                new Carte(Couleur.BLEU, Valeur.CINQ).getValeur());

        assertNotEquals(Valeur.CINQ,
                new Carte(Couleur.BLEU, Valeur.UN).getValeur());
        assertNotEquals(Valeur.UN,
                new Carte(Couleur.BLEU, Valeur.DEUX).getValeur());
        assertNotEquals(Valeur.DEUX,
                new Carte(Couleur.BLEU, Valeur.TROIS).getValeur());
        assertNotEquals(Valeur.TROIS,
                new Carte(Couleur.BLEU, Valeur.QUATRE).getValeur());
        assertNotEquals(Valeur.QUATRE,
                new Carte(Couleur.BLEU, Valeur.CINQ).getValeur());

        assertEquals(Valeur.UN,
                new Carte(Couleur.BLANC, Valeur.UN).getValeur());
        assertEquals(Valeur.DEUX,
                new Carte(Couleur.BLANC, Valeur.DEUX).getValeur());
        assertEquals(Valeur.TROIS,
                new Carte(Couleur.BLANC, Valeur.TROIS).getValeur());
        assertEquals(Valeur.QUATRE,
                new Carte(Couleur.BLANC, Valeur.QUATRE).getValeur());
        assertEquals(Valeur.CINQ,
                new Carte(Couleur.BLANC, Valeur.CINQ).getValeur());

        assertNotEquals(Valeur.DEUX,
                new Carte(Couleur.BLANC, Valeur.UN).getValeur());
        assertNotEquals(Valeur.TROIS,
                new Carte(Couleur.BLANC, Valeur.DEUX).getValeur());
        assertNotEquals(Valeur.UN,
                new Carte(Couleur.BLANC, Valeur.TROIS).getValeur());
        assertNotEquals(Valeur.CINQ,
                new Carte(Couleur.BLANC, Valeur.QUATRE).getValeur());
        assertNotEquals(Valeur.QUATRE,
                new Carte(Couleur.BLANC, Valeur.CINQ).getValeur());
    }

    /**
     * Méthode de test pour {@link jeu.modele.Carte#getCouleurConnue()}.
     */
    @Test
    void testGetCouleurConnue() {

        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.UN).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.DEUX).getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.ROUGE, Valeur.TROIS)
                .getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.CINQ).getCouleurConnue());

        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.UN).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.DEUX).getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.JAUNE, Valeur.TROIS)
                .getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.CINQ).getCouleurConnue());

        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.UN).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.DEUX).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.TROIS).getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.VERT, Valeur.QUATRE)
                .getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.CINQ).getCouleurConnue());

        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.UN).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.DEUX).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.TROIS).getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.BLEU, Valeur.QUATRE)
                .getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.CINQ).getCouleurConnue());

        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.UN).getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.DEUX).getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.BLANC, Valeur.TROIS)
                .getCouleurConnue());
        assertFalse(() -> new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getCouleurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.CINQ).getCouleurConnue());

        /* Tests après setter pour passer couleurConnue sur true */
        // Testé implicitement dans les méthodes de test des setters
    }

    /**
     * Méthode de test pour {@link jeu.modele.Carte#getValeurConnue()}.
     */
    @Test
    void testGetValeurConnue() {

        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.TROIS).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.ROUGE, Valeur.QUATRE)
                .getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.ROUGE, Valeur.CINQ).getValeurConnue());

        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.TROIS).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.JAUNE, Valeur.QUATRE)
                .getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.JAUNE, Valeur.CINQ).getValeurConnue());

        assertFalse(() -> new Carte(Couleur.VERT, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.TROIS).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.QUATRE).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.VERT, Valeur.CINQ).getValeurConnue());

        assertFalse(() -> new Carte(Couleur.BLEU, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.TROIS).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.QUATRE).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLEU, Valeur.CINQ).getValeurConnue());

        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.UN).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.DEUX).getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.TROIS).getValeurConnue());
        assertFalse(() -> new Carte(Couleur.BLANC, Valeur.QUATRE)
                .getValeurConnue());
        assertFalse(
                () -> new Carte(Couleur.BLANC, Valeur.CINQ).getValeurConnue());

        /* Tests après setter pour passer valeurConnue sur true */
        // Testé implicitement dans les méthodes de test des setters
    }

    /**
     * Méthode de test pour
     * {@link jeu.modele.Carte#setCouleurConnue(boolean)}.
     */
    @Test
    void testSetCouleurConnue() {

        /* Jeu de test */
        Carte unRouge = new Carte(Couleur.ROUGE, Valeur.UN);
        Carte deuxJaune = new Carte(Couleur.JAUNE, Valeur.DEUX);
        Carte troisVert = new Carte(Couleur.VERT, Valeur.TROIS);
        Carte quatreBleu = new Carte(Couleur.BLEU, Valeur.QUATRE);
        Carte cinqBlanc = new Carte(Couleur.BLANC, Valeur.CINQ);

        /* Changement d'état pour l'attribut couleurConnue */
        unRouge.setCouleurConnue(true);
        deuxJaune.setCouleurConnue(true);
        troisVert.setCouleurConnue(true);
        quatreBleu.setCouleurConnue(true);
        cinqBlanc.setCouleurConnue(true);

        /* L'attribut est à true */
        assertTrue(unRouge.getCouleurConnue());
        assertTrue(deuxJaune.getCouleurConnue());
        assertTrue(troisVert.getCouleurConnue());
        assertTrue(quatreBleu.getCouleurConnue());
        assertTrue(cinqBlanc.getCouleurConnue());

        /* Changement d'état pour l'attribut couleurConnue */
        unRouge.setCouleurConnue(false);
        deuxJaune.setCouleurConnue(false);
        troisVert.setCouleurConnue(false);
        quatreBleu.setCouleurConnue(false);
        cinqBlanc.setCouleurConnue(false);

        /* L'attribut est à false */
        assertFalse(unRouge.getCouleurConnue());
        assertFalse(deuxJaune.getCouleurConnue());
        assertFalse(troisVert.getCouleurConnue());
        assertFalse(quatreBleu.getCouleurConnue());
        assertFalse(cinqBlanc.getCouleurConnue());
    }

    /**
     * Méthode de test pour
     * {@link jeu.modele.Carte#setValeurConnue(boolean)}.
     */
    @Test
    void testSetValeurConnue() {

        /* Jeu de test */
        Carte unRouge = new Carte(Couleur.ROUGE, Valeur.UN);
        Carte deuxJaune = new Carte(Couleur.JAUNE, Valeur.DEUX);
        Carte troisVert = new Carte(Couleur.VERT, Valeur.TROIS);
        Carte quatreBleu = new Carte(Couleur.BLEU, Valeur.QUATRE);
        Carte cinqBlanc = new Carte(Couleur.BLANC, Valeur.CINQ);

        /* Changement d'état pour l'attribut valeurConnue */
        unRouge.setValeurConnue(true);
        deuxJaune.setValeurConnue(true);
        troisVert.setValeurConnue(true);
        quatreBleu.setValeurConnue(true);
        cinqBlanc.setValeurConnue(true);

        /* L'attribut est à true */
        assertTrue(unRouge.getValeurConnue());
        assertTrue(deuxJaune.getValeurConnue());
        assertTrue(troisVert.getValeurConnue());
        assertTrue(quatreBleu.getValeurConnue());
        assertTrue(cinqBlanc.getValeurConnue());

        /* Changement d'état pour l'attribut valeurConnue */
        unRouge.setValeurConnue(false);
        deuxJaune.setValeurConnue(false);
        troisVert.setValeurConnue(false);
        quatreBleu.setValeurConnue(false);
        cinqBlanc.setValeurConnue(false);

        /* L'attribut est à false */
        assertFalse(unRouge.getValeurConnue());
        assertFalse(deuxJaune.getValeurConnue());
        assertFalse(troisVert.getValeurConnue());
        assertFalse(quatreBleu.getValeurConnue());
        assertFalse(cinqBlanc.getValeurConnue());
    }

    /**
     * Méthode de test pour {@link jeu.modele.Carte#toString()}.
     */
    @Test
    void testToString() {
        fail("Not yet implemented");
    }
}
