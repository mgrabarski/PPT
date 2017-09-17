package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import mateusz.grabarski.businesslogiclayer.models.Scores;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresModel;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public class ScoresModelImpl implements ScoresModel {

    private Scores scores;

    public ScoresModelImpl() {
    }

    @Override
    public void setScores(Scores scores) {
        this.scores = scores;
    }

    @Override
    public Scores getScores() {
        return scores;
    }
}
