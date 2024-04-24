package programmers.level0;

import java.util.Arrays;

public class Test9 {
    public static void main(String[] args) {
        int[] array = {1, 2, 100, -99, 1, 2, 3};
        int size = array.length;
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = array[i] * 2;
        }
        Arrays.stream(t1(array)).forEach(System.out::println);
    }

    public static int[] t1(int[] array){
        return Arrays.stream(array).map(i -> i * 2).toArray();
    }
}
