package com.ait.carpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarParkFeeTest {
    public CarParkFee car;

    @BeforeEach
    void setUp() {
        car = new CarParkFee();
    }

    static Stream<Arguments> hoursOutOfRange(){
        return Stream.of(
                Arguments.of(-2,new int[] {3,3,-2,3,3}),
                Arguments.of(-1,new int[] {3,3,-1,3,3}),
                Arguments.of(25,new int[] {3,3,6,3,25}),
                Arguments.of(26,new int[] {3,3,26,3,3}),
                Arguments.of(27,new int[] {3,3,27,3,3})
        );
    }

    static Stream<Arguments> hoursBoundsOutOfRange(){
        return Stream.of(
                Arguments.of(4,new int[] {3,3,3,3}),
                Arguments.of(6,new int[] {3,3,3,3,3,3})
        );
    }

    static Stream<Arguments> hoursInRange(){
        return Stream.of(
                Arguments.of(10,new int[] {5,5,5,2,2}),
                Arguments.of(10,new int[] {5,5,5,3,2}),
                Arguments.of(20,new int[] {5,5,5,5,1}),
                Arguments.of(20,new int[] {10,10,10,10,10}),
                Arguments.of(30,new int[] {20,20,20,20,20})
        );
    }


    @ParameterizedTest(name="Weekly fee for {1} hours is {0}")
    @MethodSource("hoursInRange")
    void testWeeklyFeeInRange(int expected, int[] hours) {
        assertEquals(expected, car.calculateWeeklyFee(hours));
    }

    @ParameterizedTest(name="Hours out of Range = {0} expecting IllegalArgumentException")
    @MethodSource("hoursOutOfRange")
    void testHoursOutOfRangeValues(int outOfRange,int[] hours) {
        Throwable exception=assertThrows(IllegalArgumentException.class,()->{car.calculateWeeklyFee(hours);});
        assertEquals("Invalid number of hours " + outOfRange + " received",exception.getMessage());
    }

    @ParameterizedTest(name="Testing hours = {0}, expecting fee = {1}")
    @CsvFileSource(resources="/car-data.csv")
    void testBoundariesDailyFee(int hours, double expected){
        assertEquals(expected,car.calculateDailyFee(hours));
    }

    @ParameterizedTest(name="Hour out of Range = {0} expecting IllegalArgumentException")
    @CsvFileSource(resources="/car-data-out-of-range.csv")
    void testHoursOutOfRangeValues(int outOfRange) {
        Throwable exception=assertThrows(IllegalArgumentException.class,()->{car.calculateDailyFee(outOfRange);});
        assertEquals("Invalid number of hours " + outOfRange + " received",exception.getMessage());
    }

    @ParameterizedTest(name="Length of hours out of Range = {0} expecting IllegalArgumentException")
    @MethodSource("hoursBoundsOutOfRange")
    void testBoundsOutOfRange(int outOfRange,int[] hours) {
        Throwable exception=assertThrows(IllegalArgumentException.class,()->{car.calculateWeeklyFee(hours);});
        assertEquals("Invalid number of days " + hours.length + " received",exception.getMessage());
    }

}