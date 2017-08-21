import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem022 extends Problem{

	@Override
	public String solve() {
		List<String> names = input("src/Problem022-data.txt");
		Collections.sort(names);
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			scores.add((i + 1) * getScore(names.get(i)));
		}
		int sum = 0;
		for (int i : scores) {
			sum += i;
		}
		return String.valueOf(sum);
	}
	
	public int getScore(String name) {
		int sum = 0;
		int valOfA = Integer.valueOf('A');
		for (int i = 0; i < name.length(); i++) {
			sum += Integer.valueOf(name.charAt(i)) - valOfA + 1;
		}
		return sum;
	}
	
	public List<String> input(String path) {
		List<String> input = new ArrayList<String>();
		try {
			Scanner s = new Scanner(new FileReader(path));
			String[] in = s.next().replaceAll("\"", "").split(",");
			s.close();
			for (String i : in) {
				input.add(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void main(String[] args) {
		new Problem022().benchmark();
	}
}
