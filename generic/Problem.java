package generic;

/**
 * permet de representer un probleme d'optimisation
 * 
 */
public abstract class Problem {

	/**
	 * evaluer une solution partielle
	 * 
	 * @param s
	 *            solution a avaluer
	 * @return evaluation de la solution partielle
	 */
	public abstract double evaluer(SolutionPartielle s);

	/**
	 * retourne une solution vide a partir de laquelle construire
	 * 
	 * @return solution vide
	 */
	public abstract SolutionPartielle solutionInitiale();

}
