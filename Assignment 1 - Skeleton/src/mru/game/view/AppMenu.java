package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {
	
	private Scanner input;

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 * help
	 */
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public char showMainMenu() {
		System.out.println("Select one of the Options:\n");
		System.out.println("(P) Play game");
		System.out.println("(S) Search");
		System.out.println("(E) Exit");
		System.out.println("\nEnter a choice: ");
		char option = input.next().toLowerCase().charAt(0);
		
		while (option != 'p' && option != 's' && option != 'e') {
			System.out.println("Invalid option. Please enter either 'p', 's', or 'e':");
			option = input.next().toLowerCase().charAt(0);
		}
		
		return option;
	}
	
	public char searchMenu() {		
		System.out.println("Select one of these options:\n");
		System.out.println("(T) Top player (Most number of wins)");
		System.out.println("(N) Looking for a Name");
		System.out.println("(B) Back to Main menu");
		System.out.println("\nEnter a choice:");
		char option1 = input.next().toLowerCase().charAt(0);
		
		while (option1 != 't' && option1 != 'n' && option1 != 'c' && option1 != 'b') {
			System.out.println("Invalid option. Please enter either 't', 'n', or 'b':");
			option1 = input.next().toLowerCase().charAt(0);
		}
		
		return option1;
	}
	
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
	
	
	
	public void showPlayer(Player ply) {
		if (ply !=null)
			System.out.println(ply);
		else
			System.out.println("No record found for that name!");
	}
	
	public void topPlayerMenu() {
		System.out.println("- TOP PLAYERS -");
		System.out.println("+=============+==============+");
		System.out.println("|NAME         |# WINS        |");
		System.out.println("+=============+==============+");
//		System.out.println("|" + topPlayerName(0) + "|" + topPlayerWins(0) + "|");
//		System.out.println("+-------------+--------------+");
//		System.out.println("|" + topPlayerName(1) + "|" + topPlayerWins(1) + "|");
		System.out.println("+-------------+--------------+");
		
		System.out.println("Press \"Enter\" to continue...");
//		System.in.read();
	}
	
//	public String enterName() {
//		System.out.println("What is your name: ");
//		String name = input.nextLine().trim().toLowerCase();
//		return name;
//		
//	}
	
	public void oldPlayer() {
		
	}
	
	public void newPlayer() {
		
	}
	
	public void toMenu() {
		showMainMenu();
	}
	
	public void exitProgram() {
		
		System.out.println("Saving...");
		System.out.println("Done! Please visit us again!");
		System.exit(0);
		
	}
	
	
}
