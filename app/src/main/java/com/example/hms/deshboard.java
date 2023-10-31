package com.example.hms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class deshboard extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshboard);

        mAuth = FirebaseAuth.getInstance();

    }
    public void studentRegistration(View view) {
        // Add the code to open another screen here, for example, start a new activity
        Intent intent = new Intent(this, student_registration.class);
        startActivity(intent);
    }
    public void logOut(View view) {
        // Add the code to open another screen here, for example, start a new activity
        mAuth.signOut();
        Intent logOut = new Intent(this, LoginActivity.class);
        logOut.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logOut);
    }
    public void studentList(View view) {
        // Add the code to open another screen here, for example, start a new activity
        Intent studentList = new Intent(this, MainActivity.class);
        startActivity(studentList);
    }
}