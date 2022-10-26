public class Main {
    public static void main(String[] args) throws InterruptedException {

        for(int i = 1; i <= 100; i++) {
            MultiThreadFactorial multiThreadFactorial = new MultiThreadFactorial(i);
            Thread thread = new Thread(multiThreadFactorial, "Thread" + i);
            thread.start();
            thread.join();
        }
    }
}
