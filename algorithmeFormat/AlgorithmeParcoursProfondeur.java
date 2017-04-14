package algorithmeFormat;

import generic.Problem;
import generic.SolutionPartielle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 10/04/2017.
 */
public class AlgorithmeParcoursProfondeur extends AlgorithmeFormat {
    /**
     * constucteur
     *
     * @param p probleme a resoudre
     */
    public AlgorithmeParcoursProfondeur(Problem p) {
        super(p);
    }

    @Override
    protected SolutionPartielle getMeilleureSolution() {
        SolutionPartielle meilleure = null;
        double max = 0.0;
        for(SolutionPartielle s : ferme){
            if(problemeAResoudre.evaluer(s) > max){
                max = problemeAResoudre.evaluer(s);
                meilleure = s;
            }
        }
        return meilleure;
    }

    @Override
    protected SolutionPartielle[] filtrer(SolutionPartielle[] voisins) {
        compteur++;
        return voisins;
    }

    @Override
    protected boolean etreFini() {

        return ouvert.isEmpty();
    }

    @Override
    protected SolutionPartielle choisir(List<SolutionPartielle> ouvert2) {
        return ouvert2.get(0);
    }
}
