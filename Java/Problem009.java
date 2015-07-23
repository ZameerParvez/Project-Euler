
public class Problem009 extends Problem {

    @Override
    public String solve() {
        int a = 1;
        int b = 1;
        int c = 1;
        outerloop:
        for (c = 1; c <= 1000; ++c) {
            for (b = 1; b <= c; ++b) {
                for (a = 1; a <= b; ++a) {
                    if (a*a + b*b == c*c && a + b + c == 1000) {
                        break outerloop;
                    }
                }
            }
        }
        return "" + (a * b * c);
    }
    
    public static void main(String args[]) {
        new Problem009().benchmark();
    }

}
