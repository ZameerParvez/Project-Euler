import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Problem024 extends Problem {
	
	@Override
	public String solve() {
		int n = 1000000;
		String s = "0123456789";
		//return getNthPermutationR(getPermutationsR(s), n);
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
	
	public String getNthPermutationR(List<String> permutations, int n) {
		Collections.sort(permutations);
		return permutations.get(n - 1);
	}
	
	//This method recursively finds all permutations of a string;
	public List<String> getPermutationsR(String s) {
		List<String> permutations = new ArrayList<>();
		if (s.length() == 1) {
			permutations.add(s);
			return permutations;
		}
		
		String subString = s.substring(1, s.length());
		List<String> prevPermutations = getPermutationsR(subString);
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < prevPermutations.size(); j++) {
				String permutation = prevPermutations.get(j).substring(0, i) + s.charAt(0) + prevPermutations.get(j).substring(i);
				permutations.add(permutation);
			}
		}
		
		return permutations;
	}
	
	public static void main(String[] args) {
		new Problem024().benchmark();
	}
}