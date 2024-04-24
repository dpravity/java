package programmers.level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test7 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 5};
        int n = 1;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i : array){
            if(i == n){
                hash.put(i, hash.getOrDefault(i, 0) + 1);
            }
        }
        System.out.println(hash.get(n) == null ? 0 : hash.get(n));
        System.out.println(t1(array, n));
    }
    public static int t1(int[] array, int n){
        return (int) Arrays.stream(array)
                .filter(e -> e == n)
                .count();
    }
}
