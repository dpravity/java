package programmers.level0;

import java.util.Arrays;

public class Test10 {
    public static void main(String[] args) {
        int[] array = {1, 2, 7, 10, 11};
//        int[] array = {9, -1, 0};
        Arrays.sort(array);
//        System.out.println(t1(array));
        int mid = array.length / 2;
        System.out.println(mid);
        System.out.println(array.length >> 1);
    }

    public static int t1(int[] array){
        int mid = array.length / 2;
        return array[mid];
    }
}
