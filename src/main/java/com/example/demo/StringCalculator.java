package com.example.demo;

import com.example.demo.exceptions.NegativeNumberException;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return Arrays.stream(input.split("\\r?\\n|,"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .peek(number -> {
                    if (number < 0) {
                        throw new NegativeNumberException("Negative numbers not allowed: " + number);
                    }
                })
                .sum();
    }
}
