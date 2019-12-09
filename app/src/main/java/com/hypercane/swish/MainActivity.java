package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TODO Implement a menu to switch between light and dark modes.

    ConstraintLayout mainLayout;
    TextView welcomeTextView;
    TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);
        setContentView(R.layout.activity_main);

        setStatusBarColor();
        boolean nightMode = isNightMode();
        mainLayout = findViewById(R.id.mainLayout);

        ImageButton trainingButton = findViewById(R.id.trainingButton);
        ImageButton newsButton = findViewById(R.id.newsButton);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        //Changing backgrounds for various views if app is in light mode.
        if (!nightMode) {
            changeViewColors();
        }

        trainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTrainingActivity();
            }
        });
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewsActivity();
            }
        });
    }

    private boolean isNightMode() {
        int nightModeFlags =
                getApplicationContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;

            case Configuration.UI_MODE_NIGHT_NO:
                return false;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                return true;
        }
        return true;
    }

    private void setStatusBarColor() {
        //To change the color of the status bar to match the 'Action Bar'
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#212121"));
        }
    }

    private void startTrainingActivity() {
        Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
        startActivity(intent);
    }

    private void startNewsActivity() {
        Intent intent = new Intent(MainActivity.this, TeamSelectActivity.class);
        startActivity(intent);
    }

    private void changeViewColors() {
        setStatusBarColor();
        mainLayout.setBackgroundResource(R.drawable.home_background_light);
        welcomeTextView.setBackgroundResource(0);
        welcomeTextView.setTextColor(Color.BLACK);
        descriptionTextView.setTextColor(Color.BLACK);
    }
}
