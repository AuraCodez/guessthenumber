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
    private TextView lblEasyGuessCounter;
    private int randomNum = NumberGuessingGameModel.randomNumEasy();
    private int guessCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode);

        btnEasyBack = findViewById(R.id.btnEasyBack);
        btnEasyBack.setOnClickListener(view -> openModeSelection());

        btnEasyGuess = findViewById(R.id.btnEasyGuess);
        btnEasyGuess.setOnClickListener(view -> enterGuess());

        txtEasyGuess = findViewById(R.id.txtEasyGuess);
        lblEasyResponse = findViewById(R.id.lblEasyResponse);
        lblEasyGuessCounter = findViewById(R.id.lblEasyGuessCounter);

        lblEasyGuessCounter.setText("Guesses: " + guessCounter);
    }

    public void openModeSelection() {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }

    public void enterGuess() {
        if (NumberGuessingGameModel.isNumber(txtEasyGuess.getText().toString()) == false) {
            lblEasyResponse.setText("Please enter a number!");
        } else if (NumberGuessingGameModel.isWholeNumber(Double.parseDouble(txtEasyGuess.getText().toString())) == false) {
            lblEasyResponse.setText("Please enter a whole number!");
        } else if (Integer.parseInt(txtEasyGuess.getText().toString()) < 1 || Integer.parseInt(txtEasyGuess.getText().toString()) > 10) {
            lblEasyResponse.setText("Please enter a number between 1 and 10!");
        } else {
            guessCounter++;
            lblEasyGuessCounter.setText("Guesses: " + guessCounter);
            if (Integer.parseInt(txtEasyGuess.getText().toString()) == randomNum) {
                if (guessCounter == 1) {
                    lblEasyResponse.setText("Congratulations! You correctly guessed the number in just " + guessCounter + " guess!");
                } else {
                    lblEasyResponse.setText("Congratulations! You correctly guessed the number in " + guessCounter + " guesses!");
                }
                txtEasyGuess.setFocusable(false);
                btnEasyGuess.setEnabled(false);
            } else if (Integer.parseInt(txtEasyGuess.getText().toString()) < randomNum) {
                lblEasyResponse.setText("Incorrect, try a bigger number!");
            } else if (Integer.parseInt(txtEasyGuess.getText().toString()) > randomNum) {
                lblEasyResponse.setText("Incorrect, try a smaller number!");
            }
        }
    }
}