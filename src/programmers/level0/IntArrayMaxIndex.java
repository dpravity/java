package programmers.level0;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 *
 * array	        result
 * [1, 8, 3]	    [8, 1]
 * [9, 10, 11, 8]	[11, 2]
 */
public class IntArrayMaxIndex {
    public static void main(String[] args) {
        int[] array = {9, 10, 11, 8};
        for(int i : solution1(array)){
            System.out.println(i);
        }
        for(int i : solution2(array)){
            System.out.println(i);
        }
        for(int i : solution3(array)){
            System.out.println(i);
        }
    }

    public static int[] solution1(int[] array) {
        int[] answer = new int[2];
        IntStream.range(0, array.length)
                .reduce((a,b) -> array[a] < array[b] ? b : a)
                .ifPresent(index -> {
                    answer[0] = array[index];
                    answer[1] = index;
                });

        return answer;
    }

    public static int[] solution2(int[] array) {
        return IntStream.range(0, array.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, array[i]))
                .max(Map.Entry.comparingByValue())
                .map(entry -> new int[]{entry.getValue(), entry.getKey()})
                .orElseThrow();
    }
    public static int[] solution3(int[] array) {
        int max = -1;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }
}
