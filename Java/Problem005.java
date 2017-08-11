
public class Problem005 extends Problem {

    @Override
    public String solve() {
        int number = 20;
        while (true) {
            if(isDivisbleTo(20, number)) {
                break;
            }
            ++number;
        }
        return "" + number;
    }
    
    public boolean isDivisbleTo(int limit, int number) {
        for (int i = 2; i <= limit; ++i) {
            if (number % i != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        new Problem005().benchmark();
    }

}
