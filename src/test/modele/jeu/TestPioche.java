/*
 * TestPioche.java                                            19 mai 2024
 * IUT de Rodez, Info1 2023-2024 TP4, pas de copyright
 */

package modele.jeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestPioche {

    ArrayList<Carte> pioche1 = new ArrayList<>(Arrays.asList(new Carte(Couleur.ROUGE, Valeur.UN),
            new Carte(Couleur.BLEU, Valeur.DEUX), new Carte(Couleur.VERT, Valeur.TROIS)));

    ArrayList<Carte> pioche2 = new ArrayList<>(
            Arrays.asList(new Carte(Couleur.JAUNE, Valeur.QUATRE), new Carte(Couleur.BLEU, Valeur.UN)));

    ArrayList<Carte> piocheVide = new ArrayList<>();

    @Test
    void testPioche() {
        assertDoesNotThrow(() -> new Pioche(pioche1));
        assertDoesNotThrow(() -> new Pioche(pioche2));
        assertDoesNotThrow(() -> new Pioche(piocheVide));

        assertNotNull(pioche1);
        assertNotNull(pioche2);
        assertNotNull(piocheVide);
    }

}
