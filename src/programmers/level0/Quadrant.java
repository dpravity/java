package programmers.level0;

import java.util.HashMap;

/**
 * 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
 * 1 = 양수, 양수
 * 2 = 음수, 양수
 * 3 = 음수, 음수
 * 4 = 양수, 음수
 */
public class Quadrant {
    public static void main(String[] args) {
        String POSITIVE = "POSITIVE";
        String NEGAITIVE = "NEGAITIVE";
        HashMap<String, Integer> map = new HashMap<>();
        map.put(POSITIVE + "," + POSITIVE, 1);
        map.put(NEGAITIVE + "," + POSITIVE, 2);
        map.put(NEGAITIVE + "," + NEGAITIVE, 3);
        map.put(POSITIVE + "," + NEGAITIVE, 4);

        int[] dot = {2, 4}; // 1
        int[] dot2 = {-7, 9}; // 2
//        System.out.println(map.get((dot[0] > 0 ? POSITIVE : NEGAITIVE)  + "," + (dot[1] > 0 ? POSITIVE : NEGAITIVE)));
        solution(dot);
        solution(dot2);
    }
    public static int solution(int[] dot) {
        int x = dot[0] < 0 ? 1 : 0;
        int y = dot[1] < 0 ? 2 : 0;
        System.out.println("x : " + x);
        System.out.println("y : " + y);
        System.out.println("x | y : " + (x | y));
        System.out.println("y >> 1 : " + (y >> 1));
        System.out.println("x | y  ^ y >> 1: " + ((x | y) ^ (y >> 1)));
        System.out.println("1 + ((x | y) ^ (y >> 1)): " + (1 + ((x | y) ^ (y >> 1))));
        // 양수/양수
        // 0000
        // 0000
        // 0000
        // 0000
        return 1 + ((x | y) ^ (y >> 1));
    }
}
