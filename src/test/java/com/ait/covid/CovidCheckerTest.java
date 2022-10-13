package com.ait.covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CovidCheckerTest {

    CovidChecker covidChecker;

    static Stream<Arguments> LegalBP() {
        return Stream.of(
                Arguments.of("OK", new int[]{60, 60, 60, 60, 60}),//60
                Arguments.of("OK", new int[]{61, 61, 61, 61, 61}),//61
                Arguments.of("OK", new int[]{62, 62, 62, 62, 62}),//62
                Arguments.of("OK", new int[]{72,72,72,72,72}),//74
                Arguments.of("OK", new int[]{73,73,73,73,73}),//73
                Arguments.of("OK", new int[]{74,74,74,74,74}),//74
                Arguments.of("TEST FOR COVID", new int[]{75,75,75,75,75}),//75
                Arguments.of("TEST FOR COVID", new int[]{76,76,76,76,76}),//76
                Arguments.of("TEST FOR COVID", new int[]{77,77,77,77,77}),//77
                Arguments.of("TEST FOR COVID", new int[]{88,88,88,88,88}), //88
                Arguments.of("TEST FOR COVID", new int[]{89,89,89,89,89}),//89
                Arguments.of("TEST FOR COVID", new int[]{90,90,90,90,90}) //90
        );
    }

    static Stream<Arguments> IllegalBPArray(){
        return Stream.of(
                Arguments.of(new int[]{60, 60}),
                Arguments.of(new int[]{60, 60, 60}),
                Arguments.of(new int[]{60, 60, 60, 60}),
                Arguments.of(new int[]{60, 60, 60, 60, 60, 60}),
                Arguments.of(new int[]{60, 60, 60, 60, 60, 60, 60}),
                Arguments.of(new int[]{60, 60, 60, 60, 60, 60, 60, 60})
        );
    }

    static Stream<Arguments> IllegalBP(){
        return Stream.of(
                Arguments.of(new int[]{91,91,91,91,91}),//91
                Arguments.of(new int[]{92,92,92,92,92}),//92
                Arguments.of(new int[]{93,93,93,93,93}),//93
                Arguments.of(new int[]{91,91,91,91,91}),//59
                Arguments.of(new int[]{91,91,91,91,91}),//58
                Arguments.of(new int[]{91,91,91,91,91}) //57
        );
    }

    @BeforeEach
    void setUp() {
        covidChecker = new CovidChecker();
    }

    @ParameterizedTest(name = "Temperature {0} is {1}")
    @CsvFileSource(resources = "/temp-data.csv")
    void checkTempForCovidLegal(double temp, String result) {
        assertEquals(result, covidChecker.checkTempForCovid(temp));
    }

    @ParameterizedTest(name = "Throw exception for temperature {0}")
    @ValueSource(doubles = {29.7, 29.8, 29.9, 50.1, 50.2, 50.3})
    void checkTempForCovidIllegal(double temp) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            covidChecker.checkTempForCovid(temp);
        });
        assertEquals("Temperature is out of range, should be 30-50, it is " + temp, exception.getMessage());
    }

    @ParameterizedTest(name = "Values {1} give an average that means {0}")
    @MethodSource("LegalBP")
    void checkBPForCovidLegal(String result, int[] bloodPressure) {
        assertEquals(result, covidChecker.checkBPForCovid(bloodPressure));
    }

    @ParameterizedTest(name = "Throw exception for blood pressure {0}")
    @MethodSource("IllegalBPArray")
    void checkBPForCovidIllegalArray(int[] bloodPressure) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            covidChecker.checkBPForCovid(bloodPressure);
        });
        assertEquals("Array must have 5 values, array has " + bloodPressure.length, exception.getMessage());
    }

    @ParameterizedTest(name = "Throw exception for blood pressure {0}")
    @MethodSource("IllegalBP")
    void checkBPForCovidIllegalValue(int[] bloodPressure) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            covidChecker.checkBPForCovid(bloodPressure);});
        assertEquals("Blood pressure is out of range, should be 60-90, it is " + bloodPressure[0] ,exception.getMessage());
    }
}

