package algorithmeFormat;

import generic.Problem;
import generic.SolutionPartielle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mulhauser on 10/04/2017.
 */
public class AlgorithmeGreedy extends AlgorithmeFormat {
    /**
     * constucteur
     *
     * @param p probleme a resoudre
     */
    public AlgorithmeGreedy(Problem p) {
        super(p);
    }

    @Override
    protected SolutionPartielle getMeilleureSolution() {
        double opt = 0;
        SolutionPartielle meilleure = null;
        for(SolutionPartielle s : ferme){
            if(problemeAResoudre.evaluer(s) >= opt){
                meilleure = s;
                opt = problemeAResoudre.evaluer(s);
            }
        }
        return meilleure;
    }

    @Override
    protected SolutionPartielle[] filtrer(SolutionPartielle[] voisins) {
        SolutionPartielle sp = null;
        double opt = 0;
        for(SolutionPartielle s : voisins){
            if(!s.invalide()){
                if(problemeAResoudre.evaluer(s) > opt){
                    opt = problemeAResoudre.evaluer(s);
                    sp = s;
                }
            }
            compteur++;
        }

        return new SolutionPartielle[]{sp};
    }

    @Override
    protected boolean etreFini() {
        for(SolutionPartielle s : ouvert){
            return s.estComplete();
        }
        return false;
    }

    @Override
    protected SolutionPartielle choisir(List<SolutionPartielle> ouvert2) {
        double opt = 0;
        SolutionPartielle sol = null;
        for(SolutionPartielle s : ouvert2){
            if(problemeAResoudre.evaluer(s) >= opt){
                opt = problemeAResoudre.evaluer(s);
                sol = s;
            }
        }
        return sol;
    }
}
