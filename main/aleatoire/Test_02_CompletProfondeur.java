package main.aleatoire;
import generic.Problem;
import generic.SolutionPartielle;
import sacADos.ProblemSacADos;
import algorithmes.AlgorithmeParcoursProfondeur;


public class Test_02_CompletProfondeur {

	public static void main(String args [])
	{
		
		System.out.println("Complet profondeur - tres complexe");

		//creation du probleme
		Problem probleme=ProblemSacADos.initialiseProblemeAleatoire(Constante.NB_OBJETS);
		
		//creation algorithme
		AlgorithmeParcoursProfondeur parcoursComplet;
		parcoursComplet=new AlgorithmeParcoursProfondeur(probleme);
		
		//resultat
		SolutionPartielle resultat=parcoursComplet.construireMeilleur();
		System.out.println(resultat);
		
	}
	
}
