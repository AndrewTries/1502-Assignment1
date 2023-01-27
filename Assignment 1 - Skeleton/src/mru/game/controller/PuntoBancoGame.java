package mru.game.controller;


public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
public boolean gameWon = false;
	public int Balance = 100;
	public static CardDeck dec = new CardDeck();
public static int[] Getpoints() {
	

	Card playerH = dec.getDeck().remove(0);
	Card compH = dec.getDeck().remove(0);
	int playerP = playerH.getRank();
	if (playerP == 10 || playerP == 11 || playerP == 12 || playerP == 13) {
		playerP = 0;
	}
	int compP = compH.getRank();
	if (compP == 10 || compP == 11 || compP == 12 || compP == 13) {
		compP = 0;
		}
	Card playerH1 = dec.getDeck().remove(0);
	Card compH1 = dec.getDeck().remove(0);
	int playerP1 = playerH1.getRank();
	if (playerP1 == 10 || playerP1 == 11 || playerP1 == 12 || playerP1 == 13) {
		playerP1 = 0;
	}
	int compP1 = compH1.getRank();
	if (compP1 == 10 || compP1 == 11 || compP1 == 12 || compP1 == 13) {
		compP1 = 0;
	}
    int totalC = (compP + compP1)%10;
    if (totalC ==18) {
    	totalC = 8;
    }
    int totalP = (playerP + playerP1)%10;
    if (totalP ==18) {
    	totalP = 8;
    }
	
	System.out.println("Player cards are : " + playerH + " and " + playerH1 + " total points are " + totalP);
	System.out.println("Computer cards are : " + compH + " and " + compH1+ " total points are " + totalC);
	int[] totalarr = {totalC, totalP};
	return totalarr;
	}
public static void method( int[] x) {
	if (dec.getDeck().size() <= 0) {
		dec = new CardDeck();
	}
	int totalC = x[0];
	int totalP = x[1];
	boolean cardDraw = false;
	Card playerH3 = dec.getDeck().remove(0);
	int playerP3 = playerH3.getRank();
	Card compH3 = dec.getDeck().remove(0);
	int compP3 = compH3.getRank();
if ( (totalC == 8 || totalC == 9) || (totalP == 8 || totalP == 9)) {

	if (totalC ==18) {
    	totalC = 8;
    }
	
	if (totalP ==18) {
    	totalP = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player looses epikly");
	}
	else if (totalP> totalC) {
		System.out.println("Player Wins epikly");
	}
	else {
		System.out.println("Its a tie epik");
	}
}
else if (totalP >= 0 && totalP<=5) {
	totalP = (totalP + playerP3)%10;
	System.out.println(playerH3);
	if (totalP ==18) {
    	totalP = 8;
    }
	cardDraw = true;
	if (totalC>totalP) {
		System.out.println("Player looses");
	System.out.println(totalP);
	}
	else if (totalP> totalC) {
		System.out.println("Player Wins");
		System.out.println(totalP);
	}
	else {
		System.out.println("Its a tie");
		System.out.println(totalP);
	}
	}
else if ( ( totalC <= 5 ) && (cardDraw = false) ) {
	totalC = (totalC + compP3)%10;
	if (totalC ==18) {
    	totalC = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player loosesss");
	}
	else if (totalP> totalC) {
		System.out.println("Player Winsss");
	}
	else {
		System.out.println("Its a tieee");
	}
	
} 
else if ((playerP3 == 2 || playerP3 == 3) && (cardDraw= true) && (totalC <=4) ) {
	totalC = (totalC + compP3)%10;
	if (totalC ==18) {
    	totalC = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player loosesrr");
	}
	else if (totalP> totalC) {
		System.out.println("Player Winsrr");
	}
	else {
		System.out.println("Its a tierr");
	}
}
else if ((playerP3 == 4 || playerP3 == 5) && (cardDraw= true) && (totalC <=5) ) {
	totalC = (totalC + compP3)%10;
	if (totalC ==18) {
    	totalC = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player looseszz");
	}
	else if (totalP> totalC) {
		System.out.println("Player Winszz");
	}
	else {
		System.out.println("Its a tiezz");
	}
}
else if ((playerP3 == 6 || playerP3 == 7) && (cardDraw= true) && (totalC <=6) ) {
	totalC = (totalC + compP3)%10;
	if (totalC ==18) {
    	totalC = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player loosesff");
	}
	else if (totalP> totalC) {
		System.out.println("Player Winsff");
	}
	else {
		System.out.println("Its a tieff");
	}
	
}
else if ((playerP3 == 8) && (cardDraw= true) && (totalC <=2) ) {
	totalC = (totalC + compP3)%10;
	if (totalC ==18) {
    	totalC = 8;
    }
	if (totalC>totalP) {
		System.out.println("Player loosesgg");
	}
	else if (totalP> totalC) {
		System.out.println("Player Winsgg");
	}
	else {
		System.out.println("Its a tiegg");
	}
	
}
System.out.println(dec.getDeck().size());

}
}
