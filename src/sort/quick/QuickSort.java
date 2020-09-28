package sort.quick;

import sort.ArrayUtil;

public class QuickSort {
    public static final int DATA_SIZE = 40;

    public static void main(String[] args) {
        int[] test = ArrayUtil.generate(DATA_SIZE, 200);
        System.out.println(ArrayUtil.toString(test));
        quickSort(test, 0, DATA_SIZE - 1);
        System.out.println(ArrayUtil.toString(test));
    }

    public static void quickSort(int[] data, int left, int right) {
        if (data == null) {
            return;
        }

        if (right > left) {
            int i = partition(data, left, right);
            quickSort(data, left, i - 1);
            quickSort(data, i + 1, right);
        }
    }

    /**
     * 划分数组。
     * 核心思想是维护两个指针i和j，其中[left,i - 1]的元素都小于flag，[i, j]的元素都大于flag，移动j从[left, right)，如果data[j] < flag，则交换下标为i, j的数组元素，然后i++，
     * 这样就能一直保证[left,i - 1]的元素都小于flag，[i, j]的元素都大于flag。
     * <p>
     * 根据上述划分数组的原理，可以得到，对于数据随机分布均匀的数据集，每次划分数组都会得到两个大小接近的数组，那么一共只需要划分lgN（lg表示以2为底的对数）次即可。
     * 但是极端情况下，每次划分n个元素的数组时，得到的结果可能是一个只有一个元素的数组和一个n-1个元素的数组，此时需要划分N次。
     */
    private static int partition(int[] data, int left, int right) {
        if (left >= right) {
            return left;
        }
        int flag = data[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (data[j] < flag) {
                exchange(data, i, j);
                i++;
            }
        }
        exchange(data, i, right);
        return i;
    }

    private static void exchange(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
