package fr.uga.miashs.inff3.carolanb;

import java.awt.Color;

public class GrilleNavaleGraphique extends GrilleNavale{
	
	GrilleGraphique grilleGraphique;
	
	
	public GrilleNavaleGraphique(int taille){
		super(taille);
		grilleGraphique = new GrilleGraphique(taille);
		
	}
	public GrilleGraphique getGrilleGraphique() {
		return grilleGraphique;
	}
	
	public boolean ajouteNavire(Navire n)
	{
		if(super.ajouteNavire(n))
		{
			grilleGraphique.colorie(n.getDebut(), n.getFin(), Color.GREEN);
			return true;
		}
		return false;
	}
	
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
