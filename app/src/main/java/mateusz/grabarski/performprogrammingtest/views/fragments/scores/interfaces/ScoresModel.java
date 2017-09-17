package mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces;

import mateusz.grabarski.businesslogiclayer.models.Scores;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public interface ScoresModel {
    void setScores(Scores scores);
    Scores getScores();
}
