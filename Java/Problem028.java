public class Problem028 extends Problem {
	
	@Override
	public String solve() { 
		int limit = 1001 * 1001;
		int sum = 0;
		int diff = 2;
		int prevTopRight = 1;
		
		for (int i = 1; i <= limit; i += diff) {
			sum += i;
			if (i == prevTopRight + 4 * diff) {
				diff += 2;
				prevTopRight = i;
			}
		}
		
		return String.valueOf(sum);
	}
	
	public static void main(String[] args) {
		new Problem028().benchmark();
	}
}
