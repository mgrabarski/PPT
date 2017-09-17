package mateusz.grabarski.performprogrammingtest.views.fragments.scores.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.scores.Match;
import mateusz.grabarski.performprogrammingtest.R;

/**
 * Created by Mateusz Grabarski on 17.09.2017.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private Context context;
    private List<Match> matches;

    public MatchesAdapter(Context context, List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_scores, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.populate(matches.get(position), position);
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout rootLl;
        private TextView leftTeamTv, rightTeamTv, scoreTv;

        public ViewHolder(View itemView) {
            super(itemView);

            rootLl = itemView.findViewById(R.id.item_scores_root_ll);
            leftTeamTv = itemView.findViewById(R.id.item_scores_left_tv);
            rightTeamTv = itemView.findViewById(R.id.item_scores_right_tv);
            scoreTv = itemView.findViewById(R.id.item_scores_center_tv);
        }

        public void populate(Match match, int position) {
            if (position % 2 == 0)
                rootLl.setBackgroundColor(ContextCompat.getColor(context, R.color.md_color_grey_300));
            else
                rootLl.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));

            leftTeamTv.setText(match.getTeamAName());
            rightTeamTv.setText(match.getTeamBName());
            scoreTv.setText(match.getFsA() + " - " + match.getFsB());
        }
    }
}
