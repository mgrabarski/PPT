package mateusz.grabarski.businesslogiclayer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class NetworkConnectionUtils extends BroadcastReceiver {

    private ArrayList<NetworkChangeReceiver> networkChangeReceivers = new ArrayList<>();

    public static boolean isNetworkConnectionAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) return false;
        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            boolean networkOnline = isNetworkConnectionAvailable(context);
            for (NetworkChangeReceiver receiver : networkChangeReceivers) {
                receiver.onNetworkChangeReceive(networkOnline);
            }
        }
    }

    public void addNetworkChangeReceiver(NetworkChangeReceiver receiver) {
        networkChangeReceivers.add(receiver);
    }

    public void removeNetworkChangeReceiver(NetworkChangeReceiver receiver) {
        networkChangeReceivers.remove(receiver);
    }

    public interface NetworkChangeReceiver {
        void onNetworkChangeReceive(boolean isConnected);
    }
}
