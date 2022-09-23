package com.ait.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentGradeTest {

    //Equivalence partition is the range of values that are valid for a given input


    @Test
    void testGradeA() {
        assertEquals('A', StudentGrade.getGrade(85));
    }

    @Test
    void testGradeB() {
        assertEquals('B', StudentGrade.getGrade(70));
    }

    @Test
    void testGradeC() {
        assertEquals('C', StudentGrade.getGrade(55));
    }

    @Test
    void testGradeD() {
        assertEquals('D', StudentGrade.getGrade(40));
    }

    @Test
    void testGradeE() {
        assertEquals('E', StudentGrade.getGrade(25));
    }


    @Test
    void testGradeF() {
        assertEquals('F', StudentGrade.getGrade(0));
    }
}