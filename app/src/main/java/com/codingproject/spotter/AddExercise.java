package com.codingproject.spotter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class AddExercise extends AppCompatActivity {
    private static final String[] Muscles = new String[]{
            "Abs", "Chest", "Arms", "Legs", "Shoulders", "Back"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        AutoCompleteTextView editText = findViewById(R.id.editTextMuscle);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Muscles);
        editText.setAdapter(adapter);
        Button submit = findViewById(R.id.addExerciseBtn);

        EditText link = findViewById(R.id.editTextLink);
        EditText reps = findViewById(R.id.editTextReps);
        EditText sets = findViewById(R.id.editTextSets);
        EditText desc = findViewById(R.id.editTextDesc);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().clear();
                link.getText().clear();
                reps.getText().clear();
                sets.getText().clear();
                desc.getText().clear();

            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    editText.showDropDown();
                }
            }
        });

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText.showDropDown();
                return false;
            }
        });
    }
}