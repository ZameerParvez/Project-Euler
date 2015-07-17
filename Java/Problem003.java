import java.math.BigInteger;
import java.util.List;

public class Problem003 extends Problem {

    @Override
    public String solve() {
        BigInteger number = new BigInteger("600851475143");
        List<BigInteger> primeFactors = PrimeUtils.getPrimeFactorisationByTrialDivision(number);
        return "" + primeFactors.get(primeFactors.size() - 1);
    }
    
    public static void main(String args[]) {
        new Problem003().benchmark();
    }

}
