package com.ait.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class InvestmentTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/dataInv.csv")
    void calcualteInvestmentValue(int invest, int years, double expected) {
            double actual = Investment.calcualteInvestmentValue(years, invest);
            Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/limits.csv")
    void limitsTest(int invest, int years) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Investment.calcualteInvestmentValue(years, invest);
            });
    }
}
