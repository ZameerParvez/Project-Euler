
public class Problem006 extends Problem {

    @Override
    public String solve() {
        int sumOfSquares = 0;
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            sumOfSquares += i * i;
            sum += i;
        }
        int squareOfSum = sum * sum;
        return "" + Math.abs(sumOfSquares - squareOfSum);
    }
    
    public static void main(String args[]) {
        new Problem006().benchmark();
    }

}
