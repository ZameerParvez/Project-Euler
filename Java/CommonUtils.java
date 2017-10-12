import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

	public static BigInteger factorial(long n) {
		BigInteger product = BigInteger.ONE;
		while (n > 1) {
			product = product.multiply(BigInteger.valueOf(n--));
		}
		
		return product;
	}

	public static BigInteger binomial(long n, long r) {
		return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
	}

	public static BigInteger pow(BigInteger base, BigInteger exponent) {
		BigInteger ans = BigInteger.ONE;
		while (!exponent.equals(BigInteger.ZERO)) {
			ans = ans.multiply(base);
			exponent = exponent.subtract(BigInteger.ONE);
		}
		
		return ans;
	}

	public static List<Integer> getProperDivisors(int n) {
		List<Integer> divisors = new ArrayList<>();
		divisors.add(1);
		
		double limit = Math.sqrt(n);
		for (int i = 2; i < limit; i++) {
			if (n % i == 0) {
				divisors.add(i);
				divisors.add(n / i);
			}
		}

		boolean isInt = limit - (int) limit == 0;
		if (n != 1 && isInt && n % limit == 0) {
			divisors.add((int) limit);
		}

		return divisors;
	}

	public static int sumProperDivisors(int n) {
		List<Integer> divisors = getProperDivisors(n);
		
		int sum = 0;
		for (int i : divisors) {
			sum += i;
		}
		
		return sum;
	}
	
	public static List<String> getPermutations(String s) {
		List<String> permutations = new ArrayList<>();
		if (s.length() == 1) {
			permutations.add(s);
			return permutations;
		}
		
		String subString = s.substring(1, s.length());
		List<String> prevPermutations = getPermutations(subString);
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < prevPermutations.size(); j++) {
				String permutation = prevPermutations.get(j).substring(0, i) + s.charAt(0) + prevPermutations.get(j).substring(i);
				permutations.add(permutation);
			}
		}
		
		return permutations;
	}
}