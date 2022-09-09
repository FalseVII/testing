package com.ait.game;

import java.util.Random;

public class Die
{
    private int value;
    private Random r = new Random();


    public Die()
    {
       this.value = 1;  // initialize value to 1
    }


    // roll the die
    public void roll()
    {
        value = r.nextInt(0,7) ; // number from 0 to sides
        if (value == 0)
        {
            value = 1;  // make sure value is not 0
        }
    }

    public int getValue()
    {
        return value;
    }
}