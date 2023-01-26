package mru.lab1.application;

import java.util.Scanner;

/**
 * 
 * @author Egor Galiulin
 * @version 1.0
 *
 */
public class PizzaOrder {
	/**
	 * 
	 * @param Start of the project
	 */
	public static void main(String[] args) {
		// Create a Scanner object to read input.
		Scanner keyboard = new Scanner(System.in);

		String firstName; // User's first name
		boolean discount = false; // Flag for discount
		int inches; // Size of the pizza
		char crustType; // For type of crust
		String crust = "Hand-tossed"; // Name of crust
		double cost = 12.99; // Cost of the pizza
		final double TAX_RATE = .08; // Sales tax rate
		double tax; // Amount of tax
		char choice; // User's choice
		String input; // User input
		String toppings = "Cheese "; // List of toppings
		int numberOfToppings = 0; // Number of toppings

		// Prompt user and get first name.
		System.out.println("Welcome to Mike and " + "Diane's Pizza");
		System.out.print("Enter your first name: ");
		firstName = keyboard.nextLine();

		if (firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Diane")) {
			System.out.println("You are eligible for a discount!");
			discount = true;
		} else {
			System.out.println("You are not eligible for a discount");
		}

		// ADD LINES HERE FOR TASK #2.2 and 2.3
		// Determine if user is eligible for discount by
		// having the same first name as one of the owners.

		// Prompt user and get pizza size choice.
		System.out.println("Pizza Size (inches)   Cost");
		System.out.println("        10            $10.99");
		System.out.println("        12            $12.99");
		System.out.println("        14            $14.99");
		System.out.println("        16            $16.99");
		System.out.println("What size pizza " + "would you like?");
		System.out.print("10, 12, 14, or 16 " + "(enter the number only): ");
		inches = keyboard.nextInt();

		if (inches == 10) {
			System.out.println("You selected: 10 inch. Cost: 10.99$");
			cost = 10.99;
		} else if (inches == 12) {
			System.out.println("You selected: 12 inch pizza. Cost: 12.99$");
			cost = 12.99;
		} else if (inches == 14) {
			System.out.println("You selected: 14 inch. Cost: 14.99$");
			cost = 14.99;
		} else if (inches == 16) {
			System.out.println("You selected: 16 inch. Cost: 16.99$");
			cost = 16.99;
		} else {
			System.out.println("Invalid selection, default size is 12 inches. Cost: 12.99$");
			cost = 12.99;
		}

		// ADD LINES HERE FOR TASK #2.4 and 2.5
		// Set price and size of pizza ordered.

		// Consume the remaining newline character.
		keyboard.nextLine();

		// Prompt user and get crust choice.
		System.out.println("What type of crust " + "do you want? ");
		System.out.print("(H)Hand-tossed, " + "(T) Thin-crust, or " + "(D) Deep-dish " + "(enter H, T, or D): ");
		input = keyboard.nextLine();
		crustType = input.charAt(0);

		switch (crustType) {
		case 'H':
			crust = "Hand-Tossed";
			System.out.println("You selected a Hand-Tossed Crust");
			break;
		case 'h':
			crust = "Hand-Tossed";
			System.out.println("You selected a Hand-Tossed Crust");
			break;
		case 'T':
			crust = "Thin-Crust";
			System.out.println("You selected a Thin Crust");
			break;
		case 't':
			crust = "Thin-Crust";
			System.out.println("You selected a Thin Crust");
			break;
		case 'D':
			crust = "Deep-Dish";
			System.out.println("You selected a Deep-Dish Crust");
			break;
		case 'd':
			crust = "Deep-Dish";
			System.out.println("You selected a Deep-Dish Crust");
			break;
		default:
			crust = "Hand-Tossed";
			System.out.println("Your input is invalid, selection was defaulted to " + crust);
		}

		// ADD LINES FOR TASK #3
		// Set user's crust choice on pizza ordered.
		if (discount) {
			System.out.println("You are eligible for a 2.00$ discount");
			cost = cost - 2;
		}
		// Prompt user and get topping choices one at a time.
		System.out.println("All pizzas come with cheese.");
		System.out.println("Additional toppings are " + "$1.25 each, choose from:");
		System.out.println("Pepperoni, Sausage, " + "Onion, Mushroom");

		// If topping is desired,
		// add to topping list and number of toppings
		System.out.print("Do you want Pepperoni? (Y/N): ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y') {
			numberOfToppings += 1;
			toppings = toppings + "Pepperoni ";
		}
		System.out.print("Do you want Sausage? (Y/N): ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y') {
			numberOfToppings += 1;
			toppings = toppings + "Sausage ";
		}
		System.out.print("Do you want Onion? (Y/N): ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y') {
			numberOfToppings += 1;
			toppings = toppings + "Onion ";
		}
		System.out.print("Do you want Mushroom? (Y/N): ");
		input = keyboard.nextLine();
		choice = input.charAt(0);
		if (choice == 'Y' || choice == 'y') {
			numberOfToppings += 1;
			toppings = toppings + "Mushroom ";
		}

		// Add additional toppings cost to cost of pizza.
		cost = cost + (1.25 * numberOfToppings);

		// Display order confirmation.
		System.out.println();
		System.out.println("Your order is as follows: ");
		System.out.println(inches + " inch pizza");
		System.out.println(crust + " crust");
		System.out.println(toppings);

		// ADD LINES FOR TASK #4 HERE
		// Apply discount if user is eligible.

		// EDIT PROGRAM FOR TASK #5
		// SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES

		System.out.printf("Total cost: %.2f", cost);
		System.out.println(" Your order will be ready " + "for pickup in 30 minutes.");
	}
}
