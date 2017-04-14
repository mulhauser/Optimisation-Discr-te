package generic;

/**
 * represente une solution en cours de construction
 */
public abstract class SolutionPartielle {

	/**
	 * retourne les solutions partielles avec le choix de l'element suivant
	 * 
	 * @return liste des solutions partielles suivantes
	 */
	public abstract SolutionPartielle[] solutionsVoisines();

	/**
	 * permet de savoir si la solution partielle est valide
	 * 
	 * @return true si la solution est invalide
	 */
	public abstract boolean invalide();

	/**
	 * permet de savoir si la solution partielle est entiere ou s'il est
	 * necessaire de la construire
	 * 
	 * @return true si la solution est complete
	 */
	public abstract boolean estComplete();
}
