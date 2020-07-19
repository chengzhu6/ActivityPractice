package com.thoughtworks.linearlayout;

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
    }


    public void createConstraintLayoutActivity(View view) {
        Intent intent = new Intent(this, ConstraintLayout.class);
        startActivity(intent);
    }
}