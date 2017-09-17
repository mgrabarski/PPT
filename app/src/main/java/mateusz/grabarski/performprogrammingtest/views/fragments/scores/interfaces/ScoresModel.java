package mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces;

import java.text.ParseException;
import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.Scores;
import mateusz.grabarski.businesslogiclayer.models.scores.Match;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public interface ScoresModel {
    void setScores(Scores scores);
    Scores getScores();
    List<Match> getMatchesList();
    String getDate() throws ParseException;
    void downloadNewData();
}
