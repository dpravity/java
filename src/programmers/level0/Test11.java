package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test11 {
    public static void main(String[] args) {
        int n = 10;
        int size = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] array = new int[size];
        for(int i = 1, j = 0; i <= n; i++){
            if(i % 2 != 0){
                if(i == 0){
                    System.out.println("test");
                }
                array[j++] = i;
            }
        }
//        1, 3, 5, 7, 9
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("--");
        Arrays.stream(t1(n)).forEach(System.out::println);
    }
    public static int[] t1(int n){
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).toArray();
    }
}
