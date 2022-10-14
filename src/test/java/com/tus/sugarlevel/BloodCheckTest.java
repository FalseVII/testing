package com.tus.sugarlevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BloodCheckTest {
    BloodCheck bloodCheck;

    //THREE VALUE BOUNDARY TESTS MEANS 3 TESTS FOR EACH BOUNDARY

    static Stream<Arguments> LegalSugarAndArrayLength() {
        return Stream.of(
                Arguments.of(true, new double[]{10, 10, 10}),//10.0 ARRAY LENGTH 3
                Arguments.of(true, new double[]{10.1, 10.1, 10.1, 10.1}),//10.1 ARRAY LENGTH 4
                Arguments.of(true, new double[]{19.9,19.9,19.9,19.9,19.9}),//19.9 ARRAY LENGTH 5
                Arguments.of(true, new double[]{20.0,20.0,20.0,20.0,20.0}),//20.0 ARRAY LENGTH 5
                Arguments.of(false, new double[]{0.0,0.0,0.0,0.0,0.0,0.0}),//0.0 ARRAY LENGTH 6
                Arguments.of(false, new double[]{0.1,0.1,0.1,0.1,0.1}),//0.1 ARRAY LENGTH 5
                Arguments.of(false, new double[]{9.8,9.8,9.8,9.8,9.8}),//9.8 ARRAY LENGTH 5
                Arguments.of(false, new double[]{9.9,9.9,9.9,9.9,9.9}) //9.9 ARRAY LENGTH 5
        );
    }

    static Stream<Arguments> IllegalSugarArrayLength() {
        return Stream.of(
                Arguments.of( new double[]{10}),//1
                Arguments.of( new double[]{10,10}),//2
                Arguments.of( new double[]{10,10,10,10,10,10,10}),//7
                Arguments.of( new double[]{10,10,10,10,10,10,10,10})//8
        );
    }

    static Stream<Arguments> IllegalSugarValues() {
        return Stream.of(
                Arguments.of( new double[]{-0.1,-0.1,-0.1}),//-0.1
                Arguments.of( new double[]{-0.2,-0.2,-0.2}),//-0.2
                Arguments.of( new double[]{20.1,20.1,20.1}),//20.1
                Arguments.of( new double[]{20.2,20.2,20.2})//20.2
        );
    }


    @BeforeEach
    void setUp() {
        bloodCheck = new BloodCheck();
    }
    //==================================================================================================
    // PART 1


    @ParameterizedTest(name="Blood Sugar {0} is {1}")
    @CsvFileSource(resources = "/sugar-data.csv")
    void checkBloodSugarLegal(double sugar, String result) {
        assertEquals(result, bloodCheck.checkBloodSugar(sugar));
    }


    @ParameterizedTest(name="Blood Sugar {0} is invalid, will throw exception.")
    @ValueSource(doubles = {-0.2,-0.1, 20.1, 20.2})
    void checkBloodSugarIllegal(double sugar) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> bloodCheck.checkBloodSugar(sugar));
        assertEquals("Invalid sugar level " + sugar + " received, should be between 0 and 20.", exception.getMessage());

    }

    //=======================================================================================================
    //PART 2

    @ParameterizedTest(name="Values {1} gives an average that means {0}, ALSO USING VALID ARRAY LENGTHS")
    @MethodSource("LegalSugarAndArrayLength")
    void checkBloodSugarForDiabetesType2Legal(boolean result, double[] sugarLevels) {
        assertEquals(result, bloodCheck.checkBloodSugarForDiabetesType2(sugarLevels));
    }


    @ParameterizedTest(name="Values {0} is invalid, will throw exception.")
    @MethodSource("IllegalSugarArrayLength")
    void checkBloodSugarForDiabetesType2Illegal(double[] sugarLevels) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> bloodCheck.checkBloodSugarForDiabetesType2(sugarLevels));
        assertEquals("Invalid number of readings " + sugarLevels.length + " received, should be between 3 and 6.", exception.getMessage());
    }

    @ParameterizedTest(name="Values {0} is invalid, will throw exception.")
    @MethodSource("IllegalSugarValues")
    void checkBloodSugarForDiabetesType2IllegalValues(double[] sugarLevels) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> bloodCheck.checkBloodSugarForDiabetesType2(sugarLevels));
        assertEquals("Invalid sugar level " + sugarLevels[0] + " received, should be between 0 and 20.", exception.getMessage());
    }
}
