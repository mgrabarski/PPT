package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import android.content.Context;

import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresModel;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresPresenter;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresView;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public class ScoresPresenterImpl implements ScoresPresenter {

    private ScoresModel scoresModel;
    private ScoresView scoresView;
    private Context context;

    public ScoresPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setScoresModel(ScoresModel scoresModel) {
        this.scoresModel = scoresModel;
    }

    @Override
    public ScoresModel getScoresModels() {
        return scoresModel;
    }

    @Override
    public void setScoresView(ScoresView scoresView) {
        this.scoresView = scoresView;
    }

    @Override
    public ScoresView getScoresView() {
        return scoresView;
    }

    @Override
    public void displayMatches() {
        scoresView.updateDateHeader(scoresModel.getScores().getGsmrs().getCompetition().getName());
        scoresView.updateList(scoresModel.getMatchesList());
    }
}
