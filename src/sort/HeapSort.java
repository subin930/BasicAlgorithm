package sort;

public class HeapSort {
    public static int[] heapSortDesc(int[] arr) {
        MaxHeap mp = new MaxHeap(arr.length);
        for(int i = 0; i < arr.length; ++i) {
            mp.insert(arr[i]);
        }

        int[] result = new int[mp.heap.length];
        for(int i = 0; i < mp.heap.length; ++i) {
            result[i] = mp.delete();
        }
        return result;
    }

    public static int[] heapSortAsc(int[] arr) {
        MinHeap mp = new MinHeap(arr.length);

        for(int i = 0; i < arr.length; ++i) {
            mp.insert(arr[i]);
        }

        int[] result = new int[mp.heap.length];
        for(int i = 0; i < mp.heap.length; ++i) {
            result[i] = mp.delete();
        }
        return result;
    }
}

class MaxHeap{
    int[] heap;
    int size; //heap에 존재하는 요소 개수

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        heap[size++] = val;

        int cur = size - 1;

        while(cur > 0) {
            int parentIdx = (cur - 1) / 2;

            if(heap[parentIdx] < val) {
                heap[cur] = heap[parentIdx];
                heap[parentIdx] = val;
                cur = parentIdx;
            } else break;
        }
    }

    public Integer delete() {
        if(size == 0) return null;

        int val = heap[0];
        heap[0] = heap[--size];

        int cur = 0;

        while(cur < size) {
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;
            int largest = cur;

            if(left < size && heap[left] > heap[largest]) largest = left;
            if(right < size && heap[right] > heap[largest]) largest = right;

            if(largest == cur) break;

            int tmp = heap[cur];
            heap[cur] = heap[largest];
            heap[largest] = tmp;
            cur = largest;
        }

        return val;
    }
}

class MinHeap {
    int[] heap;
    int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        heap[size++] = val;

        int cur = size - 1;

        while(cur > 0) {
            int parentIdx = (cur - 1) / 2;

            if(heap[parentIdx] > heap[cur]) {
                int tmp = heap[cur];
                heap[cur] = heap[parentIdx];
                heap[parentIdx] = tmp;
                cur = parentIdx;
            } else break;
        }
    }

    public Integer delete() {
        Integer val = heap[0];
        heap[0] = heap[--size];

        int cur = 0;

        while(cur < size) {
            int left = cur * 2 + 1;
            int right = cur * 2 + 2;
            int min = cur;

            if(left < size && heap[left] < heap[min]) min = left;
            if(right < size && heap[right] < heap[min]) min = right;

            if(min == cur) break;

            int tmp = heap[cur];
            heap[cur] = heap[min];
            heap[min] = tmp;
            cur = min;
        }

        return val;
    }
}