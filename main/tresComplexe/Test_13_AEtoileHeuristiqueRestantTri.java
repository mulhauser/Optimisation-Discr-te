package main.tresComplexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.HeuristiqueDensiteRealisteTrie;
import sacADos.ProblemSacADos;
import sacADos.HeuristiqueDensiteMaxRestante;
import algorithmes.AlgorithmeAEtoile;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_13_AEtoileHeuristiqueRestantTri {

	public static void main(String args [])
	{
		
		System.out.println("largeurFiltree");
		
		//creation du probleme
		ProblemSacADos probleme=(ProblemSacADos) ProblemSacADos.initialiseProblemeTresComplexe();
		probleme.trierDensite();
		
		//creation algorithme
		AlgorithmeAEtoile parcoursComplet;
		parcoursComplet=new AlgorithmeAEtoile(probleme,new HeuristiqueDensiteMaxRestante());
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
