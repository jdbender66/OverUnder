//Joe Bender
//CS 401
//Ramirez Assignment #1
//Tues/Thurs 9:30-10:45


import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Assig2
{
	
	public static void main(String [] args) throws IOException
	{
		DecimalFormat formatter = new DecimalFormat ("$###0.00");
		
		String name ="";
		int exist;
		String lastname ="";
		int startingmoney;
		
		String[] playerdata;
		
		String existingname = "";
		String existinglastname = "";
		String existingmoneyinput;
		String totalroundsplayedinput;
		String roundswoninput;
		
		int numbertimesplayed = 0;
		
		int existingmoney;
		int totalroundsplayed = 0;
		int roundswon = 0;
		
		int playround;
		
		int sessioncounter = 0;
		int wincounter = 0;
		//create scanner for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\nWelcome to Over Seven / Under Seven!\nPlease enter your first name:\n");
		name = keyboard.nextLine();
		
		//create an instance of the player class
		Player playername = new Player();
		//send the first name to the setName method of my player class
		playername.setName(name);
		//check to see if the file with the first name exists
		exist = playername.checkExist();
		//An if statement in which if the file doesnt exist, it prompts you for info to create one and if it does exist it calls it up and tells you the info
		if (exist == 1)
		{
		System.out.println("\nIt's nice to meet you "+name+".\nEnter your information below:\n");
		System.out.println("Last Name:\n");
		lastname = keyboard.nextLine();
		System.out.println("Initial Starting Deposit:\n");
		startingmoney = keyboard.nextInt();
		existingmoney = startingmoney;
		
		playername.setLastname(lastname);
		playername.setstartingcash(startingmoney);
		//creates file if not created already
		playername.createFile();
		
		}
		else
		{
		//accessing the array with the 5 elements of info in it
		playerdata = playername.inputloop();
		
		
		//assigning array elements to variables, and converting some from strings to ints
		
		existingname = playerdata[0];
		name = existingname;
		existinglastname = playerdata[1];
		lastname = existinglastname;
		
		existingmoneyinput = playerdata[2];
		existingmoney = Integer.parseInt(existingmoneyinput);
		
		totalroundsplayedinput = playerdata[3];
		totalroundsplayed= Integer.parseInt(totalroundsplayedinput);
		
		roundswoninput = playerdata[4];
		roundswon = Integer.parseInt(roundswoninput);
		
		
		System.out.println("\nWelcome back "+name+"! Here is your history:\n");
		System.out.println("First name: "+name);
		System.out.println("Last name: "+lastname);
		System.out.println("\nRemaining Money: "+formatter.format(existingmoney));
		System.out.println("\nTotal Rounds Played: "+totalroundsplayed);
		System.out.println("Total Rounds Won: "+roundswon);
		
		
		}
		//calling my die class
		Die rollofthedice = new Die();
		
		int bet;
		int choice;
		int wanttoplay;
		
		
		System.out.println("\nWould you like to play a round?");
		
		do
		{
		System.out.println("Press 1 for Yes, and 2 for No:");
		wanttoplay = keyboard.nextInt();
		} while (wanttoplay > 2 || wanttoplay < 1);
		
		int playagain;
		int die1;
		int die2;
		int correct = 0;
		int totalamount;
		
		int sessionwinnings = 0;
		int roundwinnings = 0;
		
		int bettingamount; 
		
		
		if (wanttoplay == 1)
		{
		
		do
		{
		
		bettingamount = (existingmoney + sessionwinnings);
		
		do
		{
			//cancels program if you have no money
			if( bettingamount == 0)
			{
				System.out.println("Sorry, but you don't have any money remaining.");
				System.out.println("The program will now terminate");
				System.exit(0);
			}
		System.out.println("\nHow much would you like to bet? (<="+formatter.format(bettingamount)+"):");
		bet = keyboard.nextInt();
		} while (bet > bettingamount || bet <= 0);
		
		
		do
		{
		System.out.println("\nSelect your choice:\n");
		System.out.println("Press 1 for Over");
		System.out.println("Press 2 for Under");
		System.out.println("Press 3 for Seven");
		choice = keyboard.nextInt();
		} while (choice > 3  || choice < 1);
		
		//calls the die class twice to simulate 2 rolls
		die1 = rollofthedice.rollDice();
		die2 = rollofthedice.rollDice();
		
		System.out.println("The dice have been rolled...and they are...");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("Die 1: "+die1);
		System.out.println("Die 2: "+die2);
		
		totalamount = (die1 + die2);
		
		System.out.println("Die 1 + Die 2 = "+totalamount);
		
		
		//The following if statements are a tree with the three options of over, under and seven. And nested within are the 3 options you couldve chosen.
		
		if (totalamount == 7)
		{
			System.out.println("\nThe total is exactly SEVEN! Wow!.");
			
				if (choice == 3)
				{
					System.out.println("\nYou were correct!!!");
					correct = 2;
					wincounter++;
				}
				else if (choice == 2)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
				else if (choice == 1)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
		}
		else if (totalamount < 7)
		{
			System.out.println("\nThe total is UNDER seven.");
				if (choice == 1)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
				else if (choice == 2)
				{
					System.out.println("\nYou were correct!!!");
					correct = 1;
					wincounter++;
				}
				else if (choice == 3)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
		}
		else if (totalamount > 7)
		{
			System.out.println("\nThe total is OVER seven.");
			
				if (choice == 2)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
				else if (choice == 3)
				{
					System.out.println("\nSorry, you were not correct");
					correct = 0;
				}
				else if (choice == 1)
				{
					System.out.println("\nYou were correct!!!");
					correct = 1;
					wincounter++;
				}
		}
		
		//these if statements determine winnings or loses based on the previous roll
		if (correct == 1)
		{
			
			roundwinnings = (bet *2);
			System.out.println("You win "+ formatter.format((roundwinnings)));
			
		}
		else if (correct == 0)
		{
			
			roundwinnings = (bet * -1);
			System.out.println("You get "+ formatter.format(roundwinnings));
			
		}
		else if (correct == 2)
		{
			roundwinnings = (bet * 5);
			System.out.println("You win "+ formatter.format((roundwinnings)));
		}
		
		//these few statements accumulate the money, rounds played, and rounds won and prepares to write them to the file
		sessionwinnings += roundwinnings;
		
		sessioncounter ++;
		//calculates new money total
		bettingamount = (existingmoney + sessionwinnings);
		
		System.out.println("Your updated money total is: "+formatter.format(bettingamount));
		
		System.out.println("Would you like to play again?");
		System.out.println("Press 1 for Yes, and 2 for No");
		playagain = keyboard.nextInt();
		numbertimesplayed++;
		//if the choice to play again wasnt selected then the do-while loop doesnt reexecute and it moves to the final report
		} while (playagain == 1);
		
		sessioncounter += totalroundsplayed;
		roundswon += wincounter;
		
		existingname = name;
		existinglastname = lastname;
		//The individual sessions stats
		System.out.println("\nThis session's statistics:");
		System.out.println("Rounds Played: "+numbertimesplayed);
		System.out.println("Rounds Won: "+wincounter);
		System.out.println("Winnings: "+ formatter.format((bettingamount - existingmoney)));
		//Sending the 3 new values to be 
		playername.uFile(name,lastname,bettingamount,sessioncounter,wincounter);
		
		System.out.println("\nThank you for playing Over Seven / Under Seven\n");
		System.out.println("Here is your updated information:\n");
		System.out.println("First name: "+existingname);
		System.out.println("Last name: "+existinglastname);
		System.out.println("\nRemaining Money: "+formatter.format(bettingamount));
		System.out.println("\nTotal Rounds Played: "+sessioncounter);
		System.out.println("Total Rounds Won: "+roundswon);
			
		}
		
		
		
	}
	
}
