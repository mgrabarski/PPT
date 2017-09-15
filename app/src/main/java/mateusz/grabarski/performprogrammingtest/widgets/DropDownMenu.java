package mateusz.grabarski.performprogrammingtest.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import mateusz.grabarski.performprogrammingtest.R;

/**
 * Created by Mateusz Grabarski on 15.09.2017.
 */

public class DropDownMenu extends LinearLayout implements View.OnClickListener {

    private ImageButton mMainBtn;
    private LinearLayout optionsLl;
    private Button newsBtn, scoresBtn, standingsBtn;

    private DropDownMenuListener listener;

    public DropDownMenu(Context context) {
        super(context);
        init(context);
    }

    public DropDownMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropDownMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_drop_down_menu, this);

        if (isInEditMode()) {
            return;
        }

        initViews(view);
    }

    private void initViews(View view) {
        mMainBtn = view.findViewById(R.id.view_drop_down_menu_icon_ib);
        optionsLl = view.findViewById(R.id.view_drop_down_options_ll);
        newsBtn = view.findViewById(R.id.view_drop_down_menu_news_btn);
        scoresBtn = view.findViewById(R.id.view_drop_down_menu_scores_btn);
        standingsBtn = view.findViewById(R.id.view_drop_down_menu_standings_btn);

        mMainBtn.setOnClickListener(this);
        optionsLl.setOnClickListener(this);
        newsBtn.setOnClickListener(this);
        scoresBtn.setOnClickListener(this);
        standingsBtn.setOnClickListener(this);
    }

    public void setListener(DropDownMenuListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_drop_down_menu_icon_ib:
                showHideOptions();
                break;
            case R.id.view_drop_down_menu_news_btn:
                showHideOptions();

                if (listener != null)
                    listener.onNewsClick();
                break;
            case R.id.view_drop_down_menu_scores_btn:
                showHideOptions();

                if (listener != null)
                    listener.onScoresClick();
                break;
            case R.id.view_drop_down_menu_standings_btn:
                showHideOptions();

                if (listener != null)
                    listener.onStandingsClick();
                break;
        }
    }

    public void showHideOptions() {
        if (optionsLl.getVisibility() == GONE)
            optionsLl.setVisibility(VISIBLE);
        else
            optionsLl.setVisibility(GONE);

        refreshMenuIcon(optionsLl.getVisibility());
    }

    private void refreshMenuIcon(int visibility) {
        switch (visibility) {
            case VISIBLE:
                mMainBtn.setImageResource(R.drawable.ic_arrow_drop_up_white);
                break;
            case GONE:
                mMainBtn.setImageResource(R.drawable.ic_arrow_drop_down_white);
                break;
        }
    }

    public interface DropDownMenuListener {
        void onNewsClick();
        void onScoresClick();
        void onStandingsClick();
    }
}
