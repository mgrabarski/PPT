package mateusz.grabarski.performprogrammingtest.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mateusz.grabarski.performprogrammingtest.R;

public class NewsDetailsActivity extends AppCompatActivity {

    public static final String NEWS_URL = "news_url";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        webView = (WebView) findViewById(R.id.activity_news_details_wv);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getIntent().getExtras().getString(NEWS_URL));
    }
}
