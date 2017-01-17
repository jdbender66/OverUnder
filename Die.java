//Joe Bender
//CS 401
//Ramirez Assignment #1
//Tues/Thurs 9:30-10:45

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Random;



public class Die
{
	public int rollDice()
	{
		//pretty simple class. The rubric said it needed an instance 
		//variable but I feel like I was successful without one
		int roll;
		//random object
		Random singleroll = new Random();
		
		roll = singleroll.nextInt(5) +1;
		//return the roll
		return roll;
		
		
	}
	
	
	
	
	
}
