package com.tus.sugarlevel;

public class BloodCheck {


    public String checkBloodSugar(double sugarLevel) {
        String result = "";
        final double MIN_SUGAR_LEVEL = 0.0, MAX_SUGAR_LEVEL = 20.0;
        final double LOW =5.0, OK = 7.0, HIGH = 10.0;
        if (sugarLevel < MIN_SUGAR_LEVEL || sugarLevel > MAX_SUGAR_LEVEL) {
            throw new IllegalArgumentException("Invalid sugar level " + sugarLevel + " received, should be between 0 and 20.");
        }
        if (sugarLevel <= LOW) {
            result = "LOW";
        } else if (sugarLevel <= OK) {
            result = "OK";
        } else if (sugarLevel <= HIGH) {
            result = "HIGH";
        } else if (sugarLevel > HIGH) {
            result = "ALERT";
        }
        return result;
    }

    public boolean checkBloodSugarForDiabetesType2(double[] sugarLevels) {
        double sum=0;
        final double MAX_SUGAR_LEVEL = 20.0, MIN_SUGAR_LEVEL = 0.0;
        final int ARRAY_LENGTH_MIN =3, ARRAY_LENGTH_MAX = 6;
        final double AVERAGE_BOUND = 10.0;

        if(sugarLevels.length < ARRAY_LENGTH_MIN || sugarLevels.length > ARRAY_LENGTH_MAX){
            throw new IllegalArgumentException("Invalid number of readings " + sugarLevels.length + " received, should be between 3 and 6.");
        }

        for (double sugarLevel : sugarLevels) {
            if (sugarLevel < MIN_SUGAR_LEVEL || sugarLevel > MAX_SUGAR_LEVEL) {
                throw new IllegalArgumentException("Invalid sugar level " + sugarLevel + " received, should be between 0 and 20.");
            }
            sum += sugarLevel;
        }
        double average = sum / sugarLevels.length;

        if (average >= AVERAGE_BOUND) {
            return true;
        } else {
            return false;
        }

    }
}
