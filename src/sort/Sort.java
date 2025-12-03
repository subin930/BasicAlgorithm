package sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 7, 3, 5};

        //선택 정렬
        int[] result1 = SelectionSort.selectionSort(Arrays.copyOfRange(arr, 0, arr.length));

        System.out.print("selection sort: ");
        Arrays.stream(result1).forEach(x -> System.out.print(x + " "));
        System.out.println();


        //삽입 정렬
        int[] result2 = InsertionSort.insertionSort(Arrays.copyOfRange(arr, 0, arr.length));

        System.out.print("insertion sort: ");
        Arrays.stream(result2).forEach(x -> System.out.print(x + " "));
        System.out.println();

        //버블 정렬
        int[] result3 = BubbleSort.bubbleSort(Arrays.copyOfRange(arr, 0, arr.length));

        System.out.print("bubble sort: ");
        Arrays.stream(result3).forEach(x -> System.out.print(x + " "));
        System.out.println();


        //합병 정렬
        int[] result4 = MergeSort.mergeSort(Arrays.copyOfRange(arr, 0, arr.length));
        System.out.print("merge sort: ");
        Arrays.stream(result4).forEach(x -> System.out.print(x + " "));
        System.out.println();

        //퀵 정렬
        int[] result5 = QuickSort.quickSort(Arrays.copyOfRange(arr, 0, arr.length));
        System.out.print("quick sort: ");
        Arrays.stream(result5).forEach(x -> System.out.print(x + " "));
        System.out.println();


        //힙 정렬
        int[] result6 = HeapSort.heapSortAsc(Arrays.copyOfRange(arr, 0, arr.length));
        System.out.print("heap sort ascending: ");
        Arrays.stream(result6).forEach(x -> System.out.print(x + " "));
        System.out.println();

        int[] result7 = HeapSort.heapSortDesc(Arrays.copyOfRange(arr, 0, arr.length));
        System.out.print("heap sort descending: ");
        Arrays.stream(result7).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
