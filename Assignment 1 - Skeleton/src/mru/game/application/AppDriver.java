package mru.game.application;


import mru.game.controller.Card;
import mru.game.controller.CardDeck;
import mru.game.controller.GameManager;
import mru.game.controller.PuntoBancoGame;
import mru.game.view.AppMenu;

public class AppDriver {

	public static void main(String[] args) {
		
		// This is the starting point of the project!
		// hint - It usually calls method from GameManager class to start the app, so only one or two lines will be written here
		//PuntoBancoGame pbc = new PuntoBancoGame();
		GameManager gm = new GameManager();
		gm.Display();
		 
		
	}

}
