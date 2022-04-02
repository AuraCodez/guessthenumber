package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediumMode extends AppCompatActivity {
    private Button btnMediumBack;
    private Button btnMediumGuess;
    private EditText txtMediumGuess;
    private TextView lblMediumResponse;
    private TextView lblMediumGuessCounter;
    private int randomNum = NumberGuessingGameModel.randomNumMedium();
    private int guessCounter = 0;

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

        btnMediumGuess = findViewById(R.id.btnMediumGuess);
        btnMediumGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterGuess();
            }
        });

        txtMediumGuess = findViewById(R.id.txtMediumGuess);
        lblMediumResponse = findViewById(R.id.lblMediumResponse);
        lblMediumGuessCounter = findViewById(R.id.lblMediumGuessCounter);

        lblMediumGuessCounter.setText("Guesses: " + guessCounter);
    }

    public void openModeSelection() {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }

    public void enterGuess() {
        if (NumberGuessingGameModel.isNumber(txtMediumGuess.getText().toString()) == false) {
            lblMediumResponse.setText("Please enter a number!");
        } else if (NumberGuessingGameModel.isWholeNumber(Double.parseDouble(txtMediumGuess.getText().toString())) == false) {
            lblMediumResponse.setText("Please enter a whole number!");
        } else if (Integer.parseInt(txtMediumGuess.getText().toString()) < 1 || Integer.parseInt(txtMediumGuess.getText().toString()) > 100) {
            lblMediumResponse.setText("Please enter a number between 1 and 100!");
        } else {
            guessCounter++;
            lblMediumGuessCounter.setText("Guesses: " + guessCounter);
            if (Integer.parseInt(txtMediumGuess.getText().toString()) == randomNum) {
                if (guessCounter == 1) {
                    lblMediumResponse.setText("Congratulations! You correctly guessed the number in just " + guessCounter + " guess!");
                } else {
                    lblMediumResponse.setText("Congratulations! You correctly guessed the number in " + guessCounter + " guesses!");
                }
                txtMediumGuess.setFocusable(false);
                btnMediumGuess.setEnabled(false);
            } else if (Integer.parseInt(txtMediumGuess.getText().toString()) < randomNum) {
                lblMediumResponse.setText("Incorrect, try a bigger number!");
            } else if (Integer.parseInt(txtMediumGuess.getText().toString()) > randomNum) {
                lblMediumResponse.setText("Incorrect, try a smaller number!");
            }
        }
    }
}