public class Problem021 extends Problem {
	
	@Override
	public String solve() {
		int sum = 0;
		int a = 10000;
		while (a > 0) {
			int b = CommonUtils.sumProperDivisors(a);
			sum += (a != b && a == CommonUtils.sumProperDivisors(b))?a:0;
			a--;
		}
		return String.valueOf(sum);
	}
	
	public static void main(String[] args) {
		new Problem021().benchmark();
	}
}
