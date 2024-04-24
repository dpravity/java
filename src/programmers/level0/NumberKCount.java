package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
 * 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
 *
 * i	j	k	result
 * 1	13	1	6
 * 10	50	5	5
 * 3	10	2	0
 *
 * 입출력 예 #1
 * 본문과 동일합니다.
 *
 * 입출력 예 #2
 * 10부터 50까지 5는 15, 25, 35, 45, 50 총 5번 등장합니다. 따라서 5를 return 합니다.
 *
 * 입출력 예 #3
 * 3부터 10까지 2는 한 번도 등장하지 않으므로 0을 return 합니다.
 */
public class NumberKCount {
    public static void main(String[] args) {
        int i = 10;
        int j = 50;
        int k = 5;

        System.out.println(solution1(i, j, k));
        System.out.println(solution2(i, j, k));
    }

    public static int solution1(int i, int j, int k) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        for(; i <= j; i++){
            sb.append(i);
        }

        for(String str : sb.toString().split("")){
            if(Integer.parseInt(str) == k){
                answer++;
            }
        }

        return answer;
    }
    public static int solution2(int i, int j, int k) {
        StringBuffer sb = new StringBuffer();
        for(; i <= j; i++){
            sb.append(i);
        }
        return sb.toString().replaceAll("[^" + k +"]", "").length();
    }
    public static int solution3(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }

    public static int solution4(int i, int j, int k) {
        return (int) Arrays.stream(IntStream.rangeClosed(i, j)
                        .mapToObj(String::valueOf)
                        .flatMap(String::lines)
                        .collect(Collectors.joining())
                        .split(""))
                .filter(s -> s.equals(String.valueOf(k)))
                .count();
    }

    public static int solution5(int i, int j, int k) {
        int answer = 0;

        for (int num = i; num <= j; num++){
            int tmp = num;
            while (tmp != 0){
                if (tmp % 10 == k){
                    answer++;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
