package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 머쓱이는 행운의 숫자 7을 가장 좋아합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
 *
 * array	    result
 * [7, 77, 17]	4
 * [10, 29]	    0
 *
 * 입출력 예 #1
 * [7, 77, 17]에는 7이 4개 있으므로 4를 return 합니다.
 *
 * 입출력 예 #2
 * [10, 29]에는 7이 없으므로 0을 return 합니다.
 */
public class NumberKCount2 {
    public static void main(String[] args) {
        int[] array = {10, 29};
        System.out.println(solution1(array));
    }
    public static int solution1(int[] array) {
        StringBuffer sb = new StringBuffer();
        for(int i : array){
            sb.append(i);
        }

        return sb.toString().replaceAll("[^7]", "").length();
    }

    public static int solution2(int[] array) {
        return (int) Arrays.stream(
                        Arrays.stream(array)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining())
                                .split("")
                )
                .filter(s -> s.equals("7"))
                .count();
    }
}
