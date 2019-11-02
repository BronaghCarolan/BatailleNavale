package fr.uga.miashs.inff3.carolanb;

import java.util.Arrays;
import java.util.Random;

public class GrilleNavale {
	/**
	 * Le tableau des navires contenus dans la grille
	 */
	private Navire[] navires;
	/**
	 * Le nombre de navires contenus dans navires
	 */
	private int nbNavires;
	/**
	 * Taille de la grille, la grille est carr�e
	 */
	private int tailleGrille;
	/**
	 * Tableau des tirs recus
	 */
	private Coordonnee[] tirsRecus;
	/**
	 * Nombre de tirs contenus dans tirRecus
	 */
	private int nbTirsRecus;

	/**
	 * Initialise une grille navale de taille donn�e Tous les attributs doivent �tre
	 * initialis�s
	 * 
	 * @param taille la taille de la grille
	 */
	public GrilleNavale(int taille) {
		navires = new Navire[0];
		tirsRecus = new Coordonnee[0];
		tailleGrille = taille;
		nbNavires = 0;
		nbTirsRecus = 0;
	}

	/**
	 * Ajoute un navire dans la grille. Un navire n'est pas ajout� si ses dimensions
	 * font qu'il sort de la grille ou si il touche ou chevauche un navire d�j�
	 * pr�sent dans la grille. L'attribut navire est agrandi automatiquement de 5
	 * �l�ments si besoin
	 * 
	 * @param n le navire � ajouter
	 * @return true si le navire a �t� ajout�.
	 */
	public boolean ajouteNavire(Navire n) {
		if (n == null) {
			return false;
		}
		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin())) {
			return false;
		}

		if (navires.length == nbNavires) {
			navires = Arrays.copyOf(navires, navires.length + 5);
		}

		for (int i = 0; i < navires.length; i++) {
			if (navires[i] == null) {
				navires[i] = n;
				nbNavires++;
				return true;
			}
			if (navires[i].touche(n) || navires[i].chevauche(n)) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Place automatiquement tailleNavires.length navires dont les tailles sont
	 * donn�es dans tailleNavires
	 * 
	 * @param taillesNavires tableau donnant les tailles des navires � cr�er et �
	 *                       placer dans la grille
	 */
	public void placementAuto(int[] taillesNavires) {
		Random r = new Random();
		for (int i = 0; i < taillesNavires.length; i++) {
			boolean estVertical = false;
			if (r.nextInt(2) == 1) {
				estVertical = true;
			}

			Coordonnee c = new Coordonnee(r.nextInt(tailleGrille + 1), r.nextInt(tailleGrille + 1));

			if (ajouteNavire(new Navire(c, taillesNavires[i], estVertical)) == false) {
				i--;
			} else {
				System.out.println((new Navire(c, taillesNavires[i], estVertical).toString()));
			}

		}
	}

	/**
	 * Teste si la coordonn�e pass�e en param�tre est contenue dans la grille
	 * 
	 * @param c r�f�rence non nulle vers la coordonn�e � tester
	 * @return true si la coordonn�e est dans la grille
	 */
	private boolean estDansGrille(Coordonnee c) {
		if (c.getLigne() > tailleGrille || c.getLigne() > tailleGrille
				|| c.getColonne() > tailleGrille || c.getColonne() > tailleGrille) {
			return false;
		}
		return true;

	}

	/**
	 * Teste si la coordonn�e pass�e en param�tre est dans l'ensemble des tirs re�us
	 * sur la grille
	 * 
	 * @param c r�f�rence non nulle vers la coordonn�e � tester
	 * @return true si la coordonn�e est dans l'ensemble des tirs re�us sur la
	 *         grille
	 */
	private boolean estDansTirsRecus(Coordonnee c) {
		for (int i =0; i < nbTirsRecus; i++) {
			if (c.equals(tirsRecus[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ajoute un tir dans le tableau tirsRecus. Pour �tre ajout� un tir doit �tre
	 * dans la grille et ne doit pas etre d�j� pr�sent dans tirsRecus
	 * 
	 * @param c la coordonn�e � ajouter
	 * @return true si la coordonn�e a �t� ajout�e dans tirsRecus
	 */
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (estDansTirsRecus(c) || !estDansGrille(c)){
			return false;
		}

		if (tirsRecus.length == nbTirsRecus) {
			tirsRecus = Arrays.copyOf(tirsRecus, tirsRecus.length + 5);
		}
		for (int i = 0; i < tirsRecus.length; i++) {
			if (tirsRecus[i] == null) {
				tirsRecus[i] = c;
				nbTirsRecus++;
				return true;
			}
		}
		return false;
	}

	/**
	 * G�re la r�ception d'un tir sur la grille. Si le tir est ajout� dans les tir
	 * recus alors ce tir est �galement envoy� � chaque navire contenu dans la grille
	 * 
	 * @param c une r�f�rence vers la coordonn�e du tir � receptionner
	 * @return true si le tir � touch� un navire de la grille
	 */
	public boolean recoitTir(Coordonnee c) {
		boolean tirToucheNavire = false;
		if(ajouteDansTirsRecus(c) == true) {
			for(int i = 0; i < nbNavires; i++) {
				if(navires[i].contient(c)) {
					navires[i].recoitTir(c);
					tirToucheNavire = true;
				}
			}
		}
		return tirToucheNavire;
	}

	/**
	 * Teste si l'un des navires pr�sent dans la grille est touch� au niveau de la
	 * coordonn�e pass�e en param�tre
	 * 
	 * @param c ue r�f�rence vers la coordonn�e � tester
	 * @return true si l'un des navire de la grille est touch� sur cette coordonn�e
	 */
	public boolean estTouche(Coordonnee c) {
		for(int i = 0; i < nbNavires; i++) {
			if(navires[i].estTouche(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Teste si un tir est dans les tirs recus mais n'a touch� aucun navire
	 * 
	 * @param c ue r�f�rence vers la coordonn�e � tester
	 * @return true si la coordonn�e est dans tirs re�us mais aucun bateau n'a �t�
	 *         touch�
	 */
	public boolean estALEau(Coordonnee c) {
		if(estDansTirsRecus(c) && !estTouche(c)) {
			return true;
		}
		return false;
	}

	/**
	 * Teste si tous les navires de la grille sont coul�s
	 * 
	 * @return true si tous les navires contenus dans la grille sont coul�s
	 */
	public boolean perdu() {
		for(Navire n : navires) {
			if(!n.estCoule()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Donne la taille de la grille
	 * 
	 * @return la taille de la grille
	 */
	public int getTaille() {
		return tailleGrille;
	}

	/**
	 * Si l'un des navires est pr�sent sur la coordonn�e c, la m�thode teste si ce
	 * navire est est coul�
	 * 
	 * @param c une r�f�rence vers la coordonn�e � tester
	 * @return true si un navire est pr�sent sur cette coordonn�e et si il est coul�
	 */
	public boolean estCoule(Coordonnee c) {
		for(Navire n : navires) {
			if(n.contient(c) && n.estCoule()) {
				return true;
			}
		}
		return false;
	}
}