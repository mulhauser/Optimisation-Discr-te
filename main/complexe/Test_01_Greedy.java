package main.complexe;
import algorithmeFormat.AlgorithmeFormat;
import generic.AlgorithmeAbstract;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeGreedy;


public class Test_01_Greedy {

	public static void main(String args [])
	{
		
		System.out.println("largeurFiltree");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		// modifier AlgorithmeAbstrat et l'import pour AlgoGreddy
		AlgorithmeAbstract greedy=new AlgorithmeGreedy(probleme);
		
		//resultat
		SolutionPartielle resultat=greedy.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
