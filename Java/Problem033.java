import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem033 extends Problem {
	
	@Override
	public String solve() {	
		return String.valueOf(calculate(2));
	}
	
	public String calculate(int numOfDigits) {
		List<int[]> nonTrivial = getNonTrivialFractions(numOfDigits);
		
		BigInteger commonDenom = BigInteger.ONE;
		BigInteger commonNum = BigInteger.ONE;
		
		for (int[] i : nonTrivial) {
			commonNum = commonNum.multiply(BigInteger.valueOf(i[0]));
			commonDenom = commonDenom.multiply(BigInteger.valueOf(i[1]));
		}
		
		BigInteger[] fraction = {commonNum, commonDenom};
		simplify(fraction);
	
		return String.valueOf(fraction[1]);
	}
	
	public List<int[]> getNonTrivialFractions(int numOfDigits) {
		List<int[]> f = new ArrayList<>();
		int lim = (int) Math.pow(10, numOfDigits);
		
		for (int i = 1; i < lim; i++) {
			for (int j = i + 1; j < lim; j++) {
				if (i % 10 != 0 && isCancellingFraction(i, j)) {
					int[] temp = {i, j};
					f.add(temp);
				}
			}
		}
		
		return f;
	}
	
	public boolean isCancellingFraction(int num, int denom) {
		String numerator = Integer.toString(num);
		String denominator = Integer.toString(denom);
		Map<Character, Integer> mN = new HashMap<>();
		Map<Character, Integer> mD = new HashMap<>();
		
		for (int i = 0; i < numerator.length(); i++) {
			char key = numerator.charAt(i);
			if (mN.containsKey(key)) {
				mN.put(key, mN.get(key) + 1);				
			} else {
				mN.put(key, 1);
			}
		}
		
		for (int i = 0; i < denominator.length(); i++) {
			char key = denominator.charAt(i);
			if (mD.containsKey(key)) {
				mD.put(key, mD.get(key) + 1);				
			} else {
				mD.put(key, 1);
			}
		}
		
		StringBuilder reducedNum = new StringBuilder();
		StringBuilder reducedDenom = new StringBuilder();
		
		for (int i = 0; i < numerator.length(); i++) {
			char key = numerator.charAt(i);
			if (mD.containsKey(key)) {
				mD.put(key, mD.get(key) - 1);
				if (mD.get(key) == 0) {
					mD.remove(key);
				}
			} else {
				reducedNum.append(key);
			}
		}
		
		for (int i = 0; i < denominator.length(); i++) {
			char key = denominator.charAt(i);
			if (mN.containsKey(key)) {
				mN.put(key, mN.get(key) - 1);
				if (mN.get(key) == 0) {
					mN.remove(key);
				}
			} else {
				reducedDenom.append(key);
			}
		}
		
		if (reducedNum.toString().equals("") || reducedDenom.toString().equals("")) {
			return false;
		}
		
		int num2 = Integer.valueOf(reducedNum.toString());
		int denom2 = Integer.valueOf(reducedDenom.toString());
		
		if (denom2 == 0 || (num == num2 && denom == denom2)) {
			return false;
		}
		
		double val1 = num / (double) denom;
		double val2 = num2 / (double) denom2;
		
		return val1 == val2;
	}
	
	public void simplify(BigInteger[] fraction) {
		BigInteger gcd = fraction[0].gcd(fraction[1]);
		
		fraction[0] = fraction[0].divide(gcd);
		fraction[1] = fraction[1].divide(gcd);
	}
	
	public long[] simplify(long[] fraction) {
		long num = fraction[0];
		long denom = fraction[1];
		long lim = (num < denom) ? num : denom;
		
		for (int i = 2; i <= lim; i++) { 
			while (num % i == 0 && denom % i == 0) {
				 num = num / i;
				 denom = denom / i;
			}
			lim = (num < denom) ? num : denom;
		}
		
		long[] simplified = {num, denom};
		return simplified;
	}
	
	public static void main(String[] args) {
		new Problem033().benchmark();
	}
}
