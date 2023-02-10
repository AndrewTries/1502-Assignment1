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
	}
	
	private void launchApplication() throws IOException {
		
		boolean flag = true;
		char option;
		
		while (flag) {
			option = appMenu.showMainMenu();
			
			switch(option) {
			case 1:
				
			}
		}
	}
	
	private void Save() throws IOException {
		File file = new File (FILE_PATH);
		PrintWriter printWrite = new PrintWriter(file);
		for (Player p: players) {
			printWrite.println(p.format());
		}
		printWrite.close();
	}

	private void PlayerSearch() {
		String name = appMenu.enterName();
		boolean found = false;

		for (Player c : players)
			if (c.getName().equals(name)) {
				appMenu.showPlayer(c);
				found = true;
				break;
			}
	}

	private void TopPlayer() {

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
