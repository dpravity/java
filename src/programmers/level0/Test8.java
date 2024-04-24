package programmers.level0;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test8 {
    public static void main(String[] args) {
        int[] array = {149, 180, 192, 170};
        int height = 167;
        int count = 0;
        for(int i : array){
            if(i > height){
                count++;
            }
        }
        System.out.println(count);
    }

    public static int t1(int[] array, int height){
        return (int) Arrays.stream(array).filter(i -> i > height).count();
    }
}
