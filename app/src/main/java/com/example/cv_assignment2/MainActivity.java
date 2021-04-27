package com.example.cv_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick_info(View view) {
        Intent intent = new Intent(this, PersonalInfoActivity.class);
        startActivity(intent);
    }


    public void onclick_hobbies(View view) {
        Intent intent = new Intent(this, hobbiesActivity.class);
        startActivity(intent);
    }

    public void onclick_edu(View view) {
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }


}