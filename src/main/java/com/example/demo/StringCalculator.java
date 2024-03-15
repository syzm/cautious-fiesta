package com.example.demo;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split("[,\n]");

        int sum = 0;
        try {
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim());
            }
            return sum;
        } catch (NumberFormatException e) {
            // Handle
        }

        return 0;
    }
}
