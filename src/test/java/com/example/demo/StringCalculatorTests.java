package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTests {
    private StringCalculator calculator;

    @BeforeEach
    public void setUp() { calculator = new StringCalculator(); }

    @Test
    public void whenEmptyString_thenReturnZero() {
        // Given
        String emptyString = "";
        int expected = 0;

        // When
        int result = calculator.calculate(emptyString);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenSingleNumber_thenReturnValue() {
        // Given
        String singleNumberString = "5";
        int expected = 5;

        // When
        int result = calculator.calculate(singleNumberString);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
