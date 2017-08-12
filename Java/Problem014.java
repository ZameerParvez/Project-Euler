public class Problem014 extends Problem {

	@Override
	public String solve() {
		long n = 1;
		long upper = 1000000;
		long max = 0 ;
		long startingMax = 0;
		while (n < upper) {
			long temp = countCollatzTerms(n);
			if (temp > max) {
				max = temp;
				startingMax = n;
			}
			n++;
		}
		return "" + startingMax;
	}
	
	public long countCollatzTerms(long n) {
		long count = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			}
			else {
				n = 3*n + 1;
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		new Problem014().benchmark();
	}
}
