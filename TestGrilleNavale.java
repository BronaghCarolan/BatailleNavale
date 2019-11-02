package fr.uga.miashs.inff3.carolanb;

import java.util.Random;

public class TestGrilleNavale {

	public static void main(String[] args) {
		
		GrilleNavale g = new GrilleNavale(10);
		int[] i = new int[]{2, 4};
		//testPlacementAuto(g, i);
		
		//testAjouteNavire();
		//testRecoitTir();
		//testEstTouche();
		//testEstAlEau();
		testPerdu();
	}
	public static void testAjouteNavire() {
		System.out.println("\nTest AjouteNavire");
		/*
		 * Un teste avec 2 navires qui ne touchent pas et qui ne chevauchent pas
		 * 
		 * Sortie:  Test 1 true true
		 * 
		 */
		GrilleNavale g = new GrilleNavale(10);
		Coordonnee c1 = new Coordonnee(0, 2);
		Coordonnee c2 = new Coordonnee(3, 3);
		Navire n1 = new Navire(c1,3,true);
		Navire n2 = new Navire(c2,2,true);
		
		System.out.println("Test 1: " + g.ajouteNavire(n1) + " ");
		System.out.print(g.ajouteNavire(n2));
		
		/* Un teste avec 2 navires qui touchent et qui ne chevauchent pas
		 * 
		 * Sortie:  Test 2 true false
		 */
		 g = new GrilleNavale(10);
		 c1 = new Coordonnee(0, 2);
		 c2 = new Coordonnee(2, 3);
		 n1 = new Navire(c1,3,true);
		 n2 = new Navire(c2,2,true);
		 System.out.println("\nTest 2: " + g.ajouteNavire(n1) + " ");
		 System.out.print(g.ajouteNavire(n2));
		 
		 /*
		 * Un teste avec 2 navires qui chevauchent
		 * 
		 * Sortie:  Test 3 true false
		 */
			 g = new GrilleNavale(10);
			 c1 = new Coordonnee(0, 2);
			 c2 = new Coordonnee(2, 2);
			 n1 = new Navire(c1,3,true);
			 n2 = new Navire(c2,2,true);
			 System.out.println("\nTest 3: " + g.ajouteNavire(n1) + " ");
			 System.out.print(g.ajouteNavire(n2));
			 
			 /*
			* Un teste avec 2 navires qui sortent des limites de la grille
			* 
			* Sortie:  Test 4 false false
			*/
			 g = new GrilleNavale(10);
			 c1 = new Coordonnee(11, 2);
			 c2 = new Coordonnee(12, 2);
			 n1 = new Navire(c1,3,true);
			 n2 = new Navire(c2,2,true);
			 System.out.println("\nTest 4: " + g.ajouteNavire(n1) + " ");
			 System.out.print(g.ajouteNavire(n2));

		

	}
	public static void testPlacementAuto(GrilleNavale g, int[] tailles) {
		System.out.println("Test PlacementAuto");
		
		g.placementAuto(tailles);
		

	}
	
	public static void testRecoitTir() {
		System.out.println("Test RecoitTir");
		GrilleNavale g = new GrilleNavale(10);
		Coordonnee c1 = new Coordonnee(0, 2);
		Coordonnee c2 = new Coordonnee(3, 3);
		Navire n1 = new Navire(c1,3,true);
		Navire n2 = new Navire(c2,2,true);
		g.ajouteNavire(n1);
		g.ajouteNavire(n2);
		/*
		 * Un teste avec un Coordonnee qui est dans un Navire
		 * Sortie:  Test 1 true
		*/
		System.out.println("Test 1: " + g.recoitTir(c1));
		
		/*
		 * Un teste avec un Coordonnee qui n'est pas dans un Navire
		 * Sortie:  Test 2 false
		*/
		Coordonnee c = new Coordonnee(0, 4);		
		System.out.println("Test 2: " + g.recoitTir(c));
		
		/*
		 * Un teste avec un Coordonnee qui n'est pas dans les limites de la Grille
		 * Sortie:  Test 3 false
		*/
		System.out.println("Test 3: " + g.recoitTir(new Coordonnee(0, 14)));
		
		/*
		 * Un teste avec un Coordonnee qui est déjà dans "tirsRecu"
		 * Sortie:  Test 4 false
		*/
		System.out.println("Test 4: " + g.recoitTir(c1));
	}
	public static void testEstTouche()
	{
		System.out.println("Test EstTouche");
		GrilleNavale g = new GrilleNavale(10);
		Coordonnee c1 = new Coordonnee(0, 2);
		Coordonnee c2 = new Coordonnee(3, 3);
		Navire n1 = new Navire(c1,3,true);
		Navire n2 = new Navire(c2,2,true);
		g.ajouteNavire(n1);
		g.ajouteNavire(n2);
		
		g.recoitTir(c1);
		g.recoitTir(new Coordonnee(5, 9));
		
		/*
		 * Un teste avec un Coordonnee qui est dans un Navire et qui est touché
		 * Sortie:  Test 1 true
		*/
		System.out.println("Test 1: " + g.estTouche(c1));
		
		/*
		 * Un teste avec un Coordonnee qui est dans un Navire et qui n'est pas touché
		 * Sortie:  Test 2 false
		*/
		System.out.println("Test 2: " + g.estTouche(c2));
		/*
		 * Un teste avec un Coordonnee qui n'est pas dans un Navire et qui est touché
		 * Sortie:  Test 3 false
		*/
		System.out.println("Test 3: " + g.estTouche(new Coordonnee(5, 9)));
		
	}
	public static void testEstAlEau() {
		System.out.println("Test EstAlEau");
		GrilleNavale g = new GrilleNavale(10);
		Coordonnee c1 = new Coordonnee(0, 2);
		Coordonnee c2 = new Coordonnee(3, 3);
		Navire n1 = new Navire(c1,3,true);
		Navire n2 = new Navire(c2,2,true);
		g.ajouteNavire(n1);
		g.ajouteNavire(n2);
		g.recoitTir(c1);
		g.recoitTir(new Coordonnee(5,9));
		/*
		 * Un teste avec un Coordonnee qui est dans un Navire et qui est touché
		 * Sortie:  Test 1 false
		*/
		System.out.println("Test 1: " + g.estALEau(c1));
		
		/*
		 * Un teste avec un Coordonnee qui n'est pas dans un Navire et qui est touché
		 * Sortie:  Test 2 true
		*/
		System.out.println("Test 2: " + g.estALEau(new Coordonnee(5,9)));
		
		/*
		 * Un teste avec un Coordonnee qui n'est pas dans un Navire et qui n'est pas touché
		 * Sortie:  Test 3 false
		*/
		System.out.println("Test 3: " + g.estALEau(new Coordonnee(5,10)));
		
		/*
		 * Un teste avec un Coordonnee qui est dans un Navire et qui n'est pas touché
		 * Sortie:  Test 4 false
		*/
		System.out.println("Test 4: " + g.estALEau(c1));
		
	}
	public static void testPerdu() {
		System.out.println("Test Perdu");
		GrilleNavale g = new GrilleNavale(10);
		Coordonnee c1 = new Coordonnee(0, 2);
		Coordonnee c2 = new Coordonnee(3, 3);
		Navire n1 = new Navire(c1,2,true);
		Navire n2 = new Navire(c2,2,true);
		g.ajouteNavire(n1);
		g.ajouteNavire(n2);
		g.recoitTir(c1);
		g.recoitTir(c2);
		
		/*
		 * Tous les navires de la grille ne sont pas coulés
		 * Sortie:  Test 1 false
		*/
		System.out.println("Test 1: " + g.perdu());
		
		/*
		 * Tous les navires de la grille sont coulés
		 * Sortie:  Test 2 true
		*/
		g.recoitTir(n1.getFin());
		g.recoitTir(n2.getFin());
		System.out.println("Test 2: " + g.perdu());
		
	}
	
	
	
}