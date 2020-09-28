package algorithm.leetcode;

import sort.quick.QuickSort;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            throw new RuntimeException();
        }

        int length = nums.length;
        Arrays.sort(nums);

        int close = nums[0] + nums[1] + nums[length - 1];
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) <= Math.abs(close - target)) {
                    close = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return close;
    }
}
