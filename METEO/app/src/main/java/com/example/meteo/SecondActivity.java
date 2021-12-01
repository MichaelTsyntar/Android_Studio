package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private TextView descText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        descText = findViewById(R.id.desc_text);

        String desc = getIntent().getStringExtra("DESCRIPTION");

        descText.setText(desc);

    }
}