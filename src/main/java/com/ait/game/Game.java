package com.ait.game;

import java.util.Scanner;

public class Game {
	static final int SCORE_TO_WIN = 20;


	public void start() {
		Scanner sc;
		Player player1;
		Player player2;
		int numDiceRolls = 0;
		// display a welcome message
		System.out.println("Welcome to the Dice Roller application");
		System.out.println();
		sc = new Scanner(System.in);
		String player1Name;
		String player2Name;
		System.out.println("Please enter player one name: (Stub assumes Tom)");
		player1Name = "Tom"; //sc.next();
		System.out.println("Please enter player two name: (Stub assumes Jerry)");
		player2Name ="Jerry"; //sc.next();
		player1 = new Player(player1Name);
		player2 = new Player(player2Name);
		PairOfDiceStub dice = new PairOfDiceStub();
		System.out.println("Roll the dice? (y/n): (Stub assumes y)");
		String choice = "y"; //sc.next().toLowerCase();
		while (choice.equals("y")) {
			numDiceRolls++;
			System.out.println("");
			System.out.println("Round " + numDiceRolls + ": ");
			System.out.println("Rolling dice for player one ");
			dice.roll();
			System.out.println("Die 1 is " + dice.getValue1());
			System.out.println("Die 2 is " + dice.getValue2());
			player1.setTotalScore(dice.getSum());
			System.out.println("Rolling dice for player two ");
			dice.roll();
			System.out.println("Die 1 is " + dice.getValue1());
			System.out.println("Die 2 is " + dice.getValue2());
			player2.setTotalScore(dice.getSum());
			System.out.println(player1.toString());
			System.out.println(player2.toString());
			choice = "n";
			if ((player1.getTotalScore() >= SCORE_TO_WIN) && (player2.getTotalScore() >= SCORE_TO_WIN)) {
				System.out.println("DRAW");
			} else if (player1.getTotalScore() >= SCORE_TO_WIN) {
				System.out.println(player1.getName() + " wins");
			} else if (player2.getTotalScore() >= SCORE_TO_WIN) {
				System.out.println(player2.getName() + " wins");
			} else {
				System.out.println("No winner yet");

				System.out.println("Roll the dice again? (y/n): (Stub assumes y)");
				choice = "y"; //sc.next().toLowerCase();
			}
		}
		System.out.println("Good bye!");
	}

}
