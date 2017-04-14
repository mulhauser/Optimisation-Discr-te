package algorithmes;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeParcoursLargeurFiltre extends AlgorithmeParcoursLargeur {

	public AlgorithmeParcoursLargeurFiltre(Problem p) {
		super(p);
	}

	protected boolean doitEtreFiltre(SolutionPartielle fille,
									 ArrayList<SolutionPartielle> nouvelles) {

		return fille.invalide();
		//throw new Error("TODO"); //TODO  ecrire un filtre qui retire les solutions invalides
		
	}

}
