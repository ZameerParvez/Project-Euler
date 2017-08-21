import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem018 extends Problem{

	@Override
	public String solve() {
		List<List<Integer>> triangle = input("src/Problem018-data.txt");
		return "" + getMaxSum(triangle);
	}
	
	public int getNextTermR(List<List<Integer>> triangle, int row, int position, int sumL, int sumR, int depth) {
		int left = triangle.get(row).get(position);
		int right = triangle.get(row).get(position + 1);		
		sumL += left;
		sumR += right;
		if (depth > triangle.size() - row) {
			depth = triangle.size() - row;
		}
		if (depth > 0 && row < triangle.size() - 1) {
			sumL += getNextTermR(triangle, row + 1, position, sumL, sumL, depth - 1);
			sumR += getNextTermR(triangle, row + 1, position + 1, sumR, sumR, depth - 1);
		}
		if (sumL > sumR) {
			return left;
		}
		else {
			return right;
		}
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
		new Problem018().benchmark();	
	}
}
