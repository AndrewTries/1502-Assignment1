package mru.game.controller;

import java.util.Scanner;

public class PuntoBancoGame {
	
private Scanner input;


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
 //if (result.equals("Player Wins!") && betType.equals("player")) {
 //     balance += betAmount;
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

	
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

}
