package algorithm.leetcode;

public class MaxProfit {
    public static void main(String[] args) {
        new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < length; i++) {
            int profit = prices[i] - min;
            min = Math.min(min, prices[i]);
            max = Math.max(max, profit);
        }
        return max;
    }
}
