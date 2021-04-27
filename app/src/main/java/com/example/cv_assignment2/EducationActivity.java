package com.example.cv_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import com.google.gson.Gson;

import Models.Career;
import Models.PersonalInfo;

public class EducationActivity extends AppCompatActivity {

    private EditText major;
    private EditText degree;
    private EditText year;
    private EditText school;
    private EditText company;
    private EditText job;
    private EditText fromYear;
    private EditText toYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        initialize();

    }
    public  void initialize(){
        major=findViewById(R.id.et_major);
        degree=findViewById(R.id.et_degree);
        year=findViewById(R.id.et_year);
        school=findViewById(R.id.et_school);
        company=findViewById(R.id.et_company);
        job=findViewById(R.id.et_job);
        fromYear=findViewById(R.id.et_startyear);
        toYear=findViewById(R.id.et_endyear);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();

        if(! prefs.getString("career", "").isEmpty()) {
            String str = prefs.getString("career", "");
            Career ca = gson.fromJson(str, Career.class);
            major.setText(ca.getMajor());
            degree.setText(ca.getDegree());
            year.setText(ca.getYear());
            school.setText(ca.getSchool());
            company.setText(ca.getCompany());
            job.setText(ca.getJob());
            fromYear.setText(ca.getStartYear());
            toYear.setText(ca.getEndYear());
        }

    }

    public void onclick_addEdu(View view) {
       Career career = new Career(degree.getText().toString(),major.getText().toString(),school.getText().toString(),year.getText().toString(),
               company.getText().toString(),job.getText().toString(),fromYear.getText().toString(),toYear.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String  carerString= gson.toJson(career);

        editor.putString("career", carerString);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}