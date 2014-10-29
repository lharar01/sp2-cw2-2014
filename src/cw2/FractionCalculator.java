package cw2;

public class FractionCalculator {
	public static /*Fraction*/ void evaluate(Fraction fraction, String inStr) {
		Fraction total = new Fraction(fraction.getNumerator(), fraction.getDenominator());
		String[] operators = {"+", "-", "*", "/"};
		String[] abs = {"a", "A", "abs"};
		String[] neg = {"n", "N", "neg"};
		String[] clr = {"c", "C", "clr"};
		String remOp = " "; // remembered operation
		/*if(!inStr.contains(/\s+)) {
			System.out.println("Please use spaces between your operators.");
		}
		else {*/
		String[] bits = inStr.split("\\s+");
		System.out.println("inStr: " + inStr);
		for(int i=0; i<bits.length; i++) {
			//System.out.print(bits[i] + ",");
			// If current bit is an operator, store it in the remOp variable
			if(inStringArray(operators, bits[i])) {
				//System.out.println("char " + i + ": " + bits[i] + " is an operator.");
				remOp = bits[i];
			}
			// If current bit is a/A/abs, make the total absolute
			else {
				if(inStringArray(abs, bits[i])) {
					total = total.absValue();
				}
				// If current bit is n/N/neg, change the sign of the total
				else {
					if(inStringArray(neg, bits[i]))
					{
						total = total.negate();
					}
					// If current bit is c/C/clr, set the total to 0
					else {
						if(inStringArray(clr, bits[i])) {
							total.setNumerator(0);
						}
						else {
							// Continue here with "A fraction" in "When you see. . . Do this. . ." in the instructions
						}
					}					
				}
			}
		}
		//}
		
		
		
	
		
		
		
		
		
		
		
		
		//		char current;
//		char next;
//		// Afterwards, in places where I used inStr.charAt(i+1), add code to only check this if i+1 < inStr.length.
//		for(int i=0; i<inStr.length(); i++) {
//			current = inStr.charAt(i);
//			next = inStr.charAt(i+1);
//			// If current char is a digit
//			if(current > -9 && current < 9) {
//				if(next == ' ') {
//					
//				}
//			}
//		}
	}
	
	private static boolean inStringArray(String[] haystack, String needle) {
		for(int i=0; i<haystack.length; i++) {
			if(haystack[i].equals(needle)) {
				return true;
			}
		}
		return false;
	}
}