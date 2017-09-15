import java.math.BigInteger;

public class Problem025 extends Problem {
	
	@Override
	public String solve() {
		int limit = 1000;
		
		int index = 2;
		BigInteger lim = CommonUtils.pow(BigInteger.valueOf(10), BigInteger.valueOf(limit - 1));
		BigInteger a = BigInteger.ONE;
		BigInteger b = a;
		while (a.compareTo(lim) < 0) {
			BigInteger temp = a;
			a = a.add(b);
			b = temp;
			index++;
		}
		
		return String.valueOf(index);
	}
	
	public static void main(String[] args) {
		new Problem025().benchmark();
	}
}
