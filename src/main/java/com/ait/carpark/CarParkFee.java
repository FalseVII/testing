package com.ait.carpark;

//Programme Description
//A car park has two payment types. Customers that use the car park on an infrequent basis can pay for a number of hours on a given day. Customers that use the car park more regularly can pay for a week based on the total number of hours that they used the car park each day over the course of the working week (Mon. – Fri).
//
//
//
//Write a class called CarParkFee.java. The class has two methods as follows:
//
//
//The method calculateDailyFee takes one parameter and returns a double. The argument numHour is the number of hours that a customer used the car park in a given day (to the nearest hour ie. An int). The method calculates the parking fee based on the following table. The fee is returned as a double formatted to 2 decimal places.
//No. of hours	Fee
//0-5 hours	€2 per hour
//6-10	€2 per hour minus 20% discount to a minimum of €10
//10-24	€20
//			Table 1 – Daily Rates
//
//Any values outside of the legal range for numHours must be handled with IllegalArgumentException and an appropriate error message. The error message should include the value that caused the exception (e.g.25) and the test should assert for the correct message in the exception. Use @ValueSource to generate invalid values and use @CsvFileSource to generate valid values/expected results. Call your CSV file car-data.csv.
//The method calculateWeeklyFee takes in an array of ints. The array should contain 5 integer values that represent the number of hours that the customer used the carpark for each of five working days. If the array has not exactly the correct number of values or any of the values are out or range, IllegalArgumentException is thrown with an appropriate error message. The method should compute the total number of hours that the car park was used for the week and calculate the fee based on the following table. Use @MethodSource to generate the values for testing the CalculateWeeklyFee method.
//
//No. of hours per week	Fee
//0-20	€10
//21-50	€20
//>50	€30
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
