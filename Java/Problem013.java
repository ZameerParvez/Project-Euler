import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem013 extends Problem{
	
	public String solve() {
		BigInteger sum = BigInteger.ZERO;
		List<BigInteger> input = inputNumbers("src/Problem013-data.txt");
		for (BigInteger i:input) {
			sum = sum.add(i);
		}
		
		return String.format("%d\n", sum).substring(0, 10);
	}
	
	public List<BigInteger> inputNumbers(String fileName) {
		List<BigInteger> input = new ArrayList<BigInteger>();
		try {
			Scanner s = new Scanner(new FileReader(fileName));
			while (s.hasNextLine()) {
				input.add(new BigInteger(s.nextLine()));
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static void main(String[] args) {
		new Problem013().benchmark();
	}

}
