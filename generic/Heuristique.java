package generic;
/**
 * permet de representer des heuristiques 
 *
 */
public abstract class Heuristique {

	/**
	 * estime la solution de manière optimiste
	 * 
	 * @param solutionAnalysee solution à estimer
	 * @return estimation optimisate du reste 
	 */
	public abstract  double estimer(SolutionPartielle solutionAnalysee);

}
