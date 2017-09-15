public class Problem027 extends Problem {
	
	@Override
	public String solve() {
		int limit = 1000;
		int maxNumOfPrimes = 0;
		int maxA = 0;
		int maxB = 0;
		
		for (int a = 1 - limit; a < limit; a++) {
			for (int b = -limit; b <= limit; b++) {
				int n = 0;
				int numOfPrimes = 0;
				
				// count the number of consecutive primes starting from n = 0
				while (((n * n) + (a * n) + b) > 0 && PrimeUtils.getPrimeFactors((n * n) + (a * n) + b).isEmpty()) {
					numOfPrimes++;
					n++;
				}
				
				if (numOfPrimes > maxNumOfPrimes) {
					maxNumOfPrimes = numOfPrimes;
					maxA = a;
					maxB = b;
				}
			}
		}
		
		return String.valueOf(maxA * maxB);
	}
	
	public static void main(String[] args) {
		new Problem027().benchmark();
	}
}