package com.ait.Sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GradeCalculatorTest {
    private GradeCalculator gradeCalculator;
    @BeforeEach
    public void setUp() {
        gradeCalculator= new GradeCalculator();
    }

    static Stream<Arguments> marksOutOfRange(){
        return Stream.of(
                Arguments.of(-2,new int[] {3,3,-2,3,3}),//-2
                Arguments.of(-1,new int[] {3,3,-1,3,3}),//-1
                Arguments.of(21,new int[] {3,3,6,3,21}),//21
                Arguments.of(22,new int[] {3,3,22,3,3})//22
        );
    }

    @ParameterizedTest(name="Marks has out of range value = {0}")
    @MethodSource("marksOutOfRange")
    void testMarksOutOfRangeValues(int outOfRange,int[] marks) {
        Throwable exception=assertThrows(IllegalArgumentException.class,()->{gradeCalculator.calculateTotalMarks(marks);});
        assertEquals("Invalid mark " + outOfRange + " received",exception.getMessage());
    }

}
