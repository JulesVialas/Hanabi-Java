/*
 * TestTour.java                                            19/05/2024
 * IUT de Rodez, TP42 (Solignac, Valat, Vialas), pas de copyright.
 * Hanabi est un jeu créé par Antoine Bauza, et édité par Cocktail
 * Games/XII Singes.
 */
package jeu.modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link jeu.modele.Tour}.
 *
 * @author Corentin Solignac
 */
class TestTour {

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#Tour(jeu.modele.Joueur, int)}.
	 */
	@Test
	void testTour() {

		assertDoesNotThrow(() -> new Tour(new Joueur("Coucou"), 1));
		assertDoesNotThrow(() -> new Tour(new Joueur("John"), 2));
		assertDoesNotThrow(() -> new Tour(new Joueur("Coltrane"), 3));
		assertDoesNotThrow(() -> new Tour(new Joueur("Charles"), 4));
		assertDoesNotThrow(() -> new Tour(new Joueur("Mingus"), 5));

		assertThrows(IllegalArgumentException.class, () -> new Tour(new Joueur("Mingus"), -1));
		assertThrows(IllegalArgumentException.class, () -> new Tour(new Joueur("Mingus"), 0));
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#getJoueurCourant()}.
	 */
	@Test
	void testGetJoueurCourant() {

		Joueur Charles = new Joueur("Charles");
		Joueur Mingus = new Joueur("Mingus");
		assertEquals(Charles, new Tour(Charles, 5).getJoueurCourant());
		assertEquals(Mingus, new Tour(Mingus, 15).getJoueurCourant());
		assertNotEquals(Mingus, new Tour(Charles, 5).getJoueurCourant());
		assertNotEquals(Charles, new Tour(Mingus, 15).getJoueurCourant());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#getNumero()}.
	 */
	@Test
	void testGetNumero() {

		assertEquals(5, new Tour(new Joueur("Charles"), 5).getNumero());
		assertEquals(15, new Tour(new Joueur("Mingus"), 15).getNumero());
		assertNotEquals(15, new Tour(new Joueur("Charles"), 5).getNumero());
		assertNotEquals(5, new Tour(new Joueur("Mingus"), 15).getNumero());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#getJetonsBleus()}.
	 */
	@Test
	void testGetJetonsBleus() {
		Partie partie1 = new Partie("Coco", "Sol");
		Tour roundUn = new Tour(new Joueur("Emile"), 1);
		roundUn.setPartieDuTour(partie1);

		/* 8 jetons au début d'une partie, valeur par défaut */
		assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().setBleus(4);
		assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(4, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().incrementBleus();
		assertNotEquals(4, roundUn.getPartieDuTour().getJetons().getBleus());
		assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(5, roundUn.getPartieDuTour().getJetons().getBleus());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#getJetonsRouges()}.
	 */
	@Test
	void testGetJetonsRouges() {
		Partie partie1 = new Partie("Coco", "Sol");
		Tour roundUn = new Tour(new Joueur("Emile"), 1);
		roundUn.setPartieDuTour(partie1);

		assertEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());

		roundUn.getPartieDuTour().getJetons().incrementRouges();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
		assertEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());

		roundUn.getPartieDuTour().getJetons().incrementRouges();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
		assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());
		assertEquals(2, roundUn.getPartieDuTour().getJetons().getRouges());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#incrementJetonsBleus()}.
	 */
	@Test
	void testIncrementJetonsBleus() {
		Partie partie1 = new Partie("Coco", "Sol");
		Tour roundUn = new Tour(new Joueur("Emile"), 1);
		roundUn.setPartieDuTour(partie1);

		/* 8 jetons par défaut en début de partie */
		assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
		roundUn.getPartieDuTour().getJetons().setBleus(0);

		roundUn.getPartieDuTour().getJetons().incrementBleus();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(1, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().incrementBleus();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getBleus());
		assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(2, roundUn.getPartieDuTour().getJetons().getBleus());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#setJetonsBleus()}.
	 */
	@Test
	void testSetJetonsBleus() {
		Partie partie1 = new Partie("Coco", "Sol");

		Tour roundUn = new Tour(new Joueur("Emile"), 1);
		Tour roundDeux = new Tour(new Joueur("Parisien"), 2);
		roundUn.setPartieDuTour(partie1);
		roundDeux.setPartieDuTour(partie1);

		/* Nombre par défaut est 8 jetons lors de création d'une partie */
		assertEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().decrementBleus();
		assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(7, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().decrementBleus();
		assertNotEquals(8, roundUn.getPartieDuTour().getJetons().getBleus());
		assertNotEquals(7, roundUn.getPartieDuTour().getJetons().getBleus());
		assertEquals(6, roundUn.getPartieDuTour().getJetons().getBleus());

		roundUn.getPartieDuTour().getJetons().decrementBleus();
		roundDeux.getPartieDuTour().getJetons().setBleus((roundUn.getPartieDuTour().getJetons().getBleus()));
		assertEquals(5, roundDeux.getPartieDuTour().getJetons().getBleus());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#decrementJetonsBleus()}.
	 */
	@Test
	void testDecrementJetonsBleus() {
		Partie partie1 = new Partie("Coco", "Sol");
		Tour roundTrois = new Tour(new Joueur("Parker"), 3);
		roundTrois.setPartieDuTour(partie1);

		roundTrois.getPartieDuTour().getJetons().setBleus(4);
		assertEquals(4, roundTrois.getPartieDuTour().getJetons().getBleus());

		roundTrois.getPartieDuTour().getJetons().decrementBleus();
		assertEquals(3, roundTrois.getPartieDuTour().getJetons().getBleus());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#incrementJetonsRouges()}.
	 */
	@Test
	void testIncrementJetonsRouges() {

		Partie partie1 = new Partie("Coco", "Sol");
		Tour roundUn = new Tour(new Joueur("Emile"), 1);
		roundUn.setPartieDuTour(partie1);

		assertEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());

		roundUn.getPartieDuTour().getJetons().incrementRouges();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
		assertEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());

		roundUn.getPartieDuTour().getJetons().incrementRouges();
		assertNotEquals(0, roundUn.getPartieDuTour().getJetons().getRouges());
		assertNotEquals(1, roundUn.getPartieDuTour().getJetons().getRouges());
		assertEquals(2, roundUn.getPartieDuTour().getJetons().getRouges());
	}

	/**
	 * Méthode de test pour
	 * {@link jeu.modele.Tour#donnerIndice(jeu.modele.Joueur, jeu.modele.Carte, char)}.
	 */
	@Test
	void testDonnerIndice() {
		/* Partie et Tours de test */
		Partie partie1 = new Partie("Coltrane", "John");

		Carte carte1 = new Carte(Couleur.ROUGE, Valeur.TROIS);
		Carte carte2 = new Carte(Couleur.BLEU, Valeur.CINQ);
		partie1.getJoueur1().setCartesEnMains(carte1);
		partie1.getJoueur2().setCartesEnMains(carte2);

		Tour tour1 = new Tour(partie1.getJoueur1(), 1);
		Tour tour2 = new Tour(partie1.getJoueur2(), 2);
		tour1.setPartieDuTour(partie1);
		tour2.setPartieDuTour(partie1);

		/* Le joueur veut donner un indice à sa propre main */
		assertThrows(IllegalStateException.class, () -> tour1.donnerIndice(carte1, 'c'));

		/* On défini les jetons bleus à 1 */
		tour1.getPartieDuTour().getJetons().setBleus(1);
		tour2.getPartieDuTour().getJetons().setBleus(1);

		/* On peut donner un indice car 1 jeton est dispo */
		assertDoesNotThrow(() -> tour1.donnerIndice(carte2, 'c'));
		/*
		 * L'indice est donné, donc le booleen de la carte qui a reçu l'indice est true,
		 * et false pour celle qui ne l'a pas reçu
		 */
		assertTrue(carte2.getCouleurConnue());
		assertFalse(carte1.getCouleurConnue());
		assertEquals(0, tour1.getPartieDuTour().getJetons().getBleus());

		/* Tentative de donner indice lorsque zéro jetons bleus */
		assertThrows(IllegalStateException.class, () -> tour2.donnerIndice(carte1, 'v'));

		/* On redonne un jeton */
		tour2.getPartieDuTour().getJetons().setBleus(1);

		/* On donne un indice */
		assertDoesNotThrow(() -> tour2.donnerIndice(carte1, 'v'));
		/*
		 * L'indice est donné, donc le booleen de la carte qui a reçu l'indice est true,
		 * et false pour celle qui ne l'a pas reçu
		 */
		assertTrue(carte1.getValeurConnue());
		assertFalse(carte2.getValeurConnue());

		/*
		 * On essaie de redonner le même indice à une carte, ce qui ne doit pas poser de
		 * problèmes
		 */
		tour2.getPartieDuTour().getJetons().setBleus(1);
		assertDoesNotThrow(() -> tour2.donnerIndice(carte1, 'v'));

		/* Il n'y a plus de jetons bleus */
		assertEquals(0, tour2.getPartieDuTour().getJetons().getBleus());

		/* Les saisies d'indices sont invalides ( != 'c' et 'v') */
		assertThrows(IllegalStateException.class, () -> tour2.donnerIndice(carte1, 'c'));

		/* On redonne un jeton mais les saisies d'indices sont invalides */
		tour2.getPartieDuTour().getJetons().setBleus(1);
		assertThrows(IllegalArgumentException.class, () -> tour2.donnerIndice(carte1, 'x'));

		/* On essaie de redonner le même indice à une carte */
		tour2.getPartieDuTour().getJetons().setBleus(1);
		assertDoesNotThrow(() -> tour2.donnerIndice(carte1, 'c'));

		/* Création de joueurs pour tester la propagation de l'indice */
		Partie partie2 = new Partie("Kyle", "Poole"); // Jetons bleus à 8 par défaut
		Tour tour3 = new Tour(partie2.getJoueur2(), 3);
		Tour tour4 = new Tour(partie2.getJoueur1(), 3);
		tour3.setPartieDuTour(partie2);
		tour4.setPartieDuTour(partie2);

		Carte unJaune1 = new Carte(Couleur.JAUNE, Valeur.UN);

		/* On remplace la main du joueur */
		partie2.getJoueur1().getCartesEnMains().remove(3);
		partie2.getJoueur1().getCartesEnMains().remove(2);
		partie2.getJoueur1().getCartesEnMains().remove(1);
		partie2.getJoueur1().getCartesEnMains().remove(0);

		partie2.getJoueur1().setCartesEnMains(unJaune1);
		partie2.getJoueur1().setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.DEUX));
		partie2.getJoueur1().setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.TROIS));
		partie2.getJoueur1().setCartesEnMains(new Carte(Couleur.JAUNE, Valeur.QUATRE));

		/* On vérifie qu'aucun carte n'a l'indice de couleur */
		for (Carte cartesDuJoueur : partie2.getJoueur1().getCartesEnMains()) {
			assertFalse(cartesDuJoueur.getCouleurConnue());
		}

		/* L'indice est donné par joueur 2 à joueur 1 */
		tour3.donnerIndice(unJaune1, 'c');

		/* On vérifie que toutes les cartes ont reçu l'indice */
		for (Carte cartesDuJoueur : partie2.getJoueur1().getCartesEnMains()) {
			assertTrue(cartesDuJoueur.getCouleurConnue());
		}

		/* Même démarche pour l'indice valeur */
		Carte unRouge1 = new Carte(Couleur.ROUGE, Valeur.UN);
		Carte unJaune2 = new Carte(Couleur.JAUNE, Valeur.UN);
		Carte quatreVert1 = new Carte(Couleur.VERT, Valeur.QUATRE);
		partie2.getJoueur2().setCartesEnMains(unJaune1);
		partie2.getJoueur2().setCartesEnMains(unRouge1);
		partie2.getJoueur2().setCartesEnMains(unJaune2);
		partie2.getJoueur2().setCartesEnMains(quatreVert1);

		/* On vérifie qu'aucun carte n'a l'indice de valeur */
		for (Carte cartesDuJoueur : partie2.getJoueur2().getCartesEnMains()) {
			assertFalse(cartesDuJoueur.getValeurConnue());
		}

		/* L'indice est donné par joueur 2 à lui-même, donc refusé */
		assertThrows(IllegalStateException.class, () -> tour3.donnerIndice(unRouge1, 'v'));

		/* L'indice est donné par J1 à J2 */
		assertDoesNotThrow(() -> tour4.donnerIndice(unRouge1, 'v'));

		/*
		 * On vérifie que seules les cartes répondant au critère ont reçu l'indice
		 */
		assertTrue(unRouge1.getValeurConnue());
		assertTrue(unJaune1.getValeurConnue());
		assertTrue(unJaune2.getValeurConnue());
		assertFalse(quatreVert1.getValeurConnue());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#poser(jeu.modele.Carte)}.
	 */
	@Test
	void testPoser() {
		Partie partie2J = new Partie("Roberto", "Fonseca");
		Tour tour1 = new Tour(partie2J.getJoueur1(), 1);
		tour1.setPartieDuTour(partie2J);

		Carte unJauneDefinitif = new Carte(Couleur.JAUNE, Valeur.UN);
		Carte troisJauneDefinitif = new Carte(Couleur.JAUNE, Valeur.TROIS);

		/*
		 * On remplace 1 carte pour que le joueur possède un 1 jaune, et ainsi tester
		 * l'ajout valide sur une pile vide.
		 */
		tour1.getJoueurCourant().getCartesEnMains().remove(0);
		tour1.getJoueurCourant().getCartesEnMains().add(unJauneDefinitif);

		/* On vérifie que la pile de feux jaunes est bien vide */
		assertTrue(partie2J.getFeuxPosesJaune().isEmpty());

		/* On sauvegarde la main avant d'avoir posé la carte */
		List<Carte> saveAvantPose1;
		saveAvantPose1 = List.copyOf(tour1.getJoueurCourant().getCartesEnMains());

		/* On pose le 1 jaune, qui se trouve à l'index 4 car ajouté manuellement */
		tour1.poser(tour1.getJoueurCourant().getCartesEnMains().get(4));

		/* On vérifie que les mains avant/après sont différentes */
		assertNotEquals(tour1.getJoueurCourant().getCartesEnMains(), saveAvantPose1);

		/* On vérifie que la pile jaune contient le 1 sur le dessus */
		assertTrue(partie2J.getFeuxPosesJaune().contains(unJauneDefinitif));

		/* On vérifie qu'aucun jeton rouge n'a été ajouté */
		assertEquals(0, partie2J.getJetons().getRouges());

		/* On vérifie qu'aucun jeton bleu n'a été ajouté (car au max par défaut) */
		assertEquals(8, partie2J.getJetons().getBleus());

		/* On remplace ensuite une carte par un 3 jaune */
		tour1.getJoueurCourant().getCartesEnMains().remove(0);
		tour1.getJoueurCourant().getCartesEnMains().add(troisJauneDefinitif);

		/* On sauvegarde la main pour comparer après l'action */
		List<Carte> saveAvantPose2;
		saveAvantPose2 = List.copyOf(tour1.getJoueurCourant().getCartesEnMains());

		/* On essaie de poser le 3 jaune sur la pile qui contient le 1 jaune */
		tour1.poser(tour1.getJoueurCourant().getCartesEnMains().get(4));

		/* On vérifie que la carte n'a pas été ajoutée à la pile jaune */
		assertFalse(partie2J.getFeuxPosesJaune().contains(troisJauneDefinitif));

		/* On vérifie qu'un jeton rouge a bien été ajouté */
		assertEquals(1, partie2J.getJetons().getRouges());

		/* On vérifie qu'aucun jeton bleu n'a été ajouté (car au max par défaut) */
		assertEquals(8, partie2J.getJetons().getBleus());

		/* On vérifie que la main avant/après est différente */
		assertNotEquals(saveAvantPose2, tour1.getJoueurCourant().getCartesEnMains());
	}

	/**
	 * Méthode de test pour {@link jeu.modele.Tour#defausser(jeu.modele.Carte)}.
	 */
	@Test
	void testDefausser() {

		Partie partie2J = new Partie("Bob", "Dylan");
		Tour tour1 = new Tour(partie2J.getJoueur1(), 1);
		tour1.setPartieDuTour(partie2J);

		/* On vérifie que le nombre de cartes est le bon pour 2 joueurs */
		assertTrue(partie2J.getJoueur1().getCartesEnMains().size() == 5);

		/*
		 * On stocke l'état actuel de la main avant défausse, à l'aide d'une deep copy
		 * pour ne pas seulement copier la référence de l'objet
		 */
		List<Carte> saveCarteAvantDefausse = List.copyOf(partie2J.getJoueur1().getCartesEnMains());

		/* On défausse une carte */
		tour1.defausser(partie2J.getJoueur1().getCartesEnMains().getLast());

		/*
		 * On vérifie que le nombre de cartes dans la main est le bon. On suppose que la
		 * pioche n'est pas vide donc qu'une carte lui est rendue.
		 */
		assertTrue(partie2J.getJoueur1().getCartesEnMains().size() == 5);

		/* On compare les mains avant et après défausse */
		assertFalse(partie2J.getJoueur1().getCartesEnMains().containsAll(saveCarteAvantDefausse));
	}
}
