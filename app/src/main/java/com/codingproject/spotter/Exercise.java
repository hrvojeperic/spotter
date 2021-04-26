package com.codingproject.spotter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.provider.CalendarContract;
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

import java.util.Calendar;

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

    ExerciseObject newExercise;

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
        benchPress      = new ExerciseObject("Chest", "Bench Press", "Lay your back on the bench. Push barbell away from chest.", "Sets: 5", "Reps: 5", "-MAABwVKxok");
        inclinePress    = new ExerciseObject("Chest", "Incline Press", "Lay on bench at inclined angle. Push barbell away from chest.", "Sets: 3", "Reps: 3", "0G2_XV7slIg");
        pushup          = new ExerciseObject("Chest", "Push-up", "Raise & lower body by pushing away from the ground.","Sets: 3", "Reps: 8","MO10KOoQx5E");
        chestExercises[0] = benchPress;
        chestExercises[1] = inclinePress;
        chestExercises[2] = pushup;
        //Arm
        bicepCurl       = new ExerciseObject("Arm", "Bicep Curl", "Dumbbells in each hand with arms at sides. Raise dumbbell by bending at the elbow.", "Sets: 3", "Reps: 8","in7PaeYlhrM");
        hammerCurl      = new ExerciseObject("Arm", "Hammer Curl", "Dumbbells in each hand with arms at sides. Raise dumbbell by bending the elbow.","Sets: 3","Reps: 8", "7jqi2qWAUJk");
        tricepPushup    = new ExerciseObject("Arm", "Tricep Push-up", "Place hands on floor & beneath chest. Raise & lower body by pushing away from the ground.", "Sets: 3", "Reps: 12", "kZi0j-7rDe8");
        armExercises[0] = bicepCurl;
        armExercises[1] = hammerCurl;
        armExercises[2] = tricepPushup;
        //Legs
        lunges          = new ExerciseObject("Legs", "Lunges", "Place one leg in a few steps in front of you, then bend down until knee if barely off ground. Repeat for other leg" , "Sets: 3", "Reps: 12","wrwwXE_x-pQ");
        squat           = new ExerciseObject("Legs", "Squat", "Place bar behind neck, then bend down while having a straight back. Drive up through legs while lifting weight.", "Sets: 5", "Reps: 12", "aclHkVaku9U");
        calfRaise       = new ExerciseObject("Legs", "Calf Raise", "Place top of you feet on a ledge. Then, dip down as far as possible, then drive up your feet while contracting calves.","Sets: 5", "Reps: 20", "-M4-G8p8fmc");
        legExercises[0] = lunges;
        legExercises[1] = squat;
        legExercises[2] = calfRaise;
        //Abs
        crunches    = new ExerciseObject("Abs", "Crunches", "Lay flat on back with knees bent. Contract abs until you reach your knees.", "Sets: 5", "Reps: 20","Xyd_fa5zoEU");
        plank       = new ExerciseObject("Abs", "Plank", "Lay flat on stomach then lift body up with only forearms and feet.", "Sets: 3", "Reps: < 1 minute", "Ehy8G39d_PM");
        legRaise    = new ExerciseObject("Abs", "Leg Raise", "Lay flat on back. Lift legs up and down while contracting abs.", "Sets: 3","Reps: 12", "JB2oyawG9KI");
        abExercises[0] = crunches;
        abExercises[1] = plank;
        abExercises[2] = legRaise;
        //Back
        chinUp      = new ExerciseObject("Back", "Chin-up", "Hang from bar with palms facing you. Then, lift you body until chin reaches bar.", "Sets: 3", "Reps: 8","mRy9m2Q9_1I");
        pullup      = new ExerciseObject("Back", "Pullup", "Hang from bar with palms facing away. Lift you body until chin reaches bar.","Sets: 3", "Reps: 8", "XB_7En-zf_M");
        deadlift    = new ExerciseObject("Back","Deadlift", "Start in squat position with back straight. Lift bar by driving up through legs.", "Sets: 3", "Reps: 5","r4MzxtBKyNE");
        backExercises[0] = chinUp;
        backExercises[1] = pullup;
        backExercises[2] = deadlift;
        //Shoulder
        lateralRaise    = new ExerciseObject("Shoulder", "Lateral Raise", "Stand with dumbbells in each hand and arms at side. Raise arms laterally.", "Sets: 3", "Reps: 8","geenhiHju-o");
        dbShrug         = new ExerciseObject("Shoulder", "Dumbbell Shrug", "Stand with dumbbells in each hand and arms at side. Raise shoulders up and down.", "Sets: 3", "Reps: 12", "g6qbq4Lf1FI");
        dbPress         = new ExerciseObject("Shoulder", "Dumbbell Press", "Lay on bench at inclined angle. Push dumbbell away from chest.", "Sets: 3", "Reps: 12", "B-aVuyhvLHU");
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
        long myTime = System.currentTimeMillis()-60000;
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, myTime)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, myTime)
                .putExtra(CalendarContract.Events.TITLE, groupSelected)
                .putExtra(CalendarContract.Events.DESCRIPTION, "WOO DID EXERCISE!!")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "N/A");
        startActivity(intent);
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
