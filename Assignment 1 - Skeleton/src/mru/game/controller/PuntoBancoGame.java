package mru.game.controller;

import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;


public static CardDeck cards = new CardDeck();
public String puntoBancoGame() {

	final int SET_ZERO = 0;
	final int MODULO = 10;
	boolean playerWin = false;
	boolean dealerWin = false;
	boolean gameTie = false;


		//Card playerHand = cards.getDeck().remove(0);
		Card playerCard1 = cards.getDeck().remove(0);
		Card playerCard2 = cards.getDeck().remove(0);
		//Card dealerHand = cards.getDeck().remove(0);
		Card dealerCard1 = cards.getDeck().remove(0);
		Card dealerCard2 = cards.getDeck().remove(0);

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

		System.out.printf("%s %s\n", playerCard1, playerCard2);
		System.out.printf("%s %s\n", dealerCard1, dealerCard2);
		System.out.println(playerHandValue);
		System.out.println(dealerHandValue);

		String result;
		if(playerHandValue == 8 || playerHandValue == 9 || dealerHandValue == 8 || dealerHandValue == 9) {
			System.out.printf("%s %s\n", playerHandValue, dealerHandValue);
			if(playerHandValue > dealerHandValue) {
				System.out.println("Player Wins!");
			    result = "p";			
			}
			else if(playerHandValue < dealerHandValue) {
				System.out.println("Dealer Wins!");
			     result = "d";
			}
			else {				
				System.out.println("Game Tied");
		        result = "t";
			}
			System.out.println("\t\t - PUNTO BANCO - \t\t");
		    System.out.println("+===================+===================+");
		    System.out.println("||PLAYER            |DEALER            ||");
		    System.out.println("+===================+===================+");
		    System.out.println("| " + playerCard1 + "|" + dealerCard1 +           "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("| " + playerCard2 + "|" + dealerCard2 +           "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("|                   |                   |");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
		    System.out.println("+===================+===================+");
		}
		else if(playerHandValue >= 0 && playerHandValue < 6) {
			Card playerCard3 = cards.getDeck().remove(0);
			int playerValue3 = playerCard3.getRank();
			if(playerValue3 > 9 && playerValue3 < 14) {
				playerValue3 = SET_ZERO;					
			}

			if((playerValue3 == 2 || playerValue3 == 3) && dealerHandValue >= 0 && dealerHandValue < 5) {
				Card dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
				System.out.printf("%s ", playerCard3);
				System.out.printf("%s ", dealerCard3);
				System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
				if(playerHandValue > dealerHandValue) {
					System.out.println("Player Wins!");
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
					System.out.println("Dealer Wins!");
				     result = "d";
				}
				else {				
					System.out.println("Game Tied");
			        result = "t";
				}
				System.out.println("\t\t - PUNTO BANCO - \t\t");
			    System.out.println("+===================+===================+");
			    System.out.println("||PLAYER            |DEALER            ||");
			    System.out.println("+===================+===================+");
			    System.out.println("| " + playerCard1 + "|" + dealerCard1 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard2 + "|" + dealerCard2 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard3 + "|" + dealerCard3 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
			    System.out.println("+===================+===================+");
			}
			else if((playerValue3 == 4 || playerValue3 == 5) && (dealerHandValue >= 0 && dealerHandValue < 6)) {
				Card dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
				System.out.printf("%s ", playerCard3);
				System.out.printf("%s ", dealerCard3);
				System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
				if(playerHandValue > dealerHandValue) {
					System.out.println("Player Wins!");
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
					System.out.println("Dealer Wins!");
				     result = "d";
				}
				else {				
					System.out.println("Game Tied");
			        result = "t";
				}
				System.out.println("\t\t - PUNTO BANCO - \t\t");
			    System.out.println("+===================+===================+");
			    System.out.println("||PLAYER            |DEALER            ||");
			    System.out.println("+===================+===================+");
			    System.out.println("| " + playerCard1 + "|" + dealerCard1 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard2 + "|" + dealerCard2 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard3 + "|" + dealerCard3 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
			    System.out.println("+===================+===================+");
			}
			else if(playerValue3 == 8 && (dealerHandValue >= 0 && dealerHandValue < 3)) {
				Card dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
				System.out.printf("%s ", playerCard3);
				System.out.printf("%s ", dealerCard3);
				System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
				if(playerHandValue > dealerHandValue) {
					System.out.println("Player Wins!");
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
					System.out.println("Dealer Wins!");
				     result = "d";
				}
				else {				
					System.out.println("Game Tied");
			        result = "t";
				}
				System.out.println("\t\t - PUNTO BANCO - \t\t");
			    System.out.println("+===================+===================+");
			    System.out.println("||PLAYER            |DEALER            ||");
			    System.out.println("+===================+===================+");
			    System.out.println("| " + playerCard1 + "|" + dealerCard1 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard2 + "|" + dealerCard2 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard3 + "|" + dealerCard3 +           "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
			    System.out.println("+===================+===================+");
			}
			else if((playerValue3 == 1 || playerValue3 == 9 || playerValue3 == 10)){
				Card dealerCard3 = cards.getDeck().remove(0);
				int dealerValue3 = dealerCard3.getRank();
				if(dealerValue3 > 9 && dealerValue3 < 14) {
					dealerValue3 = SET_ZERO;					
				}
				playerHandValue = (playerHandValue + playerValue3)%MODULO;
				dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
				System.out.printf("%s ", playerCard3);
				System.out.printf("%s ", dealerCard3);
				System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
				if(playerHandValue > dealerHandValue) {
					System.out.println("Player Wins!");
				    result = "p";			
				}
				else if(playerHandValue < dealerHandValue) {
					System.out.println("Dealer Wins!");
				     result = "d";
				}
				else {				
					System.out.println("Game Tied");
			        result = "t";
				}
				System.out.println("\t\t - PUNTO BANCO - \t\t");
			    System.out.println("+===================+===================+");
			    System.out.println("||PLAYER            |DEALER            ||");
			    System.out.println("+===================+===================+");
			    System.out.println("| " + playerCard1 +"|" + dealerCard1 + "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard2 +"|" + dealerCard2 + "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("| " + playerCard3 +"|" + dealerCard3 + "|");
			    System.out.println("+-------------------+-------------------+");
			    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
			    System.out.println("+===================+===================+");
			}
			playerHandValue = (playerHandValue + playerValue3)%MODULO;				
			System.out.printf("%s ", playerCard3);				
			System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
			if(playerHandValue > dealerHandValue) {
				System.out.println("Player Wins!");
			    result = "p";			
			}
			else if(playerHandValue < dealerHandValue) {
				System.out.println("Dealer Wins!");
			     result = "d";
			}
			else {				
				System.out.println("Game Tied");
		        result = "t";
			}
			System.out.println("\t\t - PUNTO BANCO - \t\t");
		    System.out.println("+===================+===================+");
		    System.out.println("||PLAYER            |DEALER            ||");
		    System.out.println("+===================+===================+");
		    System.out.println("| " + playerCard1 +"|" + dealerCard1 + "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("| " + playerCard2 +"|" + dealerCard2 + "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("| " + playerCard3 +"|"  +              "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
		    System.out.println("+===================+===================+");
		}
		else /*(playerDraw == false && dealerHandValue >= 0 && dealerHandValue < 6 && dealerHandValue != 6 && dealerHandValue !=7)*/{
			Card dealerCard3 = cards.getDeck().remove(0);
			int dealerValue3 = dealerCard3.getRank();
			if(dealerValue3 > 9 && dealerValue3 < 14) {
				dealerValue3 = SET_ZERO;					
			}
			dealerHandValue = (dealerHandValue + dealerValue3)%MODULO;
			System.out.printf("%s \n", dealerCard3);
			System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
			if(playerHandValue > dealerHandValue) {
				System.out.println("Player Wins!");
			    result = "p";					    
			}
			else if(playerHandValue < dealerHandValue) {
				System.out.println("Dealer Wins!");
			     result = "d";
			}
			else {				
				System.out.println("Game Tied");
		        result = "t";
			}
			System.out.println("\t\t - PUNTO BANCO - \t\t");
		    System.out.println("+===================+===================+");
		    System.out.println("||PLAYER            |DEALER            ||");
		    System.out.println("+===================+===================+");
		    System.out.println("| " + playerCard1 +"|" + dealerCard1 + "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("| " + playerCard2 +"|" + dealerCard2 + "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("|                   |" + dealerCard3 + "|");
		    System.out.println("+-------------------+-------------------+");
		    System.out.println("|PLAYER POINTS: " + playerHandValue + " |DEALER POINTS" + dealerHandValue + "|");
		    System.out.println("+===================+===================+");
		}
return result;
}


private int getValue(Card card) {
  int value = card.getRank();
  if (value > 9 && value < 14) {
    value = 0;
  }
  return value;
}

	
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

}

