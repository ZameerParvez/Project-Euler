import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem029 extends Problem {
	
	@Override
	public String solve() {
		int limit = 100;
		Set<BigInteger> powers = new HashSet<>();
		
		for (int a = 2; a <= limit; a++) {
			for (int b = 2; b <= limit; b++) {
				powers.add(CommonUtils.pow(BigInteger.valueOf(a), BigInteger.valueOf(b)));
			}
		}
		
		return String.valueOf(powers.size());
	}
	
	public static void main(String[] args) {
		new Problem029().benchmark();
	}
}