import java.math.BigInteger;

public class Problem015 extends Problem{
	
	@Override
	public String solve() {
		return String.valueOf(totalNumberOfPaths(20));
	}
	
	public BigInteger totalNumberOfPaths(int size) {
		BigInteger numOfPaths = BigInteger.ZERO;
		long n = size - 1;
		for (long r = 0; r < size; r++) {
			numOfPaths = numOfPaths.add(CommonUtils.binomial(n, r));
			n++;
		}
		return numOfPaths.multiply(BigInteger.valueOf(2));
	}
	
	public static void main(String[] args) {
		new Problem015().benchmark();
	}
}