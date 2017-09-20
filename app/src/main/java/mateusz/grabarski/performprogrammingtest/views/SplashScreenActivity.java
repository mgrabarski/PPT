package mateusz.grabarski.performprogrammingtest.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mateusz.grabarski.businesslogiclayer.utils.DataManager;
import mateusz.grabarski.businesslogiclayer.utils.listeners.DataManagerListener;

public class SplashScreenActivity extends AppCompatActivity implements DataManagerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new DataManager(this, this);
    }

    @Override
    public void onFinishDownloadData(boolean success) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
