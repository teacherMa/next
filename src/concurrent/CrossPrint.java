package concurrent;

public class CrossPrint {

    public static void main(String[] args) {
        int[] input = new int[]{0};
        WaitAndNotify t1 = new WaitAndNotify(input);
        WaitAndNotify t2 = new WaitAndNotify(input);
        t1.start();
        t2.start();
    }

    private static class WaitAndNotify extends Thread {
        final int[] origin;

        public WaitAndNotify(int[] origin) {
            this.origin = origin;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (origin) {
                    origin.notifyAll();
                    if (origin[0] > 100) {
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + " print " + origin[0]);
                    origin[0]++;
                    try {
                        origin.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
