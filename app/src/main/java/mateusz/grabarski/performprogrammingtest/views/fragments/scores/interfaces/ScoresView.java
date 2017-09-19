package mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces;

import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.scores.Match;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public interface ScoresView {
    void updateList(List<Match> matches);
    void updateDateHeader(String header);
    void showNoDataView();
    void showDataViews();
}
