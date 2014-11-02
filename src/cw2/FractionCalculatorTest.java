package cw2;
import java.util.Scanner;

public class FractionCalculatorTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] quit = {"q", "Q", "quit"};
		System.out.println("0\nWelcome to Liran's calculator!\nPlease enter a line to calculate\n");
		String userInput = input.nextLine();
		while(!FractionCalculator.inStringArray(quit, userInput)) {
			System.out.println("\nResult: " + FractionCalculator.evaluate(new Fraction(0,1), userInput) + "\n\nEnter a line to calculate, or 'q'/'Q'/'quit' to quit\n");
			userInput = input.nextLine();
		}
		System.out.print("\nGoodbye.");
		input.close();
	}
}