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

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Exercise extends AppCompatActivity {

    // UI Elements
    protected TextView  textView1;
    protected TextView  textView2;
    protected TextView  textView3;
    protected TextView  textView4;
    protected TextView  textView5;
    protected Button    button1;
    protected Button    button2;
    protected boolean   firstTime = true;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer myPlayer;
    AbstractYouTubePlayerListener listener;


    // Data objects
    ExerciseObject chestExercises[] = new ExerciseObject[3];
    ExerciseObject armExercises[] = new ExerciseObject[3];
    ExerciseObject legExercises[] = new ExerciseObject[3];
    ExerciseObject abExercises[]= new ExerciseObject[3];
    ExerciseObject shoulderExercises[]= new ExerciseObject[3];
    ExerciseObject backExercises[]= new ExerciseObject[3];
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
    ExerciseObject squat;
    ExerciseObject calfRaise;
    // Abs
    ExerciseObject crunches;
    ExerciseObject plank;
    ExerciseObject legRaise;
    // Shoulder
    ExerciseObject lateralRaise;
    ExerciseObject dbShrug;
    ExerciseObject dbPress;
    // Back
    ExerciseObject chinUp;
    ExerciseObject pullup;
    ExerciseObject deadlift;
    //Intent extra
    String groupSelected;

    //Keep track of exercise index within group array
    int exerciseIndex;



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
        youTubePlayerView  = findViewById(R.id.youtubePlayerView);          // Embedded YouTube Player
        getLifecycle().addObserver(youTubePlayerView);




        // Get intent extra
        // Muscle group selected by user
        Intent i = getIntent();
        groupSelected = i.getStringExtra("muscle");

        // Set up listeners
        button1.setOnClickListener(b1Listener);
        button2.setOnClickListener(b2Listener);

        // Start with first exercise in respective muscle group array
        exerciseIndex = 0;

        // Instantiate Exercise Objects
        //Chest
        benchPress      = new ExerciseObject("Chest", "Bench Press", "Bench Press Description here.", "Sets: 5", "Reps: 5", "-MAABwVKxok");
        inclinePress    = new ExerciseObject("Chest", "Incline Press", "Incline Press Description here", "Sets: 3", "Reps: 3", "0G2_XV7slIg");
        pushup          = new ExerciseObject("Chest", "Push-up", "Push-up Description here","Sets: 3", "Reps: 8","MO10KOoQx5E");
        chestExercises[0] = benchPress;
        chestExercises[1] = inclinePress;
        chestExercises[2] = pushup;
        //Arm
        bicepCurl       = new ExerciseObject("Arm", "Bicep Curl", "Bicep curl description here.", "Sets: 3", "Reps: 8","in7PaeYlhrM");
        hammerCurl      = new ExerciseObject("Arm", "Hammer Curl", "Hammer Curl description here","Sets: 3","Reps: 8", "7jqi2qWAUJk");
        tricepPushup    = new ExerciseObject("Arm", "Tricep Push-up", "Tricep Push-up description here", "Sets: 3", "Reps: 12", "kZi0j-7rDe8");
        armExercises[0] = bicepCurl;
        armExercises[1] = hammerCurl;
        armExercises[2] = tricepPushup;
        //Legs
        lunges          = new ExerciseObject("Legs", "Lunges", "Lunges description here", "Sets: 3", "Reps: 12","wrwwXE_x-pQ");
        squat           = new ExerciseObject("Legs", "Squat", "Squat description here", "Sets: 5", "Reps: 12", "aclHkVaku9U");
        calfRaise       = new ExerciseObject("Legs", "Calf Raise", "Calf Raise description here", "Sets: 5", "Reps: 20", "-M4-G8p8fmc");
        legExercises[0] = lunges;
        legExercises[1] = squat;
        legExercises[2] = calfRaise;
        //Abs
        crunches    = new ExerciseObject("Abs", "Crunches", "Crunches description here", "Sets: 5", "Reps: 20","Xyd_fa5zoEU");
        plank       = new ExerciseObject("Abs", "Plank", "Plank description here", "Sets: 3", "Reps: < 1 minute", "Ehy8G39d_PM");
        legRaise    = new ExerciseObject("Abs", "Leg Raise", "Leg Raise description here", "Sets: 3","Reps: 12", "JB2oyawG9KI");
        abExercises[0] = crunches;
        abExercises[1] = plank;
        abExercises[2] = legRaise;
        //Back
        chinUp      = new ExerciseObject("Back", "Chin-up", "Chin-up description here.", "Sets: 3", "Reps: 8","mRy9m2Q9_1I");
        pullup      = new ExerciseObject("Back", "Pullup", "Pullup description here","Sets: 3", "Reps: 8", "XB_7En-zf_M");
        deadlift    = new ExerciseObject("Back","Deadlift", "Deadlift description here", "Sets: 3", "Reps: 5","r4MzxtBKyNE");
        backExercises[0] = chinUp;
        backExercises[1] = pullup;
        backExercises[2] = deadlift;
        //Shoulder
        lateralRaise    = new ExerciseObject("Shoulder", "Lateral Raise", "Lateral raise description here", "Sets: 3", "Reps: 8","geenhiHju-o");
        dbShrug         = new ExerciseObject("Shoulder", "Dumbbell Shrug", "Dumbbell shrug description here", "Sets: 3", "Reps: 12", "g6qbq4Lf1FI");
        dbPress         = new ExerciseObject("Shoulder", "Dumbbell Press", "Dumbbell Press description here", "Sets: 3", "Reps: 12", "B-aVuyhvLHU");
        shoulderExercises[0] = lateralRaise;
        shoulderExercises[1] = dbShrug;
        shoulderExercises[2] = dbPress;


        //Update UI with exercise
        generateNewExercise(groupSelected, exerciseIndex);

    }

    public View.OnClickListener b1Listener = v -> {
        firstTime = false;
        exerciseIndex++;
        generateNewExercise(groupSelected, exerciseIndex);
    };

    public View.OnClickListener b2Listener = v -> {
        exerciseDone();
    };

    private void generateNewExercise(String muscleGroup, int exIndex){

        ExerciseObject newExercise;
        int index;

        if(exIndex > 2){
            this.exerciseIndex = 0;
            index = exerciseIndex;              // Go back to beginning of array once last exercise has been reached
        }
        else{
            index = exIndex;
        }

        // Select an exercise based on muscle group selected
        switch (muscleGroup){
            case "chest":
                newExercise = chestExercises[index];
                break;
            case "arm":
                newExercise = armExercises[index];
                break;
            case "shoulder":
                newExercise = shoulderExercises[index];
                break;
            case "back":
                newExercise = backExercises[index];
                break;
            case "legs":
                newExercise = legExercises[index];
                break;
            case "abs":
                newExercise = abExercises[index];
                break;
            default:
                newExercise = benchPress;       // if an error occurs, make the generated exercise a bench press
                Log.i("ExerciseActivity","Error in generateNewExercise method" );
        }

        // Update UI
        textView1.setText(newExercise.getMuscleGroup());
        textView2.setText(newExercise.getDescription());
        textView3.setText(newExercise.getSets());
        textView4.setText(newExercise.getReps());
        textView5.setText(newExercise.getExerciseName());

        //youTubePlayerView.removeYouTubePlayerListener();

        if(firstTime) {
            listener = new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(YouTubePlayer youTubePlayer) {
                    myPlayer = youTubePlayer;
                    String vidId = newExercise.getVideoId();
                    Log.i("onReady", "VidId is: " + vidId);
                    myPlayer.cueVideo(vidId, 0);
                }
            };
            // Update YouTube video
            youTubePlayerView.addYouTubePlayerListener(listener);
        }
        else{
            myPlayer.cueVideo(newExercise.getVideoId(),0);
        }



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
