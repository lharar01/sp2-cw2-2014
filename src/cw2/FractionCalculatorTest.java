// This JUnit class tests class FractionCalculator's "evaluate" method to ensure it is working correctly. It calls
// the method with a string which attempts to includes most of the scenarios that the method could encounter.
// Created by Liran Harary, student number 12837230.
// Submitted on: 07.11.2014

package cw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionCalculatorTest {
	@Test
	public void testEvaluate() {
		String input = "5/10 + 1/6 - 1/7 * 23/5 / 3 neg * 1/-7 * -1 abs";
		Fraction startFrac = new Fraction(1,5);
		Fraction correctResult = new Fraction(253,2205);
		assertEquals("Wrong answer", correctResult, FractionCalculator.evaluate(startFrac, input));
	}
}
