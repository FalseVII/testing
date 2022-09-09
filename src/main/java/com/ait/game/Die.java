package com.ait.game;
public class Die
{
    private int value;

    private static int max=6;
    private static int min=1;

    public Die()
    {
       this.value = 1;  // initialize value to 1
    }


    // roll the die
    public void roll()
    {
        value = (int) (Math.random()  * (max - min + 1) + min);  // number from 0 to sides
    }

    public int getValue()
    {
        return value;
    }
}