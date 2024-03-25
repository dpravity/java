package java01.algorithm.search;

import java.util.Arrays;

/**
 * 이진 탐색 알고리즘
 */
public class BinarySearch {
    // 이진 탐색 메소드
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        System.out.println("left: " + left + ", right: " + right);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid: " + mid);

            if (arr[mid] == target) {
                return mid; // 찾은 경우, 인덱스 반환
            } else if (arr[mid] < target) {
                left = mid + 1; // 중간값보다 큰 경우, 왼쪽 경계 이동
            } else {
                right = mid - 1; // 중간값보다 작은 경우, 오른쪽 경계 이동
            }
        }
        return -1; // 탐색 실패
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 2, 4, 40};
        // 정렬된 배열
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 3;
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
