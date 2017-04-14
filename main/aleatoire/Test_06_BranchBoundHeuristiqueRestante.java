package main.aleatoire;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.HeuristiqueDensiteMax;
import sacADos.ProblemSacADos;
import sacADos.HeuristiqueDensiteMaxRestante;
import algorithmes.AlgorithmeBranchAndBound;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_06_BranchBoundHeuristiqueRestante {

	public static void main(String args [])
	{
		
		System.out.println("branch and bound (densite max restante) - tres complexe");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeAleatoire(Constante.NB_OBJETS);
		
		//creation algorithme
		AlgorithmeParcoursLargeur parcoursComplet;
		parcoursComplet=new AlgorithmeBranchAndBound(probleme,new HeuristiqueDensiteMaxRestante());
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
