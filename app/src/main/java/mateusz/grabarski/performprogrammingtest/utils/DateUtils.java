package mateusz.grabarski.performprogrammingtest.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class DateUtils {

    @SuppressLint("SimpleDateFormat")
    public static SimpleDateFormat newsDateFormat() {
        return new SimpleDateFormat("EEEE, d MMMM yyyy, HH:mm");
    }
}
