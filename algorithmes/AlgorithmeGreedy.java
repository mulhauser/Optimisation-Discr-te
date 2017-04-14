package algorithmes;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;

public class AlgorithmeGreedy extends AlgorithmeAbstract {

	public AlgorithmeGreedy(Problem p) {
		super(p);
	}

	@Override
	public SolutionPartielle construireMeilleur() {

		SolutionPartielle enCours = this.problemeAResoudre.solutionInitiale();
		while(!enCours.estComplete()) {
			SolutionPartielle[] sp = enCours.solutionsVoisines();
			double opt = 0;
			for (SolutionPartielle s : sp) {
				if ((problemeAResoudre.evaluer(s)) > opt){
					opt = problemeAResoudre.evaluer(s);
					enCours = s;
				}
				compteur++;
			}
		}
		System.out.println(compteur);
		return enCours;

	}

}
