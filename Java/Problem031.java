import java.util.Arrays;

public class Problem031 extends Problem {
	
	private int[] denominations = {200, 100, 50, 20, 10, 5, 2, 1};
	
	@Override
	public String solve() {
		int n = 200;
		return String.valueOf(calculate(n));
		//return String.valueOf(calculateR(n));
	}

	public int calculateR(int n) {
		Arrays.sort(denominations);
		return getNumOfCoins(n, denominations.length - 1);
	}
	
	public int getNumOfCoins(int n, int denomIndex) {
		if (denomIndex == 0) {
			return 1;
		}
		
		int count = 0;
		for (int i = n; i >= 0; i -= denominations[denomIndex]) {
			count += getNumOfCoins(i, denomIndex - 1);
		}
		
		return count;
	}
	
	// This is method implements the more efficient algorithm in the Project Euler notes for Problem 031
	public int calculate(int n) {
		Arrays.sort(denominations);
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for (int c : denominations) {
			for (int j = c; j <= n; j++) {
				ways[j] = ways[j] + ways[j - c];
			}
		}
		return ways[n];
	}
	
	public static void main(String[] args) {
		new Problem031().benchmark();
	}
}