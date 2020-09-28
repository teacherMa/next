package sort.heapsort;

/**
 * 堆其实就是用数组表示的完全二叉树（不是满二叉树）
 * <p>
 * 堆的下标从1开始，数组下标从0开始。
 * <p>
 * 堆的第i个元素的左孩子为2 * i，右孩子为（2 * i） + 1；容易推得：非堆根节点的其他元素父节点为（int）(i / 2)。
 * <p>
 * 对于一个有n个元素的堆，(n/2, n]的所有元素都是叶子节点，[1, n/2]的所有元素都是非叶子节点。
 */
public abstract class Heap<T extends Comparable> {

    /**
     * 输入一个数组，将数组转化为堆。
     */
    public void build(T[] data) {
        if (data == null) {
            return;
        }

        int heapLength = data.length;

        for (int i = heapLength / 2; i > 0; i--) {
            heap(data, i, data.length);
        }
    }

    /**
     * 堆排序
     */
    public void sort(T[] heap) {
        if (heap == null) {
            return;
        }
        int heapLength = heap.length;
        for (int i = heapLength; i > 1; i--) {
            exchange(heap, h2a(i), h2a(1));
            heap(heap, 1, i - 1);
        }
    }

    /**
     * 使以index为根元素的堆满足堆的性质。
     *
     * @param heapIndex element's heap-heapIndex
     */
    protected abstract void heap(T[] data, int heapIndex, int heapLength);

    /**
     * array index to heap index
     */
    protected static int a2h(int arrayIndex) {
        return arrayIndex + 1;
    }

    /**
     * head index to array index
     */
    protected static int h2a(int heapIndex) {
        return heapIndex - 1;
    }

    /**
     * get left child index of a heap-index element
     *
     * @return left child heap-index
     */
    protected static int left(int heapIndex) {
        return 2 * heapIndex;
    }

    /**
     * get right child index of a heap-index element
     *
     * @return right child heap-index
     */
    protected static int right(int heapIndex) {
        return 2 * heapIndex + 1;
    }

    /**
     * get parent's index of a heap-index element
     *
     * @return parent's heap-index
     */
    protected static int parent(int heapIndex) {
        return heapIndex / 2;
    }

    /**
     * 交换两个下标的值。
     *
     * @param i 需要交换的第一个下标
     * @param j 需要交换的第二个下标
     */
    protected void exchange(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
