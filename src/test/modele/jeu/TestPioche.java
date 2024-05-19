/*
 * TestPioche.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */

package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPioche {
	

    Carte[] pioche1 = new Carte[] {
            new Carte(Couleur.ROUGE, Valeur.UN),
            new Carte(Couleur.BLEU, Valeur.DEUX),
            new Carte(Couleur.VERT, Valeur.TROIS),
    	};
    
    Carte[] pioche2 = new Carte[] {
            new Carte(Couleur.JAUNE, Valeur.QUATRE),
            new Carte(Couleur.BLEU, Valeur.UN)
    	};
    
    Carte[] piocheVide = new Carte[] {
    		
    	};
    
	@Test
	void testPioche() {
		assertDoesNotThrow(()->new Pioche(pioche1));
		assertDoesNotThrow(()->new Pioche(pioche2));
		assertDoesNotThrow(()->new Pioche(piocheVide));
		
		assertNotNull(pioche1);
		assertNotNull(pioche2);
	}
	

	@Test
    void testSetPile() {
		fail("Not yet implemented");
    }
}
