package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeSelection extends AppCompatActivity {
    private Button btnBack;
    private Button btnStartEasy;
    private Button btnStartMedium;
    private Button btnStartHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });

        btnStartEasy = (Button) findViewById(R.id.btnStartEasy);
        btnStartEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEasyMode();
            }
        });

        btnStartMedium = findViewById(R.id.btnStartMedium);
        btnStartMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMediumMode();
            }
        });

        btnStartHard = findViewById(R.id.btnStartHard);
        btnStartHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHardMode();
            }
        });
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void openEasyMode() {
        Intent intent = new Intent(this, EasyMode.class);
        startActivity(intent);
    }

    public void openMediumMode() {
        Intent intent = new Intent(this, MediumMode.class);
        startActivity(intent);
    }

    public void openHardMode() {
        Intent intent = new Intent(this, HardMode.class);
        startActivity(intent);
    }
}