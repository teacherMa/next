package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSize {
//    private static final int TIME = 864 * 1000;
    private static final int TIME = 0;
    static class Dummy extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        int count = 0;
        try {
            while(true) {
                exec.execute(new Dummy());
                count++;
            }
        } catch(Error e) {
            System.out.println(
                    e.getClass().getSimpleName() + ": " + count);
            System.exit(0);
        } finally {
            exec.shutdown();
        }
    }
}