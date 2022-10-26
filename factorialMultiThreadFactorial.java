import java.math.BigInteger;

public class MultiThreadFactorial implements Runnable {
    private int n;

    public MultiThreadFactorial(int n) {
        super();
        this.n = n;
    }


    @Override
    public void run() {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            System.out.println(Thread.currentThread().getName() + "-" + fact);
        }
    }
}
