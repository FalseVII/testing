package com.ait.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player = new Player("John");
        assertEquals("John",player.getName());
    }

    @Test
    void getTotalScore() {
        Player player = new Player("John");
        player.setTotalScore(10);
        assertEquals(10,player.getTotalScore());
    }

    @Test
    void testToString() {
        Player player = new Player("John");
        player.setTotalScore(10);
        assertEquals("Current score for John is 10",player.toString());
    }
}