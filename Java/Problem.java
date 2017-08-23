public abstract class Problem {

    public abstract String solve();

    public void benchmark() {
        long startTime = System.currentTimeMillis();
        String solution = solve();
        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("Solution: %s\nTook %d milliseconds", solution, duration);
    }

}
