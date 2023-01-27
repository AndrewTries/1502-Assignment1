package mru.game.controller;

import java.util.Scanner;

import mru.game.view.AppMenu;

public class GameManager {
	
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
public  void Display() {
	
String i1 =	AppMenu.firstMenu();
String userInput = "Y";
Scanner sc = new Scanner(System.in);

while (userInput.equalsIgnoreCase("y"))
if(i1.equalsIgnoreCase("P")) {
	
	PuntoBancoGame.method(PuntoBancoGame.Getpoints());
	System.out.println("Do you want to play again?");
	 userInput = sc.nextLine();
	}
else if (i1.equalsIgnoreCase("S")) {  // second menu prompt
	String i2 = AppMenu.secondMenu();
	if (i2.equalsIgnoreCase("T")) {
		;
	}
	else if (i2.equalsIgnoreCase("N")) {
		;
	}
	else if (i2.equalsIgnoreCase("B")) {
		Display();
		
	}
}
else if(i1.equalsIgnoreCase("E")) {
	System.out.println("Saving............");
    System.out.print("Thank you for playing");
	System.exit(0);
}
else {
	System.out.println("Invalid input entered please try again");
	Display();
}

}
	
}
