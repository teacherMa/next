import java.util.ArrayList;
import java.util.List;

public class DivideAndShift {
    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int a = 2000000;
            a = a / 8;
        }
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            int a = 2000000;
            a = a >> 3;
        }
        System.out.println(System.nanoTime() - start);
    }
}
