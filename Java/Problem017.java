import java.util.ArrayList;
import java.util.List;

public class Problem017 extends Problem{
	
	static String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String[] magnitudes = {"", "hundred", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion"};
	
	@Override
	public String solve() {
		long sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += toWords(String.valueOf(i)).replaceAll(" ", "").length();
		}
		return String.valueOf(sum);
	}
	
	public String toWords(String number) {
		int length = number.length();
		int d1 = length % 3;
		int d2 = (d1 + 1) % 3;
		List<String> words = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int n = i % 3;
			int t1 = Integer.parseInt(String.valueOf(number.charAt(i)));
			switch (t1) {
				case 0:
					words.add(units[t1]);
					break;
				case 1:
					if (n == d1) {
						words.add(units[t1] + " " + magnitudes[1]);
					} else if (n == d2) {
						int t2 = Integer.parseInt(String.valueOf(number.charAt(i + 1)));
						if (t2 == 0) {
							words.add(tens[t2]);
						}
						else {
							words.add(teens[t2 - 1]);
						}
						words.add(units[0]);
						i++;
					} else {
						words.add(units[t1]);
					}
					break;
				default:
					if (n == d1) {
						words.add(units[t1] + " " + magnitudes[1]);
					} else if (n == d2) {
						words.add(tens[t1 - 1]);
					} else {
						words.add(units[t1]);
					}
			}
		}
		StringBuilder s = new StringBuilder();
		int count = (length - 1) / 3 + 1;
		int d3 = (d1 + 2) % 3;
		for (int i = 0; i < words.size(); i++) {
			int n = i % 3;
			boolean isNotZero = !words.get(i).equals(units[0]);
			if (isNotZero && i != 0 && ((n == d2 && !words.get(i - 1).equals(units[0])) || (n == d3 &&  words.get(i - 1).equals(units[0])))) {
				s.append("and ");
			}
			if (isNotZero || length == 1) {
				s.append(words.get(i) + ' ');
			}
			if (n == d3 && words.size() != i + 1) {
				if (isNotZero || !words.get(i - 1).equals(units[0]) || !words.get(i - 2).equals(units[0])) {
					s.append(magnitudes[count]);
					s.append(" ");
				}
				count--;
			}
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		new Problem017().benchmark();
	}
}