package com.codingproject.spotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare class variables
    LinearLayout startExerciseButton;
    LinearLayout restDayButton;
    LinearLayout calendarButton;
    LinearLayout addExerciseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get gui element
        startExerciseButton = findViewById(R.id.startExerciseButton);
        restDayButton = findViewById(R.id.restDayButton);
        calendarButton = findViewById(R.id.calendarButton);
        addExerciseButton = findViewById(R.id.addExerciseButton);

        // start exercise handler
        startExerciseButton.setOnClickListener(v -> {
            // start choose muscle group activity
            Intent chooseMuscleIntent = new Intent(this, ChooseMuscleActivity.class);
            startActivity(chooseMuscleIntent);
        });

        addExerciseButton.setOnClickListener(v -> {
            // start add exercise activity
            Intent addExerciseIntent = new Intent(this, AddExercise.class);
            startActivity(addExerciseIntent);
        });

        // rest day handler
        restDayButton.setOnClickListener(v -> {
            Toast.makeText(this, "Rest Day Chosen!", Toast.LENGTH_LONG).show();
        });

        // calendar handler
        calendarButton.setOnClickListener(v -> {
            long startMillis = System.currentTimeMillis();
            Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
            builder.appendPath("time");
            ContentUris.appendId(builder, startMillis);
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(builder.build());
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // set up menu
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.faqItem:
                Intent faqIntent = new Intent(this, FaqActivity.class);
                startActivity(faqIntent);
                break;
            case R.id.homeItem:
                // do nothing
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}