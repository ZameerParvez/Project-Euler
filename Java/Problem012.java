import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem012 extends Problem{

	@Override
	public String solve() {
		int numOfDivisors = 500;
		long n = 0;
		long i = 0;
		while (i < numOfDivisors) {
			i = numOfDivisors(BigInteger.valueOf(nthTriangleNum(++n)));
		}
		return "" + nthTriangleNum(n);
	}
	
	public long nthTriangleNum(long n) {
		return (n*(n+1))/2;
	}
	
	public int numOfDivisors(BigInteger n) {
		List<BigInteger> primeFactors = PrimeUtils.getPrimeFactorisationByTrialDivision(n);
		List<Integer> indicies = new ArrayList<Integer>();
		BigInteger temp = BigInteger.ZERO;
		int counter = 1;
		int numOfDivisors = 1;
		for (BigInteger i : primeFactors) {
			if (i == temp) {
				counter++;
			}
			else {
				temp = i;
				indicies.add(counter);
				counter = 1;
			}
		}
		for (int i : indicies) {
			numOfDivisors *= ++i;
		}
		return numOfDivisors;
	}
	
	public static void main(String[] args) {
		new Problem012().benchmark();
	}
}
