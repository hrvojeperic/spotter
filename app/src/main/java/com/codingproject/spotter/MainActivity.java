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

public class MainActivity extends AppCompatActivity {

    // declare class variables
    Button startExerciseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get gui element
        startExerciseButton = findViewById(R.id.startExerciseButton);

        // start exercise handler
        startExerciseButton.setOnClickListener(v -> {
            // start choose muscle group activity
            Intent chooseMuscleIntent = new Intent(this, ChooseMuscleActivity.class);
            startActivity(chooseMuscleIntent);
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
        }
        return super.onOptionsItemSelected(item);
    }
}