package main.complexe;

import algorithmeFormat.AlgorithmeFormat;
import algorithmeFormat.AlgorithmeGreedy;
import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;


public class Test_01_GreedyFormat {

	public static void main(String args [])
	{
		
		System.out.println("largeurFiltree");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		// modifier AlgorithmeAbstrat et l'import pour AlgoGreddy
		AlgorithmeFormat greedy=new AlgorithmeGreedy(probleme);
		
		//resultat
		SolutionPartielle resultat=greedy.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
