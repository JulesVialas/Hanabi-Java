package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestDefausse {

	Defausse defausse = new Defausse();
	
	ArrayList<Carte> TableauCarte = new ArrayList<>(Arrays.asList(
            new Carte(Couleur.ROUGE, Valeur.UN),
            new Carte(Couleur.BLEU, Valeur.DEUX),
            new Carte(Couleur.VERT, Valeur.TROIS)
    ));
	
	@Test
	void testDefausse() {
		assertDoesNotThrow(()->new Defausse());
		
	}

	@Test
	void testSetPile() {
		defausse.setPile(TableauCarte);
		
		assertDoesNotThrow(()->defausse);
	}
}
