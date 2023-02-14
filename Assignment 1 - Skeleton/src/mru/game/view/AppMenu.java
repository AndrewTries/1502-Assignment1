package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

/**
 * 
 * @author Andrew Kravicz 
 *
 */
public class AppMenu {
	
	private Scanner input;

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 * help
	 */
	
	public AppMenu() {
		/**
		 * This is the constructor of this class
		 */
		input = new Scanner(System.in);
	}
	
	/**
	 * This method displays the the main menu of the game and prompts user to enter the character to proceed
	 * @return variable option
	 */
	public char showMainMenu() {
		System.out.println("Select one of the Options:\n");
		System.out.println("(P) Play game");
		System.out.println("(S) Search");
		System.out.println("(E) Exit");
		System.out.println("\nEnter a choice: ");
		char option = input.next().toLowerCase().charAt(0);
		/**
		 * a loop that checks whether or not the entered character is a valid option, otherwise throws a message and prompts the user to try again
		 */
		while (option != 'p' && option != 's' && option != 'e') {
			System.out.println("Invalid option. Please enter either 'p', 's', or 'e':");
			option = input.next().toLowerCase().charAt(0);
		}
		
		return option;
	}
	/**
	 * This method is a 2nd menu of the program that contains the top player and the search by name function
	 * @return option1, which is the selection candidates for this method
	 */
	public char searchMenu() {		
		System.out.println("Select one of these options:\n");
		System.out.println("(T) Top player (Most number of wins)");
		System.out.println("(N) Looking for a Name");
		System.out.println("(B) Back to Main menu");
		System.out.println("\nEnter a choice:");
		char option1 = input.next().toLowerCase().charAt(0);
		/**
		 * checks the validity of entered character
		 */
		while (option1 != 't' && option1 != 'n' && option1 != 'c' && option1 != 'b') {
			System.out.println("Invalid option. Please enter either 't', 'n', or 'b':");
			option1 = input.next().toLowerCase().charAt(0);
		}
		
		return option1;
	}
	/**
	 * This is the Game menu where the payer selects what they should bet on
	 * @return option2, which is the selected character for this method
	 * 
	 */
	public char gameMenu() {
		System.out.println("Who do you want to bet on?\n");
		System.out.println("(P) Player Wins");
		System.out.println("(B) Banker Wins");
		System.out.println("(T) Tie Game");
		System.out.println("\nEnter your Choice:");
		char option2 = input.next().toLowerCase().charAt(0);
		
		while (option2 != 'p' && option2 != 'b' && option2 != 't') {
			System.out.println("Invalid option. Please enter either 'p', 'b', or 't':");
			option2 = input.next().toLowerCase().charAt(0);
		}
		
		return option2;
	}
	
	
	/**
	 * this method is used to show the stored player data, if there is no record, show that the appropriate message
	 * @param ply, which is just a stored value from the text file
	 */
	public void showPlayer(Player ply) {
		if (ply !=null)
			System.out.println(ply);
		else
			System.out.println("No record found for that name!");
	}
	/**
	 * This method is used to show the name and number of wins of the top scoring player registered
	 */
	public void topPlayerMenu() {
		System.out.println("- TOP PLAYERS -");
		System.out.println("+=============+==============+");
		System.out.println("|NAME         |# WINS        |");
		System.out.println("+=============+==============+");
		System.out.println("+-------------+--------------+");
		
		System.out.println("Press \"Enter\" to continue...");
	}
	/**
	 * this method is used to return to the main menu
	 */
	public void toMenu() {
		showMainMenu();
	}
	/**
	 * method the ends the program and saves the results into the text file
	 */
	public void exitProgram() {
		
		System.out.println("Saving...");
		System.out.println("Done! Please visit us again!");
		System.exit(0);
		
	}
	
	
}
