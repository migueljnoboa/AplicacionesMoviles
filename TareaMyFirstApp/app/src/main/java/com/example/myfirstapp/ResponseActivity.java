package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity {

    TextView textResponse1;
    TextView textResponse2;
    TextView textResponse3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        Intent intent = getIntent();
        textResponse1 = findViewById(R.id.textResponse1);
        textResponse2 = findViewById(R.id.textResponse2);
        textResponse3 = findViewById(R.id.textResponse3);

        String response1 = intent.getStringExtra(MainActivity.RESPONSE1);
        String response2 = intent.getStringExtra(MainActivity.RESPONSE2);
        String response3 = intent.getStringExtra(MainActivity.RESPONSE3);

        textResponse1.setText(response1);
        textResponse2.setText(response2);
        textResponse3.setText(response3);
    }
}