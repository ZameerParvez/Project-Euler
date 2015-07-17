
public class Problem002 extends Problem {

    @Override
    public String solve() {
        int previousValue = 1;
        int currentValue = 2;
        int temp = 0; // Temporarily stores the value of currentValue.
        int evenSum = 0;
        while (currentValue <= 4000000) {
            if (currentValue % 2 == 0) {
                evenSum += currentValue;
            }
            temp = currentValue;
            currentValue += previousValue;
            previousValue = temp;
        }
        return "" + evenSum;
    }

    public static void main(String args[]) {
        new Problem002().benchmark();
    }
    
}
