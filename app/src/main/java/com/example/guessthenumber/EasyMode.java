package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EasyMode extends AppCompatActivity {
    private Button btnEasyBack;
    private Button btnEasyGuess;
    private EditText txtEasyGuess;
    private TextView lblEasyResponse;
    private int randomNum = NumberGuessingGameModel.randomNumEasy();
    private int guessCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode);

        btnEasyBack = findViewById(R.id.btnEasyBack);
        btnEasyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModeSelection();
            }
        });

        btnEasyGuess = findViewById(R.id.btnEasyGuess);
        btnEasyGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterGuess();
            }
        });

        txtEasyGuess = findViewById(R.id.txtEasyGuess);
        lblEasyResponse = findViewById(R.id.lblEasyResponse);
    }

    public void openModeSelection() {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }

    public void enterGuess() {
        if (NumberGuessingGameModel.isNumber(txtEasyGuess.getText().toString()) == false) {
            lblEasyResponse.setText("Please enter a whole number!");
        } else if (NumberGuessingGameModel.isWholeNumber(Double.parseDouble(txtEasyGuess.getText().toString())) == false) {
            lblEasyResponse.setText("Please enter a whole number!");
        } else if (Integer.parseInt(txtEasyGuess.getText().toString()) <= 1 || Integer.parseInt(txtEasyGuess.getText().toString()) >= 10) {
            lblEasyResponse.setText("Please enter a whole number in the range!");
        } else {
            if (Integer.parseInt(txtEasyGuess.getText().toString()) == randomNum) {
                lblEasyResponse.setText("Correct, you win!");
            } else {
                lblEasyResponse.setText("Incorrect, try again!");
            }
            guessCounter++;
        }
    }
}