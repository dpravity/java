package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 정수가 담긴 리스트 num_list가 주어질 때, num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 *
 * num_list	        result
 * [1, 2, 3, 4, 5]	[2, 3]
 * [1, 3, 5, 7]	    [0, 4]
 */
public class IntEvenOdd {
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5};
        for(int i : solution4(num_list)){
            System.out.println(i);
        }
    }

    public static int[] solution1(int[] num_list) {
        int[] answer = new int[]{0, 0};

        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
        }

        return answer;
    }

    public static int[] solution2(int[] num_list) {
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++){
            answer[num_list[i] % 2]++;
        }

        return answer;
    }

    public static int[] solution3(int[] numList) {
        return IntStream.of(
                (int) Arrays.stream(numList)
                        .filter(i -> i % 2 == 0)
                        .count()
                , (int) Arrays.stream(numList)
                        .filter(i -> i % 2 == 1)
                        .count()
        ).toArray();
    }

    public static int[] solution4(int[] num_list) {
        return Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.partitioningBy(number -> number % 2 == 1, Collectors.counting()))
                .values().stream()
                .mapToInt(Long::intValue)
                .toArray();
    }
}
