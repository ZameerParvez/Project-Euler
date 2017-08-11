
public class Problem004 extends Problem {

    @Override
    public String solve() {
        int max = 0;
        for (int i = 100; i < 1000; ++i) {
            for (int j = i; j < 1000; ++j) {
                int product = i * j;
                if (isPalindrome(product) && product > max) {
                    max = product;
                }
            }
        }
        return "" + max;
    }
    
    public boolean isPalindrome(int number) {
        String string = "" + number;
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
    }
    
    public static void main(String args[]) {
        new Problem004().benchmark();
    }

}
