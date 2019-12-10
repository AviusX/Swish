package com.hypercane.swish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        ImageButton routineButton = findViewById(R.id.trainingRoutineBtn);
        ImageButton notesButton = findViewById(R.id.addNotesBtn);

        routineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityTraining();
            }
        });
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityTraining();
            }
        });
    }

    private void startActivityTraining() {
        Intent intent = new Intent(TrainingActivity.this, RoutineActivity.class);
        startActivity(intent);
    }
}
