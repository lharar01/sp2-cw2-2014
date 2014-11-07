// This JUnit class tests class Fraction's public methods to ensure they are working correctly.
// Created by Liran Harary, student number 12837230.
// Submitted on: 07.11.2014

package cw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testMultiply() {
		Fraction a = new Fraction(2,3);
		Fraction b = new Fraction(5,4);
		Fraction correct = new Fraction(10,12);
		assertEquals("Wrong answer", correct, a.multiply(b));
	}

	@Test
	public void testAdd() {
		Fraction a = new Fraction(1,3);
		Fraction b = new Fraction(2,3);
		Fraction correct = new Fraction(1,1);
		assertEquals("Wrong answer", correct, a.add(b));
	}

	@Test
	public void testSubtract() {
		Fraction a = new Fraction(2,3);
		Fraction b = new Fraction(2,3);
		Fraction correct = new Fraction(0,1);
		assertEquals("Wrong answer", correct, a.subtract(b));
	}

	@Test
	public void testDivide() {
		Fraction a = new Fraction(11,30);
		Fraction b = new Fraction(3,5);
		Fraction correct = new Fraction(55,90);
		assertEquals("Wrong answer", correct, a.divide(b));
	}

	@Test
	public void testAbsValue() {
		Fraction negativeFrac = new Fraction(-1,3);
		Fraction absFrac = new Fraction(1,3);
		assertEquals("Wrong answer", absFrac, negativeFrac.absValue());
	}

	@Test
	public void testNegate() {
		Fraction aFrac = new Fraction(4,5);
		Fraction negatedFrac = new Fraction(-4,5);
		assertEquals("Wrong answer", negatedFrac, aFrac.negate());
	}

}
