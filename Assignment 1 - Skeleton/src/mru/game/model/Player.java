package mru.game.model;

/**
 * @author Adrew Krawiec and Egor Galiulin
 * This class represent each player record in the Database
 * It is basically a model class for each record in the txt file
 */
public class Player {
	/**
	 * declaring the variables that will be used later in this class
	 */
	private String name;
	private long balance;
	private int numberOfWins;
	
	/**
	 * The constructor of this class, contains all the values
	 */
	public Player (String name, long balance, int numberOfWins) {
		this.name = name;
		this.balance = balance; 
		this.numberOfWins = numberOfWins;
	}
	/**
	 * setter class to be used later to assign name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter class for name variable that will be used to retrive data from the txt file
	 */
	public String getName() {
		return name;
	}
	/** 
	 * setter class for Balance variable
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
	/**
	 * getter class for balance to be later used to retrive data from the txt file
	 */
	public long getBalance() {
		return balance;
	}
	/** 
	 * setter class for number of wins variable
	 */
	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}
	/**
	 * getter class for number of wins to be later used to retrive data from the txt file
	 */
	public int getNumberOfWins() {
		return numberOfWins;
	}
	/**
	 * method to be used to print the data in the txt file in a nice format
	 */
	public String toString() {
		return "Name: " + name + " Balance: " + balance + " Number of Wins: " + numberOfWins;
	}
	/** 
	 * sets format to the data stored on the txt file
	 */
	public String format() {
		return name+","+balance+","+numberOfWins;
	}
	
	
}
