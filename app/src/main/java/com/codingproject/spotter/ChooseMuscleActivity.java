package com.codingproject.spotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
            // TODO: Start chest exercise activity
        });

        // arm card handler
        armCard.setOnClickListener(v -> {
            // TODO: Start arm exercise activity
        });

        // shoulder card handler
        shoulderCard.setOnClickListener(v -> {
            // TODO: Start shoulder exercise activity
        });

        // back card handler
        backCard.setOnClickListener(v -> {
            // TODO: Start back exercise activity
        });

        // legs card handler
        legsCard.setOnClickListener(v -> {
            // TODO: Start legs exercise activity
        });

        // abs card handler
        absCard.setOnClickListener(v -> {
            // TODO: Start abs exercise activity
        });
    }
}