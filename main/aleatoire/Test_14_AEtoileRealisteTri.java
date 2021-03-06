package main.aleatoire;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.HeuristiqueDensiteRealisteTrie;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeAEtoile;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_14_AEtoileRealisteTri {

	public static void main(String args [])
	{
		
		System.out.println("A* (heuristique realiste)");
		
		//creation du probleme
		ProblemSacADos probleme=(ProblemSacADos) ProblemSacADos.initialiseProblemeAleatoire(Constante.NB_OBJETS);
		probleme.trierDensite();
		
		//creation algorithme
		AlgorithmeAEtoile parcoursComplet;
		parcoursComplet=new AlgorithmeAEtoile(probleme,new HeuristiqueDensiteRealisteTrie());
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
