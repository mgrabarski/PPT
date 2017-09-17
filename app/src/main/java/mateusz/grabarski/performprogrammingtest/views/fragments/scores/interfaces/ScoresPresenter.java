package mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public interface ScoresPresenter {
    void setScoresModel(ScoresModel scoresModel);
    ScoresModel getScoresModels();
    void setScoresView(ScoresView scoresView);
    ScoresView getScoresView();
    void displayMatches();
}
