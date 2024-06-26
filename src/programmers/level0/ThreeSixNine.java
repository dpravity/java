package programmers.level0;

import java.util.Arrays;

/**
 * 머쓱이는 친구들과 369게임을 하고 있습니다.
 * 369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
 * 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.
 *
 * order	result
 * 3	    1
 * 29423	2
 *
 * 입출력 예 #1
 * 3은 3이 1개 있으므로 1을 출력합니다.
 *
 * 입출력 예 #2
 * 29423은 3이 1개, 9가 1개 있으므로 2를 출력합니다.
 */
public class ThreeSixNine {
    public static void main(String[] args) {
        int order = 369369369;

        System.out.println(solution1(order));
        System.out.println(solution3(order));
    }

    // TODO - test case 통과못함
    public static int solution1(int order) {
        int answer = 0;

        int temp = order;
        while(temp > 0){
            if((temp % 10) % 3 == 0){
                answer++;
            }
            temp /= 10;
        }

        return answer;
    }
    public static int solution2(int order) {
        int answer = 0;

        int temp = order;
        while(temp > 0){
            int compare = (temp % 10);

            if(compare == 3 || compare == 6 || compare == 9){
                answer++;
            }
            temp /= 10;
        }

        return answer;
    }
    public static int solution3(int order) {
//        long count = Arrays.stream(String.valueOf(order).split(""))
//                .mapToInt(i -> Integer.parseInt(i))
//                .filter(i -> i == 3 || i == 6 || i == 9)
//                .count();
//        System.out.println("co : " +count);

        return (int) Arrays.stream(String.valueOf(order).split(""))
                .map(Integer::parseInt)
                .filter(i -> i == 3 || i == 6 || i == 9)
                .count();
    }
}
