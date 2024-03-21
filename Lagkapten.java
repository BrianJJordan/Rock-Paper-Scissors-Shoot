import java.util.Random;
import java.util.Scanner;

public class Lab4 {
	public static Scanner input = new Scanner (System.in);
	
	public static void rules() {
		System.out.println("Lagkapten Game Rules:");
		System.out.println("During each round, players choose a move, "
				+ "which may be either Olserod, Knarrevik, Utespelare,"
				+ " Yngvar, or Melltorp:");
		System.out.println("\nMelltorp beats Utespelare, Olserod\r\n"
				+ "Utespelare beats Knarrevik, Yngvar\r\n"
				+ "Knarrevik beats Melltorp, Olserod\r\n"
				+ "Olserod Beats Yngvar, Utespelare\r\n"
				+ "Yngvar beats Melltorp, Knarrevik");
		System.out.println("\nDo you want to play? 'y' or 'n'");	
	}


	public static String ComputersChoice(int options) { 
		return FindChoice(options);
	}


	public static String UsersChoice(int humansChoice) {	
		return FindChoice(humansChoice);
	}


	// based on CPU's RNG & users input (Numbers 1-5), chooses a game option
	public static String FindChoice(int choice) {
		String gameChoice = "";
		switch (choice) { // this decides what the CPU's choice is based on the RNG
		case 1:
			gameChoice = "Olserod";
			break;
		case 2:
			gameChoice = "Knarrevik";
			break;
		case 3:
			gameChoice = "Utespelare";
			break;
		case 4:
			gameChoice = "Yngvar";
			break;
		case 5:
			gameChoice = "Melltorp";
			break;
		}
		return gameChoice;
	}


	public static void FindWinner(int humansChoice, int options) {
		String computersChoice = ComputersChoice(options);
//		System.out.println("FindWinner(): " + ComputersChoice(options)); // *TEST* to show what the function prints 
		
		String usersChoice = UsersChoice(humansChoice);
		
		if (computersChoice.equals(usersChoice)) {
			System.out.println("Computer wins due a tie :(");
		}
		else if (computersChoice.equals("Melltorp") && (usersChoice.equals("Utespelare") || usersChoice.equals("Olserod"))){
			System.out.println("Computer wins because " + ComputersChoice(options) + " beats " + UsersChoice(humansChoice));
		}
		else if (computersChoice.equals("Utespelare") && (usersChoice.equals("Knarrevik") || usersChoice.equals("Yngvar"))){
			System.out.println("Computer wins because " + ComputersChoice(options) + " beats " + UsersChoice(humansChoice));
		}
		else if (computersChoice.equals("Knarrevik") && (usersChoice.equals("Melltorp") || usersChoice.equals("Olserod"))){
			System.out.println("Computer wins because " + ComputersChoice(options) + " beats " + UsersChoice(humansChoice));
		}
		else if (computersChoice.equals("Olserod") && (usersChoice.equals("Yngvar") || usersChoice.equals("Utespelare"))){
			System.out.println("Computer wins because " + ComputersChoice(options) + " beats " + UsersChoice(humansChoice));
		}
		else if (computersChoice.equals("Yngvar") && (usersChoice.equals("Melltorp") || usersChoice.equals("Knarrevik"))){
			System.out.println("Computer wins because " + ComputersChoice(options) + " beats " + UsersChoice(humansChoice));
		}
		else {
			System.out.println("You win because " + UsersChoice(humansChoice) + " beats " + ComputersChoice(options));
		}
	}

	public static void main(String[] args) {
		
	rules(); //gives rules of the game
		
		String answer = input.next(); // Asks if user wants to play or not
		
		if (answer.equals("y") || answer.equals("Y")) {
			while (!(answer.equals("n") || answer.equals("N"))) {

			//rng picks a number 1-5
			Random randomNumber = new Random();
			int options = randomNumber.nextInt(5)+ 1;
			
//			System.out.println("CPU chose: " + ComputersChoice(options) + "\n"); // *TEST* finds NPC's choice (RNG) 
			
			// asks the user to pick a number 1-5 to choose a game option
			System.out.println("1. Olserod\n2. Knarrevik\n3. Utespelare\n4. Yngvar\n5. Melltorp");
			System.out.println("\nPick a choice #1-5:");
			int humansChoice = input.nextInt(); 
			
			// tests to make sure the user enters a number 1-5
			while (humansChoice > 5 || humansChoice < 1) {
				System.out.println("enter a number 1-5");
				humansChoice = input.nextInt(); 
			}
			
//			System.out.println("Users choice: " + UsersChoice(humansChoice)); // *TEST* finds Users choice (Input)
			
			FindWinner(humansChoice, options);
			
			System.out.println("\n'y' to keep playing or 'n' to quit: ");
			answer = input.next(); // Asks if user wants to play or not
			
			}
		}
		else {
		System.out.println("Game Over, thanks for playing!");
		}
		System.out.println("Game over, thanks for playing");

		
		
		
		
		
		
		
		
	}

	
	
	
}
