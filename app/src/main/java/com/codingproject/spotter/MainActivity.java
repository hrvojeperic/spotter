package com.codingproject.spotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare class variables
    Button startExerciseButton;
    Button restDayButton;
    Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get gui element
        startExerciseButton = findViewById(R.id.startExerciseButton);
        restDayButton = findViewById(R.id.restDayButton);
        calendarButton = findViewById(R.id.calendarButton);

        // start exercise handler
        startExerciseButton.setOnClickListener(v -> {
            // start choose muscle group activity
            Intent chooseMuscleIntent = new Intent(this, ChooseMuscleActivity.class);
            startActivity(chooseMuscleIntent);
        });

        // rest day handler
        restDayButton.setOnClickListener(v -> {
            Toast.makeText(this, "Rest Day Chosen!", Toast.LENGTH_LONG).show();
        });

        // calendar handler
        calendarButton.setOnClickListener(v -> {

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // set up menu
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.expandable_add_exercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addExerciseItem:
                // TODO: START EXERCISE INTENT HERE
                Intent addExerciseIntent = new Intent(this, AddExercise.class);
                startActivity(addExerciseIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}