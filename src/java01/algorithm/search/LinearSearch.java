package java01.algorithm.search;

import java.util.Arrays;

/**
 * 선형 탐색 알고리즘
 */
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));  // [1, 2, 3, 4, 5]
        System.out.println("index : " + linearSearch(arr, 3));  // 2
        System.out.println("index : " + linearSearch(arr, 6));  // -1
    }
}
