package mateusz.grabarski.businesslogiclayer.utils;

import android.content.Context;

import mateusz.grabarski.businesslogiclayer.managers.NewsManager;
import mateusz.grabarski.businesslogiclayer.managers.ScoresManager;
import mateusz.grabarski.businesslogiclayer.managers.StandingsManager;
import mateusz.grabarski.businesslogiclayer.utils.listeners.DataManagerListener;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class DataManager {

    private NewsManager newsManager;
    private ScoresManager scoresManager;
    private StandingsManager standingsManager;

    private boolean isNewsFinished, isScoresFinished, isStandingsFinished;

    private Context context;
    private DataManagerListener listener;

    public DataManager(Context context, DataManagerListener listener) {
        this.context = context;
        this.listener = listener;

        isNewsFinished = isScoresFinished = isStandingsFinished = false;

        newsManager = new NewsManager(context);
        scoresManager = new ScoresManager(context);
        standingsManager = new StandingsManager(context);

        downloadData();
    }

    private void downloadData() {

        if (!NetworkConnectionUtils.isNetworkConnectionAvailable(context)) {
            listener.onFinishDownloadData(false);
            return;
        }

        newsManager.downloadData(new DataManagerListener() {
            @Override
            public void onFinishDownloadData(boolean success) {
                isNewsFinished = true;

                checkIsAllOperationsFinished();
            }
        });

        scoresManager.downloadData(new DataManagerListener() {
            @Override
            public void onFinishDownloadData(boolean success) {
                isScoresFinished = true;

                checkIsAllOperationsFinished();
            }
        });

        standingsManager.downloadData(new DataManagerListener() {
            @Override
            public void onFinishDownloadData(boolean success) {
                isStandingsFinished = true;

                checkIsAllOperationsFinished();
            }
        });
    }

    private void checkIsAllOperationsFinished() {
        if (isNewsFinished && isScoresFinished && isStandingsFinished)
            listener.onFinishDownloadData(true);
    }
}
