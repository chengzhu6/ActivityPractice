package com.thoughtworks.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        System.out.println("Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop");
    }
}