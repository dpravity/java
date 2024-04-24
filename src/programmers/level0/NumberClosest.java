package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * array	    n	result
 * [3, 10, 28]	20	28
 * [10, 11, 12]	13	12
 *
 * 입출력 예 #1
 * 3, 10, 28 중 20과 가장 가까운 수는 28입니다.
 *
 * 입출력 예 #2
 * 10, 11, 12 중 13과 가장 가까운 수는 12입니다.
 */
public class NumberClosest {
    public static void main(String[] args) {
        int[] array = {10, 11, 12};
        int n = 13;

        System.out.println(solution1(array, n));
        System.out.println(solution2(array, n));
    }

    public static int solution1(int[] array, int n) {
        int answer = array[0];
        int diff = Math.abs(array[0] - n);
        for(int i : array){
            int temp = Math.abs(i - n);
            if(diff > temp){
                diff = temp;
                answer = i;
            }else if(diff == temp){
                answer = Math.min(answer, i);
            }
        }
        return answer;
    }
    public static int solution2(int[] array, int n) {
        return Math.min(
                array[Arrays.stream(array)
                        .map(operand -> Math.abs(n - operand))
                        .boxed()
                        .collect(Collectors.toList())
                        .indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))
                        ]
                , array[Arrays.stream(array)
                        .map(operand -> Math.abs(n - operand))
                        .boxed()
                        .collect(Collectors.toList())
                        .lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))
                        ]
        );
    }

    public static int solution3(int[] array, int n) {
        Arrays.sort(array);

        int min = Math.abs(array[0] - n);
        int minIdx = 0;
        for(int i = 1; i < array.length; i++)
            if(Math.abs(array[i] - n) < min) {
                min = Math.abs(array[i] - n);
                minIdx = i;
            }

        return array[minIdx];
    }
}
