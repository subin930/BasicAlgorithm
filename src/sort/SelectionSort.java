package sort;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int len = arr.length;

        for(int i = 0; i < len - 1; ++i) {
            int min = arr[i];
            int idx = i;

            for(int j = i + 1; j < len; ++j) {
                if(arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = min;
            arr[idx] = tmp;
        }

        return arr;
    }
}
