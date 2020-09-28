package algorithm.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int max = 0;
        int length = height.length;
        for (int i = 0, j = length - 1; i < j ; ) {
            int h = height[j];
            if (height[i] < height[j]) {
                h = height[i];
                max = Math.max(max, h * (j - i));
                i ++;
            } else {
                max = Math.max(max, h * (j - i));
                j --;
            }
        }
        return max;
    }
}
