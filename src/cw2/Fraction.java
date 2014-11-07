// This class provides fraction creating and manipulating capabilities.
// Created by Liran Harary, student number 12837230.
// Submitted on: 07.11.2014

package cw2;
/**
 * Created by keith for the second coursework assignment.
 * Completed by Liran Harary.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor functionality:
	// - If denominator is 0, return.
	// - Simplify the fraction, by diving both numerator and denominator by the gcd.
    // - Newly added: Fix fractions with a negative denominator (see method description above method declaration).
    public Fraction(int num, int denom) {
    	if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0");
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
        fixNegDomFrac();
    }

    // Custom toString() method:
    // - If denominator is 1, it returns only the numerator.
    // - If numerator is 0, it returns "0".
    // - Otherwise, it returns numerator + "/" + denominator.
    @Override
    public String toString() {
    	if(this.getDenominator() == 1) {
    		return Integer.toString(this.getNumerator());
    	}
    	if(this.getNumerator() == 0) {
    			return "0";
    	}
        return "" + getNumerator() + '/' + getDenominator();
    }
    
    // Next four methods: Getters and setters for numerator and denominator 
    
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    // Custom equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    // Custom hashCode() method.
    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }
    
    // The following four methods take a fraction, perform the operation in their name with the VALUES of this Fraction and the parameter Fraction,
    // and return a new Fraction.
    
    public Fraction multiply(Fraction other) {
        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction other) {
    	int num = this.getNumerator()*other.getDenominator() + other.getNumerator()*this.getDenominator();
    	int denom = this.getDenominator()*other.getDenominator();
    	return new Fraction(num, denom);
    }
    
    public Fraction subtract(Fraction other) {
    	int num = this.getNumerator()*other.getDenominator() - other.getNumerator()*this.getDenominator();
    	int denom = this.getDenominator()*other.getDenominator();
    	return new Fraction(num, denom);
    }
    
    public Fraction divide(Fraction other) {
    	Fraction reversedOther = new Fraction(other.getDenominator(), other.getNumerator());
    	return this.multiply(reversedOther);
    }
    
    // This method returns a new Fraction whose numerator and denominator have the absolute values of the ones in this Fraction's. 
    public Fraction absValue() {
    	Fraction absFrac = new Fraction(this.getNumerator(), this.getDenominator());
    	if(absFrac.getNumerator() < 0) {
    		absFrac.setNumerator(absFrac.getNumerator() * -1);
    	}
    	if(absFrac.getDenominator() < 0) {
    		absFrac.setDenominator(absFrac.getDenominator() * -1);
    	}
    	return absFrac; 
    }
    
    // This method returns a new Fraction that has this Fraction's numerator and denominator, but the numerator is negated.
    public Fraction negate() {
    	return new Fraction(this.getNumerator()*-1, this.getDenominator());
    }

    // This method calculates and returns the gcd (Greatest Common Divisor) of this Fraction. 
    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    // This method "fixes" fractions with a negative denominator, by negating both numerator and denominator.
    // Note that This method performs its operation on this Fraction, and does not return a new Fraction. This is due to the fact that it is used only by
    // the constructor, and not externally.
    private void fixNegDomFrac() {
    	if(this.getDenominator() < 0) {
    		this.setNumerator(this.getNumerator() * -1);
    		this.setDenominator(this.getDenominator() * -1);
    	}
    }
}