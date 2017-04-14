package algorithmes;

import generic.SolutionPartielle;

public class ValeurAEtoile implements Comparable<ValeurAEtoile> {

	SolutionPartielle solutionStockee;
	double valeurAssociee;
	double heuristiqueEstimee;
	double valeurEstimee;
	
	public ValeurAEtoile(SolutionPartielle s, double valeur, double heuristique) {
		this.solutionStockee = s;
		this.valeurAssociee = valeur;
		this.heuristiqueEstimee = heuristique;
		this.valeurEstimee = valeur + heuristique;
	}

	@Override
	public int compareTo(ValeurAEtoile o) {
		if (this.valeurEstimee < o.valeurEstimee)
			return (1);
		else if (this.valeurEstimee > o.valeurEstimee)
			return (-1);
		else
			return 0;
	}
	
	public String toString()
	{
		String r="";
		r+=solutionStockee+" , h: "+heuristiqueEstimee+" , max:"+valeurEstimee;
		return(r);
	}
}
