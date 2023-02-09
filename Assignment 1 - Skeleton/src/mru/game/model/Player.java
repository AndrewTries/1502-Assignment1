package mru.game.model;

/**
 * This class represent each player record in the Database
 * It is basically a model class for each record in the txt file
 */
public class Player {
	
	private String name;
	private long balance;
	private int numberOfWins;
	
	
	public Player (String name, long balance, int numberOfWins) {
		this.name = name;
		this.balance = balance; 
		this.numberOfWins = numberOfWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}
	
	public double getNumberOfWins() {
		return numberOfWins;
	}
	
	public String toString() {
		return "Name: " + name + " Balance: " + balance + " Number of Wins: " + numberOfWins;
	}
	
	public String format() {
		return name+","+balance+","+numberOfWins;
	}
	
	
}
