import java.util.List;

public class Problem007 extends Problem {
    
    // Upper bound for nth prime, valid for n > 6.
    // See https://en.wikipedia.org/wiki/Prime_number_theorem#Approximations_for_the_nth_prime_number.
    public static int getPrimeBound(int n) {
        return (int) Math.ceil(n*(Math.log(n) + Math.log(Math.log(n))));
    }

    @Override
    public String solve() {
        int n = 10001;
        int limit = getPrimeBound(n);
        List<Integer> primes = PrimeUtils.sieve(limit);
        return "" + primes.get(n - 1);
    }
    
    public static void main(String args[]) {
        new Problem007().benchmark();
    }

}
