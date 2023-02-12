package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	
	private Scanner input;
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMenu;

	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMenu = new AppMenu();
		launchApplication();
	}
	
	private void launchApplication() throws IOException {
		
		boolean flag = true;
		char option;
		
		while (flag) {
			option = appMenu.showMainMenu();
			
			switch(option) {
			case 'P':
			case 'p':
				appMenu.gameMenu();
				break;
			case 'S':
			case 's':
				appMenu.searchMenu();
				break;
			case 'E':
			case 'e':
				save();
				flag = false;
			}	
		}
	}
	
	private void searchApplication() throws IOException {
		
		boolean flag = true;
		char option1;
		
		while (flag) {
			option1 = appMenu.searchMenu();
			
			switch(option1) {
			case 'T':
			case 't':
				topPlayer();
				break;
			case 'N':
			case 'n':
				playerSearch();
				break;
			case 'B':
			case 'b':
				returnToMenu();
				flag = false;
			}			
		}
	}
	
	private void outcomeApplication() {
		
		boolean flag = true;
		char option2;
		
		while (flag) {
			option2 = appMenu.gameMenu();
			
			switch(option2) {
			case 'P':
			case 'p':
				playerWin();
				break;
			case 'D':
			case 'd':
				dealerWin();
				break;
			case 'T':
			case 't':
				gameTie();
				flag = false;
			}
		}
	}
	
//	private long playerBalance(){
//	boolean done = false;
//	for (int index = 0; index < players.size() && !done; index++) {
//		if (players.get(index).getName() != null) {
//			long oldBalance = players.get(index).getBalance();
//			players.get(index).setBalance(oldBalance);
//			done = true;
//		}
//		return oldBalance;
//		
//	}
//	}
		
//	public void playGame(int betAmount, String betType) {
//	    if (betAmount > players.get(index).getBalance) {
//	      System.out.println("Insufficient balance.");
//	      return;
//	    }
//	}
	
	private void findPlayer() {
		
	}
	
	private void save() throws IOException {
		File file = new File (FILE_PATH);
		PrintWriter printWrite = new PrintWriter(file);
		for (Player p: players) {
			printWrite.println(p.format());
		}
		printWrite.close();
		appMenu.exitProgram();
	}

	private void topPlayer() {

	}
	
	private void playerSearch() {
		System.out.println("balls");
		String name = appMenu.enterName();
		boolean found = false;

		for (Player c : players)
			if (c.getName().equals(name)) {
				appMenu.showPlayer(c);
				found = true;
				break;
			}
	}
	
	private void returnToMenu() {
		
	}
		
	private void makeBet() {
		
	}
	
	private void playerWin() {
		
	}
	
	private void dealerWin() {
		
	}
	
	private void gameTie() {
		
	}
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

	

}
