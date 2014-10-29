package cw2;
import java.util.Scanner;

public class FractionCalculatorTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("0\nWelcome to Liran's calculator!\nPlease enter a line to calculate.\n");
		FractionCalculator.evaluate(new Fraction(0,1), input.nextLine());
		input.close();
	}
}