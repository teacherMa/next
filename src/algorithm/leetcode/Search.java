package algorithm.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {
    public static void main(String[] args) {
        int[] test = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Search().search(test, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return search(nums, left, right, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int flag = nums[mid];
        int start = nums[left];
        if (flag == target) {
            return mid;
        } else {
            // 根据区间中点的值与最左侧点的值，分情况讨论即可。
            if (flag < start) {
                if (flag < target) {
                    int result = search(nums, mid + 1, right, target);
                    if (result == -1) {
                        return search(nums, left, mid - 1, target);
                    } else {
                        return result;
                    }
                } else {
                    return search(nums, left, mid - 1, target);
                }
            } else {
                if (flag < target) {
                    return search(nums, mid + 1, right, target);
                } else {
                    int result = search(nums, mid + 1, right, target);
                    if (result == -1) {
                        return search(nums, left, mid - 1, target);
                    } else {
                        return result;
                    }
                }
            }
        }
    }
}
