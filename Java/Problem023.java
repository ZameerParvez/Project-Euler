import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem023 extends Problem {

	@Override
	public String solve() {
		List<Integer> abundantNums = new ArrayList<>();
		int limit = 28123;
		boolean[] SumOfTwoAbundants = new boolean[limit];
		Arrays.fill(SumOfTwoAbundants, false);
		long sum = 0;
		for (int i = 1; i <= limit; i++) {
			if (isAbundant(i)) {
				abundantNums.add(i);
				int position = abundantNums.size() - 1;
				for (int j = position; j >= 0; j--) {
					int s = i + abundantNums.get(j);
					if (s < limit) {
						SumOfTwoAbundants[s] = true;
					}
				}
			}
		}
		for (int i = 0; i < limit; i++) {
			if (!SumOfTwoAbundants[i]) {
				sum += i;
			}
		}
		return String.valueOf(sum);
	}

	public boolean isAbundant(int n) {
		return (n < CommonUtils.sumProperDivisors(n));
	}

	public static void main(String[] args) {
		new Problem023().benchmark();
	}

}