package mru.game.controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;


	
//	public PuntoBancoGame(Player[] players) {
//		System.out.println("What is your name?: ");
//		String name = input.nextLine().trim().toLowerCase();
//		
//		for (Player pl : players) {
//			if (input.equals(name)) {
//				System.out.println("***********************");
//				System.out.println("*** Welcome back "+name+" --- Your Balance is: "+balance+" $ ***");
//				System.out.println("***********************");
//				break;
//			}
//			else {
//				PrintWriter write = new PrintWriter ("res/CasinoInfo.txt");
//				write.println(name+"100"+"0");
//				write.close();
//				System.out.println("New account has been created for " + name+" your balance is "+balance+" $");
//			}
//		}
//		boolean done = false;
//
//		for (int index = 0; index < players.size() && !done; index++) {
//			if (players.get(index).getName()) {
//				double oldBalance = players.get(index).getBalance();
//				players.get(index).setBalance(oldBalance);
//				done = true;
//			}
//			return oldBalance;
//			
//		}
//			
//	}


    
public static CardDeck cards = new CardDeck();

public void puntoBancoGame() {
  final int MODULO = 10;

  Card playerCard1 = cards.getDeck().remove(0);
  Card playerCard2 = cards.getDeck().remove(0);
  Card dealerCard1 = cards.getDeck().remove(0);
  Card dealerCard2 = cards.getDeck().remove(0);

  int playerHandValue = (getValue(playerCard1) + getValue(playerCard2)) % MODULO;
  int dealerHandValue = (getValue(dealerCard1) + getValue(dealerCard2)) % MODULO;

  System.out.printf("%s %s\n", playerCard1, playerCard2);
  System.out.printf("%s %s\n", dealerCard1, dealerCard2);
  System.out.println(playerHandValue);
  System.out.println(dealerHandValue);

  String result;
  if (playerHandValue == 8 || playerHandValue == 9 || dealerHandValue == 8 || dealerHandValue == 9) {
    System.out.printf("%s %s\n", playerHandValue, dealerHandValue);
    if (playerHandValue > dealerHandValue) {
      System.out.println("Player Wins!");
      result = "p";
    } else if (playerHandValue < dealerHandValue) {
      System.out.println("Dealer Wins!");
      result = "d";
    } else {
      System.out.println("Game Tied");
      result = "t";
    }
  } else if (playerHandValue >= 0 && playerHandValue < 6) {
    Card playerCard3 = cards.getDeck().remove(0);
    int playerValue3 = getValue(playerCard3);
    if (playerValue3 == 2 || playerValue3 == 3) {
      if (dealerHandValue >= 0 && dealerHandValue < 5) {
        Card dealerCard3 = cards.getDeck().remove(0);
        int dealerValue3 = getValue(dealerCard3);
        playerHandValue = (playerHandValue + playerValue3) % MODULO;
        dealerHandValue = (dealerHandValue + dealerValue3) % MODULO;
        System.out.printf("%s ", playerCard3);
        System.out.printf("%s ", dealerCard3);
        System.out.printf("%s %s \n", playerHandValue, dealerHandValue);
        if (playerHandValue > dealerHandValue) {
          System.out.println("Player Wins!");
          result = "p";
        } else if (playerHandValue < dealerHandValue) {
          System.out.println("Dealer Wins!");
          result = "d";
        } else {
          System.out.println("Game Tied");
          result = "t";
        }
      }
    }
  }
//  if (result.equals("Player Wins!") && betType.equals("player")) {
//      balance += betAmount;
//      
//  }
}

private int getValue(Card card) {
  int value = card.getRank();
  if (value > 9 && value < 14) {
    value = 0;
  }
  return value;
}

			
	
	private static int playerDraw3() {
		CardDeck cards = new CardDeck();
		final int SET_ZERO = 0;
		Card playerCard3 = cards.getDeck().remove(0);
		int playerValue3 = playerCard3.getRank();
		if(playerValue3 > 9 && playerValue3 < 14) {
			playerValue3 = SET_ZERO;					
		}
		return playerValue3;
	}
	private static int dealerDraw3() {
		CardDeck cards = new CardDeck();
		final int SET_ZERO = 0;
		Card dealerCard3 = cards.getDeck().remove(0);
		int dealerValue3 = dealerCard3.getRank();
		if(dealerValue3 > 9 && dealerValue3 < 14) {
			dealerValue3 = SET_ZERO;					
		}
		return dealerValue3;
	}
	
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

}
