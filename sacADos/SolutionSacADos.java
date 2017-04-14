package sacADos;

import generic.SolutionPartielle;

/**
 * permet de représenter une solution pour le probleme du sac à dos une solution
 * est une suite d'entiers
 */
public class SolutionSacADos extends SolutionPartielle {

	/**
	 * etat des objets
	 */
	boolean[] objetsPresents;
	int volumeActuel;
	int valeurActuelle;

	/**
	 * la profondeur traitee dans la solution partielle
	 */
	int profondeurTraitee;

	/**
	 * lien vers le probleme
	 */
	ProblemSacADos problemeEnCours;

	/**
	 * solution par défaut
	 * 
	 * @param nb
	 *            nb d'objets
	 */
	public SolutionSacADos(ProblemSacADos pb) {
		this.problemeEnCours = pb;

		this.objetsPresents = new boolean[pb.objetsDisponibles.length];
		this.volumeActuel = 0;
		this.valeurActuelle = 0;
		this.profondeurTraitee = 0;
	}

	/**
	 * construit une solution par copie
	 */
	SolutionSacADos(SolutionSacADos origine) {
		this.objetsPresents = origine.objetsPresents.clone();
		this.volumeActuel = origine.volumeActuel;
		this.valeurActuelle = origine.valeurActuelle;
		this.profondeurTraitee = origine.profondeurTraitee;

		this.problemeEnCours = origine.problemeEnCours;
	}

	@Override
	public SolutionPartielle[] solutionsVoisines() {
		// si tous ont ete traite
		if (estComplete()) {
			return (new SolutionPartielle[0]);
		}

		// construire les solutions
		SolutionPartielle[] resultat = new SolutionPartielle[2];
		SolutionSacADos solutionNonPris = new SolutionSacADos(this);
		solutionNonPris.nePasPrendre();
		resultat[0] = solutionNonPris;

		SolutionSacADos solutionPris = new SolutionSacADos(this);
		solutionPris.prendre();
		resultat[1] = solutionPris;

		return resultat;
	}

	private void prendre() {
		this.objetsPresents[profondeurTraitee] = true;
		Objet objetAjoute = this.problemeEnCours.objetsDisponibles[profondeurTraitee];
		this.volumeActuel += objetAjoute.volume;
		this.valeurActuelle += objetAjoute.valeur;

		profondeurTraitee++;

		if (this.volumeActuel > this.problemeEnCours.contenance) {
			this.valeurActuelle = 0;
		}
	}

	private void nePasPrendre() {
		this.objetsPresents[profondeurTraitee] = false;
		this.profondeurTraitee++;
	}

	public String toString() {
		String r = "sac ";
		for (int i = 0; i < profondeurTraitee; i++) {
			r += " ";
			if (objetsPresents[i])
				r += "1";
			else
				r += "0";
		}
		for (int i = profondeurTraitee; i < objetsPresents.length; i++)
			r += " X";

		r += "(val:" + valeurActuelle + " , vol:" + volumeActuel + " )";
		return (r);
	}

	@Override
	public boolean invalide() {
		return (this.volumeActuel > problemeEnCours.contenance);
	}

	@Override
	public boolean estComplete() {
		// complet si dernier element est pas NON_TRAITE
		return (profondeurTraitee == this.objetsPresents.length);
	}

}
