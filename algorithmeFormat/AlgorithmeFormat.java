package algorithmeFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public abstract class AlgorithmeFormat extends AlgorithmeAbstract {

	/**
	 * la liste des solutions partielles
	 */
	List<SolutionPartielle> ouvert, ferme;

	/**
	 * constucteur
	 * 
	 * @param p
	 *            probleme a resoudre
	 */
	public AlgorithmeFormat(Problem p) {
		super(p);
		ouvert = new ArrayList<>();
		ferme = new ArrayList<>();
	}

	@Override
	public SolutionPartielle construireMeilleur() {
		ouvert.add(this.problemeAResoudre.solutionInitiale());
		while (!this.etreFini()) {
			// choisit une solution
			SolutionPartielle s = this.choisir(this.ouvert);
			this.ouvert.remove(s);
			this.ferme.add(s);

			// developpe la solution
			SolutionPartielle[] voisins = s.solutionsVoisines();

			// filtre les solutions
			SolutionPartielle[] filtre = this.filtrer(voisins);

			// ajoute les nouvelles solutions a developper dans ouvert
			for (SolutionPartielle sol : filtre){
			    if(sol != null) ouvert.add(sol);
            }
		}
		System.out.println(compteur);
		return this.getMeilleureSolution();
	}

	protected  abstract SolutionPartielle getMeilleureSolution() ;

	protected abstract SolutionPartielle[] filtrer(SolutionPartielle[] voisins);

	protected abstract boolean etreFini();

	protected abstract SolutionPartielle choisir(List<SolutionPartielle> ouvert2);

}
