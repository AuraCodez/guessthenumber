package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Credits extends AppCompatActivity {
    private Button btnCreditsBack;
    private Button testbtn;
    private Button testbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        btnCreditsBack = findViewById(R.id.btnCreditsBack);
        btnCreditsBack.setOnClickListener(view -> openMainMenu());
    }
    public void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}