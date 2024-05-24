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
        /* La pile est initialisée vide */
        assertTrue(new CartesPlateau().getPileRouge().empty());
        
        /* Testé implicitement dans les méthodes de test des setters */
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileJaune()}.
     */
    @Test
    void testGetPileJaune() {
        /* La pile est initialisée vide */
        assertTrue(new CartesPlateau().getPileJaune().empty());
        
        /* Testé implicitement dans les méthodes de test des setters */
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileVert()}.
     */
    @Test
    void testGetPileVert() {
        /* La pile est initialisée vide */
        assertTrue(new CartesPlateau().getPileVert().empty());
        
        /* Testé implicitement dans les méthodes de test des setters */
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileBleu()}.
     */
    @Test
    void testGetPileBleu() {
        /* La pile est initialisée vide */
        assertTrue(new CartesPlateau().getPileBleu().empty());
        
        /* Testé implicitement dans les méthodes de test des setters */
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#getPileBlanc()}.
     */
    @Test
    void testGetPileBlanc() {
        /* La pile est initialisée vide */
        assertTrue(new CartesPlateau().getPileBlanc().empty());
        
        /* Testé implicitement dans les méthodes de test des setters */
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
        
        /* Couleur invalide pour la pile en question */
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileJaune(new Carte(Couleur.VERT, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileJaune(new Carte(Couleur.ROUGE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileJaune(new Carte(Couleur.BLEU, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileJaune(new Carte(Couleur.BLANC, Valeur.UN))); 
        
        /* Pile de test */
        CartesPlateau jeu1 = new CartesPlateau();
        assertTrue(jeu1.getPileJaune().empty());
        
        /* On essaie d'insérer une carte autre que 1 sur pile vide */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.CINQ)));
       
        /* On a ajoute une carte à la pile vide */
        assertDoesNotThrow(
            ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.UN)));


        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.CINQ)));
        
        /* Valeur suivante est 2 car last stack est 1 */
        assertDoesNotThrow(
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.DEUX)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.CINQ)));
        
        /* Valeur suivante est 3 car last stack est 2 */
        assertDoesNotThrow(
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.TROIS)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.CINQ)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.UN)));
        
        /* Valeur suivante est 4 car last stack est 3 */
        assertDoesNotThrow(
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.QUATRE)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.UN)));
        
        /* Valeur suivante est 5 car last stack est 4 */
        assertDoesNotThrow(
                ()->jeu1.setPileJaune(new Carte(Couleur.JAUNE, Valeur.CINQ)));
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileVert(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileVert() {
        
        /* Couleur invalide pour la pile en question */
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileVert(new Carte(Couleur.ROUGE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileVert(new Carte(Couleur.JAUNE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileVert(new Carte(Couleur.BLEU, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileVert(new Carte(Couleur.BLANC, Valeur.UN))); 
        
        /* Pile de test */
        CartesPlateau jeu1 = new CartesPlateau();
        assertTrue(jeu1.getPileVert().empty());
        
        /* On essaie d'insérer une carte autre que 1 sur pile vide */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.CINQ)));
       
        /* On a ajoute une carte à la pile vide */
        assertDoesNotThrow(
            ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.UN)));

        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.CINQ)));
        
        /* Valeur suivante est 2 car last stack est 1 */
        assertDoesNotThrow(
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.DEUX)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.CINQ)));
        
        /* Valeur suivante est 3 car last stack est 2 */
        assertDoesNotThrow(
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.TROIS)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.CINQ)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.UN)));
        
        /* Valeur suivante est 4 car last stack est 3 */
        assertDoesNotThrow(
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.QUATRE)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.UN)));
        
        /* Valeur suivante est 5 car last stack est 4 */
        assertDoesNotThrow(
                ()->jeu1.setPileVert(new Carte(Couleur.VERT, Valeur.CINQ)));
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileBleu(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileBleu() {
        
        /* Couleur invalide pour la pile en question */
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBleu(new Carte(Couleur.VERT, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBleu(new Carte(Couleur.JAUNE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBleu(new Carte(Couleur.ROUGE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBleu(new Carte(Couleur.BLANC, Valeur.UN))); 
        
        /* Pile de test */
        CartesPlateau jeu1 = new CartesPlateau();
        assertTrue(jeu1.getPileBleu().empty());
        
        /* On essaie d'insérer une carte autre que 1 sur pile vide */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.CINQ)));
       
        /* On a ajoute une carte à la pile vide */
        assertDoesNotThrow(
            ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.UN)));


        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.CINQ)));
        
        /* Valeur suivante est 2 car last stack est 1 */
        assertDoesNotThrow(
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.DEUX)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.CINQ)));
        
        /* Valeur suivante est 3 car last stack est 2 */
        assertDoesNotThrow(
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.TROIS)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.CINQ)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.UN)));
        
        /* Valeur suivante est 4 car last stack est 3 */
        assertDoesNotThrow(
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.QUATRE)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.UN)));
        
        /* Valeur suivante est 5 car last stack est 4 */
        assertDoesNotThrow(
                ()->jeu1.setPileBleu(new Carte(Couleur.BLEU, Valeur.CINQ)));
    }

    /**
     * Test method for {@link modele.jeu.CartesPlateau#setPileBlanc(modele.jeu.Carte)}.
     */
    @Test
    void testSetPileBlanc() {
        
        /* Couleur invalide pour la pile en question */
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBlanc(new Carte(Couleur.VERT, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBlanc(new Carte(Couleur.JAUNE, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBlanc(new Carte(Couleur.BLEU, Valeur.UN))); 
        assertThrows(IllegalArgumentException.class,
                ()->new CartesPlateau()
                .setPileBlanc(new Carte(Couleur.ROUGE, Valeur.UN))); 
        
        /* Pile de test */
        CartesPlateau jeu1 = new CartesPlateau();
        assertTrue(jeu1.getPileBlanc().empty());
        
        /* On essaie d'insérer une carte autre que 1 sur pile vide */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.CINQ)));
       
        /* On a ajoute une carte à la pile vide */
        assertDoesNotThrow(
            ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.UN)));


        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.CINQ)));
        
        /* Valeur suivante est 2 car last stack est 1 */
        assertDoesNotThrow(
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.DEUX)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.UN)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.CINQ)));
        
        /* Valeur suivante est 3 car last stack est 2 */
        assertDoesNotThrow(
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.TROIS)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.CINQ)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.UN)));
        
        /* Valeur suivante est 4 car last stack est 3 */
        assertDoesNotThrow(
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.QUATRE)));
        
        /* 
         * La valeur de la carte a poser n'est pas la valeur suivante
         * par rapport à la dernière posée, mais la couleur est la bonne
         */
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.QUATRE)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.TROIS)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.DEUX)));
        assertThrows(IllegalArgumentException.class,
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.UN)));
        
        /* Valeur suivante est 5 car last stack est 4 */
        assertDoesNotThrow(
                ()->jeu1.setPileBlanc(new Carte(Couleur.BLANC, Valeur.CINQ)));
    }

}
