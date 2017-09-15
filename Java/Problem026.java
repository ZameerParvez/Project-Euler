import java.math.BigInteger;

public class Problem026 extends Problem {
	
	@Override
	public String solve() {
		int iOfMax = 0;
		int maxReccurrence = 0;
		
		for (int i = 1; i < 1000; i += 2) {
			int reccurrenceLength = getReccurrence(CommonUtils.pow(BigInteger.TEN, BigInteger.valueOf(i)), i);
			
			if (reccurrenceLength > maxReccurrence) {
				maxReccurrence = reccurrenceLength;
				iOfMax = i;
			}	
		}
		
		return String.valueOf(iOfMax);
	}

	public static int getReccurrence(BigInteger numerator, int denominator) {
		if (numerator.remainder(BigInteger.valueOf(denominator)).equals(BigInteger.ZERO)) {
			return 0;
		}

		BigInteger n = numerator.divide(BigInteger.valueOf(denominator));
		String number = n.toString();
		number = number.substring(1, number.length());
		
		int reccurenceLength = 1;
		while (reccurenceLength < number.length()) {
			boolean isReccurrence = true;
		
			for (int i = 0; i < number.length() - reccurenceLength; i++) {
				if (number.charAt(i) != number.charAt(i + reccurenceLength)) {
					isReccurrence = false;
					break;
				}
			}
			
			if (isReccurrence) {
				break;
			}
			
			reccurenceLength++;
		}

		return reccurenceLength;
	}
	
	public static void main(String[] args) {
		new Problem026().benchmark();
	}
}