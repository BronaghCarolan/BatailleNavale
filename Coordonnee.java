package fr.uga.miashs.inff3.carolanb;

/**
 * Cette classe répresente une coordonnée dans un tableau d'un jeu de Bataille
 * Navale
 *
 * @author Conor Evans et Bronagh Carolan
 * @version 1.0
 * @since 2018-10-19
 */
public class Coordonnee {

	private int ligne;
	private int colonne;

	/**
	 * Ce constructeur initialise une coordonnée.
	 * 
	 * @param String x: une répresentation d'une coordonnée en forme d'une chaine de
	 *               caracteres.
	 */
	public Coordonnee(String x) {
		colonne = x.charAt(0) - 'A';
		ligne = Integer.parseInt(x.substring(1)) - 1;
	}

	/**
	 * Ce constructeur initialise une coordonnée.
	 * 
	 * @param int ligne: la ligne de la coordonnée.
	 * @param int colonne: la colonne de la coordonnée.
	 */
	public Coordonnee(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/**
	 * Cette méthode retourne la ligne
	 * 
	 * @return int ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Cette méthode retourne la colonne
	 * 
	 * @return int colonne
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Cette méthode retourne la chaine qui répresente la coordonnée
	 * 
	 * @return String
	 */
	public String toString() {
		return "" + (char) (colonne + 'A') + (ligne + 1);
	}

	/**
	 * Cette méthode retourne si la coordonnée sur laquelle on appelle la méthode
	 * est égale à la coordonnée passée en paramètres.
	 * 
	 * @param Coordonnée
	 * @return boolean
	 */
	public boolean equals(Coordonnee o) {
		return (ligne == o.getLigne() && colonne == o.getColonne());
	}

	/**
	 * Cette méthode retourne si la coordonnée sur laquelle on appelle la méthode
	 * est une voisine de la coordonnée passée en paramètres.
	 * @param Coordonnée
	 * @return boolean
	 */
	public boolean voisine(Coordonnee o) {
		return (ligne == o.getLigne() && (colonne == o.getColonne() + 1) || colonne == o.getColonne() - 1)
				|| (colonne == o.getColonne() && ((ligne == o.getLigne() + 1) || ligne == o.getLigne() - 1));
	}

	/**
	 * Cette méthode retourne si la coordonnée sur laquelle on appelle la méthode
	 * est moins que, égal à, ou plus que la coordonnée passée en paramètres.
	 * @param Coordonnée
	 * @return int : moins <0, égal =0, plus >0
	 */
	public int compareTo(Coordonnee o) {
		int compareColonne = colonne - o.colonne;
		if (compareColonne == 0) {
			return ligne - o.ligne;
		} else
			return compareColonne;
	}

}
