package com.ait.game;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    Die die;
    PairOfDice pairOfDice;
    @RepeatedTest(100)
    void roll() {
        pairOfDice = new PairOfDice();
        die = new Die();
        die.roll();
        int die1 = pairOfDice.getValue1();
        int die2 = pairOfDice.getValue2();
        assertThat(die1,allOf(greaterThanOrEqualTo(1),lessThanOrEqualTo(6)));   //Maybe if we over-engineer it, it will work
        assertThat(die2,allOf(greaterThanOrEqualTo(1),lessThanOrEqualTo(6)));
    }
    /*
    A cleaner implementation but does not follow the brief.
        https://www.youtube.com/watch?v=k6KG-k3z05Q this is an absolute banger tho.

    @RepeatedTest(100)
    void roll2(){
        die = new Die();
        die.roll();
        assertTrue(die.getValue() >= 1 && die.getValue() <= 6);
    }
     */
}