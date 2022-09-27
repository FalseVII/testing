package com.ait.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class InvestmentTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/dataInv.csv")
    void calcualteInvestmentValue(int invest, int years, double expected) {
        Investment investment = new Investment();
        double actual = investment.calcualteInvestmentValue(years, invest);
        Assertions.assertEquals(expected, actual);
    }

}
