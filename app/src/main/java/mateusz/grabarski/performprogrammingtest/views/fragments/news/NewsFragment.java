package mateusz.grabarski.performprogrammingtest.views.fragments.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mateusz.grabarski.businesslogiclayer.handlers.NewsHandler;
import mateusz.grabarski.businesslogiclayer.managers.SharedPreferenceManager;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.views.fragments.news.adapter.NewsAdapter;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class NewsFragment extends Fragment {

    private RecyclerView newsRv;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRv = view.findViewById(R.id.fragment_news_rv);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        newsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRv.setAdapter(new NewsAdapter(getContext(), NewsHandler.parseNews(SharedPreferenceManager.getNewsXML(getContext())).getRss().getChannel().getItem()));
    }
}
