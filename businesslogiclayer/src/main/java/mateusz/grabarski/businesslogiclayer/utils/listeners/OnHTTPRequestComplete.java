package mateusz.grabarski.businesslogiclayer.utils.listeners;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public interface OnHTTPRequestComplete {
    void onTaskCompleted(String xml);
    void onTaskFailed();
}
