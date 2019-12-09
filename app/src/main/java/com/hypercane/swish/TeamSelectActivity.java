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

                startTeamActivity(position);
            }
        });
    }

    private void startNewsActivity(String url) {
        Intent intent = new Intent(TeamSelectActivity.this, NewsActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private void startTeamActivity(int position) {
        if (position == 0) {
            String url = "https://www.nba.com/bucks/rss.xml";
            startNewsActivity(url);
        }
        if (position == 1) {
            String url = "https://www.nba.com/bulls/rss.xml";
            startNewsActivity(url);
        }
        if (position == 2) {
            String url = "https://www.nba.com/cavaliers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 3) {
            String url = "https://www.nba.com/celtics/rss.xml";
            startNewsActivity(url);
        }
        if (position == 4) {
            String url = "https://www.nba.com/clippers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 5) {
            String url = "https://www.nba.com/grizzlies/rss.xml";
            startNewsActivity(url);
        }
        if (position == 6) {
            String url = "https://www.nba.com/hawks/rss.xml";
            startNewsActivity(url);
        }
        if (position == 7) {
            String url = "https://www.nba.com/heat/rss.xml";
            startNewsActivity(url);
        }
        if (position == 8) {
            String url = "https://www.nba.com/hornets/rss.xml";
            startNewsActivity(url);
        }
        if (position == 9) {
            String url = "https://www.nba.com/jazz/rss.xml";
            startNewsActivity(url);
        }
        if (position == 10) {
            String url = "https://www.nba.com/kings/rss.xml";
            startNewsActivity(url);
        }
        if (position == 11) {
            String url = "https://www.nba.com/knicks/rss.xml";
            startNewsActivity(url);
        }
        if (position == 12) {
            String url = "https://www.nba.com/lakers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 13) {
            String url = "https://www.nba.com/magic/rss.xml";
            startNewsActivity(url);
        }
        if (position == 14) {
            String url = "https://www.nba.com/mavericks/rss.xml";
            startNewsActivity(url);
        }
        if (position == 15) {
            String url = "https://www.nba.com/nets/rss.xml";
            startNewsActivity(url);
        }
        if (position == 16) {
            String url = "https://www.nba.com/nuggets/rss.xml";
            startNewsActivity(url);
        }
        if (position == 17) {
            String url = "https://www.nba.com/pacers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 18) {
            String url = "https://www.nba.com/pelicans/rss.xml";
            startNewsActivity(url);
        }
        if (position == 19) {
            String url = "https://www.nba.com/pistons/rss.xml";
            startNewsActivity(url);
        }
        if (position == 20) {
            String url = "https://www.nba.com/raptors/rss.xml";
            startNewsActivity(url);
        }
        if (position == 21) {
            String url = "https://www.nba.com/rockets/rss.xml";
            startNewsActivity(url);
        }
        if (position == 22) {
            String url = "https://www.nba.com/sixers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 23) {
            String url = "https://www.nba.com/spurs/rss.xml";
            startNewsActivity(url);
        }
        if (position == 24) {
            String url = "https://www.nba.com/suns/rss.xml";
            startNewsActivity(url);
        }
        if (position == 25) {
            String url = "https://www.nba.com/thunder/rss.xml";
            startNewsActivity(url);
        }
        if (position == 26) {
            String url = "https://www.nba.com/blazers/rss.xml";
            startNewsActivity(url);
        }
        if (position == 27) {
            String url = "https://www.nba.com/timberwolves/rss.xml";
            startNewsActivity(url);
        }
        if (position == 28) {
            String url = "https://www.nba.com/warriors/rss.xml";
            startNewsActivity(url);
        }
        if (position == 29) {
            String url = "https://www.nba.com/wizards/rss.xml";
            startNewsActivity(url);
        }
    }
}
