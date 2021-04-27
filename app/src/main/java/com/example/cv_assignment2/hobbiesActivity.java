package com.example.cv_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;

import com.google.gson.Gson;

import Models.Career;
import Models.Hobbies;

public class hobbiesActivity extends AppCompatActivity {
    CheckBox sports;
    CheckBox music;
    CheckBox travelling;
    CheckBox reading;
    CheckBox videoGames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        initialize();
    }

    public  void initialize() {
        sports = findViewById(R.id.checkBox_sports);
        music = findViewById(R.id.checkBox_music);
        travelling = findViewById(R.id.checkBox_travelling);
        reading = findViewById(R.id.checkBox_reading);
        videoGames = findViewById(R.id.checkBox_videoGames);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();

        if (!prefs.getString("hobie", "").isEmpty()) {
            String str = prefs.getString("hobie", "");
            Hobbies ho = gson.fromJson(str, Hobbies.class);
            music.setChecked(ho.isMusic());
            travelling.setChecked(ho.isTravelling());
            reading.setChecked(ho.isReading());
            sports.setChecked(ho.isSports());
            videoGames.setChecked(ho.isVideoGames());
        }
    }
    public void onclick_addHobbies(View view) {
        Hobbies career = new Hobbies(music.isChecked(),sports.isChecked(),travelling.isChecked(),reading.isChecked(),videoGames.isChecked());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String  HobieString= gson.toJson(career);

        editor.putString("hobie", HobieString);
        editor.commit();


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}