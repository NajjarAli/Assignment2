package com.example.cv_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;

import Models.Career;
import Models.PersonalInfo;

public class PersonalInfoActivity extends AppCompatActivity {
    private EditText name;
    private EditText dob;
    private Spinner gender;
    private EditText email ;
    private EditText phone;
    private EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        initilize();
    }

    public void initilize(){
        name =findViewById(R.id.et_name);
        dob =findViewById(R.id.et_DOB);
        gender =findViewById(R.id.gender);
        email =findViewById(R.id.et_email);
        phone =findViewById(R.id.et_phone);
        address =findViewById(R.id.et_address);
        spinnerData();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();

        if(! prefs.getString("info", "").isEmpty()){
            String str = prefs.getString("info", "");
        PersonalInfo inf = gson.fromJson(str, PersonalInfo.class);
        name.setText(inf.getName());
        dob.setText(inf.getDOB());
        email.setText(inf.getEmail());
        phone.setText(inf.getPhone());
        address.setText(inf.getAddress());
        if(inf.getGender().equals("MALE"))
        gender.setSelection(0);
        else
            gender.setSelection(1);}
    }
    private void spinnerData(){
        ArrayList<String> data = new ArrayList<>();
        data.add("MALE");
        data.add("FEMALE");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,data);
        gender.setAdapter(adapter);
    }

    public void onclick_save(View view) {
        PersonalInfo info = new PersonalInfo(name.getText().toString(),dob.getText().toString(),gender.getSelectedItem().toString(),email.getText().toString(),
                phone.getText().toString(),address.getText().toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String  infoString= gson.toJson(info);

        editor.putString("info", infoString);
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}