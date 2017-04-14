package sacADos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import generic.Problem;
import generic.SolutionPartielle;

/**
 * represente le probleme du sac a dos
 * 
 * les donnees sont stockees dans un tableau d'objets
 * 
 */
public class ProblemSacADos extends Problem {

	/**
	 * données du problemes
	 */
	Objet[] objetsDisponibles;
	int contenance;

	/**
	 * permet de stocker la densité maximale
	 */
	private double densiteMax;

	/**
	 * construit un probleme vide le constructeur est prive car il faut passer
	 * par une methode d'initialisation
	 */
	private ProblemSacADos() {
	}

	/**
	 * initialise un probleme Simple
	 * 
	 * @return nouveau probleme
	 */
	static public Problem initialiseProblemeSimple() {
		ProblemSacADos probleme = new ProblemSacADos();
		probleme.contenance = 11;
		probleme.objetsDisponibles = new Objet[3];
		probleme.objetsDisponibles[0] = new Objet(5, 4);
		probleme.objetsDisponibles[1] = new Objet(9, 8);
		probleme.objetsDisponibles[2] = new Objet(2, 3);
		probleme.calculeDensiteMax();
		return (probleme);
	}

	/**
	 * mise à jour de l'attributDensiteMax qui est la densite maximale sur les
	 * objets présents
	 */
	private void calculeDensiteMax() {
		this.densiteMax = 0;

		for (int i = 0; i < this.objetsDisponibles.length; i++) {
			Objet obj = this.objetsDisponibles[i];
			if (obj.densite > this.densiteMax) {
				this.densiteMax = obj.densite;
			}
		}

	}

	/**
	 * initialise un probleme moyen (15 objets)
	 * 
	 * @return nouveau probleme
	 */
	static public ProblemSacADos initialiseProblemePlutotComplexe() {
		ProblemSacADos probleme = new ProblemSacADos();
		probleme.contenance = 50;
		probleme.objetsDisponibles = new Objet[15];
		probleme.objetsDisponibles[0] = new Objet(5, 4);
		probleme.objetsDisponibles[1] = new Objet(9, 8);
		probleme.objetsDisponibles[2] = new Objet(2, 3);
		probleme.objetsDisponibles[3] = new Objet(2, 1);
		probleme.objetsDisponibles[4] = new Objet(7, 12);
		probleme.objetsDisponibles[5] = new Objet(8, 4);
		probleme.objetsDisponibles[6] = new Objet(9, 13);
		probleme.objetsDisponibles[7] = new Objet(24, 20);
		probleme.objetsDisponibles[8] = new Objet(4, 7);
		probleme.objetsDisponibles[9] = new Objet(5, 14);
		probleme.objetsDisponibles[10] = new Objet(3, 3);
		probleme.objetsDisponibles[11] = new Objet(9, 7);
		probleme.objetsDisponibles[12] = new Objet(12, 2);
		probleme.objetsDisponibles[13] = new Objet(6, 9);
		probleme.objetsDisponibles[14] = new Objet(2, 3);
		probleme.calculeDensiteMax();
		return (probleme);
	}

	/**
	 * initialise un probleme complexe (20 objets)
	 * 
	 * @return nouveau probleme
	 */
	static public ProblemSacADos initialiseProblemeComplexe() {
		ProblemSacADos probleme = new ProblemSacADos();
		probleme.contenance = 50;
		probleme.objetsDisponibles = new Objet[20];
		probleme.objetsDisponibles[0] = new Objet(5, 4);
		probleme.objetsDisponibles[1] = new Objet(9, 8);
		probleme.objetsDisponibles[2] = new Objet(2, 3);
		probleme.objetsDisponibles[3] = new Objet(2, 2);
		probleme.objetsDisponibles[4] = new Objet(7, 12);
		probleme.objetsDisponibles[5] = new Objet(8, 4);
		probleme.objetsDisponibles[6] = new Objet(9, 13);
		probleme.objetsDisponibles[7] = new Objet(26, 22);
		probleme.objetsDisponibles[8] = new Objet(4, 7);
		probleme.objetsDisponibles[9] = new Objet(5, 14);
		probleme.objetsDisponibles[10] = new Objet(3, 3);
		probleme.objetsDisponibles[11] = new Objet(9, 7);
		probleme.objetsDisponibles[12] = new Objet(12, 2);
		probleme.objetsDisponibles[13] = new Objet(6, 9);
		probleme.objetsDisponibles[14] = new Objet(5, 3);
		probleme.objetsDisponibles[15] = new Objet(14, 5);
		probleme.objetsDisponibles[16] = new Objet(7, 4);
		probleme.objetsDisponibles[17] = new Objet(1, 6);
		probleme.objetsDisponibles[18] = new Objet(6, 5);
		probleme.objetsDisponibles[19] = new Objet(5, 12);
		probleme.calculeDensiteMax();
		return (probleme);
	}

	/**
	 * initialise un probleme tres complexe (25 objets)
	 * 
	 * @return nouveau probleme
	 */
	static public ProblemSacADos initialiseProblemeTresComplexe() {
		ProblemSacADos probleme = new ProblemSacADos();
		probleme.contenance = 103;
		probleme.objetsDisponibles = new Objet[25];
		probleme.objetsDisponibles[0] = new Objet(5, 4);
		probleme.objetsDisponibles[1] = new Objet(9, 8);
		probleme.objetsDisponibles[2] = new Objet(2, 3);
		probleme.objetsDisponibles[3] = new Objet(2, 1);
		probleme.objetsDisponibles[4] = new Objet(7, 12);
		probleme.objetsDisponibles[5] = new Objet(8, 4);
		probleme.objetsDisponibles[6] = new Objet(9, 13);
		probleme.objetsDisponibles[7] = new Objet(26, 20);
		probleme.objetsDisponibles[8] = new Objet(4, 7);
		probleme.objetsDisponibles[9] = new Objet(5, 14);
		probleme.objetsDisponibles[10] = new Objet(3, 3);
		probleme.objetsDisponibles[11] = new Objet(9, 7);
		probleme.objetsDisponibles[12] = new Objet(12, 2);
		probleme.objetsDisponibles[13] = new Objet(6, 9);
		probleme.objetsDisponibles[14] = new Objet(5, 3);
		probleme.objetsDisponibles[15] = new Objet(14, 5);
		probleme.objetsDisponibles[16] = new Objet(24, 24);
		probleme.objetsDisponibles[17] = new Objet(1, 6);
		probleme.objetsDisponibles[18] = new Objet(6, 5);
		probleme.objetsDisponibles[19] = new Objet(5, 12);
		probleme.objetsDisponibles[20] = new Objet(11, 2);
		probleme.objetsDisponibles[21] = new Objet(9, 4);
		probleme.objetsDisponibles[22] = new Objet(1, 3);
		probleme.objetsDisponibles[23] = new Objet(3, 9);
		probleme.objetsDisponibles[24] = new Objet(7, 5);
		probleme.calculeDensiteMax();
		return (probleme);
	}

	/**
	 * initialise un probleme aleatoire (n correspondant au nombre d'objets)
	 *
	 * <p>
	 * la contenance globale est un nombre aleatoire de 100*n
	 * <p>
	 * chaque objet a une contenance entre 100 et 200 et une valeur entre 0 et
	 * 100
	 * 
	 * @return nouveau probleme
	 */
	static public ProblemSacADos initialiseProblemeAleatoire(int n) {
		ProblemSacADos probleme = new ProblemSacADos();
		probleme.objetsDisponibles = new Objet[n];

		// contenance aleatoire
		probleme.contenance = (int) (Math.random() * (100 * n));
		for (int i = 0; i < n; i++) {
			// creation objet i
			int valeur = (int) (Math.random() * 100);
			int volume = (int) (Math.random() * 200);
			probleme.objetsDisponibles[i] = new Objet(valeur, volume);
		}
		probleme.calculeDensiteMax();
		return (probleme);
	}

	@Override
	/**
	 * retourne une solution partielle vide à partir de laquelle construire
	 */
	public SolutionPartielle solutionInitiale() {
		return new SolutionSacADos(this);
	}

	@Override
	/**
	 * permet d'évaluer une solution plutot que calcule l'évaluation, on stocke
	 * dans la solution son évaluation partielle
	 */
	public double evaluer(SolutionPartielle s) {
		// on retourne simplement la valeur stockee
		return (((SolutionSacADos) (s)).valeurActuelle);
	}

	/**
	 * retourne la densite de l'objet le plus dense
	 * 
	 * @return
	 */
	public double getDensiteMax() {
		return this.densiteMax;
	}

	/**
	 * on trie les objets par densite permet de simplifier le probleme et
	 * d'ameliorer les heuristiques
	 */
	public void trierDensite() {
		ArrayList<Objet> listeTemp = new ArrayList<Objet>();
		for (int i = 0; i < objetsDisponibles.length; i++)
			listeTemp.add(objetsDisponibles[i]);

		// comparateur de comparaison par densite
		Collections.sort(listeTemp, new Comparator<Objet>() {
			public int compare(Objet o1, Objet o2) {
				double d1 = o1.densite;
				double d2 = o2.densite;
				if (d1 > d2)
					return -1;
				if (d2 > d1)
					return 1;
				else
					return (0);
			}
		});
		this.objetsDisponibles = listeTemp.toArray(new Objet[0]);
	}

}
