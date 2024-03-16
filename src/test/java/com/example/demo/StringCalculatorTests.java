package com.example.demo;

import com.example.demo.exceptions.NegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void whenTwoNumbersCommaDelimited_thenReturnSum() {
        // Given
        String twoSeparatedNumbersString = "1,2";
        int expected = 3;

        // When
        int result = calculator.calculate(twoSeparatedNumbersString);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenTwoNumbersNewlineDelimited_thenReturnSum() {
        // Given
        String twoSeparatedNumbersString = "1\n2";
        int expected = 3;

        // When
        int result = calculator.calculate(twoSeparatedNumbersString);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenThreeNumbersAnyDelimited_thenReturnSum() {
        // Given
        String threeNumbersString = "1,2\n3";
        int expected = 6;

        // When
        int result = calculator.calculate(threeNumbersString);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNegativeNumbers_throwAnException() {
        // Given
        String negativeNumberString = "-1, 2";

        // When + Then
        assertThrows(NegativeNumberException.class,
                () -> calculator.calculate(negativeNumberString));
    }
}
