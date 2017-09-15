package mateusz.grabarski.businesslogiclayer.managers;

import android.content.Context;
import android.content.SharedPreferences;

import mateusz.grabarski.businesslogiclayer.utils.Constants;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class SharedPreferenceManager {

    private static final String PREFERENCES_FILE = "prefs";

    private static void saveStringValue(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static String getStringValue(Context context, String key, String defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    public static void saveNewsXML(Context context, String xml) {
        saveStringValue(context, Constants.KEY_SHARE_PREFS_NEWS, xml);
    }

    public static String getNewsXML(Context context) {
        return getStringValue(context, Constants.KEY_SHARE_PREFS_NEWS, "");
    }

    public static void saveScoresXML(Context context, String xml) {
        saveStringValue(context, Constants.KEY_SHARE_PREFS_SCORES, xml);
    }

    public static String getScoresXML(Context context) {
        return getStringValue(context, Constants.KEY_SHARE_PREFS_SCORES, "");
    }

    public static void saveStandingsXML(Context context, String xml) {
        saveStringValue(context, Constants.KEY_SHARE_PREFS_STANDINGS, xml);
    }

    public static String getStandingsXML(Context context) {
        return getStringValue(context, Constants.KEY_SHARE_PREFS_STANDINGS, "");
    }
}
