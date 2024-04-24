package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * n	numlist	                        result
 * 3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
 * 5	[1, 9, 3, 10, 13, 5]	        [10, 5]
 * 12	[2, 100, 120, 600, 12, 12]	    [120, 600, 12, 12]
 *
 * 입출력 예 #1
 * numlist에서 3의 배수만을 남긴 [6, 9, 12]를 return 합니다.
 *
 * 입출력 예 #2
 * numlist에서 5의 배수만을 남긴 [10, 5]를 return 합니다.
 *
 * 입출력 예 #3
 * numlist에서 12의 배수만을 남긴 [120, 600, 12, 12]를 return 합니다.
 */
public class NumberMultiple {
    public static void main(String[] args) {
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        for(int i : solution1(n, numlist)){
            System.out.println(i);
        }
        for(int i : solution2(n, numlist)){
            System.out.println(i);
        }
    }

    public static int[] solution1(int n, int[] numlist) {
        boolean[] visieted = new boolean[numlist.length];
        int size = 0;

        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                visieted[i] = true;
                size++;
            }
        }

        int[] answer = new int[size];
        for(int i = 0, j = 0; i < numlist.length; i++){
            if(visieted[i]){
                answer[j++] = numlist[i];
            }
        }

        return answer;
    }

    public static int[] solution2(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .boxed()
                .mapToInt(i -> i)
                .filter(i -> i % n == 0)
                .toArray();
    }
}
