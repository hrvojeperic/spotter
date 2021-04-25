package com.codingproject.spotter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    // UI Elements
    protected TextView  textView1;
    protected TextView  textView2;
    protected TextView  textView3;
    protected TextView  textView4;
    protected TextView  textView5;
    protected Button    button1;
    protected Button    button2;
    protected ImageView imageView1;

    // Data objects
    ExerciseObject chestExercises[];
    ExerciseObject armExercises[];
    ExerciseObject legExercises[];
    ExerciseObject abExercises[];
    ExerciseObject shoulderExercises[];
    ExerciseObject backExercises[];
    // Chest
    ExerciseObject benchPress;
    ExerciseObject inclinePress;
    ExerciseObject pushup;
    // Arm
    ExerciseObject bicepCurl;
    ExerciseObject hammerCurl;
    ExerciseObject tricepPushup;
    // Legs
    ExerciseObject lunges;
    // Abs
    ExerciseObject crunches;
    // Shoulder
    ExerciseObject lateralRaise;
    // Back
    ExerciseObject chinUp;

    //Intent extra
    String groupSelected;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate layout from res folder
        setContentView(R.layout.exercise_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Bind UI elements to fields
        textView1   = (TextView) findViewById(R.id.textView1ex); // Muscle group
        textView2   = (TextView) findViewById(R.id.textView2ex); // Description
        textView3   = (TextView) findViewById(R.id.textView3ex); // Sets
        textView4   = (TextView) findViewById(R.id.textView4ex); // Reps
        textView5   = (TextView) findViewById(R.id.textView5ex); // Exercise name
        button1     = (Button) findViewById(R.id.button1ex);     // Generate
        button2     = (Button) findViewById(R.id.button2ex);     // Done
        imageView1  = (ImageView) findViewById(R.id.imageView1ex);

        // Get intent extra
        // Muscle group selected by user
        Intent i = getIntent();
        groupSelected = i.getStringExtra("muscle");

        // Set up listeners
        button1.setOnClickListener(b1Listener);
        button2.setOnClickListener(b2Listener);

        // Instantiate Exercise Objects
        benchPress  = new ExerciseObject("Chest", "Bench Press", "Bench Press Description here.", "Sets: 5", "Reps: 5");
        bicepCurl   = new ExerciseObject("Arm", "Bicep Curl", "Bicep curl description here.", "Sets: 3", "Reps: 8");
        lunges      = new ExerciseObject("Legs", "Lunges", "Lunges description here", "Sets: 3", "Reps: 12");
        crunches    = new ExerciseObject("Abs", "Crunches", "Crunches description here", "Sets: 5", "Reps: 20");
        chinUp      = new ExerciseObject("Back", "Chin up", "Chin up description here.", "Sets: 3", "Reps: 8");
        lateralRaise    = new ExerciseObject("Shoulder", "Lateral Raise", "Lateral raise description here", "Sets: 3", "Reps: 8");

        switch (groupSelected){
            case "chest":
                textView1.setText(benchPress.getMuscleGroup());
                textView2.setText(benchPress.getDescription());
                textView3.setText(benchPress.getSets());
                textView4.setText(benchPress.getReps());
                textView5.setText(benchPress.getExerciseName());
                break;
            case "arm":
                textView1.setText(bicepCurl.getMuscleGroup());
                textView2.setText(bicepCurl.getDescription());
                textView3.setText(bicepCurl.getSets());
                textView4.setText(bicepCurl.getReps());
                textView5.setText(bicepCurl.getExerciseName());
                break;
            case "shoulder":
                textView1.setText(lateralRaise.getMuscleGroup());
                textView2.setText(lateralRaise.getDescription());
                textView3.setText(lateralRaise.getSets());
                textView4.setText(lateralRaise.getReps());
                textView5.setText(lateralRaise.getExerciseName());
                break;
            case "back":
                textView1.setText(chinUp.getMuscleGroup());
                textView2.setText(chinUp.getDescription());
                textView3.setText(chinUp.getSets());
                textView4.setText(chinUp.getReps());
                textView5.setText(chinUp.getExerciseName());
                break;
            case "legs":
                textView1.setText(lunges.getMuscleGroup());
                textView2.setText(lunges.getDescription());
                textView3.setText(lunges.getSets());
                textView4.setText(lunges.getReps());
                textView5.setText(lunges.getExerciseName());
                break;
            case "abs":
                textView1.setText(crunches.getMuscleGroup());
                textView2.setText(crunches.getDescription());
                textView3.setText(crunches.getSets());
                textView4.setText(crunches.getReps());
                textView5.setText(crunches.getExerciseName());
                break;
            default:
                Log.i("ExerciseActivity", "Missing Intent Extra - Muscle group not selected");
        }

    }

    public View.OnClickListener b1Listener = v -> {
        generateNewExercise();
    };

    public View.OnClickListener b2Listener = v -> {
        exerciseDone();
    };

    private void generateNewExercise(){
        //FIXME -- add functionality
    }

    private void exerciseDone(){
        //FIXME -- add functionality
        finish();
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
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
