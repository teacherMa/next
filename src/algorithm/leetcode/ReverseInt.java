package algorithm.leetcode;

public class ReverseInt {

    public static void main(String[] args) {
        new ReverseInt().reverse(-2147483648);
    }

    public int reverse(int x) {
        int i = Integer.MAX_VALUE / 10;
        int j = Integer.MIN_VALUE / 10;
        int result = 0;
        while (x != 0) {
            int d = x % 10;
            if (result > i || (result == i) && d > 7) {
                return 0;
            } else if (result < j || (result == j) && d > 7) {
                return 0;
            }
            result = result * 10 + d;
            x = x / 10;
        }

        return result;
    }
}
