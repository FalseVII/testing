package com.ait.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void normalLeapYearIsLeap() {
        assertTrue(DateUtils.isLeapYear(1992));
    }

    @Test
    void normalLeapYearIsLeap2() {
        assertTrue(DateUtils.isLeapYear(1996));
    }

    @Test
    void notLeapYear(){
        assertFalse(DateUtils.isLeapYear(1991));
    }

    @Test
    void centuryLeapYear(){
        assertFalse(DateUtils.isLeapYear(1900));
    }

    @Test
    void year2000IsLeap(){
        assertTrue(DateUtils.isLeapYear(2000));
    }
}