package mateusz.grabarski.performprogrammingtest.views.fragments.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import mateusz.grabarski.businesslogiclayer.models.news.Item;
import mateusz.grabarski.performprogrammingtest.R;
import mateusz.grabarski.performprogrammingtest.utils.DateUtils;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public NewsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.populate(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoIv;
        private TextView titleTv, dateTv;
        private ProgressBar progressBar;
        private LinearLayout rootLl;

        public ViewHolder(View itemView) {
            super(itemView);

            rootLl = itemView.findViewById(R.id.item_news_root_ll);
            photoIv = itemView.findViewById(R.id.item_news_iv);
            progressBar = itemView.findViewById(R.id.item_news_pb);
            titleTv = itemView.findViewById(R.id.item_news_title_tv);
            dateTv = itemView.findViewById(R.id.item_news_date_tv);
        }

        public void populate(Item item) {
            titleTv.setText(item.getTitle());
            dateTv.setText(DateUtils.newsDateFormat().format(new Date()));

            Picasso.with(context).load(item.getEnclosure().getUrl()).fit().into(photoIv, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    progressBar.setVisibility(View.GONE);
                    photoIv.setImageResource(R.mipmap.ic_launcher);
                }
            });
        }
    }
}
