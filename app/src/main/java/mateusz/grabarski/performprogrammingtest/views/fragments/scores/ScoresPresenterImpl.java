package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import android.content.Context;

import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresModel;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresPresenter;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresView;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public class ScoresPresenterImpl implements ScoresPresenter {

    public static final long REFRESH_TIME = 30_000L;

    private ScoresModel scoresModel;
    private ScoresView scoresView;
    private Context context;

    private RefreshTask refreshTask;
    private Timer refreshTimer;
    private Runnable task;

    public ScoresPresenterImpl(Context context) {
        this.context = context;

        refreshTask = new RefreshTask();
        refreshTimer = new Timer();
        task = new Runnable() {
            @Override
            public void run() {
                scoresModel.downloadNewData();
            }
        };
    }

    @Override
    public void setScoresModel(ScoresModel scoresModel) {
        this.scoresModel = scoresModel;
        this.scoresModel.setScoresPresenter(this);
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
        try {
            scoresView.updateDateHeader(scoresModel.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        scoresView.updateList(scoresModel.getMatchesList());
    }

    @Override
    public void startRefreshData() {
        refreshTimer.scheduleAtFixedRate(refreshTask, 1, REFRESH_TIME);
    }

    @Override
    public void stopRefreshData() {
        if (refreshTask != null) {
            refreshTask.cancel();
            refreshTimer.purge();
        }
    }

    private class RefreshTask extends TimerTask {

        @Override
        public void run() {
            new Thread(task).start();
        }
    }
}
