package sort.heapsort;


import sort.ArrayUtil;

public class HeapSort {
    public static final int DATA_SIZE = 20;

    public static void main(String[] args) {
        Integer[] test = ArrayUtil.generateInteger(DATA_SIZE, 200);

        System.out.println("origin " + ArrayUtil.toString(test));

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.build(test);
        System.out.println("after build max " + ArrayUtil.toString(test));

        Integer[] max = new Integer[DATA_SIZE];
        System.arraycopy(test, 0, max, 0, DATA_SIZE);
        maxHeap.sort(max);
        System.out.println("after sort max " + ArrayUtil.toString(max));

        MinHeap minHeap = new MinHeap();
        minHeap.build(test);
        System.out.println("after build min " + ArrayUtil.toString(test));

        Integer[] min = new Integer[DATA_SIZE];
        System.arraycopy(test, 0, min, 0, DATA_SIZE);
        minHeap.sort(min);
        System.out.println("after sort min " + ArrayUtil.toString(min));
    }
}
