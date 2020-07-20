package com.thoughtworks.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createConstraintLayoutActivity(view);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLoginActivity(view);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createSelectContactActivity(view);
            }
        });
    }

    public void createConstraintLayoutActivity(View view) {
        Intent intent = new Intent(this, ConstraintLayout.class);
        startActivity(intent);
    }

    public void createLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void createSelectContactActivity(View view) {
        Intent intent = new Intent(this, SelectContactActivity.class);
        startActivity(intent);
    }
}