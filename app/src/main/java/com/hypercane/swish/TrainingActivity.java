package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class TrainingActivity extends AppCompatActivity {

    boolean nightMode;
    ImageView trainingLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        trainingLogo = findViewById(R.id.trainingLogo);
        nightMode = isNightMode();
        if (!nightMode) {
            setStatusBarColor();
            trainingLogo.setImageResource(R.drawable.training_logo_light);
        }
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
            window.setStatusBarColor(Color.WHITE);
        }
    }
}
