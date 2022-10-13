package com.ait.covid;

import java.text.DecimalFormat;

public class CovidChecker {


    public String checkTempForCovid(double temperature){
        if (temperature < 30 || temperature > 50) {
            throw new IllegalArgumentException("Temperature is out of range, should be 30-50, it is " + temperature);
        }
        DecimalFormat df = new DecimalFormat("##.#");
        df.format(temperature);
        if (temperature <= 37.5) {
            return "OK";
        }
        return "TEST FOR COVID";
    };

    public String checkBPForCovid(int[] bloodPressure){

        if (bloodPressure.length != 5) {
            throw new IllegalArgumentException("Array must have 5 values, array has " + bloodPressure.length);
        }
        int sum = 0;
        for (int i = 0; i < bloodPressure.length; i++) {
            if (bloodPressure[i] < 60 || bloodPressure[i] > 90) {
                throw new IllegalArgumentException("Blood pressure is out of range, should be 60-90, it is " + bloodPressure[i]);
            }
            sum += bloodPressure[i];
        }

        int average = Math.round(sum / bloodPressure.length);
        if (average > 74) {
            return "TEST FOR COVID";
        }
        return "OK";
    }
}
