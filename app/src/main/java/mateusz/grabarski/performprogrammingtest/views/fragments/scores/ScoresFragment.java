package mateusz.grabarski.performprogrammingtest.views.fragments.scores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mateusz.grabarski.performprogrammingtest.R;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class ScoresFragment extends Fragment {

    public static ScoresFragment newInstance() {

        Bundle args = new Bundle();

        ScoresFragment fragment = new ScoresFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores, container, false);

        return view;
    }
}
