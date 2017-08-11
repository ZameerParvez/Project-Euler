
public abstract class Problem {

    public abstract String solve();

    public void benchmark() {
        long startTime = System.currentTimeMillis();
        String solution = solve();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Solution: " + solution);
        System.out.println("Took " + duration + " milliseconds.");
    }

}
