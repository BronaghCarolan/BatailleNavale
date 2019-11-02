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
	 * Méthode appelée à chaque retour d'attaque portée par ce joueur sur son adversaire
	 * @param c La coordonnée attaquée sur la grille de l'adversaire
	 * @param etat Etat de l'attaque portée qui peut être égal au constantes <code>Joueur.TOUCHE</code>, <code>Joueur.COULE</code>, ou <code>Joueur.A_L_EAU</code>
	 */
	
	
	protected void retourAttaque(Coordonnee c, int etat) {
		
	}
	/**
	 * Méthode appelée à chaque retour d'attaque porté par l'adversaire sur ce Joueur
	 * @param c La coordonnée attaquée par l'adversaire
	 * @param etat Etat de l'attaque reçue qui peut être égal au constantes <code>Joueur.TOUCHE</code>, <code>Joueur.COULE</code>, ou <code>Joueur.A_L_EAU</code>
	 */
	protected void retourDefense(Coordonnee c, int etat) {
		
	}
	
	/**
	 * Méthode appelée lorsque c'est au tour de ce joueur de jouer. 
	 * Elle doit retourner la coordonnée choisie pour l'attaque
	 * @return la coordonnee à attaquer sur la grille de l'adversaire
	 */
	public Coordonnee choisirAttaque() {
		return new Coordonnee(0,0);
	}
	
	/**
	 * Méthode de défense. Cette méthode est appelée lorsqu'une attaque de l'adversaire est reçue.
	 * En focntion de l'impact de l'attaque, elle retourne un entier qui peut prendre les valeurs suivantes :
	 * Joueur.TOUCHE, Joueur.COULE, Joueur.A_L_EAU, Joueur.GAME_OVER
	 * @param c la cordonnée attaquée
	 * @return le resultat de cette attaque: Joueur.TOUCHE, Joueur.COULE, Joueur.A_L_EAU ou Joueur.GAME_OVER
	 */
	public int defendre(Coordonnee c) {
		return 0;
	}


}
