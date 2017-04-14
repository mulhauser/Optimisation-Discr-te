package algorithmeFormat;

import generic.Problem;
import generic.SolutionPartielle;

import java.util.List;

/**
 * Created by mulhauser on 10/04/2017.
 */
public class AlgorithmeBranchAndBound extends AlgorithmeFormat {
    /**
     * constucteur
     *
     * @param p probleme a resoudre
     */
    public AlgorithmeBranchAndBound(Problem p) {
        super(p);
    }

    @Override
    protected SolutionPartielle getMeilleureSolution() {
        return null;
    }

    @Override
    protected SolutionPartielle[] filtrer(SolutionPartielle[] voisins) {
        return new SolutionPartielle[0];
    }

    @Override
    protected boolean etreFini() {
        return false;
    }

    @Override
    protected SolutionPartielle choisir(List<SolutionPartielle> ouvert2) {
        return null;
    }
}
