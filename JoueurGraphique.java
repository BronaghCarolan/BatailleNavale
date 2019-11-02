package fr.uga.miashs.inff3.carolanb;

public class JoueurGraphique extends Joueur{
	
	private GrilleNavaleGraphique ngraph;
	private GrilleGraphique graph;
	
	public JoueurGraphique(GrilleNavaleGraphique g1, GrilleGraphique g2) {
		super(g1.getTaille());
		ngraph = g1;
		graph = g2;
	}
	/**
	 * M�thode appel�e � chaque retour d'attaque port�e par ce joueur sur son adversaire
	 * @param c La coordonn�e attaqu�e sur la grille de l'adversaire
	 * @param etat Etat de l'attaque port�e qui peut �tre �gal au constantes <code>Joueur.TOUCHE</code>, <code>Joueur.COULE</code>, ou <code>Joueur.A_L_EAU</code>
	 */
	
	
	protected void retourAttaque(Coordonnee c, int etat) {
		
	}
	/**
	 * M�thode appel�e � chaque retour d'attaque port� par l'adversaire sur ce Joueur
	 * @param c La coordonn�e attaqu�e par l'adversaire
	 * @param etat Etat de l'attaque re�ue qui peut �tre �gal au constantes <code>Joueur.TOUCHE</code>, <code>Joueur.COULE</code>, ou <code>Joueur.A_L_EAU</code>
	 */
	protected void retourDefense(Coordonnee c, int etat) {
		
	}
	
	/**
	 * M�thode appel�e lorsque c'est au tour de ce joueur de jouer. 
	 * Elle doit retourner la coordonn�e choisie pour l'attaque
	 * @return la coordonnee � attaquer sur la grille de l'adversaire
	 */
	public Coordonnee choisirAttaque() {
		return new Coordonnee(0,0);
	}
	
	/**
	 * M�thode de d�fense. Cette m�thode est appel�e lorsqu'une attaque de l'adversaire est re�ue.
	 * En focntion de l'impact de l'attaque, elle retourne un entier qui peut prendre les valeurs suivantes :
	 * Joueur.TOUCHE, Joueur.COULE, Joueur.A_L_EAU, Joueur.GAME_OVER
	 * @param c la cordonn�e attaqu�e
	 * @return le resultat de cette attaque: Joueur.TOUCHE, Joueur.COULE, Joueur.A_L_EAU ou Joueur.GAME_OVER
	 */
	public int defendre(Coordonnee c) {
		return 0;
	}


}
