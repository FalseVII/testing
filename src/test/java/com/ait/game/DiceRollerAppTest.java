package com.ait.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceRollerAppTest {
    DiceRollerApp diceRollerApp;


    @Test
    void mainPlayerOne() {
        diceRollerApp = new DiceRollerApp();
        PairOfDiceStub.identity = 1;
        diceRollerApp.main(null);
        diceRollerApp = null;
        System.gc();
    }
    @Test
    void mainPlayerTwo() {
        diceRollerApp = new DiceRollerApp();
        PairOfDiceStub.identity = 2;
        diceRollerApp.main(null);
        diceRollerApp = null;
        System.gc();
    }
    @Test
    void mainPlayerDraw() {
        diceRollerApp = new DiceRollerApp();
        PairOfDiceStub.identity = 3;
        diceRollerApp.main(null);
        diceRollerApp = null;
        System.gc();
    }
}