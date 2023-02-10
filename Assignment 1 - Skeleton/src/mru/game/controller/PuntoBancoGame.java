package mru.game.controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;
	
	public PuntoBancoGame(Player[] players) {
		System.out.println("What is your name?: ");
		String name = input.nextLine().trim().toLowerCase();
		
		for (Player pl : players) {
			if (input.equals(name)) {
				System.out.println("***********************");
				System.out.println("*** Welcome back "+name+" --- Your Balance is: "+balance+" $ ***");
				System.out.println("***********************");
				break;
			}
			else {
				PrintWriter write = new PrintWriter ("res/CasinoInfo.txt");
				write.println(name+"100"+"0");
				write.close();
				System.out.println("New account has been created for " + name+" your balance is "+balance+" $");
			}
		}
		
	}
	
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

}
