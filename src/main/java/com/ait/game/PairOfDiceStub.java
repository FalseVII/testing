package com.ait.game;

public class PairOfDiceStub {
	int counter=0;
	int value1;
	int value2;
	private Die die1;
	private Die die2;
	public static int identity = 1;

	
	public PairOfDiceStub() {
		die1 = new Die();
		die2 = new Die();
	}
	
	public void roll()
	{
		switch (identity) {
			case 1:
				if (counter==0) {
					die1.setValue(6);
					die2.setValue(6);
				}
				else if(counter==1) {
					die1.setValue(1);
					die2.setValue(1);
				}
				else if(counter==2) {
					die1.setValue(6);
					die2.setValue(5);
				}
				else if(counter==3) {
					die1.setValue(1);
					die2.setValue(2);
				}
				counter++;
				break;
			case 2:
				if (counter==0) {
					die1.setValue(1);
					die2.setValue(1);
				}
				else if(counter==1) {
					die1.setValue(6);
					die2.setValue(6);
				}
				else if(counter==2) {
					die1.setValue(1);
					die2.setValue(2);
				}
				else if(counter==3) {
					die1.setValue(6);
					die2.setValue(5);
				}
				counter++;
				break;
			case 3:
					die1.setValue(5);
					die2.setValue(5);
				break;
			default:
				break;
		}

		
	}
	public int getValue1()
	{
		return die1.getValue();
	}
	public int getValue2()
	{
		return die2.getValue();
	}

	public int getSum()
	{
		return die2.getValue()+ die2.getValue();
	}

}
