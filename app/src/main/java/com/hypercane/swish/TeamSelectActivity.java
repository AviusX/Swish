package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class TeamSelectActivity extends AppCompatActivity {
    private static final String TAG = "TeamSelectActivity";

    String teamName[];
    int images[] = {R.drawable.bucks, R.drawable.bulls, R.drawable.cavaliers, R.drawable.celtics,
            R.drawable.clippers, R.drawable.grizzlies, R.drawable.hawks, R.drawable.heat,
            R.drawable.hornets, R.drawable.jazz, R.drawable.kings, R.drawable.knicks,
            R.drawable.lakers, R.drawable.magic, R.drawable.mavericks,
            R.drawable.nets, R.drawable.nuggets, R.drawable.pacers, R.drawable.pelicans,
            R.drawable.pistons, R.drawable.raptors, R.drawable.rockets, R.drawable.sixers,
            R.drawable.spurs, R.drawable.suns, R.drawable.thunder, R.drawable.blazers,
            R.drawable.timberwolves, R.drawable.warriors, R.drawable.wizards};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        //To change the color of the status bar to match the 'Action Bar'
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2B2323"));
        }

        teamName = getResources().getStringArray(R.array.team_names);
        ListView teamList = findViewById(R.id.teamListView);
        TeamAdapter teamAdapter = new TeamAdapter(TeamSelectActivity.this,
                R.layout.team_select_list, teamName, images);
        teamList.setAdapter(teamAdapter);

        teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO: Implement URLs for all positions.
                if (position == 0) {
                    String url = null;
                    startNewsActivity("https://www.nba.com/bucks/rss.xml");
                }
            }
        });
    }

    private void startNewsActivity(String url) {
        Intent intent = new Intent(TeamSelectActivity.this, NewsActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
