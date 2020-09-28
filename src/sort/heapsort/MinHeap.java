package sort.heapsort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MinHeap extends Heap {

    @Override
    protected void heap(Comparable[] data, int heapIndex, int heapLength) {
        if (heapIndex > heapLength / 2) {
            return;
        }
        int ai = h2a(heapIndex);
        int al = h2a(left(heapIndex));
        int ar = h2a(right(heapIndex));

        int minIndex = ai;
        if (al >= 0 && al < heapLength && data[al].compareTo(data[ai]) < 0) {
            minIndex = al;
        }
        if (ar < heapLength && ar >= 0 && data[ar].compareTo(data[minIndex]) < 0) {
            minIndex = ar;
        }

        if (ai != minIndex) {
            exchange(data, ai, minIndex);
            heap(data, a2h(minIndex), heapLength);
        }
    }
}
