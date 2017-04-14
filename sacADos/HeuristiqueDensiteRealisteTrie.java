package sacADos;

import generic.Heuristique;
import generic.SolutionPartielle;

/**
 * heuristique qui cherche à remplir au mieux avec ce qui reste en levant la
 * contrainte du domaine entier sur les variables
 * 
 * ATTENTION : nécessite une liste triée d'objets
 */
public class HeuristiqueDensiteRealisteTrie extends Heuristique {

	@Override
	public double estimer(SolutionPartielle solutionAnalysee) {

		SolutionSacADos s = (SolutionSacADos) solutionAnalysee;
		// on essaie de completer au max
		int volumeRestant = s.problemeEnCours.contenance - s.volumeActuel;
		double valeurEstimee = 0;
		int numObjet = s.profondeurTraitee;
		int nbrObjets = s.problemeEnCours.objetsDisponibles.length;

		while (volumeRestant > 0 && numObjet < nbrObjets) {
			Objet obj = s.problemeEnCours.objetsDisponibles[numObjet];
			if (obj.volume < volumeRestant) {
				// on met tout l'objet
				volumeRestant -= obj.volume;
				valeurEstimee += obj.valeur;
				numObjet++;
			} else {
				// on met le reste
				valeurEstimee += obj.densite * volumeRestant;
				volumeRestant = 0;
			}
		}
		return (valeurEstimee);

	}

}
