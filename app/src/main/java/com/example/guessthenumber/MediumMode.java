package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediumMode extends AppCompatActivity {
    private Button btnMediumBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_mode);

        btnMediumBack = findViewById(R.id.btnMediumBack);
        btnMediumBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModeSelection();
            }
        });
    }

    public void openModeSelection() {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }
}