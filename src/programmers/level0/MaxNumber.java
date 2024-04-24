package programmers.level0;

import java.util.Arrays;
import java.util.Comparator;

/**
 * numbers	result
 * [1, 2, 3, 4, 5]	20
 * [0, 31, 24, 10, 1, 9]	744
 */
public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 31, 24, 10, 1, 9};
        Arrays.sort(numbers);
        int first = numbers[numbers.length - 1];
        int second = numbers[numbers.length - 2];
        System.out.println(first * second);
        System.out.println(solution(numbers));
    }
    public static int solution(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(2L)
                .reduce(1, Math::multiplyExact);
    }
}
