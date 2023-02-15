package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

/**
 * 
 * @author Andrew Krawiec and Egor Galiulin
 *
 */
public class GameManager {
	private Scanner input = new Scanner(System.in);
	
	/**
	 * setting a path to the txt file that will be used as a data storage
	 */
	private final String FILE_PATH = "res//CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMenu;
	PuntoBancoGame puntoBanco;
	
	/**
	 * Game Manager is the constructor of this class
	 * @throws Exception
	 * contains the initializations for the array list and the AppMenu class to be used as a method
	 */
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMenu = new AppMenu();
		puntoBanco = new PuntoBancoGame();
		loadData();
		launchApplication();
	}
	
	/**
	 * method that launches the application, by showing the main menu and activating the switch statement for selections
	 * 
	 * @throws IOException
	 */
	private void launchApplication() throws IOException {
		
		boolean flag = true;
		char option;
		
		/**
		 * while loop that is used for the selection of the menu option, that closes after the correct option was entered
		 */
		while (flag) {
			option = appMenu.showMainMenu();
			/**
			 * switch case for main menu selection options entry
			 */
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
	
	/**
	 * This method is used to display the search option with its own menu
	 * @throws IOException
	 */
	private void searchApplication() throws IOException {
		/** 
		 * boolean is initialized as true to close it when the selection is made
		 */
		boolean flag = true;
		char option1;
		/** 
		 * while loop that is used for the selection of the menu option check, that closes after the correct option was entered
		 */
		while (flag) {
			option1 = appMenu.searchMenu();
			/**
			 * switch statement that checks the correctness of the entry and closes the loop
			 */
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
	
	/**
	 * method that is used for saving the entered information about the user and their balance into the text file
	 * @throws IOException
	 */
	private void save() throws IOException {
		File file = new File (FILE_PATH);
		PrintWriter printWrite = new PrintWriter(file);
		for (Player p: players) {
			printWrite.println(p.format());
		}
		printWrite.close();
		appMenu.exitProgram();
	}

	/**
	 * method used to display the menu, name, and number of wins of the top player
	 */
	private void topPlayer() {
	    players.sort((p1, p2) -> p2.getNumberOfWins() - p1.getNumberOfWins());

	    System.out.println("		 - TOP PLAYERS -			");
	    System.out.println("+===============+===============+===============+");
	    System.out.println("|RANK           |NAME           |# WINS         |");
	    System.out.println("+===============+===============+===============+");
	    /**
	     * for loop that formats the outputed name and number of wins into the proper format
	     */
	    for (int i = 0; i < players.size() && i < 5; i++) {
	        Player player = players.get(i);
	        System.out.println("|" + (i + 1) + "              |" + player.getName() + "\t\t|" + player.getNumberOfWins() + "\t\t|");
	        System.out.println("+---------------+---------------+---------------+");
	    }
	}
	
	/**
	 * method used to search for a specific player by their name
	 * boolean is initialized as false, to be checked by comparing the entered name against the names stored in the txt file
	 * if the name was found, the boolean is set to true and shows the proper information in the field
	 * if the name was not found, shows the error message
	 */
	public void playerSearch() {
	    String name = appMenu.enterName();
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
	
	/**
	 * Method that prints the game interface depending on the name check
	 * 
	 */
	private void gameInterface() {
	    String name = appMenu.enterName();
	    boolean found = false;
	    for (Player player : players) {
	        if (player.getName().equals(name)) {
	            System.out.println("\n********************************************************************");
	            System.out.println("***   Welcome back " + player.getName() + "   ---   Your balance is: " + player.getBalance() + "$        ***");
	            System.out.println("********************************************************************\n");
	            char option2;
	            do {
	                option2 = appMenu.gameMenu();
	                if (option2 == 'p') {
	                    long betAmount = appMenu.setBet();
	                    if (betAmount > player.getBalance()) {
	                        System.out.println("Balance exceeded, please enter an amount within your limit.");
	                    } else {
	                        String result = puntoBanco.puntoBancoGame();

	                        long oldBalance = player.getBalance();
	                        if (result.equals("p")) {
	                            player.setBalance(oldBalance + betAmount);
	                            player.setNumberOfWins(player.getNumberOfWins() + 1);
	                            appMenu.playerWin(betAmount);
	                        } else {
	                            player.setBalance(oldBalance - betAmount);
	                            appMenu.playerLose(betAmount);
	                        }
	                    }
	                } else if (option2 == 'd') {
	                    long betAmount = appMenu.setBet();
	                    if (betAmount > player.getBalance()) {
	                        System.out.println("Balance exceeded, please enter an amount within your limit.");
	                    } else {
	                        String result = puntoBanco.puntoBancoGame();

	                        long oldBalance = player.getBalance();
	                        if (result.equals("d")) {
	                            player.setBalance(oldBalance + betAmount);
	                            player.setNumberOfWins(player.getNumberOfWins() + 1);
	                            appMenu.playerWin(betAmount);
	                        } else {
	                            player.setBalance(oldBalance - betAmount);
	                            appMenu.playerLose(betAmount);
	                        }
	                    }
	                } else {
	                    long betAmount = appMenu.setBet();
	                    if (betAmount > player.getBalance()) {
	                        System.out.println("Balance exceeded, please enter an amount within your limit.");
	                    } else {
	                        String result = puntoBanco.puntoBancoGame();

	                        long oldBalance = player.getBalance();
	                        if (result.equals("t")) {
	                            player.setBalance(oldBalance + (betAmount * 5));
	                            player.setNumberOfWins(player.getNumberOfWins() + 1);
	                            appMenu.playerTie(betAmount);
	                        } else {
	                            player.setBalance(oldBalance - betAmount);
	                            appMenu.playerLose(betAmount);
	                        }
	                    }
	                }
	                if (!appMenu.playAgain()) {
	                    break;
	                }
	            } while (true);
	            found = true;
	            break;
	        }
	    }
	    /**
	     * if the name does not exist in the txt file, the method prints the regular "Welcome" message and assigns 100$ to a user
	     *
	     */
		if (!found) {
		    System.out.println("********************************************************************");
		    System.out.println("***   Welcome " + name + "   ---   Your balance is: 100 $        ***");
		    System.out.println("********************************************************************");
		    Player newPlayer = new Player(name, 100, 0);
		    players.add(newPlayer);
		    char option2;
		    do {
		    option2 = appMenu.gameMenu();
		    /**
	         * if statements are used to check the result of the game, check if the bet is exceding the amount of money on the balance,
	         * and print the side that won
	         */
		    if(option2 == 'p') {
		        long betAmount = appMenu.setBet();
	            if (betAmount > newPlayer.getBalance()) {
	                System.out.println("Balance exceeded, please enter an amount within your limit.");
	            }
	            else {
	                String result = puntoBanco.puntoBancoGame();

	                long oldBalance = newPlayer.getBalance();		               
	                if(result.equals("p")) {
	                    newPlayer.setBalance(oldBalance + betAmount);
	                    newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
	                    appMenu.playerWin(betAmount);
	                }
	                else {
	                    newPlayer.setBalance(oldBalance - betAmount);
	                    appMenu.playerLose(betAmount);
	                }
	            }
	        }
	        else if(option2 == 'd'){
	            long betAmount = appMenu.setBet();
	            if (betAmount > newPlayer.getBalance()) {
	                System.out.println("Balance exceeded, please enter an amount within your limit.");
	            }
	            else {
	                String result = puntoBanco.puntoBancoGame();

	                long oldBalance = newPlayer.getBalance();		                
	                if(result.equals("d")) {
	                    newPlayer.setBalance(oldBalance + betAmount);
	                    newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
	                    appMenu.playerWin(betAmount);
	                }
	                else {
	                    newPlayer.setBalance(oldBalance - betAmount);
	                    appMenu.playerLose(betAmount);
	                }
	            }
	        }
	        else {
	            long betAmount = appMenu.setBet();
	            if (betAmount > newPlayer.getBalance()) {
	                System.out.println("Balance exceeded, please enter an amount within your limit.");
	            }
	            else {
	                String result = puntoBanco.puntoBancoGame();		                

	                long oldBalance = newPlayer.getBalance();
	                if(result.equals("t")) {
	                    newPlayer.setBalance(oldBalance + (betAmount*5));
	                    newPlayer.setNumberOfWins(newPlayer.getNumberOfWins()+1);
	                    appMenu.playerTie(betAmount);
	                }
	                else {
	                    newPlayer.setBalance(oldBalance - betAmount);
	                    appMenu.playerLose(betAmount);
	                }
	            }
	        }            
	        break;
	    }while (appMenu.playAgain());
		}
	}

	
	/**
	 * loads the data from the txt file to be accessed by methods
	 * @throws Exception
	 */
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
	
	/**
	 * method that returns the user to the main menu if activated
	 */
	private void returnToMenu() {
		
	}
}

