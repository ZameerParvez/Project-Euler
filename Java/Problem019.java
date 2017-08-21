import java.util.ArrayList;
import java.util.List;

public class Problem019 extends Problem {
	
	@Override
	public String solve() {
		List<List<Integer>> months = makeCalendar(1901, 2000);
		int sundayCount = 0;
		for (List<Integer> m : months) {
			if (m.get(0) == 6) {
				sundayCount++;
			}
		}
		return String.valueOf(sundayCount);
	}
	
	public List<List<Integer>> makeCalendar(int startYear, int endYear) {
		int currentDay = 0;
		List<List<Integer>> months = new ArrayList<List<Integer>>();
		int monthCount = 0;
		while (monthCount <= (endYear - 1900) * 12) {
			int count = 0;
			List<Integer> mon = new ArrayList<>();
			int m = monthCount % 12;
			switch (m) {
				case 1:
					int year = (monthCount / 12) + startYear;
					if (year % 4 == 0 && year % 100 != 0) {
						while(count < 29) {
							mon.add(currentDay++ % 7);
							count++;
						}
					}
					else if(year % 400 == 0) {
						while(count < 29) {
							mon.add(currentDay++ % 7);
							count++;
						}
					}
					else {
						while(count < 28) {
							mon.add(currentDay++ % 7);
							count++;
						}
					}
					break;
				case 3:
				case 5:
				case 8:
				case 10:
					while(count < 30) {
						mon.add(currentDay++ % 7);
						count++;
					}
					break;	
				default:
					while(count < 31) {
						mon.add(currentDay++ % 7);
						count++;
					}
			}
			currentDay = currentDay % 7;
			months.add(mon);
			monthCount++;
		}
		for (int i = 0; i < (startYear - 1900) * 12; i++) {
			months.remove(i);
		}
		return months;
	}
	
	public static void main(String[] args) {
		new Problem019().benchmark();
	}
}
