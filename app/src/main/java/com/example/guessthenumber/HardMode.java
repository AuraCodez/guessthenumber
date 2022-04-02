package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HardMode extends AppCompatActivity {
    private Button btnHardBack;
    private Button btnHardGuess;
    private EditText txtHardGuess;
    private TextView lblHardResponse;
    private TextView lblHardGuessCounter;
    private int randomNum = NumberGuessingGameModel.randomNumHard();
    private int guessCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mode);

        btnHardBack = findViewById(R.id.btnHardBack);
        btnHardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModeSelection();
            }
        });

        btnHardGuess = findViewById(R.id.btnHardGuess);
        btnHardGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterGuess();
            }
        });

        txtHardGuess = findViewById(R.id.txtHardGuess);
        lblHardResponse = findViewById(R.id.lblHardResponse);
        lblHardGuessCounter = findViewById(R.id.lblHardGuessCounter);

        lblHardGuessCounter.setText("Guesses: " + guessCounter);
    }

    public void openModeSelection() {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }

    public void enterGuess() {
        if (NumberGuessingGameModel.isNumber(txtHardGuess.getText().toString()) == false) {
            lblHardResponse.setText("Please enter a number!");
        } else if (NumberGuessingGameModel.isWholeNumber(Double.parseDouble(txtHardGuess.getText().toString())) == false) {
            lblHardResponse.setText("Please enter a whole number!");
        } else if (Integer.parseInt(txtHardGuess.getText().toString()) < 1 || Integer.parseInt(txtHardGuess.getText().toString()) > 1000) {
            lblHardResponse.setText("Please enter a number between 1 and 1000!");
        } else {
            guessCounter++;
            lblHardGuessCounter.setText("Guesses: " + guessCounter);
            if (Integer.parseInt(txtHardGuess.getText().toString()) == randomNum) {
                if (guessCounter == 1) {
                    lblHardResponse.setText("Congratulations! You correctly guessed the number in just " + guessCounter + " guess!");
                } else {
                    lblHardResponse.setText("Congratulations! You correctly guessed the number in " + guessCounter + " guesses!");
                }
                txtHardGuess.setFocusable(false);
                btnHardGuess.setEnabled(false);
            } else if (Integer.parseInt(txtHardGuess.getText().toString()) < randomNum) {
                lblHardResponse.setText("Incorrect, try a bigger number!");
            } else if (Integer.parseInt(txtHardGuess.getText().toString()) > randomNum) {
                lblHardResponse.setText("Incorrect, try a smaller number!");
            }
        }
    }
}