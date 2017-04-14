package main.complexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_02_CompletProfondeur {

	public static void main(String args [])
	{
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeComplexe();
		
		//creation algorithme
		AlgorithmeParcoursProfondeur parcoursComplet;
		parcoursComplet=new AlgorithmeParcoursProfondeur(probleme);
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
