package cw2;

public class FractionCalculator {
	public static Fraction evaluate(Fraction fraction, String inStr) {
		Fraction total = new Fraction(fraction.getNumerator(), fraction.getDenominator());
		String[] operators = {"+", "-", "*", "/"};
		String[] abs = {"a", "A", "abs"};
		String[] neg = {"n", "N", "neg"};
		String[] clr = {"c", "C", "clr"};
		String remOp = " ";  // remembered operation. Initial value is a space, representing: no remembered operation.
		String[] fracStringBits = {"0", "1"};
		boolean isBitFraction = false;
		boolean isBitNumeric = false;
		Fraction currentFrac;
		/*if(!inStr.contains(" ")) {
			//System.out.println("Please use spaces between your operators.");
			//if()
			return new Fraction(0,1);
		}*/
		
		// Split the user input by spaces, store result in "bits" array.
		String[] bits = inStr.split("\\s+");
		
		// Remove later:
		//System.out.println("inStr: " + inStr);
		
		// Iterate through "bits" array, processing each part of the input.
		for(int i=0; i<bits.length; i++) {
			// Remove later: System.out.print(bits[i] + ",");
			
			// If current bit is an operator, store it in the remOp variable.
			if(inStringArray(operators, bits[i])) {
				// Remove later: System.out.println("char " + i + ": " + bits[i] + " is an operator.");
				remOp = bits[i];
			}
			else {
				// If current bit is a/A/abs, make the total absolute.
				if(inStringArray(abs, bits[i])) {
					total = total.absValue();
				}
				else {
					// If current bit is n/N/neg, change the sign of the total.
					if(inStringArray(neg, bits[i]))
					{
						total = total.negate();
					}
					else {
						// If current bit is c/C/clr, set the total to 0 and the remOp to "space".
						if(inStringArray(clr, bits[i])) {
							total.setNumerator(0);
							remOp = " ";
						}
						else {
							// If bit has "/" (suspected fraction), or is a (positive or negative) number: 
							if(bits[i].contains("/") || isPosOrNegNumber(bits[i])) {
								isBitFraction = false;
								isBitNumeric = false;
								if(bits[i].contains("/")) {
									fracStringBits = bits[i].split("/");
									isBitFraction = fracStringBits.length == 2 && isPosOrNegNumber(fracStringBits[0]) && isPosOrNegNumber(fracStringBits[1]);
								}
								else {
									isBitNumeric = true;
								}
								
								// If current bit is a fraction or a number:
								// - Create the appropriate Fraction.
								// - If remOp is an operator, perform the relevant operation on the total.
								// - Otherwise, set the total to be the fraction.
								// - Finally, set the remOp to space.
								// Otherwise, print "Unrecognised fraction..." and return a new Fraction of 0/1.
								if(isBitFraction || isBitNumeric) {
									if(isBitFraction) {
										// If dominator is 0, print "illegal fraction..." and return a new Fraction of 0/1.
										if(Integer.parseInt(fracStringBits[1]) == 0) {
											System.out.println("illegal fraction: " + bits[i] + ". Please try again.");
											return new Fraction(0,1);
										}
										currentFrac = new Fraction(Integer.parseInt(fracStringBits[0]), Integer.parseInt(fracStringBits[1]));
									}
									else {
										currentFrac = new Fraction(Integer.parseInt(bits[i]), 1);
									}
									if(remOp.equals("+")) {
										total = total.add(currentFrac);
									}
									else {
										if(remOp.equals("-")) {
											total = total.subtract(currentFrac);
										}
										else {
											if(remOp.equals("*")) {
												total = total.multiply(currentFrac);
											}
											else {
												if(remOp.equals("/")) {
													total = total.divide(currentFrac);
												}
												else {
													total = currentFrac; 
												}
											}
										}
									}
									
									remOp = " ";
								}
								else {
									System.out.println("Unrecognised fraction: " + bits[i] + ". Please try again.");
									return new Fraction(0,1);
								}
							}
							else {
								/*// If current bit is q/Q/quit, print appropriate message and return a new Fraction of 0/1.
								if(inStringArray(quit, bits[i])) {
									System.out.println("Quit acknowledged.");
									return new Fraction(0,1);
								}
								else {*/
									// Anything else, print appropriate message and return a new Fraction of 0/1.
								System.out.println("Unrecognised input: " + bits[i] + ". Please try again.");
								return new Fraction(0,1);
								//}
							}
						}
					}					
				}
			}
		}
		
		return total;
	}
	
	// This function takes a string array and a string and returns true if the string equals any of the array elements, and false otherwise.
	static boolean inStringArray(String[] haystack, String needle) {
		for(int i=0; i<haystack.length; i++) {
			if(haystack[i].equals(needle)) {
				return true;
			}
		}
		return false;
	}
	
	// This function takes a string and returns true if it's numeric, and false otherwise.
	private static boolean isNumeric(String str)
	{
		return str.matches("^[0-9]+$");
	}
	
	private static boolean isPosOrNegNumber(String str)
	{
		return str.matches("^[0-9]+$") || str.charAt(0) == '-' && str.substring(1).matches("^[0-9]+$");
	}
	
	/*private static boolean containsNumbers(String str)
	{
		return str.matches(".*\\d+.*");
	}*/
	
}