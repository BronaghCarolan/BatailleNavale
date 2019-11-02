package fr.uga.miashs.inff3.carolanb;

import java.awt.Color;

/**
 * Cette classe répresente une grille navale graphique dans un jeu de Bataille
 * Navale
 *
 * @author Conor Evans et Bronagh Carolan
 * @version 1.0
 * @since 2018-10-19
 */
public class GrilleNavaleGraphique extends GrilleNavale{
	
	GrilleGraphique grilleGraphique;
	
	
	public GrilleNavaleGraphique(int taille){
		super(taille);
		grilleGraphique = new GrilleGraphique(taille);
		
	}
	public GrilleGraphique getGrilleGraphique() {
		return grilleGraphique;
	}
	
	/**
	 * Ajoute un navire dans la grille si c'est possible.
	 * 
	 * @param n le navire à ajouter
	 * @return true si le navire a été ajouté.
	 */
	public boolean ajouteNavire(Navire n)
	{
		if(super.ajouteNavire(n))
		{
			grilleGraphique.colorie(n.getDebut(), n.getFin(), Color.GREEN);
			return true;
		}
		return false;
	}
	
	/**
	 * Gère la réception d'un tir sur la grille. Si le tir est ajouté dans les tir
	 * recus alors ce tir est également envoyé à chaque navire contenu dans la grille
	 * 
	 * @param c une référence vers la coordonnée du tir à receptionner
	 * @return true si le tir à touché un navire de la grille
	 */
	public boolean recoitTir(Coordonnee c) {
		if(super.recoitTir(c))
		{
			if(estALEau(c))
			{
				grilleGraphique.colorie(c, Color.BLUE);
			}
			else if(estTouche(c))
			{
				grilleGraphique.colorie(c, Color.RED);
			}
			return true;
		}
		return false;
	}


}
