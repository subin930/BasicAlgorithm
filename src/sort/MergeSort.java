package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        int len = arr.length;

        if(len == 1) return arr;

        int[] l = mergeSort(Arrays.copyOfRange(arr, 0, len / 2));
        int[] r = mergeSort(Arrays.copyOfRange(arr, len / 2, len));

        int left = 0; int right = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(left < l.length && right < r.length) {
            if(l[left] <= r[right]) result.add(l[left++]);
            else result.add(r[right++]);
        }

        for(; left < l.length; ++left) result.add(l[left]);
        for(; right < r.length; ++right) result.add(r[right]);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
