package com.ait.testing;

public class Investment {


    public static double calcualteInvestmentValue(int term, int StartAmount){
                final int MAX_TERM = 10, MIN_TERM = 3, MAX_START_AMOUNT = 10000, MIN_START_AMOUNT = 1000;

                if(term < MIN_TERM || term > MAX_TERM){
                    throw new IllegalArgumentException("Term must be between 3 and 10");
                }

                if(StartAmount < MIN_START_AMOUNT || StartAmount > MAX_START_AMOUNT){
                    throw new IllegalArgumentException("Start Amount must be between 1000 and 10000");
                }

                double interestRate = 0.0;
                if (StartAmount >= 1000 && StartAmount <= 2999) {
                    interestRate = 0.02;
                } else if (StartAmount >= 3000 && StartAmount <= 4999) {
                    interestRate = 0.05;
                } else if (StartAmount >= 5000 && StartAmount <= 10000) {
                    interestRate = 0.07;
                }

                double total = StartAmount;

                for(int i = 0; i < term; i++) {
                    total = total + (total * interestRate);
                }
                return total;
    };

}
