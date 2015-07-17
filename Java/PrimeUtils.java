import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class PrimeUtils {
    
    public static final BigInteger ZERO = BigInteger.ZERO;
    public static final BigInteger ONE = BigInteger.ONE;
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger THREE = BigInteger.valueOf(3);
    
    private PrimeUtils() {}

    // Uses the sieve of Eratosthenes to find primes less than
    // or equal to limit.
    public static List<Integer> sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= limit; ++i) {
            if (isPrime[i]) {
                for (int j = i*i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < isPrime.length; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> primeFactors = new ArrayList<Integer>();
        int limit = (int) Math.ceil(Math.sqrt(number));
        List<Integer> primes = sieve(limit);
        for (Integer prime : primes) {
            if (number % prime == 0) {
                primeFactors.add(prime);
            }
        }
        return primeFactors;
    }
    
    public static List<BigInteger> getPrimeFactorisationByTrialDivision(BigInteger number) {
        List<BigInteger> primeFactors = new ArrayList<BigInteger>();
        while (number.mod(TWO).equals(ZERO)) {
            primeFactors.add(TWO);
            number = number.divide(TWO);
        }
        BigInteger divisor = THREE;
        while (!number.equals(ONE)) {
            while (number.mod(divisor).equals(ZERO)) {
                primeFactors.add(divisor);
                number = number.divide(divisor);
            }
            divisor = divisor.add(TWO);
        }
        return primeFactors;
    }
    
}
