package com.codingproject.spotter;

import java.net.URL;

public class ExerciseObject {

    private String muscleGroup;
    private String exerciseName;
    private String description;
    private String sets;
    private String reps;
    private String  videoId;


    // Getters
    public String getMuscleGroup() {
        return muscleGroup;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public String getSets() {
        return sets;
    }

    public String getReps() {
        return reps;
    }

    public String getVideoId() {
        return videoId;
    }

    // Setters
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public void setVideoId(String videoUrl) {
        this.videoId = videoUrl;
    }

    // Constructor
    public ExerciseObject(String muscleGroup,String exerciseName, String description, String sets, String reps, String videoId){
        this.muscleGroup = muscleGroup;
        this.exerciseName = exerciseName;
        this.description = description;
        this.sets = sets;
        this.reps = reps;
        this.videoId = videoId;
    }

}
