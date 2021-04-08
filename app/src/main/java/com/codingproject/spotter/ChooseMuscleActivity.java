package com.codingproject.spotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class ChooseMuscleActivity extends AppCompatActivity {

    // declare class variables
    CardView chestCard;
    CardView armCard;
    CardView shoulderCard;
    CardView backCard;
    CardView legsCard;
    CardView absCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_muscle);

        // get gui element
        chestCard = findViewById(R.id.chestCard);
        armCard = findViewById(R.id.armCard);
        shoulderCard = findViewById(R.id.shoulderCard);
        backCard = findViewById(R.id.backCard);
        legsCard = findViewById(R.id.legsCard);
        absCard = findViewById(R.id.absCard);

        // chest card handler
        chestCard.setOnClickListener(v -> {
            // start chest exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "chest");
            startActivity(i);
        });

        // arm card handler
        armCard.setOnClickListener(v -> {
            // start arm exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "arm");
            startActivity(i);
        });

        // shoulder card handler
        shoulderCard.setOnClickListener(v -> {
            // start shoulder exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "shoulder");
            startActivity(i);
        });

        // back card handler
        backCard.setOnClickListener(v -> {
            // start back exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "back");
            startActivity(i);
        });

        // legs card handler
        legsCard.setOnClickListener(v -> {
            // start legs exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "legs");
            startActivity(i);
        });

        // abs card handler
        absCard.setOnClickListener(v -> {
            // start abs exercise activity
            Intent i = new Intent(this, Exercise.class);
            i.putExtra("muscle", "abs");
            startActivity(i);
        });
    }
}