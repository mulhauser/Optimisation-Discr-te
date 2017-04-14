package algorithmes;

import java.util.ArrayList;

import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;

public class AlgorithmeParcoursLargeur extends AlgorithmeAbstract {

	public AlgorithmeParcoursLargeur(Problem p) {
		super(p);
	}

	@Override
	public SolutionPartielle construireMeilleur() {
		return (calculerLargeur(this.problemeAResoudre.solutionInitiale()));
	}

	/**
	 * méthode itérative
	 * 
	 * @param solutionInitiale
	 * @return meilleur solution en dessous de la solution initiale
	 */
	private SolutionPartielle calculerLargeur(SolutionPartielle solutionInitiale) {

		// construit liste
		ArrayList<SolutionPartielle> liste = new ArrayList<SolutionPartielle>();
		liste.add(solutionInitiale);
		ArrayList<SolutionPartielle> parents = liste;

		while(!solutionInitiale.estComplete()) {
			ArrayList<SolutionPartielle> enfants = profondeurSuivante(parents);
			// Pour l'algo branch and bound
			filtrerGlobal(enfants);


			for(SolutionPartielle sp : enfants){
				liste.add(sp);
			}
			parents = enfants;
			solutionInitiale = chercherMeilleureSolution(liste);
		}

		System.out.println(compteur);
		return solutionInitiale;
		//throw new Error("TODO"); //TODO  a completer en utilisant profondeurSuivante
	}

	/**
	 * cherche la meilleure solution dans une liste
	 * 
	 * @param liste
	 *            dont on cherche la meilleure solution
	 * @return meilleure solution de la liste
	 */
	private SolutionPartielle chercherMeilleureSolution(
			ArrayList<SolutionPartielle> liste) {
		SolutionPartielle meilleur = null;
		double max = -1;
		for (SolutionPartielle s : liste) {
			if (this.problemeAResoudre.evaluer(s) >= max) {
				max = this.problemeAResoudre.evaluer(s);
				meilleur = s;
			}
		}
		return meilleur;
	}

	/**
	 * construit la liste à une nouvelle profondeur
	 * 
	 * @param parents
	 *            liste de profondeur n
	 * @return liste de profondeur n+1
	 */
	private ArrayList<SolutionPartielle> profondeurSuivante(
			ArrayList<SolutionPartielle> parents) {

		ArrayList<SolutionPartielle> filles = new ArrayList<SolutionPartielle>(parents.size()*2);

		for(SolutionPartielle sp : parents){
			for(SolutionPartielle spFille : sp.solutionsVoisines()){
				compteur++;
				if(!doitEtreFiltre(spFille, null)) {
					filles.add(spFille);
				}

			}
		}

		//throw new Error("TODO"); //TODO  A completer
		
		return filles;
	}

	protected void filtrerGlobal(ArrayList<SolutionPartielle> nouvelles) {
		// ne fait rien
	}

	protected boolean doitEtreFiltre(SolutionPartielle fille,
			ArrayList<SolutionPartielle> nouvelles) {
		return (false);

	}

}
