package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.scores.Match;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.adapter.MatchesAdapter;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresModel;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresPresenter;
import mateusz.grabarski.performprogrammingtest.views.fragments.scores.interfaces.ScoresView;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class ScoresFragment extends Fragment implements ScoresView {

    private TextView headerTv, noDataTv;
    private RecyclerView matchesRv;

    private ScoresPresenter scoresPresenter;
    private ScoresModel scoresModel;

    private List<Match> matches;
    private MatchesAdapter adapter;

    public static ScoresFragment newInstance() {

        Bundle args = new Bundle();

        ScoresFragment fragment = new ScoresFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        matches = new ArrayList<>();
        scoresModel = new ScoresModelImpl(getContext());
        scoresPresenter = new ScoresPresenterImpl(getContext());
        scoresPresenter.setScoresModel(scoresModel);
        scoresPresenter.setScoresView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores, container, false);

        headerTv = view.findViewById(R.id.fragment_scores_header_tv);
        matchesRv = view.findViewById(R.id.fragment_scores_list_rv);
        noDataTv = view.findViewById(R.id.fragment_scores_no_data_tv);

        adapter = new MatchesAdapter(getContext(), matches);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        matchesRv.setLayoutManager(new LinearLayoutManager(getContext()));
        matchesRv.setAdapter(adapter);
        scoresPresenter.displayMatches();
        scoresPresenter.startRefreshData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        scoresPresenter.stopRefreshData();
    }

    @Override
    public void updateList(List<Match> matches) {
        if (matches == null)  {
            showNoDataView();
        } else {
            showNoDataView();

            this.matches.clear();
            this.matches.addAll(matches);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void updateDateHeader(String header) {
        headerTv.setText(header);
    }

    @Override
    public void showNoDataView() {
        headerTv.setVisibility(View.GONE);
        matchesRv.setVisibility(View.GONE);
        noDataTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDataViews() {
        headerTv.setVisibility(View.VISIBLE);
        matchesRv.setVisibility(View.VISIBLE);
        noDataTv.setVisibility(View.GONE);
    }
}
