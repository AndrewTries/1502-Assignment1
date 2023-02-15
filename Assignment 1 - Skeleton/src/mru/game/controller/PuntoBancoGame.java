package mru.game.controller;

import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;
/**
 * @author Andrew Krawiec
 */

/**
 * initializes CardDeck class
 */
public static CardDeck cards = new CardDeck();
/**
 * constructor of the Punto Banco Class that is responsible for running the game itself
 */
public String puntoBancoGame() {
	/**
	 *Intializing the values
	 *Set_Zero sets  the value of the hand to 0
	 *Modulo is needed in calculations, therefore it is set to the value of 10
	 *Boolean gamOver closes this method when activated
	 *String result is also initialized as null to be later populated by the game results to be used in other classes
	 */
	final int SET_ZERO = 0;
	final int MODULO = 10;
	boolean gameOver = false;
	String result = null;
	/**
	 * while the boolean is activated, 0 is removed from the deck and 3rd card is set to nothing to be played later
	 */
while(!gameOver) {
		//Card playerHand = cards.getDeck().remove(0);
		Card playerCard1 = cards.getDeck().remove(0);
		Card playerCard2 = cards.getDeck().remove(0);
		Card playerCard3 = null;
		//Card dealerHand = cards.getDeck().remove(0);
		Card dealerCard1 = cards.getDeck().remove(0);
		Card dealerCard2 = cards.getDeck().remove(0);
		Card dealerCard3 = null;
		/**
		 * gets the rank of the card from the value stored in the variable
		 */
		int playerValue1 = playerCard1.getRank();
		int dealerValue1 = dealerCard1.getRank();
		int playerValue2 = playerCard2.getRank();
		int dealerValue2 = dealerCard2.getRank();

		/**
		 * determine loose conditions
		 */
		if(playerValue1 > 9 && playerValue1 < 14) {
			playerValue1 = SET_ZERO;
		}
		if(playerValue2 > 9 && playerValue2 < 14) {
			playerValue1 = SET_ZERO;
		}
		if(dealerValue1 > 9 && dealerValue1 < 14) {
			dealerValue1 = SET_ZERO;
		}
		if(dealerValue2 > 9 && dealerValue2 < 14) {
			dealerValue2 = SET_ZERO;
		}
		
		/**
		 * intitializes the variable and assigns a formula to get the value of it
		 */
		int playerHandValue =(playerValue1+playerValue2)%MODULO;
		int dealerHandValue =(dealerValue1+dealerValue2)%MODULO;
		
		/**
		 *prints result depending on the outcome of the game and closes the class when the right condition is achived
		 */
		if(playerHandValue == 8 || playerHandValue == 9 || dealerHandValue == 8 || dealerHandValue == 9) {
			if(playerHandValue > dealerHandValue) {
			    result = "p";			
			}
			else if(playerHandValue < dealerHandValue) {
			     result = "d";
			}
			else {
		        result = "t";
			}
			gameOver = true;
		    
		}
		else if(playerHandValue >= 0 && playerHandValue < 6) {
			playerCard3 = cards.getDeck().remove(0);
			int playerValue3 = playerCard3.getRank();
			if(playerValue3 > 9 && playerValue3 < 14) {
				playerValue3 = SET_ZERO;					
			}

			if((playerValue3 == 2 || playerValue3 == 3) && dealerHandValue >= 0 && dealerHandValue < 5) {
				dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;				
				if(playerHandValue > dealerHandValue) {
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
				     result = "d";
				}
				else {
			        result = "t";
				}
				gameOver = true;
			}
			else if((playerValue3 == 4 || playerValue3 == 5) && (dealerHandValue >= 0 && dealerHandValue < 6)) {
				dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;				
				if(playerHandValue > dealerHandValue) {
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
				     result = "d";
				}
				else {
			        result = "t";
				}
				gameOver = true;
			}
			else if(playerValue3 == 8 && (dealerHandValue >= 0 && dealerHandValue < 3)) {
				dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;				
				if(playerHandValue > dealerHandValue) {
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
				     result = "d";
				}
				else {
			        result = "t";
				}
				gameOver = true;
			}
			else if((playerValue3 == 1 || playerValue3 == 9 || playerValue3 == 10)){
				dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
				if(playerHandValue > dealerHandValue) {
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
				     result = "d";
				}
				else {
			        result = "t";
				}
				gameOver = true;
			}
			playerHandValue = (playerHandValue + playerValue3)%MODULO;
			if(playerHandValue > dealerHandValue) {
			    result = "p";			
			}
			else if(playerHandValue < dealerHandValue) {
			     result = "d";
			}
			else {
		        result = "t";
			}
			gameOver = true;
		}
		else {
			dealerCard3 = cards.getDeck().remove(0);
			int dealerValue3 = dealerCard3.getRank();
			if(dealerValue3 > 9 && dealerValue3 < 14) {
				dealerValue3 = SET_ZERO;					
			}
			dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
			if(playerHandValue > dealerHandValue) {
			    result = "p";					    
			}
			else if(playerHandValue < dealerHandValue) {
			     result = "d";
			}
			else {
		        result = "t";
			}
			gameOver = true;
		}
		
		/**
		 *table of results of the game
		 */
	    System.out.println("\n             - PUNTO BANCO -             ");
	    System.out.println("+===================+===================+");
	    System.out.println("||PLAYER            |DEALER            ||");
	    System.out.println("+===================+===================+");
	    System.out.printf("|%-19s|%-19s|\n", playerCard1, dealerCard1);
	    System.out.println("+-------------------+-------------------+");
	    System.out.printf("|%-19s|%-19s|\n", playerCard2, dealerCard2);;
	    System.out.println("+-------------------+-------------------+");
	    System.out.printf("|%-19s|%-19s|\n", playerCard3, dealerCard3);
	    System.out.println("+-------------------+-------------------+");
	    System.out.printf("|PLAYER POINTS: %-4d|DEALER POINTS: %-4d|\n",playerHandValue, dealerHandValue);
	    System.out.println("+===================+===================+");	
	    return result;
}
return "p";
}
}
