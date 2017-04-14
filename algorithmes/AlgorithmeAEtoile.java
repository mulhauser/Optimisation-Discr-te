package algorithmes;

import java.util.*;

import generic.AlgorithmeAbstract;
import generic.Heuristique;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeAEtoile extends AlgorithmeAbstract {

	Heuristique heuristique;

	public AlgorithmeAEtoile(Problem p, Heuristique h) {
		super(p);
		this.heuristique = h;
	}

	@Override
	public SolutionPartielle construireMeilleur() {

		SolutionPartielle solutionEnCours = this.problemeAResoudre
				.solutionInitiale();
		PriorityQueue<ValeurAEtoile> atraiter = new PriorityQueue<ValeurAEtoile>();

		SolutionPartielle meilleureTrouvee = null;

		// initilisation
		{
			ValeurAEtoile valEtoile;
			double valeur = this.problemeAResoudre.evaluer(solutionEnCours);
			double heuristique = this.heuristique.estimer(solutionEnCours);
			valEtoile = new ValeurAEtoile(solutionEnCours, valeur, heuristique);
			atraiter.add(valEtoile);
		}

		while(!atraiter.isEmpty() && !solutionEnCours.estComplete()){
            solutionEnCours = atraiter.poll().solutionStockee;
            SolutionPartielle[] enfants = solutionEnCours.solutionsVoisines();
            for(SolutionPartielle enfant : enfants){
                if(!enfant.invalide()) {
                    ValeurAEtoile valEtoile;
                    double valeur = this.problemeAResoudre.evaluer(enfant);
                    double heuristique = this.heuristique.estimer(enfant);
                    valEtoile = new ValeurAEtoile(enfant, valeur, heuristique);
                    atraiter.offer(valEtoile);
                }
            compteur++;
            }

        }

		System.out.println(compteur);
		return solutionEnCours;
	}

}
