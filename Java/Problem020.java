public class Problem020 extends Problem{

	@Override
	public String solve() {
		return String.valueOf(sumDigits(CommonUtils.factorial(100).toString()));
	}
	
	public int sumDigits(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i+1));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new Problem020().benchmark();
	}

}
