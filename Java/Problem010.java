import java.util.List;

public class Problem010 extends Problem {

    @Override
    public String solve() {
        List<Integer> primes = PrimeUtils.sieve(2000000);
        long sum = 0;
        for (int i = 0; i < primes.size(); ++i) {
            sum += primes.get(i);
        }
        return "" + sum;
    }
    
    public static void main(String args[]) {
        new Problem010().benchmark();
    }

}
