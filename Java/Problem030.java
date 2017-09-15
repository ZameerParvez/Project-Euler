import java.util.ArrayList;
import java.util.List;

public class Problem030 extends Problem {
	
	@Override
	public String solve() {
		List<Integer> validNums = new ArrayList<>();
		int exp = 5;
		
		int limit = exp * (int) Math.pow(9, exp);
		for (int i = 2; i < limit; i++) {
			if (sumOfPowers(i, exp) == i) {
				validNums.add(i);
			}
		}
		
		int sum = 0;
		for (int i : validNums) { 
			sum += i;
		}
		
		return String.valueOf(sum);
	}
	
	public int sumOfPowers(int n, int exp) {
		String num = String.valueOf(n);
		int sum = 0;
		
		for (int i = 0; i < num.length(); i++) {
			sum += Integer.valueOf((int) Math.pow(Integer.valueOf(num.substring(i, i + 1)), exp));
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		new Problem030().benchmark();
	}
}
