import java.util.List;

public class Problem021 extends Problem {
	
	@Override
	public String solve() {
		int sum = 0;
		int a = 10000;
		while (a > 0) {
			int b = sumDivisors(CommonUtils.getProperDivisors(a));
			sum += (a != b && a == sumDivisors(CommonUtils.getProperDivisors(b)))?a:0;
			a--;
		}
		return String.valueOf(sum);
	}
	
	public int sumDivisors(List<Integer> divisors) {
		int sum = 0;
		for (int i : divisors) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new Problem021().benchmark();
	}
}
