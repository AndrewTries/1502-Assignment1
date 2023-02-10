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
		System.out.println("Select one of the Options:");
		System.out.println("(P) Play game");
		System.out.println("(S) Search");
		System.out.println("(E) Exit");
		System.out.println("Enter a choice: ");
		char option = input.next().charAt(0);
		
		return option;
	}
	
	public char searchMenu() {
		
		System.out.println("Select one of these options: ");
		System.out.println("(T) Top player (Most number of wins)");
		System.out.println("(N) Looking for a Name");
		System.out.println("(B) Back to Main menu");
		System.out.println("Enter a choice:");
		char option = input.next().charAt(0);
		
		return option;
	}
	
	public char outcomeMenu() {
		System.out.println("Who do you want to bet on?");
		System.out.println("Player Wins");
		System.out.println("Banker Wins");
		System.out.println("Tie");
		char option = input.next().charAt(0);
		
		return option;
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
	
	public String enterName() {
		System.out.println("What is your name: ");
		String name = input.nextLine().trim().toLowerCase();
		return name;
		
	}
	
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
