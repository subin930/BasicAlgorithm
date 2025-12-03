package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);

        return arr;
    }

    public static void quick(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivotIdx = partition(arr, left, right);

        quick(arr, left, pivotIdx);
        quick(arr, pivotIdx + 1, right);
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];

        while(left <= right) {
            while(arr[left] < pivot) ++left;
            while(arr[right] > pivot) --right;

            // swap
            if(left <= right) {
                int tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return left - 1;
    }
}
