package main.aleatoire;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeParcoursLargeur;
import algorithmes.AlgorithmeParcoursLargeurFiltre;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_04_CompletLargeurFiltre {

	public static void main(String args [])
	{
		
		System.out.println("complet largeur Filtree - tres complexe");
		
		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeAleatoire(Constante.NB_OBJETS);
		
		//creation algorithme
		AlgorithmeParcoursLargeur parcoursComplet;
		parcoursComplet=new AlgorithmeParcoursLargeurFiltre(probleme);
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
