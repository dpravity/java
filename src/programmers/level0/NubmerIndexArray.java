package programmers.level0;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
 * 정수 배열 emergency 가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * emergency	            result
 * [3, 76, 24]	            [3, 1, 2]
 * [1, 2, 3, 4, 5, 6, 7]	[7, 6, 5, 4, 3, 2, 1]
 * [30, 10, 23, 6, 100]	    [2, 4, 3, 5, 1]
 *
 * 입출력 예 #1
 * emergency가 [3, 76, 24]이므로 응급도의 크기 순서대로 번호를 매긴 [3, 1, 2]를 return 합니다.
 *
 * 입출력 예 #2
 * emergency가 [1, 2, 3, 4, 5, 6, 7]이므로 응급도의 크기 순서대로 번호를 매긴 [7, 6, 5, 4, 3, 2, 1]를 return 합니다.
 *
 * 입출력 예 #3
 * emergency가 [30, 10, 23, 6, 100]이므로 응급도의 크기 순서대로 번호를 매긴 [2, 4, 3, 5, 1]를 return 합니다.
 */
public class NubmerIndexArray {
    public static void main(String[] args) {
        int[] emergency = {30, 10, 23, 6, 100};
//        System.out.println(Arrays.toString(solution1(emergency)));
        System.out.println(Arrays.toString(solution2(emergency)));
    }

    public static int[] solution1(int[] emergency) {
        int size = emergency.length;
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i]++;
            for(int j = 0; j < size; j++){
                if(emergency[i] < emergency[j]){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
    public static int[] solution2(int[] e) {
        return Arrays.stream(e)
                .map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1)
                .toArray();
    }

    public static int[] solution3(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < answer.length; i++){
            if(answer[i] != 0){
                continue;
            }
            int idx = 1;
            for(int j = 0; j < answer.length; j++){
                if(emergency[i] < emergency[j]){
                    idx++;
                }
            }
            answer[i] = idx;
        }
        return answer;
    }

    public static int[] solution4(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sort = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(sort);
        Map<Integer, Integer> rank = new HashMap<Integer, Integer>();

        int rankIdx = 1;
        for (int idx = sort.length - 1; idx >= 0; idx--) {
            rank.put(sort[idx], rankIdx++);
        }
        for (int idx = 0; idx < emergency.length; idx++) {
            answer[idx] = rank.get(emergency[idx]);
        }
        return answer;
    }
}
