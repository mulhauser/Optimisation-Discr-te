package algorithmes;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeParcoursProfondeur extends AlgorithmeAbstract {

	static int compteur = 0;

	public AlgorithmeParcoursProfondeur(Problem p) {
		super(p);
	}

	@Override
	/**
	 * cherche la meilleure solution par appels récursifs
	 */
	public SolutionPartielle construireMeilleur() {
		SolutionPartielle s = (calculerMax(this.problemeAResoudre.solutionInitiale()));
		System.out.println(compteur);
		return s;
	}

	/**
	 * méthode recursive appelée pour effectuee une recherche en profondeur.
	 * <p>
	 * le principe ==> la meilleure solution est la meilleure des solutions
	 * completes construite sur les fils de la solution courante
	 * 
	 * @param solutionInitiale
	 *            solution partielle dont on souhaite la meilleure solution
	 * @return meilleure solution en dessous de la solution initiale
	 */
	private SolutionPartielle calculerMax(SolutionPartielle solutionInitiale) {

		compteur++;

		// on arrete la recursion si on est sur une solution valide
		if (solutionInitiale.estComplete())
			return (solutionInitiale);

		// sinon on cherche la meilleure solution sur le meilleur fils
		SolutionPartielle[] solutionVoisines = solutionInitiale.solutionsVoisines();
		double max = 0;
		SolutionPartielle meilleureGlobale = null;

		for (SolutionPartielle solutionAEtudier : solutionVoisines) {
			// trouve la meilleure solution complete partir du fils
			// par appel recursif
			SolutionPartielle meilleureFille = calculerMax(solutionAEtudier);
			// regarde si cette solution complete est la meilleure
			double evaluation = this.problemeAResoudre.evaluer(meilleureFille);
			if (evaluation >= max) {
				max = evaluation;
				meilleureGlobale = meilleureFille;
			}
		}

		return meilleureGlobale;
	}

}
