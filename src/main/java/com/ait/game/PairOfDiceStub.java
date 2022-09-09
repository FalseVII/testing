package com.ait.game;

public class PairOfDiceStub {
	int counter=0;
	int value1;
	int value2;
	
	public PairOfDiceStub() {
		
	}
	
	public void roll()
	{
		if (counter==0) {
			value1=2;//player1
			value2=2;
		}
		else if(counter==1) {//player2
			value1=6;//player1
			value2=6;
		}
		else if(counter==2) {
			value1=2;
			value2=2;
		}
		else if(counter==3) {
			value1=4;
			value2=4;
		}
		counter++;
		
	}

	// get value of die1
	public int getValue1()
	{
		return value1;
	}

	// get value of die2
	public int getValue2()
	{
		return value2;
	}

	public int getSum()
	{
		return value1+value2;
	}

}
