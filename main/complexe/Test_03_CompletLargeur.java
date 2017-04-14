package main.complexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_03_CompletLargeur {

	public static void main(String args [])
	{
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		AlgorithmeParcoursLargeur parcoursComplet;
		parcoursComplet=new AlgorithmeParcoursLargeur(probleme);
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
