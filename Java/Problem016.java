import java.math.BigInteger;

public class Problem016 extends Problem{
	
	@Override
	public String solve() {
		int n = 2;
		int m = 1000;
		BigInteger num = CommonUtils.pow(BigInteger.valueOf(n), BigInteger.valueOf(m));
		return sumDigits(num).toString();
	}
	
	public BigInteger sumDigits(BigInteger n) {
		String input = n.toString();
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < input.length(); i++) {
			sum = sum.add(BigInteger.valueOf(Integer.valueOf(input.substring(i, i + 1))));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new Problem016().benchmark();
	}
}
