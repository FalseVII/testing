package com.ait.game;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    Die die;

    @BeforeEach
    void setUp() {
       die = new Die();

    }

    @RepeatedTest(100)
    void roll() {
        die.roll();
        assertTrue(die.getValue() >= 1 && die.getValue() <= 6);
    }

    @Test
    void getValue() {
        die.roll();
        assertTrue(die.getValue() >= 1 && die.getValue() <= 6);
    }
}