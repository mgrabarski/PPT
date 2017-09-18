package mateusz.grabarski.performprogrammingtest.views.fragments.standings.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.standings.Ranking;
import mateusz.grabarski.performprogrammingtest.R;

/**
 * Created by Mateusz Grabarski on 18.09.2017.
 */

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    private Context context;
    private List<Ranking> rankings;

    public StandingsAdapter(Context context, List<Ranking> rankings) {
        this.context = context;
        this.rankings = rankings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_standings, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.populate(rankings.get(position));
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void populate(Ranking ranking) {
            
        }
    }
}
