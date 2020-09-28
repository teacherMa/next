package sort.heapsort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MaxHeap extends Heap {

    @Override
    protected void heap(Comparable[] data, int heapIndex, int heapLength) {
        if (heapIndex > heapLength / 2) {
            return;
        }
//        System.out.println(HeapSort.toString(data));
        int ai = h2a(heapIndex);
        int al = h2a(left(heapIndex));
        int ar = h2a(right(heapIndex));

        int largestIndex = ai;
        if (al >= 0 && al < heapLength && data[al].compareTo(data[ai]) > 0) {
            largestIndex = al;
        }
        if (ar < heapLength && ar >= 0 && data[ar].compareTo(data[largestIndex]) > 0) {
            largestIndex = ar;
        }

        String sb = "ai = " + ai + " value = " + data[ai] + " al = " + al;
        if (al >= 0 && al < heapLength) {
            sb += " value = " + data[al];
        }
        sb += " ar = " + ar;
        if (ar < heapLength && ar >= 0) {
            sb += " value = " + data[ar];
        }

        sb += " largest = " + largestIndex;

//        System.out.println(sb);

        if (ai != largestIndex) {
            exchange(data, ai, largestIndex);
            heap(data, a2h(largestIndex), heapLength);
        }
    }
}
