package mateusz.grabarski.businesslogiclayer.managers;

import android.content.Context;

import mateusz.grabarski.businesslogiclayer.utils.Constants;
import mateusz.grabarski.businesslogiclayer.utils.HTTPRequestTask;
import mateusz.grabarski.businesslogiclayer.utils.listeners.DataManagerListener;
import mateusz.grabarski.businesslogiclayer.utils.listeners.OnHTTPRequestComplete;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class StandingsManager {

    private Context context;

    public StandingsManager(Context context) {
        this.context = context;
    }

    public void downloadData(final DataManagerListener listener) {
        new HTTPRequestTask(new OnHTTPRequestComplete() {
            @Override
            public void onTaskCompleted(String xml) {

                SharedPreferenceManager.saveStandingsXML(context, xml);

                listener.onFinishDownloadData(true);
            }

            @Override
            public void onTaskFailed() {
                listener.onFinishDownloadData(false);
            }
        }).execute(Constants.STANDINGS_URL);
    }
}
