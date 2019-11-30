package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton trainingButton = findViewById(R.id.trainingButton);
        ImageButton newsButton = findViewById(R.id.newsButton);

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

    private void startTrainingActivity() {
        Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
        startActivity(intent);
    }

    private void startNewsActivity() {
        Intent intent = new Intent(MainActivity.this, TeamSelectActivity.class);
        startActivity(intent);
    }
}
