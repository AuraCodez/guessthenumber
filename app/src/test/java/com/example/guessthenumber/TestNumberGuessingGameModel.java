package com.example.guessthenumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumberGuessingGameModel {

    /*
     * Test cases for isNumber
     */
    @Test
    public void test_isNumber_01() {
        String input = "12";
        Boolean result = NumberGuessingGameModel.isNumber(input);
        assertTrue(result);
    }

    @Test
    public void test_isNumber_02() {
        String input = "hello";
        Boolean result = NumberGuessingGameModel.isNumber(input);
        assertFalse(result);
    }

    @Test
    public void test_isNumber_03() {
        String input = "3.14";
        Boolean result = NumberGuessingGameModel.isNumber(input);
        assertTrue(result);
    }

    /*
     * Test cases for isWholeNumber
     */
    @Test
    public void test_isWholeNumber_01() {
        double input = 2.71;
        Boolean result = NumberGuessingGameModel.isWholeNumber(input);
        assertFalse(result);
    }

    @Test
    public void test_isWholeNumber_02() {
        double input = 7;
        Boolean result = NumberGuessingGameModel.isWholeNumber(input);
        assertTrue(result);
    }

    /*
     * Test case for randomNumEasy
     */
    @Test
    public void test_randomNumEasy() {
        int randomNum = NumberGuessingGameModel.randomNumEasy();
        assertTrue(randomNum >= 1 && randomNum <= 10);
    }

    /*
     * Test case for randomNumMedium
     */
    @Test
    public void test_randomNumMedium() {
        int randomNum = NumberGuessingGameModel.randomNumMedium();
        assertTrue(randomNum >= 1 && randomNum <= 100);
    }

    /*
     * Test case for randomNumHard
     */
    @Test
    public void test_randomNumHard() {
        int randomNum = NumberGuessingGameModel.randomNumHard();
        assertTrue(randomNum >= 1 && randomNum <= 1000);
    }
}
