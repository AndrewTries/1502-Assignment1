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
	

	
	private final String FILE_PATH = "res//CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMenu;
	PuntoBancoGame puntoBanco;
	
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMenu = new AppMenu();
		puntoBanco = new PuntoBancoGame();
		loadData();
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
				gameInterface();
				break;
			case 'S':
			case 's':
				searchApplication();
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
	    players.sort((p1, p2) -> p2.getNumberOfWins() - p1.getNumberOfWins());

	    System.out.println("		 - TOP PLAYERS -			");
	    System.out.println("+===============+===============+===============+");
	    System.out.println("|RANK           |NAME           |# WINS         |");
	    System.out.println("+===============+===============+===============+");

	    for (int i = 0; i < players.size() && i < 5; i++) {
	        Player player = players.get(i);
	        System.out.println("|" + (i + 1) + "              |" + player.getName() + "\t\t|" + player.getNumberOfWins() + "\t\t|");
	        System.out.println("+---------------+---------------+---------------+");
	    }
	}
	
	public void playerSearch() {
	    String name = enterName();
	    boolean found = false;
	    for (Player player : players) {
	        if (player.getName().equals(name)) {
	        	System.out.println("		       - PLAYER INFO -			");
	        	System.out.println("+===============+===============+===============+");
	    		System.out.println("|NAME           |# WINS         |BALANCE        |");
	    		System.out.println("+===============+===============+===============+");
	            System.out.println("|" + player.getName() + "|" + player.getNumberOfWins() + "|" + player.getBalance() + "|");
	            System.out.println("+---------------+---------------+---------------+");
	            	            
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("Player not found.");
	    }
	}
	
	private void gameInterface() {
		String name = enterName();
		boolean found = false;
	    for (Player player : players) {
	        if (player.getName().equals(name)) {
	        	System.out.println("********************************************************************");
	        	System.out.println("***   Welcome back " + player.getName() + "   ---   Your balance is: " + player.getBalance() + "$        ***");
	        	System.out.println("********************************************************************");
	        	char option2;
		        option2 = appMenu.gameMenu();
		        
		        if(option2 == 'p') {
		            long betAmount = setBet();
		            if (betAmount > player.getBalance()) {
		                System.out.println("Balance exceeded, please enter an amount within your limit.");
		            }
		            else {
		                String result = puntoBanco.puntoBancoGame();
		                System.out.println(result);

		                long oldBalance = player.getBalance();		               
		                if(result.equals("p")) {
		                    player.setBalance(oldBalance + betAmount);
		                    player.setNumberOfWins(player.getNumberOfWins()+1);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER WON " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		                else {
		                    player.setBalance(oldBalance - betAmount);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		            }
		        }
		        else if(option2 == 'd'){
		            long betAmount = setBet();
		            if (betAmount > player.getBalance()) {
		                System.out.println("Balance exceeded, please enter an amount within your limit.");
		            }
		            else {
		                String result = puntoBanco.puntoBancoGame();
		                System.out.println(result);

		                long oldBalance = player.getBalance();		                
		                if(result.equals("d")) {
		                    player.setBalance(oldBalance + betAmount);
		                    player.setNumberOfWins(player.getNumberOfWins()+1);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER WON " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		                else {
		                    player.setBalance(oldBalance - betAmount);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		            }
		        }
		        else {
		            long betAmount = setBet();
		            if (betAmount > player.getBalance()) {
		                System.out.println("Balance exceeded, please enter an amount within your limit.");
		            }
		            else {
		                String result = puntoBanco.puntoBancoGame();
		                System.out.println(result);

		                long oldBalance = player.getBalance();
		                if(result.equals("t")) {
		                    player.setBalance(oldBalance + (betAmount*5));
		                    player.setNumberOfWins(player.getNumberOfWins()+1);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER WON " + (betAmount*5) + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		                else {
		                    player.setBalance(oldBalance - betAmount);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		            }
		        }
		        found = true;            
		        break;
		    }
		}
		if (!found) {
		    System.out.println("********************************************************************");
		    System.out.println("***   Welcome " + name + "   ---   Your balance is: 100 $        ***");
		    System.out.println("********************************************************************");
		    Player newPlayer = new Player(name, 100, 0);
		    players.add(newPlayer);
		    char option2;
		    option2 = appMenu.gameMenu();

		    if(option2 == 'p') {
		        long betAmount = setBet();
		        if (betAmount > newPlayer.getBalance()) {
		            System.out.println("Balance exceeded, please enter an amount within your limit.");
		        }
		        else {
		            String result = puntoBanco.puntoBancoGame();
		            System.out.println(result);

		            long oldBalance = newPlayer.getBalance();		            
		            if(result.equals("p")) {
		                newPlayer.setBalance(oldBalance + betAmount);
		                newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                System.out.println("$\t PLAYER WON " + betAmount + "\t$");
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		            }
		            else {
		                newPlayer.setBalance(oldBalance - betAmount);
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		            }
		        }
		    }
		    else if(option2 == 'd'){
		        long betAmount = setBet();
		        if (betAmount > newPlayer.getBalance()) {
		            System.out.println("Balance exceeded, please enter an amount within your limit.");
		        }
		        else {
		            String result = puntoBanco.puntoBancoGame();
		            System.out.println(result);

		            long oldBalance = newPlayer.getBalance();		          
		            if(result.equals("d")) {
		                newPlayer.setBalance(oldBalance + betAmount);
		                newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                System.out.println("$\t PLAYER WON " + betAmount + "$\t$");
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		            }
		            else {
		                newPlayer.setBalance(oldBalance - betAmount);
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
		                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		            }
		        }}

		        else {
		            long betAmount = setBet();
		            if (betAmount > newPlayer.getBalance()) {
		                System.out.println("Balance exceeded, please enter an amount within your limit.");
		            }
		            else {
		                String result = puntoBanco.puntoBancoGame();
		                System.out.println(result);

		                long oldBalance = newPlayer.getBalance();		                
		                if(result.equals("t")) {
		                    newPlayer.setBalance(oldBalance + (betAmount*5));
		                    newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
		                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER WON " + (betAmount*5) + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		                else {
		                    newPlayer.setBalance(oldBalance - betAmount);
		                    newPlayer.setBalance(oldBalance - betAmount);
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			                System.out.println("$\t PLAYER LOST " + betAmount + "$\t$");
			                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		                }
		            }
		        }
		    }
	    
	    }
	    
	private long setBet() {
			
			input = new Scanner(System.in);
			System.out.println("How much would you like to bet this round?");
			long betAmount = input.nextLong();
			return betAmount;
    }
	
	
	private String enterName() {
		input = new Scanner(System.in);
	    System.out.println("What is your name: ");
	    String name = input.nextLine().trim().toLowerCase();
	    return name;
	}
	
	
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;

		if (db.exists()) {
			Scanner fileReader = new Scanner(db);

			while (fileReader.hasNextLine()) {

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				
				String name = splittedLine[0].toLowerCase();
				long balance = Long.parseLong(splittedLine[1]);
				int numberOfWins = Integer.parseInt(splittedLine[2]);
				
				Player p = new Player(name,balance,numberOfWins);
				players.add(p);

			}

			fileReader.close();
		}

	}
	
	private void returnToMenu() {
		
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
