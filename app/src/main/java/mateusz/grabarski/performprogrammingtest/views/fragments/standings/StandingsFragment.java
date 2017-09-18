package mateusz.grabarski.performprogrammingtest.views.fragments.standings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mateusz.grabarski.businesslogiclayer.comparators.RankingComparator;
import mateusz.grabarski.businesslogiclayer.handlers.StandingsHandler;
import mateusz.grabarski.businesslogiclayer.managers.SharedPreferenceManager;
import mateusz.grabarski.businesslogiclayer.models.standings.Ranking;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.views.fragments.standings.adapter.StandingsAdapter;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class StandingsFragment extends Fragment {

    private RecyclerView standingsRv;

    private List<Ranking> rankings;
    private StandingsAdapter adapter;

    public static StandingsFragment newInstance() {

        Bundle args = new Bundle();

        StandingsFragment fragment = new StandingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rankings = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_standings, container, false);

        standingsRv = view.findViewById(R.id.fragment_standings_rv);

        adapter = new StandingsAdapter(getContext(), rankings);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        standingsRv.setLayoutManager(new LinearLayoutManager(getContext()));

        rankings.addAll(getOrderRankingItems());

        standingsRv.setAdapter(adapter);
    }

    private List<Ranking> getOrderRankingItems() {
        List<Ranking> rankings = StandingsHandler.parseStanding(SharedPreferenceManager.getStandingsXML(getContext())).getRoot().getCompetition().getSeason().getRound().getResultStable().getRanking();

        Collections.sort(rankings, RankingComparator.comparatorByRank());

        return rankings;
    }
}
