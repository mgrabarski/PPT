package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import android.content.Context;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mateusz.grabarski.businesslogiclayer.handlers.ScoresHandler;
import mateusz.grabarski.businesslogiclayer.managers.SharedPreferenceManager;
import mateusz.grabarski.businesslogiclayer.models.Scores;
import mateusz.grabarski.businesslogiclayer.models.scores.Group;
import mateusz.grabarski.businesslogiclayer.models.scores.Match;
import mateusz.grabarski.businesslogiclayer.models.scores.Parameter;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresModel;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public class ScoresModelImpl implements ScoresModel {

    private Scores scores;
    private Context context;

    public ScoresModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setScores(Scores scores) {
        this.scores = scores;
    }

    @Override
    public Scores getScores() {
        if (scores == null) {
            scores = ScoresHandler.parseScores(SharedPreferenceManager.getScoresXML(context));
        }
        return scores;
    }

    @Override
    public List<Match> getMatchesList() {
        List<Match> matches = new ArrayList<>();

        for (Group group : getScores().getGsmrs().getCompetition().getSeason().getRound().getGroup())
            matches.addAll(group.getMatch());

        return matches;
    }

    @Override
    public String getDate() throws ParseException {
        String date = getScores().getGsmrs().getMethod().getParameterByName(Parameter.PARAMETER_DATE);

        SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFromModel = currentFormat.parse(date);

        SimpleDateFormat displayFormat = new SimpleDateFormat("dd MMMM yyyy");

        return displayFormat.format(dateFromModel);
    }

    @Override
    public void downloadNewData() {
        Log.d(ScoresModelImpl.class.getSimpleName(), "downloadNewData()");
    }
}
