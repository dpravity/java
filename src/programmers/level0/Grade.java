package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
 * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score 가 주어질 때,
 * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 0 ≤ score[0], score[1] ≤ 100
 * 1 ≤ score의 길이 ≤ 10
 * score의 원소 길이는 2입니다.
 * score는 중복된 원소를 갖지 않습니다.
 *
 * 입출력 예
 * score	                                                                    result
 * [[80, 70], [90, 50], [40, 70], [50, 80]]	                                    [1, 2, 4, 3]
 * [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]	[4, 4, 6, 2, 2, 1, 7]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 평균은 각각 75, 70, 55, 65 이므로 등수를 매겨 [1, 2, 4, 3]을 return 합니다.
 *
 * 입출력 예 #2
 * 평균은 각각 75, 75, 40, 95, 95, 100, 20 이므로 [4, 4, 6, 2, 2, 1, 7] 을 return 합니다.
 * 공동 2등이 두 명, 공동 4등이 2명 이므로 3등과 5등은 없습니다.
 */
public class Grade {
    public static void main(String[] args) {
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        System.out.println(Arrays.toString(solution1(score)));
    }
    public static int[] solution1(int[][] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list  = new ArrayList<>();

        for(int i = 0; i < score.length; i++){
            list.add(score[i][0] + score[i][1]);
        }
        list.sort(Comparator.reverseOrder());

        for(int i = 0; i < score.length; i++){
            int target = score[i][0] + score[i][1];
            answer[i] = list.indexOf(target) + 1;
        }

        return answer;
    }

    public static int[] solution2(int[][] score) {
        return Arrays.stream(score)
                .map(ints -> Arrays.stream(ints).average().orElse(0))
                .mapToInt(d -> Arrays.stream(score)
                        .map(ints -> Arrays.stream(ints).average().orElse(0))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())
                        .indexOf(d) + 1)
                .toArray();
    }
}
