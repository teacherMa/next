package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < length; k++) {
            int diff = target - nums[k];
            if (map.containsKey(diff)) {
                i = map.get(diff);
                j = k;
                break;
            } else {
                map.put(nums[k], k);
            }
        }
        return new int[]{i, j};
    }
}
