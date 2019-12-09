package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class NewsActivity extends AppCompatActivity {
    private static final String TAG = "NewsActivity";

    ListView newsListView;
    ProgressBar newsProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //To change the color of the status bar to match with the custom 'Action Bar'.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2B2323"));
        }

        newsListView = findViewById(R.id.newsListView);
        newsProgressBar = findViewById(R.id.newsProgressBar);
        String url = getIntent().getStringExtra("url");
        Log.d(TAG, "onCreate: in with url:" + url);

        DownloadData downloadData = new DownloadData();
        downloadData.execute(url);
    }

    private class DownloadData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ParseNews parseNews = new ParseNews();
            parseNews.parse(s);
            newsProgressBar.setVisibility(View.GONE);

            NewsAdapter newsAdapter = new NewsAdapter(NewsActivity.this,
                    R.layout.news_article_list, parseNews.getNewsArticles());
            newsListView.setAdapter(newsAdapter);
        }
        @Override
        protected String doInBackground(String... strings) {

            String rssFeed = downloadXML(strings[0]);
            if (rssFeed == null) {
                Log.e(TAG, "doInBackground: Error downloading.");
            }
            return rssFeed;
        }

        private String downloadXML(String url) {

            StringBuilder xmlResult = new StringBuilder();

            try {
                URL xmlURL = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) xmlURL.openConnection();
                int response = connection.getResponseCode();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                int charsRead;
                char[] inputBuffer = new char[500];
                while (true) {
                    charsRead = reader.read(inputBuffer);
                    if (charsRead < 0) {
                        break;
                    }

                    if (charsRead > 0) {
                        xmlResult.append(String.copyValueOf(inputBuffer, 0, charsRead));
                    }
                }
                reader.close();
                return xmlResult.toString();
            } catch (MalformedURLException e) {
                Log.e(TAG, "downloadXML: Invalid URL" + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "downloadXML: IOException Reading data" + e.getMessage());
            } catch (SecurityException e) {
                Log.e(TAG, "downloadXML: Security Exception. Missing Permission?" + e.getMessage());
            }
            return null;
        }
    }
}
