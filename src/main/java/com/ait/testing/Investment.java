package com.ait.testing;

public class Investment {


    public static double calcualteInvestmentValue(int term, int StartAmount){
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
