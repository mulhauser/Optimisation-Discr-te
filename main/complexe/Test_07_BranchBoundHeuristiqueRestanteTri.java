package main.complexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;
import sacADos.HeuristiqueDensiteMaxRestante;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_07_BranchBoundHeuristiqueRestanteTri {

	public static void main(String args [])
	{
		
		System.out.println("largeurFiltree");
		
		//creation du probleme
		ProblemSacADos probleme=ProblemSacADos.initialiseProblemeComplexe();
		probleme.trierDensite();
		
		//creation algorithme
		AlgorithmeParcoursLargeur parcoursComplet;
		parcoursComplet=new AlgorithmeBranchAndBound(probleme,new HeuristiqueDensiteMaxRestante());
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
