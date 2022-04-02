package com.example.guessthenumber;

import java.lang.Math;

public class NumberGuessingGameModel {
    public static int randomNumEasy() {
        return (int) (Math.random() * 10) + 1;
    }

    public static int randomNumMedium() {
        return (int) (Math.random() * 100) + 1;
    }

    public static int randomNumHard() {
        return (int) (Math.random() * 1000) + 1;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isWholeNumber(double num) {
        if ((int) num == num) {
            return true;
        } else {
            return false;
        }
    }
}
