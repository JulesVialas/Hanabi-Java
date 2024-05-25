/*
 * TestPioche.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */
package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * TODO commenter la responsabilité de cette classe (SRP)
 */
class TestPioche {
    
    /**
     * Test method for {@link modele.jeu.Pioche#Pioche()}.
     */
    @Test
    void testPioche() {
        Pioche pioche = new Pioche();
        assertNotNull(pioche.getPioche(), "La pioche ne doit pas être null.");
        assertEquals(50, pioche.getPioche().size(), "La pioche doit contenir 50"
                + " cartes.");
        
        // Vérifie que les cartes sont mélangées 
        Carte[] jeuDeBase = Carte.jeuComplet();
        Stack<Carte> jeuPioche = pioche.getPioche();
        
        boolean estMélangé = false;
        for (int i = 0; i < jeuDeBase.length; i++) {
            if (!jeuDeBase[i].equals(jeuPioche.get(i))) {
                estMélangé = true;
                break;
            }
        }
        assertTrue(estMélangé, "Les cartes doivent être mélangées.");
    }
        

    /**
     * Test method for {@link modele.jeu.Pioche#getPioche()}.
     */
    @Test
    void testGetPioche() {
        Pioche pioche = new Pioche();
        Stack<Carte> pile = pioche.getPioche();
        assertNotNull(pile, "La pile de la pioche ne doit pas être null.");
        assertEquals(50, pile.size(), "La pile doit contenir 50 cartes.");
    }

    
    /**
     * Test method for {@link modele.jeu.Pioche#setPioche(java.util.Stack)}.
     */
    @Test
    void testSetPioche() {
        Pioche pioche = new Pioche();
        Stack<Carte> nouvellePile = new Stack<>();
        nouvellePile.push(new Carte(Couleur.ROUGE, Valeur.UN));
        nouvellePile.push(new Carte(Couleur.JAUNE, Valeur.DEUX));
        pioche.setPioche(nouvellePile);
        
        assertEquals(nouvellePile, pioche.getPioche(), "La pioche doit "
                + "être remplacée par la nouvelle pile.");
        assertEquals(2, pioche.getPioche().size(), "La nouvelle pioche doit"
                + " contenir 2 cartes.");
        
        // Avec une pile vide
        Stack<Carte> pileVide = new Stack<>();
        pioche.setPioche(pileVide);
        
        assertEquals(pileVide, pioche.getPioche(), "La pioche doit être"
                + " remplacée par une pile vide.");
        assertEquals(0, pioche.getPioche().size(), "La pioche doit contenir "
                + "0 carte.");
        
        // Avec pile contenant une seule carte
        Stack<Carte> pileCarteUnique = new Stack<>();
        pileCarteUnique.push(new Carte(Couleur.BLEU, Valeur.TROIS));       
        pioche.setPioche(pileCarteUnique);
        
        assertEquals(pileCarteUnique, pioche.getPioche(), "La pioche doit "
                + "être remplacée par la pile avec une unique carte.");
        assertEquals(1, pioche.getPioche().size(), "La pioche doit contenir 1 "
                + "carte.");
    }

}
