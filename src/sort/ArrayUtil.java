package sort;

public class ArrayUtil {
    public static int[] generate(int dataSize, int max) {
        int[] test = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            test[i] = (int) (Math.random() * max);
        }
        return test;
    }

    public static Integer[] generateInteger(int dataSize, int max) {
        Integer[] test = new Integer[dataSize];
        for (int i = 0; i < dataSize; i++) {
            test[i] = (int) (Math.random() * max);
        }
        return test;
    }

    public static <T> String toString(T[] data) {
        StringBuilder sb = new StringBuilder("data = ");
        for (T datum : data) {
            sb.append(" ").append(datum).append(" ");
        }
        return sb.toString();
    }

    public static String toString(int[] data) {
        StringBuilder sb = new StringBuilder("data = ");
        for (int datum : data) {
            sb.append(" ").append(datum).append(" ");
        }
        return sb.toString();
    }
}
