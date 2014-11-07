// This program tests class Fraction to confirm that it works correctly.
// Created by Liran Harary, student number 12837230.
// Submitted on: ?

package cw2;
/**
 * Created by keith for the second coursework assignment.
 *
 * All the tests should be (re-)written using JUnit
 */
public class FractionTestTemp {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // extend with extra tests
	// Add:
	Fraction i = new Fraction(2,15);
	Fraction j = new Fraction(5,25);
	System.out.println(i + " + " + j + " = " + i.add(j));
	
	// Add:
	Fraction k = new Fraction(4,35);
	Fraction l = new Fraction(9,53);
	System.out.println(k + " + " + l + " = " + k.add(l));
	//System.out.println("The result should be " + new Fraction(527,1855));
	
	// Subtract:
	Fraction m = new Fraction(4,35);
	Fraction n = new Fraction(9,53);
	System.out.println(m + " - " + n + " = " + m.subtract(n));
	
	// Divide:
	Fraction o = new Fraction(1,3);
	Fraction p = new Fraction(1,3);
	System.out.println(o + " / " + p + " = " + o.divide(p));
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
