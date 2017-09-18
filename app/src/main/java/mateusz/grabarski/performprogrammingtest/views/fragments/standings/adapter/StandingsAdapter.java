package mateusz.grabarski.performprogrammingtest.views.fragments.standings.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        holder.populate(rankings.get(position), position);
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout rootLl;
        private TextView lpTv, clubNameTv, totalMatchesTv, wonMatchesTv,
                lostMatchesTv, drawMatchesTv, goalsProTv, pointsTv;
        private ImageView previousRankIv;

        public ViewHolder(View itemView) {
            super(itemView);

            rootLl = itemView.findViewById(R.id.item_standings_root);
            lpTv = itemView.findViewById(R.id.item_standings_lp_tv);
            clubNameTv = itemView.findViewById(R.id.item_standings_club_name_tv);
            totalMatchesTv = itemView.findViewById(R.id.item_standings_total_matches_tv);
            wonMatchesTv = itemView.findViewById(R.id.item_standings_won_matches_tv);
            lostMatchesTv = itemView.findViewById(R.id.item_standings_lost_matches_tv);
            drawMatchesTv = itemView.findViewById(R.id.item_standings_draw_matches_tv);
            goalsProTv = itemView.findViewById(R.id.item_standings_goals_pro_tv);
            pointsTv = itemView.findViewById(R.id.item_standings_points_tv);
            previousRankIv = itemView.findViewById(R.id.item_standings_last_rank_iv);
        }

        public void populate(Ranking ranking, int position) {
            if (position % 2 == 0)
                rootLl.setBackgroundColor(ContextCompat.getColor(context, R.color.md_color_grey_300));
            else
                rootLl.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));

            lpTv.setText(String.format("%02d", ranking.getRank()));
            clubNameTv.setText(String.valueOf(ranking.getClubName()));
            totalMatchesTv.setText(String.valueOf(ranking.getMatchesTotal()));
            wonMatchesTv.setText(String.valueOf(ranking.getMatchesWon()));
            lostMatchesTv.setText(String.valueOf(ranking.getMatchesLost()));
            drawMatchesTv.setText(String.valueOf(ranking.getMatchesDraw()));
            goalsProTv.setText(String.valueOf(ranking.getGoalsPro()));
            pointsTv.setText(String.valueOf(ranking.getPoints()));

            if (ranking.getRank() < ranking.getLastRank())
                previousRankIv.setImageResource(R.drawable.ic_arrow_upward);
            else if (ranking.getRank() > ranking.getLastRank())
                previousRankIv.setImageResource(R.drawable.ic_arrow_downward);
            else
                previousRankIv.setImageResource(android.R.color.transparent);
        }
    }
}
