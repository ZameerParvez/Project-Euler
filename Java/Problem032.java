import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem032 extends Problem {
	
	private Set<Integer> products = new HashSet<>();
	private Set<Integer> products2 = new HashSet<>();

	
	@Override
	public String solve() {
		String digits = "123456789";
	
		return String.valueOf(calculateWithPermutations(digits));
		//return String.valueOf(calculateWithTrial(digits));
	}
	
	public int calculateWithTrial(String digits) {
		int sum = 0;
		int lim = (int) Math.pow(10, (digits.length() / 3) + 1);
		
		for (int i = 1; i < lim; i++) {
			for (int j = i ; j < lim; j++) {
				int product = i * j;
				if (product < lim && !products.contains(product) && isPandigital(i, j, product, digits)) {
					products.add(product);
					sum += product;					
				}
			}
		}
		
		return sum;
	}
	
	public boolean isPandigital(long multiplicand, long multiplier, long product, String pattern) {
		String digits = String.format("%d%d%d", multiplicand, multiplier, product);
		if (digits.length() != pattern.length()) {
			return false; 
		}
		
		boolean isPandigital = true;
		for (int i = 1; i <= pattern.length(); i++) {
			if (!digits.contains(String.valueOf(i))) {
				isPandigital = false;
				break;
			}
		}
		
		return isPandigital;
	}
	
	public int calculateWithPermutations(String digits) {
		int sum = 0;		
		List<String> l = CommonUtils.getPermutations(digits);
	
		for (String s : l) {
			for (int i = 1; i < 5; i++) {
				int num1 = Integer.valueOf(s.substring(0, i));

				for (int j = i; j < 5; j++) {
					int num2 = Integer.valueOf(s.substring(i, i + j));
					int prod = num1 * num2;
					
					if (String.valueOf(prod).equals(s.substring(i + j, s.length())) && !products2.contains(prod)) {
						products2.add(prod);
						sum += prod;
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		new Problem032().benchmark();
	}
}
