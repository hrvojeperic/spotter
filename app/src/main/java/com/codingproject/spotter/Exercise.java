package com.codingproject.spotter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise extends AppCompatActivity {

    // UI Elements
    protected TextView  textView1;
    protected TextView  textView2;
    protected TextView  textView3;
    protected TextView  textView4;
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
    // Leg
    ExerciseObject lunges;
    // Ab
    ExerciseObject crunches;
    // Shoulder
    ExerciseObject lateralRaise;
    // Back
    ExerciseObject chinUp;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate layout from res folder
        setContentView(R.layout.exercise_layout);

        // Bind UI elements to fields
        textView1   = (TextView) findViewById(R.id.textView1);
        textView2   = (TextView) findViewById(R.id.textView2);
        textView3   = (TextView) findViewById(R.id.textView3);
        textView4   = (TextView) findViewById(R.id.textView4);
        button1     = (Button) findViewById(R.id.button1);
        button2     = (Button) findViewById(R.id.button2);
        imageView1  = (ImageView) findViewById(R.id.imageView1);


        // Set up listeners
        button1.setOnClickListener(b1Listener);
        button1.setOnClickListener(b2Listener);

        // Instantiate Exercise Objects
        //benchPress = new ExerciseObject("Chest", "Bench Press", "Bench Press Description here.", "Sets: 5", "Reps: 5", "https://www.youtube.com/watch?v=-MAABwVKxok&ab_channel=MindPumpTV");

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
}
