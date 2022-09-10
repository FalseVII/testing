package com.ait.game;

public class PairOfDiceStub {
	int counter=0;
	int value1;
	int value2;
	private Die die1;
	private Die die2;

	
	public PairOfDiceStub() {
		die1 = new Die();
		die2 = new Die();
	}
	
	public void roll(int identifier)
	{
		switch (identifier) {
			case 1:
				if (counter==0) {
					die1.setValue(2);
					die2.setValue(2);
				}
				else if(counter==1) {
					die1.setValue(2);
					die2.setValue(3);
				}
				else if(counter==2) {
					die1.setValue(2);
					die2.setValue(4);
				}
				else if(counter==3) {
					die1.setValue(2);
					die2.setValue(6);
				}
				counter++;
				break;
			case 2:
				counter =0;
				break;
			case 3:
				counter =0;
				break;
			case 4:
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
