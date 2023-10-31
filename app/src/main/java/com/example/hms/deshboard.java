package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class deshboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshboard);
    }
    public void studentRegistration(View view) {
        // Add the code to open another screen here, for example, start a new activity
        Intent intent = new Intent(this, student_registration.class);
        startActivity(intent);
    }

}