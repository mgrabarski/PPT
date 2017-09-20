package mateusz.grabarski.businesslogiclayer.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mateusz.grabarski.businesslogiclayer.utils.listeners.OnHTTPRequestComplete;

/**
 * Created by Mateusz Grabarski on 13.09.2017.
 */

public class HTTPRequestTask extends AsyncTask<String, Void, String> {

    private OnHTTPRequestComplete listener;

    public HTTPRequestTask(OnHTTPRequestComplete listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String responseString = "";
        InputStream is = null;

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inLine;

            while ((inLine = in.readLine()) != null)
                responseString += inLine;

            in.close();
            return responseString;
        } catch (IOException e) {
            e.printStackTrace();
            listener.onTaskFailed();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return responseString;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onTaskCompleted(s);
    }
}
