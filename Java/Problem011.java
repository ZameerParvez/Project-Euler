import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem011 extends Problem{
	
	@Override
	public String solve() {
		int max = 0;
		String path = "/mnt/DATA/Documents/eclipse/ProjectEuler/src/Problem011Input";
		ArrayList<ArrayList<Integer>> grid;
		try {
			grid = initGrid(path);
			System.out.println(toString(grid));
			int maxDown = maxDown(grid);
			int maxRight = maxRight(grid);
			int maxDiagonalDown = maxDiagonalDown(grid);
			int maxDiagonalUp = maxDiagonalUp(grid);
			if (maxDown > max) {
				max = maxDown;
			}
			if (maxRight > max) {
				max = maxRight;
			}
			if (maxDiagonalDown > max) {
				max = maxDiagonalDown;
			}
			if (maxDiagonalUp > max) {
				max = maxDiagonalUp;
			}
			return Integer.toString(max);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Invalid Input";
		}
	}
	
	public ArrayList<Integer> initRow(String row) {
		String[] rowArray = row.split(" ");
		ArrayList<Integer> rowList = new ArrayList<Integer>();
		for (int i = 0; i < rowArray.length; i++) {
			rowList.add(Integer.valueOf((rowArray[i])));
		}
		return rowList;
	}
	
	public ArrayList<ArrayList<Integer>> initGrid(String path) throws FileNotFoundException {
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		Scanner s = new Scanner(new File(path));
		do {
			grid.add(initRow(s.nextLine()));
		}
		while(s.hasNextLine());
		s.close();
		return grid;
		}
	
	public String toString(ArrayList<ArrayList<Integer>> grid) {
		String s = new String();
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				s += String.format("%d ", grid.get(i).get(j));
			}
			s += "\n";
		}
		return s;
	}
	
	public int maxDown(ArrayList<ArrayList<Integer>> grid) {
		int num = 4;
		int max = 0;
		int temp = 1;
		for (int i = 0; i < grid.size() - num; i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				for (int k = 0; k < num; k++) {
					temp *= grid.get(i + k).get(j);
				}
				if (temp > max) {
					max = temp;
				}
				temp = 1;
			}
		}
		return max;
	}
	
	public int maxRight(ArrayList<ArrayList<Integer>> grid) {
		int num = 4;
		int max = 0;
		int temp = 1;
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size() - num; j++) {
				for (int k = 0; k < num; k++) {
					temp *= grid.get(i).get(j + k);
				}
				if (temp > max) {
					max = temp;
				}
				temp = 1;
			}
		}
		return max;
	}
	
	public int maxDiagonalDown(ArrayList<ArrayList<Integer>> grid) {
		int num = 4;
		int max = 0;
		int temp = 1;
		for (int i = 0; i < grid.size() - num; i++) {
			for (int j = 0; j < grid.get(i).size() - num; j++) {
				for (int k = 0; k < num; k++) {
					temp *= grid.get(i + k).get(j + k);
				}
				if (temp > max) {
					max = temp;
				}
				temp = 1;
			}
		}
		return max;
	}
	
	public int maxDiagonalUp(ArrayList<ArrayList<Integer>> grid) {
		int num = 4;
		int max = 0;
		int temp = 1;
		for (int i = grid.size() - 1; i >= num; i--) {
			for (int j = 0; j < grid.get(i).size() - num; j++) {
				for (int k = 0; k < num; k++) {
					temp *= grid.get(i - k).get(j + k);
				}
				if (temp > max) {
					max = temp;
				}
				temp = 1;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		new Problem011().benchmark();		
	}

}