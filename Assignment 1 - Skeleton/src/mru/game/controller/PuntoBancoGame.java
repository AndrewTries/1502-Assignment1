package mru.game.controller;

import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;


public static CardDeck cards = new CardDeck();
public String puntoBancoGame() {

	final int SET_ZERO = 0;
	final int MODULO = 10;
	boolean gameOver = false;
	String result = null;

while(!gameOver) {
		//Card playerHand = cards.getDeck().remove(0);
		Card playerCard1 = cards.getDeck().remove(0);
		Card playerCard2 = cards.getDeck().remove(0);
		Card playerCard3 = null;
		//Card dealerHand = cards.getDeck().remove(0);
		Card dealerCard1 = cards.getDeck().remove(0);
		Card dealerCard2 = cards.getDeck().remove(0);
		Card dealerCard3 = null;

		int playerValue1 = playerCard1.getRank();
		int dealerValue1 = dealerCard1.getRank();
		int playerValue2 = playerCard2.getRank();
		int dealerValue2 = dealerCard2.getRank();


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

		int playerHandValue =(playerValue1+playerValue2)%MODULO;
		int dealerHandValue =(dealerValue1+dealerValue2)%MODULO;
		
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
		
		// print menu after game is over
	    System.out.println("             - PUNTO BANCO -             ");
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
