package cw2;
/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    //@Override
    public String toString() {
    	if(this.getDenominator() == 1) {
    		return Integer.toString(this.getDenominator());
    	}
    	else {
    		if(this.getNumerator() == 0) {
    			return "0";
    		}
    	}
        return "" + getNumerator() + '/' + getDenominator();
    }

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

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    //@Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

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
    
    public Fraction absValue() {
    	/*double fractionValue = this.getNumerator()/this.getDenominator();
    	if(fractionValue <= 0) {
    		Fraction neg = negate();
    		return neg.getNumerator() / neg.getDenominator();
    	}
    	return fractionValue;*/
    	Fraction absFrac = new Fraction(this.getNumerator(), this.getDenominator());
    	if(absFrac.getNumerator() < 0) {
    		absFrac.setNumerator(absFrac.getNumerator() * -1);
    	}
    	if(absFrac.getDenominator() < 0) {
    		absFrac.setDenominator(absFrac.getDenominator() * -1);
    	}
    	
    	return absFrac; 
    }
    
    public Fraction negate() {
    	return new Fraction(this.getNumerator()*-1, this.getDenominator());
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
