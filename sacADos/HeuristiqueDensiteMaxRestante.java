package sacADos;

import generic.Heuristique;
import generic.SolutionPartielle;


/**
 * heuristique qui considere qu'on peut mettre une fraction d'objet restant 
 * avec une densite correspondant à la densite maximale des objets restants 
 */
public class HeuristiqueDensiteMaxRestante extends Heuristique {

	/**
	 * pour ne pas avoir besoin de recalculer la densite maximale
	 * quand on change de profondeur
	 */
	private int derniereProf=-1;
	private double derniereDensite=0;
	
	@Override
	public double estimer(SolutionPartielle solutionAnalysee) {
		
		SolutionSacADos s=(SolutionSacADos)solutionAnalysee;
		
		if (s.estComplete())
			return 0;
		
		//on recalcule le max si la profonndeur traitee a change depuis la derniere evaluation
		if (s.profondeurTraitee!=derniereProf)
		{
			derniereProf=s.profondeurTraitee;
			derniereDensite=calculerMaxDensiteAPartir(s.problemeEnCours,s.profondeurTraitee);
			System.out.println("recalcul heuristique");
		}
		
		
		//on recupere meilleuredensite
		int restant=s.problemeEnCours.contenance-s.volumeActuel;
		if (restant<0)
			restant=0;
		
		double max=restant*derniereDensite;
		return max;
	}

	/**
	 * permet de calculer la meilleure densité restante
	 * @param probleme 
	 * @param profondeur profondeur ou on se trouve
	 * @return meilleure densite restante
	 */
	private double calculerMaxDensiteAPartir(ProblemSacADos probleme, int profondeur) {
		int nbObjets = probleme.objetsDisponibles.length;
		double max=-1;
		for (int i=profondeur;i<nbObjets;i++)
		{
			Objet obj=probleme.objetsDisponibles[i];
			if (obj.densite>max)
				max=obj.densite;
		}
		return max;
	}

}
