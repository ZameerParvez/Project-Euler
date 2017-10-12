import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Problem024 extends Problem {
	
	@Override
	public String solve() {
		int n = 1000000;
		String s = "0123456789";
		//return getNthPermutationR(s, n);
		return getNthPermutation(s, n);
	}
	
	public String getNthPermutation(String s, int n) {
		n--;
		List<Integer> factoradic = getFactoradic(n);
		
		List<Character> c = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			c.add(s.charAt(i));
		}
		
		StringBuilder permutation = new StringBuilder();
		for (int i = factoradic.size() - 1; i >= 0; i--) {
			int index = factoradic.get(i);
			permutation.append(c.get(index));
			c.remove(index);
		}
		
		return permutation.toString();
	}
	
	public List<Integer> getFactoradic(int n) {
		List<Integer> digits = new ArrayList<>();
		
		int factorial = 1;
		while (n > 0) {
			digits.add(n % factorial);
			n = n / factorial;
			factorial++;
		}
		
		return digits;
	}
	
	public String getNthPermutationR(String s, int n) {
		List<String> permutations = CommonUtils.getPermutations(s);
		Collections.sort(permutations);
		return permutations.get(n - 1);
	}
	
	public static void main(String[] args) {
		new Problem024().benchmark();
	}
}