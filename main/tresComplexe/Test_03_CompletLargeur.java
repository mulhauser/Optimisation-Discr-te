package main.tresComplexe;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_03_CompletLargeur {

	public static void main(String args [])
	{
		
		System.out.println("Complet largeur - tres complexe");

		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeTresComplexe();
		
		//creation algorithme
		AlgorithmeParcoursLargeur parcoursComplet;
		parcoursComplet=new AlgorithmeParcoursLargeur(probleme);
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
