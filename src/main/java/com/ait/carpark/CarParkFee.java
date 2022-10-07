package com.ait.carpark;


public class CarParkFee {

    public double calculateDailyFee(int numHours) {
        double fee = 0;

        if (numHours < 0 || numHours > 24) {
            throw new IllegalArgumentException("Invalid number of hours " + numHours + " received");
        }
        if (numHours <= 5) {
            fee = numHours * 2;
        } else if (numHours <= 10) {
            fee = numHours * 2 * 0.8;
            if (fee < 10) {
                fee = 10;
            }
        } else if (numHours > 10) {
            fee = 20;
        }
        return fee;
    }

    public double calculateWeeklyFee(int[] hoursPerDay) {

        int totalHours = 0;
        double totalFee = 0;

        if(hoursPerDay.length != 5){
            throw new IllegalArgumentException("Invalid number of days " + hoursPerDay.length + " received");
        }

        for (int hour : hoursPerDay) {
            if (hour < 0 || hour > 24) {
                throw new IllegalArgumentException("Invalid number of hours " + hour + " received");
            }
            totalHours += hour;
        }

        if (totalHours <= 20) {
            totalFee = 10;
        } else if (totalHours <= 50) {
            totalFee = 20;
        } else if (totalHours > 50) {
            totalFee = 30;
        }
        return totalFee;
    }
}
