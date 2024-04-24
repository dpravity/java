package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * n	result
 * 24	[1, 2, 3, 4, 6, 8, 12, 24]
 * 29	[1, 29]
 */
public class NumberFactor {
    public static void main(String[] args) {
        int n = 29;
        System.out.println(Arrays.toString(solution1(n)));
    }

    public static int[] solution1(int n) {
        int[] visited = new int[n];
        int size = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                visited[i - 1] = i;
                size++;
            }
        }
        int[] answer = new int[size];
        for(int i = 1, j = 0; i <= n; i++) {
            int temp = visited[i - 1];
            if(temp != 0){
                answer[j++] = temp;
            }
        }

        return answer;
    }

    public static int[] solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
    }
}
