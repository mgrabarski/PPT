package mateusz.grabarski.performprogrammingtest.views.fragments.news;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mateusz.grabarski.businesslogiclayer.handlers.NewsHandler;
import mateusz.grabarski.businesslogiclayer.managers.SharedPreferenceManager;
import mateusz.grabarski.businesslogiclayer.models.News;
import mateusz.grabarski.businesslogiclayer.models.news.Item;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.views.fragments.news.adapter.NewsAdapter;
import mateusz.grabarski.performprogrammingtest.views.fragments.news.adapter.listeners.OnNewsClickListener;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class NewsFragment extends Fragment implements OnNewsClickListener {

    private RecyclerView newsRv;
    private TextView noDataTv;
    private NewsFragmentInterface listener;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof NewsFragmentInterface)
            listener = (NewsFragmentInterface) context;
        else
            throw new RuntimeException("Activity must implement NewsFragmentInterface");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        newsRv = view.findViewById(R.id.fragment_news_rv);
        noDataTv = view.findViewById(R.id.fragment_news_no_data_tv);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        News news = NewsHandler.parseNews(SharedPreferenceManager.getNewsXML(getContext()));

        newsRv.setLayoutManager(new LinearLayoutManager(getContext()));

        if (news == null) {
            newsRv.setVisibility(View.GONE);
            noDataTv.setVisibility(View.VISIBLE);
        } else {
            newsRv.setVisibility(View.VISIBLE);
            noDataTv.setVisibility(View.GONE);

            newsRv.setAdapter(new NewsAdapter(getContext(), news.getRss().getChannel().getItem(), this));
        }
    }

    @Override
    public void onNewsItemClick(Item item) {
        listener.onNewsItemClick(item);
    }

    public interface NewsFragmentInterface extends OnNewsClickListener {

    }
}
