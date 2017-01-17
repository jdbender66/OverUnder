//Joe Bender
//CS 401
//Ramirez Assignment #1
//Tues/Thurs 9:30-10:45

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Player
{
	private String name;
	private String lastname;
	private int startingcash;
	private int newmoney;
	private int newtotalrounds;
	private int newroundswon;
	private String newname;
	private String newlname;
	//sets the name
	public void setName(String nam)
	{
		
		name = nam;
		
		
	}
	//gets name 
	public String getName()
	{
	
		return name;
		
	}
	//sets the last name
	public void setLastname(String lastnam)
	{
		
		lastname = lastnam;
		
		
	}
	//inputs cash for first time players
	public void setstartingcash(int startingguap)
	{
		
		startingcash = startingguap;
		
		
	}
	//checks to see if a file with the name of the player exists
	public int checkExist()
	{
		int doesitexist = 0;
		
		File file = new File(name);
		
		
		if (!file.exists())
		      {
			     doesitexist = 1; 
			     
		 
		      }
		      
		return doesitexist;
		      
	}
	
	
	//creates a new file
	public void createFile() throws IOException
	{
	
		
		PrintWriter outputFile = new PrintWriter(name);
		
		outputFile.println(name);
		outputFile.println(lastname);
		outputFile.println(startingcash);
		outputFile.println(0);
		outputFile.println(0);
		
		outputFile.close();
	}
	//creates a new file and overwrites the old file
	public void uFile(String nam, String lnam, int guap, int totrounds, int roundwon) throws IOException
	{
		
		newname = nam;
		newlname = lnam;
		newmoney = guap;
		newtotalrounds = totrounds;
		newroundswon = roundwon;
		
		
		PrintWriter outputFile = new PrintWriter(name);
		
		outputFile.println(newname);
		outputFile.println(newlname);
		outputFile.println(newmoney);
		outputFile.println(newtotalrounds);
		outputFile.println(newroundswon);
		
		outputFile.close();
	}
	//creates the array to read info off the file
	public String[] inputloop() throws IOException
	{
		File playerfile = new File(name);
		Scanner inputfile = new Scanner(playerfile);
		
		String[] data = new String[5];
		
		
		
		for (int i = 0; i <=4; i++)
		{
			data[i]= inputfile.nextLine();
			
		}
		return data;
	}
	
	
	

	
	
	
	
	
}
