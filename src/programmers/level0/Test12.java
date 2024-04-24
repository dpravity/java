package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test12 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int num1 = 1;
        int num2 = 3;
        int size = num2 - num1 + 1;
        int[] temp = new int[size];
        for(int i = 0; i < size; i++){
            temp[i] = array[i + num1];
        }
//        t1(array, num1, num2);
        t2(array, num1, num2);
    }

    public static void t1(int[] array, int num1, int num2){
        int[] temp = Arrays.copyOfRange(array, num1, num2 + 1);
        for(int i : temp){
            System.out.println(i);
        }
    }
    public static void t2(int[] array, int num1, int num2) {
        Arrays.stream(IntStream.rangeClosed(num1, num2).map(i -> array[i]).toArray()).forEach(System.out::println);
    }
}
