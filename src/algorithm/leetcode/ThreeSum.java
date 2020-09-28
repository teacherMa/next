package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] test = new int[]{-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0};
        new ThreeSum().threeSum(test);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);

        List<List<Integer>> as = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return as;
            }
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            int left = i + 1;
            int right = length - 1;
            while (true) {
                if (left >= right) {
                    break;
                }
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    as.add(list);

                    while (right - 1 > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left + 1 < length && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                } else {
                    if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return as;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition(nums, l, r);
        quickSort(nums, l, q - 1);
        quickSort(nums, q + 1, r);
    }

    private int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return right;
        }
        int low = left;
        int flag = nums[right];
        for (int high = left; high < right; high++) {
            if (nums[high] < flag) {
                exchange(nums, high, low);
                low++;
            }
        }
        exchange(nums, low, right);
        return low;
    }

    private void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
