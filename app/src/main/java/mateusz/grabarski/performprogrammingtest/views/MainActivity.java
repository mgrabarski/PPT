package mateusz.grabarski.performprogrammingtest.views;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mateusz.grabarski.businesslogiclayer.managers.SharedPreferenceManager;
import mateusz.grabarski.businesslogiclayer.models.news.Item;
import mateusz.grabarski.businesslogiclayer.utils.DataManager;
import mateusz.grabarski.businesslogiclayer.utils.NetworkConnectionUtils;
import mateusz.grabarski.businesslogiclayer.utils.listeners.DataManagerListener;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.views.fragments.interfaces.FragmentConnectionListener;
import mateusz.grabarski.performprogrammingtest.views.fragments.news.NewsFragment;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.ScoresFragment;
import mateusz.grabarski.performprogrammingtest.views.fragments.standings.StandingsFragment;
import mateusz.grabarski.performprogrammingtest.widgets.DropDownMenu;

public class MainActivity extends AppCompatActivity implements
        DropDownMenu.DropDownMenuListener, NewsFragment.NewsFragmentInterface, NetworkConnectionUtils.NetworkChangeReceiver {

    private DropDownMenu dropDownMenu;
    private NetworkConnectionUtils connectionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropDownMenu = (DropDownMenu) findViewById(R.id.activity_main_drop_down_menu);
        dropDownMenu.setListener(this);

        if (savedInstanceState == null)
            replaceAndAddToBackStackFragment(NewsFragment.newInstance());
        else
            replaceAndAddToBackStackFragment(getLastFragment());

        connectionUtils = new NetworkConnectionUtils();

        connectionUtils.addNetworkChangeReceiver(this);

        registerReceiver(connectionUtils, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private Fragment getLastFragment() {
        int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);
        String tag = backEntry.getName();
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1)
            finish();
        else
            super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (connectionUtils != null) {
            unregisterReceiver(connectionUtils);
            connectionUtils.removeNetworkChangeReceiver(this);
            connectionUtils = null;
        }
    }

    @Override
    public void onNewsClick() {
        replaceAndAddToBackStackFragment(NewsFragment.newInstance());
    }

    @Override
    public void onScoresClick() {
        replaceAndAddToBackStackFragment(ScoresFragment.newInstance());
    }

    @Override
    public void onStandingsClick() {
        replaceAndAddToBackStackFragment(StandingsFragment.newInstance());
    }

    private void replaceAndAddToBackStackFragment(Fragment fragment) {
        String tag = fragment.getClass().getName();

        FragmentManager fragmentManager = getSupportFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(tag, 0);

        if (!fragmentPopped && fragmentManager.findFragmentByTag(tag) == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.activity_main_fl, fragment, tag);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onNewsItemClick(Item item) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra(NewsDetailsActivity.NEWS_URL, item.getLink());
        startActivity(intent);
    }

    @Override
    public void onNetworkChangeReceive(boolean isConnected) {
        if (SharedPreferenceManager.getNewsXML(this) == null || SharedPreferenceManager.getNewsXML(this).equals(""))
            new DataManager(this, new DataManagerListener() {
                @Override
                public void onFinishDownloadData(boolean success) {
                    Fragment currentFragment = getLastFragment();

                    if (currentFragment instanceof FragmentConnectionListener)
                        ((FragmentConnectionListener) currentFragment).updateView();
                }
            });
    }
}
