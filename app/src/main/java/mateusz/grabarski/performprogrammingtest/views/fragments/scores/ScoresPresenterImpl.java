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

    }

    @Override
    public ScoresModel getScoresModels() {
        return null;
    }

    @Override
    public void setScoresView(ScoresView scoresView) {

    }

    @Override
    public ScoresView getScoresView() {
        return null;
    }
}
