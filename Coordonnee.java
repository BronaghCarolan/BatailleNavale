package fr.uga.miashs.inff3.carolanb;

/**
 * Cette classe r�presente une coordonn�e dans un tableau d'un jeu de Bataille
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
	 * Ce constructeur initialise une coordonn�e.
	 * 
	 * @param String x: une r�presentation d'une coordonn�e en forme d'une chaine de
	 *               caracteres.
	 */
	public Coordonnee(String x) {
		colonne = x.charAt(0) - 'A';
		ligne = Integer.parseInt(x.substring(1)) - 1;
	}

	/**
	 * Ce constructeur initialise une coordonn�e.
	 * 
	 * @param int ligne: la ligne de la coordonn�e.
	 * @param int colonne: la colonne de la coordonn�e.
	 */
	public Coordonnee(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/**
	 * Cette m�thode retourne la ligne
	 * 
	 * @return int ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Cette m�thode retourne la colonne
	 * 
	 * @return int colonne
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Cette m�thode retourne la chaine qui r�presente la coordonn�e
	 * 
	 * @return String
	 */
	public String toString() {
		return "" + (char) (colonne + 'A') + (ligne + 1);
	}

	/**
	 * Cette m�thode retourne si la coordonn�e sur laquelle on appelle la m�thode
	 * est �gale � la coordonn�e pass�e en param�tres.
	 * 
	 * @param Coordonn�e
	 * @return boolean
	 */
	public boolean equals(Coordonnee o) {
		return (ligne == o.getLigne() && colonne == o.getColonne());
	}

	/**
	 * Cette m�thode retourne si la coordonn�e sur laquelle on appelle la m�thode
	 * est une voisine de la coordonn�e pass�e en param�tres.
	 * @param Coordonn�e
	 * @return boolean
	 */
	public boolean voisine(Coordonnee o) {
		return (ligne == o.getLigne() && (colonne == o.getColonne() + 1) || colonne == o.getColonne() - 1)
				|| (colonne == o.getColonne() && ((ligne == o.getLigne() + 1) || ligne == o.getLigne() - 1));
	}

	/**
	 * Cette m�thode retourne si la coordonn�e sur laquelle on appelle la m�thode
	 * est moins que, �gal �, ou plus que la coordonn�e pass�e en param�tres.
	 * @param Coordonn�e
	 * @return int : moins <0, �gal =0, plus >0
	 */
	public int compareTo(Coordonnee o) {
		int compareColonne = colonne - o.colonne;
		if (compareColonne == 0) {
			return ligne - o.ligne;
		} else
			return compareColonne;
	}

}
