package binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        //예시 input 1 2 3 4 5 6 7 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        /* 배열 입력 */
        StringTokenizer str = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        while(str.hasMoreTokens()) {
            list.add(Integer.parseInt(str.nextToken()));
        }

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();


        /* target 입력 */
        int target = Integer.parseInt(br.readLine());

        /* binary search */
        int answerByLoop = binarySearchByLoop(arr, target);
        int answerByRecursion = binarySearchByRecursion(arr, target, 0, arr.length - 1);

        bw.write("binary search answer by loop: [index] " + answerByLoop + " [value] " + (answerByLoop != -1 ? arr[answerByLoop] : "NOT FOUND") + "\n");
        bw.write("binary search answer by recursion: [index] " + answerByRecursion + " [value] " + (answerByRecursion != -1 ? arr[answerByRecursion] : "NOT FOUND")+ "\n");
        bw.write("lower bound(N 이상인 인덱스): " + lowerBound(arr, target) + "\n");
        bw.write("upper bound(N 초과인 인덱스): " + upperBound(arr, target));

        bw.flush();

        br.close();
        bw.close();
    }

    /* 반복문 이용
    * 성공: 인덱스 반환
    * 실패: -1 반환
    * */
    static int binarySearchByLoop(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /* 재귀함수 이용
    * 성공: 인덱스 반환
    * 실패: -1 반환
    * */
    static int binarySearchByRecursion(int[] arr, int target, int low, int high) {
        int mid = low + (high - low) / 2;

        if(low > high) return -1;
        else if(arr[mid] == target) return mid;

        if(arr[mid] > target) {
            return binarySearchByRecursion(arr, target, low, mid - 1);
        } else if(arr[mid] < target) {
            return binarySearchByRecursion(arr, target, mid + 1, high);
        }

        return -1;
    }

    /* lower bound: target 이상이 처음 나오는 위치
     * 결과: 인덱스 반환
     */
    static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] >= target) {
                //왼쪽 탐색(mid 포함)
                high = mid;
            } else {
                //오른쪽 탐색
                low = mid + 1;
            }
        }

        return low;
    }


    /* upper bound: target 초과가 처음 나오는 위치
     * 결과: 인덱스 반환
     */
    static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > target) {
                //왼쪽 탐색(mid포함)
                high = mid;
            } else {
                //오른쪽 탐색
                low = mid + 1;
            }
        }

        return low;
    }

}
