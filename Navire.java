package fr.uga.miashs.inff3.carolanb;

/**
 * Cette classe répresente une Navire dans un jeu de Bataille Navale
 *
 * @author Conor Evans et Bronagh Carolan
 * @version 1.0
 * @since 2018-10-19
 */

public class Navire {
	/** Coordonnée qui répresente le début du navire. */
	private Coordonnee debut;
	/** Coordonnée qui répresente la fin du navire. */
	private Coordonnee fin;
	/** Tableau de coordonnées qui répresente les parties touchées du navire. */
	private Coordonnee[] partiesTouchees;
	/** Entier qui répresente le nombres de parties touchées du navire. */
	private int nbTouchees;

	/**
	 * Ce constructeur initialise un navire
	 * 
	 * @param Coordonée   début
	 * @param             int longueur
	 * @param estVertical
	 */

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
		partiesTouchees = new Coordonnee[longueur];
		nbTouchees = 0;
		if (estVertical) {
			fin = new Coordonnee((debut.getLigne() + longueur) - 1, debut.getColonne());
		} else {
			fin = new Coordonnee(debut.getLigne(), debut.getColonne() + longueur - 1);
		}
	}

	/**
	 * Cette méthode retourne la chaine qui répresente le navire
	 * 
	 * @return String
	 */

	public String toString() {
		String s = "Debut: " + debut.toString() + "\nFin: " + fin.toString() + "\nParties Touchees : ";
		for (int i = 1; i < partiesTouchees.length - 1; i++) {
			if (partiesTouchees[i] != null) {
				s += partiesTouchees[i].toString() + " ";
			}
		}
		return s;
	}

	/**
	 * Cette méthode retourne le début du navire
	 * 
	 * @return Coordonnée début
	 */

	public Coordonnee getDebut() {
		return debut;
	}

	/**
	 * Cette méthode retourne la fin du navire
	 * 
	 * @return Coordonnée fin
	 */

	public Coordonnee getFin() {
		return fin;
	}

	/**
	 * Cette méthode retourne si le navire sur lequel on appelle la méthode contient
	 * la coordonnée passée en paramètres.
	 * 
	 * @param Coordonnée
	 * @return boolean
	 */
	public boolean contient(Coordonnee o) {
		if (debut.getColonne() == fin.getColonne() && o.getColonne() == debut.getColonne()) {
			if (o.getLigne() < debut.getLigne() || o.getLigne() > fin.getLigne())
				return false;
			return true;
		} else if (debut.getLigne() == fin.getLigne() && o.getLigne() == debut.getLigne()) {
			if (o.getColonne() < debut.getColonne() || o.getColonne() > fin.getColonne())
				return false;
			return true;
		}
		return false;
	}

	/**
	 * Cette méthode retourne s'il y a une intersection entre non-vide entre deux
	 * intervalles passées en paramètres.
	 * 
	 * @param int d1 = début de l'intervalle 1
	 * @param int f1 = fin de l'intervalle 1
	 * @param int d2 = début de l'intervalle 2
	 * @param int f2 = fin de l'intervalle 2
	 * 
	 * @return boolean
	 */
	public static boolean intersectionNonVide(int d1, int f1, int d2, int f2) {
		if (d1 == d2 || f1 == f2)
			return true;
		else if (d1 < d2) {
			if (f2 < f1 || f1 == d2 || (f1 > d2 && f1 < f2))
				return true;
			return false;
		} else {
			if (f2 >= f1)
				return true;
			return false;
		}

	}

	/**
	 * Cette méthode retourne si le navire sur lequel on appelle la méthode
	 * chevauche le navire passé en paramètres.
	 * 
	 * @param Navire
	 * @return boolean
	 */

	public boolean chevauche(Navire n) {
		return intersectionNonVide(debut.getLigne(), fin.getLigne(), n.debut.getLigne(), n.fin.getLigne())
				&& intersectionNonVide(debut.getColonne(), fin.getColonne(), n.debut.getColonne(), n.fin.getColonne());
	}

	/**
	 * Cette méthode retourne si le navire sur lequel on appelle la méthode touche
	 * le navire passé en paramètres.
	 * 
	 * @param Navire
	 * @return boolean
	 */
	public boolean touche(Navire n) {
		if (intersectionNonVide(debut.getLigne(), fin.getLigne(), n.debut.getLigne(), n.fin.getLigne())) {
			if (n.debut.getColonne() == fin.getColonne() + 1 || n.fin.getColonne() == debut.getColonne() - 1)
				return true;
			return false;
		} else if (intersectionNonVide(debut.getColonne(), fin.getColonne(), n.debut.getColonne(),
				n.fin.getColonne())) {
			if (n.debut.getLigne() == fin.getLigne() + 1 || n.fin.getLigne() == debut.getLigne() - 1)
				return true;
			return false;
		} else
			return false;
	}

	/**
	 * Cette méthode retourne si le navire sur lequel on appelle la méthode contient
	 * la coordonnée passée en paramètres et que cette coordonnée est touchée
	 * 
	 * @param Navire
	 * @return boolean
	 */
	public boolean estTouche(Coordonnee o) {
		for (int i = 0; i < partiesTouchees.length; i++) {
			if (partiesTouchees[i] != null && partiesTouchees[i].equals(o))
				return true;
		}
		return false;
	}

	/**
	 * Cette méthode touche la coordonnée passée en paramètres si cette coordonnée
	 * fait partie du navire
	 * 
	 * @param Coordonnée
	 * @return boolean
	 */
	public boolean recoitTir(Coordonnee o) {
		if (contient(o)) {
			if (!estTouche(o)) {
				partiesTouchees[o.getLigne()] = o;
				nbTouchees++;
				return true;
			}
		}
		return false;

	}

	/**
	 * Cette méthode retourne si le navire sur lequel on appelle est coulé
	 * 
	 * @return boolean
	 */
	public boolean estCoule() {
		for (int i = 0; i < partiesTouchees.length; i++) {
			if (partiesTouchees[i] == null)
				return false;
		}
		return true;

	}
}
