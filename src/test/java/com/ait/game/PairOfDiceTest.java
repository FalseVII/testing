package com.ait.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairOfDiceTest {

    PairOfDice pairOfDice;
    @BeforeEach
    void setUp() {
        pairOfDice = new PairOfDice();
    }

    @Test
    void roll() {
        pairOfDice.roll();
        assertTrue(pairOfDice.getValue1() >= 1 && pairOfDice.getValue1() <= 6);
        assertTrue(pairOfDice.getValue2() >= 1 && pairOfDice.getValue2() <= 6);
    }

    @Test
    void getValue1() {
        pairOfDice.roll();
        assertTrue(pairOfDice.getValue1() >= 1 && pairOfDice.getValue1() <= 6);
    }

    @Test
    void getValue2() {
        pairOfDice.roll();
        assertTrue(pairOfDice.getValue2() >= 1 && pairOfDice.getValue2() <= 6);
    }

    @Test
    void getSum() {
        pairOfDice.roll();
        assertTrue(pairOfDice.getSum() >= 2 && pairOfDice.getSum() <= 12);
    }
}