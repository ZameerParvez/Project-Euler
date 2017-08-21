import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem067 extends Problem{

	@Override
	public String solve() {
		List<List<Integer>> triangle = input("src/Problem067-data.txt");
		return "" + getMaxSum(triangle);
	}
	
	public int getMaxSum(List<List<Integer>> triangle) {
		for (int row = triangle.size() - 1; row > 0; row--) {
			for (int i = 0; i < triangle.get(row).size() - 1; i++) {
				if (triangle.get(row).get(i) > triangle.get(row).get(i + 1)) {
					triangle.get(row - 1).set(i, triangle.get(row - 1).get(i) + triangle.get(row).get(i));
				}
				else {
					triangle.get(row - 1).set(i, triangle.get(row - 1).get(i) + triangle.get(row).get(i + 1));
				}
			}
		}
		return triangle.get(0).get(0);
	}
	
	public List<List<Integer>> input(String path) {
		List<List<Integer>> triangleRows = new ArrayList<>();
		try {
			Scanner s = new Scanner(new FileReader(path));
			while (s.hasNextLine()) {
				String[] a = s.nextLine().split(" ");
				List<Integer> triangleColumns = new ArrayList<>();
				for (String i : a) {
					triangleColumns.add(Integer.valueOf(i));
				}
				triangleRows.add(triangleColumns);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return triangleRows;
	}
	
	public static void main(String[] args) {
		new Problem067().benchmark();	
	}
}
