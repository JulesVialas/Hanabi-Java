/*
 * TestCartesPlateau.java                                            24 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
class TestCartesPlateau {

    /**
     * Test method for {@link modele.jeu.CartesPlateau#CartesPlateau()}.
     */
    @Test
    void testCartesPlateau() {
        assertDoesNotThrow(() -> new CartesPlateau());
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileRouge()}.
     */
    @Test
    void testGetPileRouge() {
        
        /* Retourne null si la pile est vide */
        assertEquals(null, new CartesPlateau().getPileRouge());
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileJaune()}.
     */
    @Test
    void testGetPileJaune() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileVert()}.
     */
    @Test
    void testGetPileVert() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileBleu()}.
     */
    @Test
    void testGetPileBleu() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileBlanc()}.
     */
    @Test
    void testGetPileBlanc() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileRouge(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileRouge() {
        
        /* Couleur invalide pour la pile en question */
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileRouge(new Carte(Couleur.VERT, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileRouge(new Carte(Couleur.JAUNE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileRouge(new Carte(Couleur.BLEU, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileRouge(new Carte(Couleur.BLANC, Valeur.UN))); 
        
        /* Pile de test */
        CartesPlateau jeu1 = new CartesPlateau();
        assertTrue(jeu1.getPileRouge().empty());
        
        /* On essaie d'insérer une carte autre que 1 sur pile vide */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.CINQ)));
       
        /* On a ajoute une carte à la pile vide */
        assertDoesNotThrow(
            ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.UN)));


        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.CINQ)));
        
        /* Valeur suivante est 2 car last stack est 1 */
        assertDoesNotThrow(
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.DEUX)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.CINQ)));
        
        /* Valeur suivante est 3 car last stack est 2 */
        assertDoesNotThrow(
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.TROIS)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.CINQ)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.UN)));
        
        /* Valeur suivante est 4 car last stack est 3 */
        assertDoesNotThrow(
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.QUATRE)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.UN)));
        
        /* Valeur suivante est 5 car last stack est 4 */
        assertDoesNotThrow(
                ()->jeu1.setPileRouge(new Carte(Couleur.ROUGE, Valeur.CINQ)));
        
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileJaune(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileJaune() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileVert(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileVert() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileBleu(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileBleu() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileBlanc(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileBlanc() {
        fail("Not yet implemented");
    }

}
