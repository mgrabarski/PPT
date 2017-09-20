package mateusz.grabarski.businesslogiclayer.managers;

import android.content.Context;

import mateusz.grabarski.businesslogiclayer.utils.Constants;
import mateusz.grabarski.businesslogiclayer.utils.HTTPRequestTask;
import mateusz.grabarski.businesslogiclayer.utils.listeners.DataManagerListener;
import mateusz.grabarski.businesslogiclayer.utils.listeners.OnHTTPRequestComplete;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class NewsManager {

    private Context context;

    public NewsManager(Context context) {
        this.context = context;
    }

    public void downloadData(final DataManagerListener listener) {
        new HTTPRequestTask(new OnHTTPRequestComplete() {
            @Override
            public void onTaskCompleted(String xml) {

                SharedPreferenceManager.saveNewsXML(context, xml);

                listener.onFinishDownloadData(true);
            }

            @Override
            public void onTaskFailed() {
                listener.onFinishDownloadData(false);
            }
        }).execute(Constants.NEWS_URL);
    }
}
