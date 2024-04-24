package programmers.level0;

import java.util.Arrays;

/**
 * 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
 *
 * n	    result
 * 1234	    10
 * 930211	16
 */
public class IntDigitSum {
    public static void main(String[] args) {
        int n = 930211;
        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    public static int solution1(int n) {
        int answer = 0;
        String[] digit = Integer.toString(n).split("");

        for(int i = 0; i < digit.length; i++){
            answer += Integer.valueOf(digit[i]);
        }

        return answer;
    }
    public static int solution2(int n) {
        int answer = 0;
        int temp = n;

        while (temp > 0) {
            answer += temp % 10;
            temp /= 10;
        }
        return answer;
    }

    public static int solution3(int n) {
        return Arrays.stream(String.valueOf(n)
                .split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
